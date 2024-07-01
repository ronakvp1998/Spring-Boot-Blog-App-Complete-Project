package com.example.springboot.service;

import com.example.springboot.dto.OrderRequest;
import com.example.springboot.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
