package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.model.OrderModel;
import br.com.fiap.checkpoint2.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;



    public OrderModel createOrder(OrderModel order){
        return orderRepository.save(order);

    }
    public List<OrderModel> readAllOrders(){
        return orderRepository.findAll();
    }
}
