package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "port")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "port")
    private String port;

    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public Port() {

    }

    public Port(String port) {
        this.port = port;
        deliveries = new ArrayList<>();
    }

    public void addDelivery(Delivery delivery) {
        delivery.setPort(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getCargo() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.port{" + "id" + id + ",port='" + port + '}';
    }



}
