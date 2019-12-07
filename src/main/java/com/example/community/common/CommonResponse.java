package com.example.community.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommonResponse<T> {

    @JsonProperty("request_time")
    private LocalDateTime requestTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cause;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CommonPage pagenation;

    public static <T> CommonResponse<T> ok(String code, String message){
        return (CommonResponse<T>) CommonResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> ok(T data,String code, String message){
        return (CommonResponse<T>) CommonResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<T> ok(T data,String code, String message, CommonPage page){
        return (CommonResponse<T>) CommonResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .data(data)
                .pagenation(page)
                .build();
    }

    public static <T> CommonResponse<T> error(String code,String message,String cause){
        return (CommonResponse<T>) CommonResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .cause(cause)
                .build();
    }
}
