package com.rest.exemplo.rest;

import org.springframework.cache.interceptor.CacheOperationInvoker.ThrowableWrapper;

public class  StudentNotFoundException extends RuntimeException{
    
    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(String message , Throwable cause ){
        super(message , cause);
    }

    public StudentNotFoundException(Throwable cause){
        super(cause);
    }
}