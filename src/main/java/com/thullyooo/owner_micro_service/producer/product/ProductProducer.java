package com.thullyooo.owner_micro_service.producer.product;

import com.thullyooo.owner_micro_service.config.RabbitMQConfig;
import com.thullyooo.owner_micro_service.producer.category.CategoryDelRequestDTO;
import com.thullyooo.owner_micro_service.producer.category.CategoryRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void createProduct(ProductRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_4, dto);
    }

    public void updateProduct(ProductUpRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_5, dto);
    }

    public void deleteProduct(ProductDelRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_6, dto);
    }

}
