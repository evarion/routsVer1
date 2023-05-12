package com.evarion.modelBase;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false, length = 100)
    String container;

    @ManyToOne
    SeaLIne seaLIne;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public SeaLIne getSeaLIne() {
        return seaLIne;
    }

    public void setSeaLIne(SeaLIne seaLIne) {
        this.seaLIne = seaLIne;
    }
}
