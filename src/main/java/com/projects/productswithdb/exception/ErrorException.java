package com.projects.productswithdb.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Setter


public class ErrorException {
    private String message;



//    @Override
//    public String toString() {
//        return "ErrorException{" +
//                "message='" + message + '\'' +
//                '}';
//    }
    public ErrorException(String message)
    {
        this.message=message;
    }
}
