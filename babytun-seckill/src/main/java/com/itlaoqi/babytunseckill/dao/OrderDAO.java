package com.itlaoqi.babytunseckill.dao;

import com.itlaoqi.babytunseckill.entity.Order;

public interface OrderDAO {
    public void insert(Order order);

    public Order findByOrderNo(String orderNo);
}
