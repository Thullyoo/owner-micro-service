package com.thullyooo.owner_micro_service.producer.category;

import com.thullyooo.owner_micro_service.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void createCategory(CategoryRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_1, dto);
    }

    public void updateCategory(CategoryUpRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_2, dto);
    }

    public void deleteCategory(CategoryDelRequestDTO dto) {
        System.out.println("Enviando a message: " + dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METHOD_3, dto);
    }
}
