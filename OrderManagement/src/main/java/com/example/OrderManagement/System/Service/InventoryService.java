package com.example.OrderManagement.System.Service;


import com.example.OrderManagement.System.Entity.Inventory;
import com.example.OrderManagement.System.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {this.inventoryRepository = inventoryRepository;}

    public List<Inventory> getInventories(){return inventoryRepository.findAll();}

    public Optional<Inventory> getInventory(Long id) throws Exception{
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryRepository.findById(id).isPresent()){
            throw new Exception("Inventory with this id exists!");

        }
        return inventoryOptional;
    }

    public void addNewInventory(Inventory inventory) throws Exception{
        if(inventoryRepository.findByQuantity(inventory.getQuantity()).isPresent()){
            throw new Exception("Inventory with this quantity is present");
        }else{
            inventoryRepository.save(inventory);
        }

    }

    public void deleteInventory(Long id){
        if(inventoryRepository.findById(id).isPresent()){
            inventoryRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Inventory does not exist!");
        }
    }

    @Transactional
    public void updateInventory(Long id, Inventory inventory){
        Inventory inventory1 = inventoryRepository.getById(id);
        inventory1.setQuantity(inventory.getQuantity());
        inventoryRepository.save(inventory1);
    }



}
