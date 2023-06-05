package com.taoEshop.orderService.service;

import com.taoEshop.orderService.dto.OrderItemsDto;
import com.taoEshop.orderService.dto.OrderRequest;
import com.taoEshop.orderService.model.Order;
import com.taoEshop.orderService.model.OrderItems;
import com.taoEshop.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItemsList = orderRequest
                .getOrderItemsDtoList()
                .stream()
                .map(x -> mapToModel(x))
                .toList();

        log.info(orderItemsList.toString());
        order.setItemsList(orderItemsList);

        orderRepository.save(order);
    }

    private OrderItems mapToModel(OrderItemsDto orderItemsDto) {
        OrderItems orderItems = new OrderItems();
        orderItems.setSkuCode(orderItemsDto.getSkuCode());
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        return orderItems;
    }
}
