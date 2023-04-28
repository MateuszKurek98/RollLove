package com.matshop.myshopm.repository.order;

import com.matshop.myshopm.model.order.Order;
import com.matshop.myshopm.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
