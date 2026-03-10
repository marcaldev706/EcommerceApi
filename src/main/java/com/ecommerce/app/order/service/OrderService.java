package com.ecommerce.app.order.service;

import com.ecommerce.app.order.dto.CreateOrderItemResquest;
import com.ecommerce.app.order.dto.CreateOrderRequest;
import com.ecommerce.app.order.entity.OrderEntity;
import com.ecommerce.app.order.entity.StatusOrder;
import com.ecommerce.app.order.exception.NoOrderFound;
import com.ecommerce.app.order.orderItem.entity.OrderItemEntity;
import com.ecommerce.app.order.repository.OrderRepository;
import com.ecommerce.app.order.orderItem.repository.OrderItemRepository;
import com.ecommerce.app.product.entity.ProductEntity;
import com.ecommerce.app.product.exception.NoProductFound;
import com.ecommerce.app.product.repository.ProductRepository;
import com.ecommerce.app.user.entity.UserEntity;
import com.ecommerce.app.user.exception.NoUserFound;
import com.ecommerce.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderEntity createOrder(CreateOrderRequest request) {

        UserEntity user = findUser(request.getUserId());

        OrderEntity order = new OrderEntity();
        order.setUserEntity(user);
        order.setStatusOrder(StatusOrder.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        order = orderRepository.save(order);

        BigDecimal total = BigDecimal.ZERO;
        List<OrderItemEntity> orderItems = new ArrayList<>();

        for (CreateOrderItemResquest item : request.getItems()) {

            ProductEntity product = findProduct(item.getProductId());

            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(product.getPrice());

            orderItems.add(orderItem);

            total = total.add(calculateItemTotal(product, item));
        }

        orderItemRepository.saveAll(orderItems);

        order.setTotal(total);

        return orderRepository.save(order);
    }

    private UserEntity findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoUserFound(userId));
    }

    private ProductEntity findProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoProductFound(productId));
    }

    private BigDecimal calculateItemTotal(ProductEntity product, CreateOrderItemResquest item) {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()));
    }


    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoOrderFound(orderId));
    }

    public void deleteOrder(Long orderId) {

        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoOrderFound(orderId));

        orderRepository.delete(order);
    }
}