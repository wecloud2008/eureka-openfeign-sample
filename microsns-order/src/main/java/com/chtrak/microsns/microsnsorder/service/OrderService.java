package com.chtrak.microsns.microsnsorder.service;

import com.chtrak.microsns.microsnsorder.entity.Item;
import com.chtrak.microsns.microsnsorder.entity.Order;
import com.chtrak.microsns.microsnsorder.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    ItemService itemService;

    private static final Map<String, Order> MAP = new HashMap<String, Order>();

    static{

        Order order = new Order();
        order.setOrderId("5919373826896");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);

        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        Item item = new Item();
        item.setId(1L);
        orderDetails.add(new OrderDetail(order.getOrderId(),item));

        item = new Item();
        item.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(),item));

        order.setOrderDetails(orderDetails);

        MAP.put(order.getOrderId(),order);

    }

    /**
     * 根据订单Id 查询订单数据
     * @Param orderId
     * */
    public Order queryOrderById(String orderId){
        Order order = MAP.get(orderId);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for(OrderDetail orderDetail : orderDetails){
            Long id = orderDetail.getItem().getId();
            Item item = itemService.queryItemById(id);
            orderDetail.setItem(item);
        }
        return order;
    }

}
