package com.ecommerce.app.order.dto;

import java.util.List;

public class CreateOrderRequest {
    private Long userId;
    private List<CreateOrderItemResquest> items;
}
