package com.example.springboot.dto;

import com.example.springboot.entity.Order;
import com.example.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;

}
