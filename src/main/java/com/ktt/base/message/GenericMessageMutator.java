package com.ktt.base.message;

import com.ktt.base.service.LocaleAwareMessageService;

public interface GenericMessageMutator {

    boolean isCustomeMessage();

    Object getData();

    String getMessage();

    String getReturnCode();

    void transformMessage(LocaleAwareMessageService service);
}

