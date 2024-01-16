package com.example.hethongthongtin.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(boolean error,HttpStatus httpStatus,String message, Object responseObject)
    {

        Map<String, Object> response = new HashMap<String, Object>();
        try {
            response.put("status",error);
            response.put("httpStatus", httpStatus.value());
            response.put("message", message);
            response.put("data",responseObject);
            return new ResponseEntity<>(response, httpStatus);
        }catch (Exception e){
            response.clear();
            response.put("status",false);
            response.put("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", e.getMessage());
            response.put("data", null);
        return new ResponseEntity<Object>(response,httpStatus);
        }


    }
}
//public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error,String message, Object responseObj) {
//    Map<String, Object> map = new HashMap<String, Object>();
//    try {
//        map.put("status", status.value());
//        map.put("isSuccess", error);
//        map.put("message", message);
//        map.put("data", responseObj);
//
//        return new ResponseEntity<Object>(map,status);
//    } catch (Exception e) {
    //        map.clear();
//        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        map.put("isSuccess",false);
//        map.put("message", e.getMessage());
//        map.put("data", null);
//        return new ResponseEntity<Object>(map,status);
//    }
//}
//}
