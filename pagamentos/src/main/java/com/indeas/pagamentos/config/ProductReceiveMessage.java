package com.indeas.pagamentos.config;

import com.indeas.pagamentos.converter.PaymentsConverter;
import com.indeas.pagamentos.data.vo.ProductVO;
import com.indeas.pagamentos.repository.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiveMessage {

    @Autowired
    private ProductRepository productRepository;

    @RabbitListener(queues = {"${product.rabbitmq.queue}"})
    public void receive(@Payload ProductVO productVO) {
        productRepository.save(PaymentsConverter.createProduct(productVO));
    }
}
