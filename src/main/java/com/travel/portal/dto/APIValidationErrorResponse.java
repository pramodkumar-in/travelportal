package com.travel.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

abstract class ApiSubErrorResponse {

}

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationErrorResponse extends ApiSubErrorResponse {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationErrorResponse(String object, String message) {
        this.object = object;
        this.message = message;
    }
}

