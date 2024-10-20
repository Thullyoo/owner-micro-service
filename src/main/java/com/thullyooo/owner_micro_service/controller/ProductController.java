package com.thullyooo.owner_micro_service.controller;

import com.thullyooo.owner_micro_service.producer.category.CategoryDelRequestDTO;
import com.thullyooo.owner_micro_service.producer.category.CategoryProducer;
import com.thullyooo.owner_micro_service.producer.category.CategoryRequestDTO;
import com.thullyooo.owner_micro_service.producer.category.CategoryUpRequestDTO;
import com.thullyooo.owner_micro_service.producer.product.ProductDelRequestDTO;
import com.thullyooo.owner_micro_service.producer.product.ProductProducer;
import com.thullyooo.owner_micro_service.producer.product.ProductRequestDTO;
import com.thullyooo.owner_micro_service.producer.product.ProductUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/owner/product")
public class ProductController {

    @Autowired
    ProductProducer productProducer;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProduct(@RequestBody ProductRequestDTO dto){
        productProducer.createProduct(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductUpRequestDTO dto){
        productProducer.updateProduct(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody ProductDelRequestDTO dto){
        productProducer.deleteProduct(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }
}
