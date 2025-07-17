package com.app_ossebi.webretail.controller;

import com.app_ossebi.webretail.dto.ProductRequest;
import com.app_ossebi.webretail.dto.ProductResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping
    public ResponseEntity<ProductResponce> createProduct(@RequestBody ProductRequest productRequest) {

    }
}
