package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seaLine")

public class SeaLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seaLine")
    private String seaLine;

    @OneToMany(mappedBy = "seaLine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public SeaLine() {

    }

    public SeaLine(String seaLine) {
        this.seaLine = seaLine;
        deliveries = new ArrayList<>();
    }

    public void addSeaLine(Delivery delivery) {
        delivery.setSeaLine(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getSeaLine() {
        return seaLine;
    }

    public void setSeaLine(String seaLine) {
        this.seaLine = seaLine;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.seaLine{" + "id" + id + ",exportImport='" + seaLine + '}';
    }

}
