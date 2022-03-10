package com.example.OrderManagement.System.Repository;

import com.example.OrderManagement.System.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{


    Optional<Client> findById(Long id);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByPhoneNumber(Long phoneNumber);
}
