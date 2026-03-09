package com.ecommerce.app.order;

import com.ecommerce.app.user.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderEntity{
    private Long id;
    private StatusOrder statusOrder;
    private UserEntity userEntity;
    private BigDecimal total;
    private LocalDateTime createdAt;
}
