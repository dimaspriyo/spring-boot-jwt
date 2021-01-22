package com.example.demo.DTO.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static ResponseEntity<Object> okResponse(Object data){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("true");
        baseResponse.setData(data);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> failedResponse(Object data){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("false");
        baseResponse.setData(data);

        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

}
