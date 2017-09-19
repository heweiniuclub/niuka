package com.niuka.common.exception;

import com.niuka.common.model.ResultCode;

/**
 * 缓存异常
 *
 * @author hewei
 */
public class CacheException extends ApplicationException {
    private static final long  serialVersionUID = -2678203134198782909L;
    public static final String MESSAGE          = "缓存异常";

    public CacheException() {
        super(MESSAGE);
    }

    public CacheException(String message) {
        super(message);
        this.code = ResultCode.CACHE_ERROR;
    }

    public CacheException(Throwable cause) {
        super(cause);
        this.code = ResultCode.CACHE_ERROR;
    }

    public CacheException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCode.CACHE_ERROR;
    }

    public CacheException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
