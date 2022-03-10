package com.example.OrderManagement.System.Entity;

import javax.persistence.*;

@Entity
@Table
public class Supplier {

    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")

    private Long id;
    private String name;



    public Supplier(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Supplier(String name){
        this.name = name;
    }

    public Supplier(){

    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @PostLoad
    public void postLoad(){

    }
}
