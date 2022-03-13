package com.example.OrderManagement.System.Repository;

import com.example.OrderManagement.System.Entity.Inventory;
import com.example.OrderManagement.System.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    Optional<Item> findByItemId(Long id);
    Optional<Inventory> findById(Long id);

    Optional<Inventory> findByQuantity(int quantity);




}
