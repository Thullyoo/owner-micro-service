package com.thullyooo.owner_micro_service.controller;

import com.thullyooo.owner_micro_service.producer.category.CategoryDelRequestDTO;
import com.thullyooo.owner_micro_service.producer.category.CategoryProducer;
import com.thullyooo.owner_micro_service.producer.category.CategoryRequestDTO;
import com.thullyooo.owner_micro_service.producer.category.CategoryUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/owner/category")
public class CategoryController {

    @Autowired
    CategoryProducer categoryProducer;

    @PostMapping("/register")
    public ResponseEntity<Void> registerCategory(@RequestBody CategoryRequestDTO dto){
        categoryProducer.createCategory(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryUpRequestDTO dto){
        categoryProducer.updateCategory(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCategory(@RequestBody CategoryDelRequestDTO dto){
        categoryProducer.deleteCategory(dto);
        System.out.println("DTO enviado: " + dto.toString());
        return ResponseEntity.noContent().build();
    }

}
