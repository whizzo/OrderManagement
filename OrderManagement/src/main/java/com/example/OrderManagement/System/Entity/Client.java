package com.example.OrderManagement.System.Entity;

import javax.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")

    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;


    public Client(){
    }

    public Client(Long id, String name, String email, Long phoneNumber){

        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Client(String name, String email, Long phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() { return id; }

    public void setId(Long id){ this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Long getPhoneNumber(){ return phoneNumber; }

    public void setPhoneNumber(Long phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @PostLoad
    public void postLoad() {

    }
}
