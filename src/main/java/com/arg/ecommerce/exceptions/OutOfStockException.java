package com.arg.ecommerce.exceptions;

public class OutOfStockException extends Exception{

    public OutOfStockException(String errorMessage){
        super(errorMessage);
    }


}
