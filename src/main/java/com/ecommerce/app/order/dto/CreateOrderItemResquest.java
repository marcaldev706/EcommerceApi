package com.ecommerce.app.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderItemResquest {
    private Long productId;
    private Integer quantity;
}
