package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public Country() {

    }

    public Country(String country) {
        this.country = country;
        deliveries = new ArrayList<>();
    }

    public void addDelivery(Delivery delivery) {
        delivery.setCountry(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getСountry() {
        return country;
    }

    public void setСountry(String country) {
        this.country = country;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.country{" + "id" + id + ",country='" + country + '}';
    }

}
