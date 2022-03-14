package com.example.OrderManagement.System.Service;



import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.HttpExceptions.HttpRequestHandler;
import com.example.OrderManagement.System.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {this.itemRepository = itemRepository;}

    public List<Item> getItems(){return itemRepository.findAll();}

    public Optional<Item> getItem(Long id) throws Exception{
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemRepository.findById(id).isPresent()){
            throw new HttpRequestHandler("Item with this id exists");
        }
        return itemOptional;
    }

    public void addNewItem(Item item) throws Exception {
        if(itemRepository.findByName(item.getName()).isPresent()){
            throw new HttpRequestHandler("Item with this name exists!");
        }else{
            itemRepository.save(item);
        }
    }

    public void deleteItem(Long id){
        if(itemRepository.findById(id).isPresent()){
            itemRepository.deleteById(id);

        }else{
            throw new HttpRequestHandler("item does not exist!");
        }
    }

    @Transactional
    public void updateItem(Long id, Item item) {
        Item item1 = itemRepository.getById(id);
        item1.setName(item.getName());
        item1.setPrice(item.getPrice());
        itemRepository.save(item1);


    }
}
