package com.example.OrderManagement.System.Entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Orderi {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1

    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")

    private Long orderID;
    private Double totalCost;
    private Date datenow;

    @ManyToMany
    @JoinTable(
            name = "OrderItems",
            joinColumns = { @JoinColumn(name = "orderID") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    private List<Item> items;





    public Orderi(){
    }

    public Orderi(Long orderID, Double totalCost){
        this.orderID = orderID;
        this.totalCost = totalCost;
    }

    public Orderi(Double totalCost){
        this.totalCost = totalCost;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDatenow() {
        return datenow;
    }

    public void setDatenow(Date datenow) {
        this.datenow = datenow;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}