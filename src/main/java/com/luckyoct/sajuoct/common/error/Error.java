package com.luckyoct.sajuoct.common.error;

import lombok.Builder;

@Builder
public class Error {

    private ErrorCode code;
    private String message;
}
