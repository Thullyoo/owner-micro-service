package com.thullyooo.owner_micro_service.producer.product;

public record ProductRequestDTO(String name, Double price,Long categoryId,String description,String ownerId) {

}
