package com.utsoft.blockchain.config;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.RequestContextUtils;
import com.utsoft.blockchain.api.util.BaseResponse;
import com.utsoft.blockchain.support.util.ConstantUtil;
import com.utsoft.blockchain.support.util.ServiceProcessException;
/**
 * @author <a href="flyskyhunter@gmail.com">hunterfox</a>
 * @version 1.0
 * @date 2017年07月17日
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {

	private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MessageSource messageSource;
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse<Object> handleMissingServletRequestParameterException(HttpServletRequest req, MissingServletRequestParameterException e) {

        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("required_parameter_is_not_present"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse<Object> handleHttpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e) {
        logger.error(errorMsg("parameter_validation_fail"), e);
        BaseResponse<Object> base = BaseResponse.build(); //
        base.setData(errorMsg("parameter_validation_fail"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(errorMsg("method_match_fail"), e);

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);

        BaseResponse<Object> base = BaseResponse.build(); //could_not_read_json
        base.setData(errorMsg("method_match_fail"));
        base.setMessage(message);
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public BaseResponse<Object> handleBindException(BindException e) {
        logger.error(errorMsg("parameter_bind_fail"), e);

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);

        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("parameter_bind_fail"));
        base.setMessage(message);
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;

    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse<Object> handleServiceException(ConstraintViolationException e) {
        logger.error(errorMsg("parameter_validation_fail"), e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        BaseResponse<Object> base = BaseResponse.build(); //could_not_read_json
        base.setData(errorMsg("parameter_constraint_fail"));
        base.setMessage(message);
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public BaseResponse<Object> handleValidationException(ValidationException e) {
        logger.error(errorMsg("parameter_validation_fail"), e);

        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("parameter_constraint_fail"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;

    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error(errorMsg("parameter_validation_fail"), e);

        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("required_parameter_is_not_present"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;

    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public BaseResponse<Object> handleIllegalStateException(IllegalStateException e) {
        logger.error(errorMsg("parameter_validation_fail"), e);

        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("parameter_constraint_fail"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.BAD_REQUEST);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponse<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("method_not_support"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.METHOD_NOT_ALLOW);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResponse<Object> handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error(errorMsg("mediatype_not_support"), e);
        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg("mediatype_not_support"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.MEDIA_NOT_SUPPORT);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleException(HttpServletRequest req, Exception e) {
        logger.error(errorMsg("mediatype_not_support"), e);
        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg(req, "common_error"));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.SEVER_INNER_ERROR);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }

    /**
     * 500 - service provider Server Error
     */
    @ExceptionHandler(ServiceProcessException.class)
    public BaseResponse<Object> handleException(HttpServletRequest req, ServiceProcessException e) {
        logger.error(errorMsg("innner_process_error"), e);
        BaseResponse<Object> base = BaseResponse.build();
        base.setData(errorMsg(req, "innner_process_error",e.getMessage()));
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.SEVER_INNER_ERROR);
        base.setTimestamp(System.currentTimeMillis());
        return base;
    }
    
    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseResponse<Object> handleException(DataIntegrityViolationException e) {

        BaseResponse<Object> base = BaseResponse.build();
        base.setMessage(e.getMessage());
        base.setCode(ConstantUtil.SEVER_INNER_ERROR);
        base.setTimestamp(System.currentTimeMillis());
        return base;

    }
    public String errorMsg(HttpServletRequest request, String code, Object... args) {
        Locale locale1 = RequestContextUtils.getLocale(request);
        if (args.length == 0)
            return messageSource.getMessage(code, null, locale1);
        return messageSource.getMessage(code, args, locale1);
    }

    public String errorMsg(String code, Object... args) {
        if (args.length == 0)
            return messageSource.getMessage(code, null, Locale.ENGLISH);
        return messageSource.getMessage(code, args, Locale.ENGLISH);
    }
}
