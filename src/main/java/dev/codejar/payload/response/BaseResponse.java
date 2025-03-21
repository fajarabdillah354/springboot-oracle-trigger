package dev.codejar.payload.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse <T>{

    private boolean status;

    private String message;

    private T data;


}
