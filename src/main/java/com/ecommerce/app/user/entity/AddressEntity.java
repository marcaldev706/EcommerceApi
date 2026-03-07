package com.ecommerce.app.user.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressEntity {
    private String street;
    private String zipCode;
    private String neighborhood;
    private Integer number;
}
