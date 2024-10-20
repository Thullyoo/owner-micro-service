package com.thullyooo.owner_micro_service.producer.product;

public record ProductUpRequestDTO(String name, Double price, Long productId, String description, String ownerId) {
}
