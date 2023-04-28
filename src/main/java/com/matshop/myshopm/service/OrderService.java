package com.matshop.myshopm.service;

import com.matshop.myshopm.Cart;
import com.matshop.myshopm.dto.OrderDto;
import com.matshop.myshopm.mapper.OrderMapper;
import com.matshop.myshopm.model.order.Order;
import com.matshop.myshopm.model.order.OrderItem;
import com.matshop.myshopm.repository.order.OrderItemRepository;
import com.matshop.myshopm.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }
    public void saveOrder(OrderDto orderDto){
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.clearCart();
    }

}
