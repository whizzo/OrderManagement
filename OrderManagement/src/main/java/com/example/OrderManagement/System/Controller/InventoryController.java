package com.example.OrderManagement.System.Controller;


import com.example.OrderManagement.System.Entity.Inventory;
import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {this.inventoryService = inventoryService;}

    @GetMapping
    public List<Inventory> getInventories(){return inventoryService.getInventories();}

    @GetMapping(path = "{inventoryID}")
    public Optional<Inventory> getInventory(@PathVariable ("inventoryID") Long id) throws Exception{
        return inventoryService.getInventory(id);
    }

    @PostMapping
    public void registerNewItem(@RequestBody Inventory inventory) throws Exception{
        inventoryService.addNewInventory(inventory);
    }

    @DeleteMapping(path = "{inventoryID}")
    public void deleteInventory(@PathVariable ("inventoryId") Long id) {inventoryService.deleteInventory(id);}


    @PutMapping(path = "{inventoryID}")
    public void updateInventory(
            @PathVariable("inventoryID") Long id,
            @RequestBody Inventory inventory){
        inventoryService.updateInventory(id, inventory);
    }


}
