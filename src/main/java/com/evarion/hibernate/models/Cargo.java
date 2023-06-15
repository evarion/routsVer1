package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargo")

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cargo")
    private String cargo;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public Cargo() {

    }

    public Cargo(String cargo) {
        this.cargo = cargo;
        deliveries = new ArrayList<>();
    }

    public void addDelivery(Delivery delivery) {
        delivery.setCargo(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.cargo{" + "id" + id + ",cargo='" + cargo + '}';
    }
}
