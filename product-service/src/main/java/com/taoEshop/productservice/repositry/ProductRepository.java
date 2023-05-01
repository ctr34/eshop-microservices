package com.taoEshop.productservice.repositry;

import com.taoEshop.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductRepository extends MongoRepository<Product, String> {

}
