package com.example.OrderManagement.System.Service;


import com.example.OrderManagement.System.Entity.Inventory;
import com.example.OrderManagement.System.Entity.Item;
import com.example.OrderManagement.System.Entity.Orderi;
import com.example.OrderManagement.System.Repository.InventoryRepository;
import com.example.OrderManagement.System.Repository.ItemRepository;
import com.example.OrderManagement.System.Repository.OrderRepository;
import com.example.OrderManagement.System.Transport.CreateOrderTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository,
                        InventoryRepository inventoryRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }


    public List <Orderi> getOrders(){return orderRepository.findAll();}

    public Optional<Orderi> getOrder(Long id) throws Exception{
        Optional<Orderi> orderOptional = orderRepository.findById(id);
        if(orderRepository.findById(id).isEmpty()){
            throw new Exception("Order with this id does not exist!");
        }
        return orderOptional;
    }

    public void addNewOrder(CreateOrderTransport createOrderTransport) throws Exception{
        List<Item> items = new ArrayList<>();
        Orderi orderi = new Orderi();
        for(Integer id : createOrderTransport.getItemsID()){
            Optional<Item> item = itemRepository.findById((Long.parseLong( id + "")));
            if(item.isEmpty()){
                throw new Exception("this item does not exist");
            }else{
                items.add(item.get());
                Optional<Inventory> inventory = inventoryRepository.findInventoryByItemId(item.get().getId());
                if(inventory.isPresent()){
                    Inventory inventory1 = inventory.get();
                    if(inventory1.getQuantity()>0) {
                        inventory1.setQuantity(inventory1.getQuantity() - 1);
                    }
                    else{
                        throw new Exception("Inventoryu does not have stock");
                    }
                }
                else{
                    throw new Exception("Inventory with item id does not exist");
                }
            }
        }
        orderi.setItems(items);
        orderi.setDatenow(new Date());
        orderi.setTotalCost(items.stream()
                .map(ob ->ob.getPrice())
                .reduce(0.0, (a,b)->a+b));
        orderRepository.save(orderi);
    }


    public void deleteOrder(Long id){
        if(orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Order with this id does not exist");
        }
    }



    @Transactional
    public void updateOrder(Long id, Orderi order){
        Orderi order1 = orderRepository.getById(id);
//        order1.setDatenow(order.getDatenow());
        order1.setTotalCost(order.getTotalCost());
        orderRepository.save(order1);
    }

}
