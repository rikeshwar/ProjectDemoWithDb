package com.projects.productswithdb.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String messsage)
    {
        super(messsage);
    }
}
