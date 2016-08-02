package com.ktt.base.message;


import com.ktt.base.BaseConst;
import com.ktt.base.service.LocaleAwareMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * RestControler에 적용되는 ControllerAdvice
 * BaseResponse로 message나 데이터를 wrapping하여 클라이언트에 전달하는 데이터 골격을 생성한다.
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerMessageAdvice implements ResponseBodyAdvice<Object> {


	@Autowired
	private LocaleAwareMessageService messageService;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body,
								  MethodParameter methodParameter,
								  MediaType mediaType,
								  Class<? extends HttpMessageConverter<?>> messageConverter,
								  ServerHttpRequest request,
								  ServerHttpResponse response) {

		GenericMessage message = null;

		if(body instanceof GenericMessage) {
			message = (GenericMessage) body;
		}else{
			message = (GenericMessage) RequestContextHolder.getRequestAttributes()
					.getAttribute(BaseConst.GENERIC_MESSAGE, RequestAttributes.SCOPE_REQUEST);
			if(body!=null){
				message.setData(body);
			}
		}

		// 공통 메시지 처리
		if(!((GenericMessageMutator) message).isCustomeMessage()){
			((GenericMessageMutator) message).transformMessage(messageService);
		}

		System.out.println(((RestMessage) message).toString());


		return message;
	}

	/**
	 * 기본 예외처리 헨들러, 다른 예외처리 헨들러에서 처리되지 않은 예외들을 처리함.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RestMessage> handleOtherExceptions(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestMessage message = new RestMessage();
		message.setMessage(ex.getMessage());
		return new ResponseEntity<>(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
