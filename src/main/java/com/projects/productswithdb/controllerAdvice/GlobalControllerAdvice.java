package com.projects.productswithdb.controllerAdvice;

import com.projects.productswithdb.exception.CategoryNotFoundException;
import com.projects.productswithdb.exception.ErrorException;
import com.projects.productswithdb.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorException> handleProductNotFoundException(ProductNotFoundException e)
    {
        ErrorException errorException=new ErrorException(e.getMessage());
        return new ResponseEntity<>(errorException, HttpStatusCode.valueOf(404));

    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorException> handleCategoryNotFoundException(CategoryNotFoundException e)
    {
        ErrorException errorException=new ErrorException(e.getMessage());
        return new ResponseEntity<>(errorException, HttpStatusCode.valueOf(404));

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorException> handleGeneralException(Exception e)
    {
        ErrorException errorException=new ErrorException(e.getMessage());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }

}
