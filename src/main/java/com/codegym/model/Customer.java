package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String image;
    @ManyToOne
    private Provinces provincesID;
    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName,String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image=image;
    }

    public Provinces getProvincesID() {
        return provincesID;
    }

    public void setProvincesID(Provinces provincesID) {
        this.provincesID = provincesID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
