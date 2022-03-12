package com.example.OrderManagement.System.Repository;

import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    Optional<Order> findById(Long orderId);
    Optional<Order> findByDate(Date datenow);
    Optional<Order> findByTcost(Double totalCost);

}
