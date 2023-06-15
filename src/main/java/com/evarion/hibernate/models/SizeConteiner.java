package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sizeconteiner")


public class SizeConteiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sizeconteiner")
    private String sizeConteiner;

    @OneToMany(mappedBy = "sizeconteiner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public SizeConteiner() {

    }

    public SizeConteiner(String sizeConteiner) {
        this.sizeConteiner = sizeConteiner;
        deliveries = new ArrayList<>();
    }

    public void addSizeConteiner(Delivery delivery) {
        delivery.setSizeConteiner(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getSizeConteiner() {
        return sizeConteiner;
    }

    public void setSizeConteiner(String sizeConteiner) {
        this.sizeConteiner = sizeConteiner;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.sizeconteiner{" + "id" + id + ",sizeconteiner='" + sizeConteiner + '}';
    }

}
