package com.example.demo.DTO.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseResponse {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("data")
    private Object data;


}
