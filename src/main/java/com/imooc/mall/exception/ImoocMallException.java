package com.imooc.mall.exception;

public class ImoocMallException extends RuntimeException {
    private final Integer code;
    private final String message;

    public ImoocMallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ImoocMallException(ImoocMallExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
