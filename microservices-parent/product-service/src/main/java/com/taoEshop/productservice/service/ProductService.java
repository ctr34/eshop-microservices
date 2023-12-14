package com.taoEshop.productservice.service;

import com.taoEshop.productservice.dto.ProductRequest;
import com.taoEshop.productservice.dto.ProductResponse;
import com.taoEshop.productservice.model.Product;
import com.taoEshop.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .Id(productRequest.getId())
                .Name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} has been saved", product.getId());
    }

    public List<ProductResponse> getALlProduct(){
        List<Product> productResponseList = productRepository.findAll();

        return productResponseList.stream().map(x -> mapModelToResponse(x)).toList();
    }

    private ProductResponse mapModelToResponse(Product product){
        return ProductResponse.builder()
                .Id(product.getId())
                .Name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
