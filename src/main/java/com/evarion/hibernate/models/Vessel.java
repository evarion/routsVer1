package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vessel")

public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vessel")
    private String vessel;

    @OneToMany(mappedBy = "vessel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public Vessel() {

    }

    public Vessel(String vessel) {
        this.vessel = vessel;
        deliveries = new ArrayList<>();
    }

    public void addDelivery(Delivery delivery) {
        delivery.setVessel(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.vessel{" + "id" + id + ",vessel='" + vessel + '}';
    }

}
