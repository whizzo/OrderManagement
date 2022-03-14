package com.example.OrderManagement.System.Controller;


import com.example.OrderManagement.System.Service.ClientService;
import com.example.OrderManagement.System.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/client")
public class ClientController {

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) { this.clientService= clientService; }


    @GetMapping
    public List<Client> getClients () {return clientService.getClients();}


    @GetMapping(path = "{clientID}")
    public Optional<Client> getClient(@PathVariable ("clientID") Long id) throws Exception{
     return clientService.getClient(id);
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client) throws Exception{
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientID}")
    public void deleteClient(@PathVariable("clientID") Long id){
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{clientID}")
    public void updateClient(
            @PathVariable("clientID") Long id,
            @RequestBody Client client){
        clientService.updateClient(id, client);
    }

}
