package com.example.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@Controller
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @GetMapping(
            value = "/get-file",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody ResponseEntity<byte[]> getFile() {
        return new RestTemplate().getForEntity("http://localhost:8080/get-file", byte[].class);
    }

}
