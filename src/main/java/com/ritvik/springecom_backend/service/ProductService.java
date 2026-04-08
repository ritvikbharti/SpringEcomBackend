package com.ritvik.springecom_backend.service;

import com.ritvik.springecom_backend.Product;
import com.ritvik.springecom_backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService  {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAllProducts()  {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        try {
            product.setImageData(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productRepo.save(product);
    }


    public void deleteProduct(int id) {
         productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }


}
