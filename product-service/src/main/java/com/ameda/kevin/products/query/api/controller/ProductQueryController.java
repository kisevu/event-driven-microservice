package com.ameda.kevin.products.query.api.controller;

import com.ameda.kevin.products.command.api.model.ProductModel;
import com.ameda.kevin.products.query.api.queries.GetProductsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductQueryController {
    private final QueryGateway queryGateway;
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        GetProductsQuery getProductsQuery = GetProductsQuery.builder().build();
        List<ProductModel> productModelList = queryGateway.query(getProductsQuery,
                ResponseTypes.multipleInstancesOf(ProductModel.class)).join();
        //query created... now handle the projections...
        return new ResponseEntity<>(productModelList,HttpStatus.OK);
    }
}
