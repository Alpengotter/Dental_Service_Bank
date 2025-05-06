package com.alpengotter.dental_service_bank.handler.exception;

import com.alpengotter.dental_service_bank.handler.ErrorType;

public class LemonBankException extends RuntimeException{

    public final ErrorType errorType;
    public LemonBankException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }
    public LemonBankException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }


}
