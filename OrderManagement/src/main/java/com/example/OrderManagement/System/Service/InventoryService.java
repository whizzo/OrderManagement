package com.example.OrderManagement.System.Service;


import com.example.OrderManagement.System.Entity.Inventory;
import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.Repository.InventoryRepository;
import com.example.OrderManagement.System.Repository.ItemRepository;
import com.example.OrderManagement.System.Transport.CreateInventoryTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;}

    public List<Inventory> getInventories(){return inventoryRepository.findAll();}

    public Optional<Inventory> getInventory(Long id) throws Exception{
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryRepository.findById(id).isPresent()){
            throw new Exception("Inventory with this id exists!");

        }
        return inventoryOptional;
    }

    public void addNewInventory(CreateInventoryTransport createInventoryTransport) throws Exception{
        Optional<Item> inventory = inventoryRepository.findByItemId(createInventoryTransport.getItemID());

        if(inventory.isEmpty()){
            Inventory inventory1 = new Inventory();
            Optional<Item> item = itemRepository.findById(createInventoryTransport.getItemID());
            if(item.isPresent()){
                inventory1.setItem(item.get());
                inventory1.setQuantity(createInventoryTransport.getQuantity());
                inventoryRepository.save(inventory1);
            }
            else{
                throw new Exception("Item with this id does not exist!");
            }
        }else{
            throw new Exception("Inventory with this id exists!");
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
