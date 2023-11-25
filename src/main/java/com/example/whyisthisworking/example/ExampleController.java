package com.example.whyisthisworking.example;

import com.example.whyisthisworking.common.CommonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/example")
public class ExampleController {


    @GetMapping("/query-string")
    public ResponseEntity<CommonResponseDto<String>> getQueryString(@RequestParam String value){
        CommonResponseDto<String> response = new CommonResponseDto<>("Success Response", value);
        return new ResponseEntity<>(response, response.extractHttpStatus());
    }

    @GetMapping("/path-variable/{value}")
    public ResponseEntity<CommonResponseDto<String>> getPathVariable(@PathVariable String value){
        CommonResponseDto<String> response = new CommonResponseDto<>("Success Response", value);
        return new ResponseEntity<>(response, response.extractHttpStatus());
    }

    @GetMapping("/path-variable/test")
    public ResponseEntity<CommonResponseDto<String>> getPathVariableOverlappingTest(){
        CommonResponseDto<String> response = new CommonResponseDto<>("Success Response", "PathVariable 중복 테스트");
        return new ResponseEntity<>(response, response.extractHttpStatus());
    }

    @PostMapping("/path-variable/{value}")
    public ResponseEntity<CommonResponseDto<String>> postPathVariable(@RequestParam String value){
        CommonResponseDto<String> response = new CommonResponseDto<>("Success Response", value);
        return new ResponseEntity<>(response, response.extractHttpStatus());
    }


}
