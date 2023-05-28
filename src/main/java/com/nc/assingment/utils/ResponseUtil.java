package com.nc.assingment.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static ResponseEntity create(Object object) {
        return new ResponseEntity(object, HttpStatus.CREATED);
    }

    public static ResponseEntity ok(Object object) {
        return new ResponseEntity(object, HttpStatus.OK);
    }
    public static ResponseEntity internalError(Object object)
    {
        return new ResponseEntity(object,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public  static ResponseEntity notFound(Object object)
    {
        return  new ResponseEntity(object,HttpStatus.NOT_FOUND);
    }

}
