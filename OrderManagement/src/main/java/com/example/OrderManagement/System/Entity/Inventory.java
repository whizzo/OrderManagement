package com.example.OrderManagement.System.Entity;

import javax.persistence.*;

@Entity
@Table
public class Inventory {

    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="itemID",referencedColumnName = "id")
    private Item item;
    private int quantity;


    public Inventory(){
    }

    public Inventory(int quantity, Long id){
        this.id = id;
        this.item = item;
        this.quantity = quantity;

    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public Item getItem() { return item; }

    public void setItem(Item item) { this.item = item; }

    public int getQuantity(){ return quantity; }

    public void setQuantity(int quantity){ this.quantity = quantity; }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
