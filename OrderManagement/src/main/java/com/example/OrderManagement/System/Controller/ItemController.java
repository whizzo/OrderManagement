package com.example.OrderManagement.System.Controller;


import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {this.itemService = itemService;}

    @GetMapping
    public List<Item> getItems() {return itemService.getItems();}

    @GetMapping(path = "{itemID}")
    public Optional<Item> getItem(@PathVariable ("itemID") Long id) throws Exception{
        return itemService.getItem(id);
    }

    @PostMapping
    public void registerNewItem(@RequestBody Item item) throws Exception{
        itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemID}")
    public void deleteItem(@PathVariable ("itemID") Long id) {itemService.deleteItem(id);}

    @PutMapping(path = "{itemID}")
    public void updateItem(
            @PathVariable("itemID") Long id,
            @RequestBody Item item){
        itemService.updateItem(id, item);
    }





}
