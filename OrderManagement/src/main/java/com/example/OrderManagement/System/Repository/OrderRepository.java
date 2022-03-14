package com.example.OrderManagement.System.Repository;


import com.example.OrderManagement.System.Entity.Orderi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orderi, Long>{

    Optional<Orderi> findById(Long orderId);

}
