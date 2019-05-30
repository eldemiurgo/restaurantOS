package com.food.restaurant.service;

import com.food.restaurant.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {

    AtomicInteger id = new AtomicInteger();

    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(id.getAndIncrement(),"Desayuno Americano", "Desayuno",10),
                    new Product(id.getAndIncrement(),"Desayuno Continental", "Desayuno",8)

            )

    );



    public List<Product> getAll(){
        return products;
    }

    public void saveProduct(Product product){
        product.setId(id.incrementAndGet());
        products.add(product);
    }


    public Product findById(Integer id){
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseGet(null);
        return product;

    }

    public void updateProduct(Integer id, Product product){
        Product currentProduct = findById(id);
        int index = products.indexOf(currentProduct);
        product.setId(currentProduct.getId());
        products.set(index, product);

    }


    public void deleteProduct(Integer id){
        Product currentProduct = findById(id);
        products.remove(currentProduct);
    }
}
