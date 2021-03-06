package com.example.OrderManagement.System.Controller;



import com.example.OrderManagement.System.Entity.Orderi;
import com.example.OrderManagement.System.Repository.OrderRepository;
import com.example.OrderManagement.System.Service.OrderService;
import com.example.OrderManagement.System.Transport.CreateOrderTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    private final OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService){this.orderService = orderService;}


    @GetMapping
    public List<Orderi> getOrders(){return orderService.getOrders();}


    @GetMapping(path = "{orderID}")
    public Optional<Orderi> getOrder(@PathVariable ("orderID") Long id) throws Exception{
        return orderService.getOrder(id);
    }


    @PostMapping
    public void registerNewOrder(@RequestBody CreateOrderTransport createOrderTransport) throws Exception{
        orderService.addNewOrder(createOrderTransport);
    }


    @DeleteMapping(path = "{orderID}")
    public void deleteOrder(@PathVariable ("orderID") Long id) {orderService.deleteOrder(id);}


    @PutMapping(path = "{orderID}")
    public void updateOrder(
            @PathVariable("orderID") Long id,
            @RequestBody Orderi order){
        orderService.updateOrder(id, order);

    }

}
