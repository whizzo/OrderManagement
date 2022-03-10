package com.example.OrderManagement.System.Service;


import com.example.OrderManagement.System.Entity.Client;
import com.example.OrderManagement.System.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) { this.clientRepository = clientRepository; }

    public List<Client> getClients(){return clientRepository.findAll();}

    public Optional<Client> getClient(Long id) throws Exception{
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientRepository.findById(id).isEmpty()){
            throw new Exception("Client with this id doesnt exist");
        }
        return clientOptional;
    }

    public void addNewClient(Client client) throws Exception {
        if(clientRepository.findByEmail(client.getEmail()).isPresent()){
            throw new Exception("Client with this email exists!");
        }else{
            clientRepository.save(client);
        }
    }

    public void deleteClient(Long id){
        if(clientRepository.findById(id).isPresent()){
            clientRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Client does not exist! ");
        }
    }

    @Transactional
    public void updateClient(Long id, Client client){
        Client client1 = clientRepository.getById(id);
        client1.setName(client.getName());
        client1.setEmail(client.getEmail());
        clientRepository.save(client1);
    }


}
