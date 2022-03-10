package com.example.OrderManagement.System.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(
            name = "Order_sequence",
            sequenceName = "Order_sequence",
            allocationSize = 1
    )

    private Long orderID;

    private Double totalCost;


    private ArrayList<Item> items;

    private Date datenow;

    public Order(){

    }

    public Order(Long orderID, Double totalCost, ArrayList<Item> items, Date datenow){
        this.orderID = orderID;
        this.totalCost = totalCost;
        this.items = items;
        this.datenow = datenow;
    }

    public Long getOrderID() { return orderID; }

    public void setOrderID(Long orderID) {this.orderID = orderID;}

    public Double getTotalCost() { return totalCost; }

    public void setTotalCost(Double totalCost) {this.totalCost = totalCost;}

    public ArrayList<Item> getItems() { return items; }

    public void setItems(ArrayList<Item> items) { this.items = items; }

    public Date getDatenow() {return datenow;}

    public void setDatenow(Date datenow) {this.datenow = datenow;}

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", totalCost=" + totalCost +
                ", items=" + items +
                ", datenow=" + datenow +
                '}';
    }

}
