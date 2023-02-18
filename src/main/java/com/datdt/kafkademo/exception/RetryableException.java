package com.datdt.kafkademo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RetryableException extends RuntimeException {
    private String code;
    private String message;
    private Object trace;

}
