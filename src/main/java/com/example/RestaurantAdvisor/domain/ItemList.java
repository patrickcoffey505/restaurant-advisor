package com.example.RestaurantAdvisor.domain;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    List<OrderItem> orderitems;

    public ItemList() {
        this.orderitems = new ArrayList<OrderItem>();
    }

    public void addItem(OrderItem orderItem) {
        this.orderitems.add(orderItem);
    }
    
    public List<OrderItem> getOrderitems() {
        return this.orderitems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderitems = orderItems;
    }

    @Override
    public String toString() {
        return "{" +
            " orderItems='" + getOrderitems() + "'" +
            "}";
    }

}
