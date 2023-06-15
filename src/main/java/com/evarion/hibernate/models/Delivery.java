package com.evarion.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "container")
    private String container;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_id")
    private Vessel vessel;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    private Port port;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sealine_id")
    private SeaLine seaLine;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "exportimport_id")
    private ExportImport exportImport;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeconteiner_id")
    private TypeConteiner typeConteiner;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizeconteiner_id")
    private SizeConteiner sizeConteiner;

    public Delivery() {
    }

    public Delivery(String container) {
        this.container = container;
    }

    public int getId() {
        return id;
    }

    public String getContainer() {
        return container;
    }
    public void setContainer(String container) {
        this.container = container;
    }

    public Vessel getVessel() {
        return vessel;
    }
    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Port getPort() {
        return port;
    }
    public void setPort(Port port) {
        this.port = port;
    }

    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public SeaLine getSeaLine() {
        return seaLine;
    }
    public void setSeaLine(SeaLine seaLine) {
        this.seaLine = seaLine;
    }

    public ExportImport getExportImport() {
        return exportImport;
    }
    public void setExportImport(ExportImport exportImport) {
        this.exportImport = exportImport;
    }


    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public TypeConteiner getTypeConteiner() {
        return typeConteiner;
    }
    public void setTypeConteiner(TypeConteiner typeConteiner) {
        this.typeConteiner = typeConteiner;
    }

    public SizeConteiner getSizeConteiner() {
        return sizeConteiner;
    }
    public void setSizeConteiner(SizeConteiner sizeConteiner) {
        this.sizeConteiner = sizeConteiner;
    }


    @Override
    public String toString() {
        return container;
    }
}

