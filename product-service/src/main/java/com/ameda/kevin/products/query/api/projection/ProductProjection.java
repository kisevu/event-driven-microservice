package com.ameda.kevin.products.query.api.projection;

import com.ameda.kevin.products.command.api.data.entity.Product;
import com.ameda.kevin.products.command.api.data.repository.ProductRepository;
import com.ameda.kevin.products.command.api.model.ProductModel;
import com.ameda.kevin.products.query.api.queries.GetProductsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductProjection {
    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductModel> handle(GetProductsQuery getProductsQuery){
        List<Product> products =
                productRepository.findAll();
        List<ProductModel> productModelList =
                products.stream()
                        .map(product -> ProductModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .toList();
        return productModelList;
    }
}
