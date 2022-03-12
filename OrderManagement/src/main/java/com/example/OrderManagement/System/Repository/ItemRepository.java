package com.example.OrderManagement.System.Repository;


import com.example.OrderManagement.System.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById (Long id);
    Optional<Item> findByName (String name);
    Optional<Item> findByPrice (Double price);


}
