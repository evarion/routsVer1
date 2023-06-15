package com.evarion.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exportImport")

public class ExportImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "exportImport")
    private String exportImport;

    @OneToMany(mappedBy = "exportImport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries;

    public ExportImport() {

    }

    public ExportImport(String exportImport) {
        this.exportImport = exportImport;
        deliveries = new ArrayList<>();
    }

    public void addExportImport(Delivery delivery) {
        delivery.setExportImport(this);
        deliveries.add(delivery);
    }

    public int getId() {
        return id;
    }

    public String getExportImport() {
        return exportImport;
    }

    public void setExportImport(String exportImport) {
        this.exportImport = exportImport;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    @Override
    public String toString() {
        return "models.exportImport{" + "id" + id + ",exportImport='" + exportImport + '}';
    }
}
