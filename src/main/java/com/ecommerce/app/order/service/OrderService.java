package com.ecommerce.app.order.service;

import com.ecommerce.app.order.entity.OrderEntity;
import com.ecommerce.app.order.repository.OrderRepository;
import com.ecommerce.app.order.orderItem.entity.OrderItemEntity;
import com.ecommerce.app.order.orderItem.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
}
