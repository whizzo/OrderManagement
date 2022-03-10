package com.example.OrderManagement.System.Service;


import com.example.OrderManagement.System.Entity.Order;
import com.example.OrderManagement.System.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired

    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    public List <Order> getOrders(){return orderRepository.findAll();}

    public Optional<Order> getOrder(Long id) throws Exception{
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderRepository.findById(id).isEmpty()){
            throw new Exception("Order with this id does not exist!");
        }
        return orderOptional;
    }

    public void addNewOrder(Order order) throws Exception{
        if(orderRepository.findById(order.getOrderID()).isPresent()){
            throw new Exception("Order with this id exists!");
        }else{
            orderRepository.save(order);
        }
    }

    public void deleteClient(Long id){
        if(orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Order with this id does not exist");
        }
    }

    @Transactional

    public void updateOrder(Long id, Order order){
        Order order1 = orderRepository.getById(id);
        order1.setDatenow(order.getDatenow());
        order1.setTotalCost(order.getTotalCost());
        orderRepository.save(order1);
    }

}
