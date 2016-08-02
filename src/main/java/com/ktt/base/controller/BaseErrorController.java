package com.ktt.base.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;


/**
 * @author Leonardo Park (blue.park@kt.com)
 * @description
 */
public class BaseErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
