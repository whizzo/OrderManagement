package com.example.OrderManagement.System.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")

    private Long id;
    private String name;
    private Double price;

    @ManyToMany(mappedBy = "items")
    private List<Orderi> inOrders;




    public Item() {
    }

    public Item(Long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getName(){ return name; }

    public void setName(String name){ this.name = name; }

    public Double getPrice(){ return price; }

    public void setPrice(Double price){ this.price = price; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @PostLoad
    public void postLoad(){

    }
}
