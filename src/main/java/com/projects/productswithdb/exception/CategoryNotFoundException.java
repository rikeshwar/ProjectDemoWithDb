package com.projects.productswithdb.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message)
    {
        super(message);
    }
}
