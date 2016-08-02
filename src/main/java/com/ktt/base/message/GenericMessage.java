package com.ktt.base.message;

public interface GenericMessage {

	String OK = "OK";

	String NG = "NG";

	void setOK();

	void setNG();

	void enableCustomeMessage();

	void setMessage(String message);

	void setData(Object data);

	void setReturnCode(String returnCode);

}
