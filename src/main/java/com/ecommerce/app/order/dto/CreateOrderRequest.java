package com.ecommerce.app.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private Long userId;
    private List<CreateOrderItemResquest> items;
}
