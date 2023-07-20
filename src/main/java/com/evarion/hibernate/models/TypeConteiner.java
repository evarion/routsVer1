package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "typeconteiner")
public class TypeConteiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "typeconteiner")
    private String typeConteiner;

    @OneToMany(mappedBy = "typeconteiner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public TypeConteiner() {

    }

    public TypeConteiner(String typeConteiner) {
        this.typeConteiner = typeConteiner;
        deliveries = new ArrayList<>();
    }

    public void addDelivery(Delivery delivery) {
        delivery.setTypeConteiner(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getTypeConteiner() {
        return typeConteiner;
    }

    public void setTypeConteiner(String typeConteiner) {
        this.typeConteiner = typeConteiner;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.typeconteiner{" + "id" + id + ",typeconteiner='" + typeConteiner + '}';
    }

}
