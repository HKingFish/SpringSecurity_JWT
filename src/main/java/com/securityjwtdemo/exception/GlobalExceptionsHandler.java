package com.securityjwtdemo.exception;


import com.securityjwtdemo.common.JsonResponseStatus;
import com.securityjwtdemo.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionsHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public JsonResult<Object> jsonErrorHandler(BindException e) {
        logError(e);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(JsonResponseStatus.ParamsFormatError.getCode());
        result.setMessage(e.getFieldError().getDefaultMessage());
        return result;
    }

    @ExceptionHandler(value = BusinessError.class)
    @ResponseBody
    public JsonResult<Object> jsonErrorHandler(BusinessError e) {
        logError(e);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(JsonResponseStatus.BusinessError.getCode());
        result.setMessage(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = LoginInvalidationException.class)
    public JsonResult<Object> jsonErrorHandler(LoginInvalidationException e) {
        logError(e);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(JsonResponseStatus.TokenFail.getCode());
        result.setMessage(e.getMessage());
        return result;
    }


    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public JsonResult<Object> jsonErrorHandler(SystemException e) {
        logError(e);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(JsonResponseStatus.SystemError.getCode());
        result.setMessage(JsonResponseStatus.SystemError.getMessage() + ": " + e.getMessage());
        return result;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public JsonResult<Object> jsonErrorHandler(Throwable t) {
        logError(t);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(JsonResponseStatus.FAILURE.getCode());
        result.setMessage(JsonResponseStatus.FAILURE.getMessage() + " : " + t.getMessage());
        return result;
    }

    private void logError(Throwable t) {
        logger.error(t.getMessage(), t);
    }

}
