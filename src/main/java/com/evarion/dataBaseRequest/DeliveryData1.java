package com.evarion.dataBaseRequest;

class DeliveryData1 {
    private String id;
    private String container;
    private String line_id;
    private String vessel_id;
    private String port_id;
    private String cargo_id;
    private String exportimport_id;
    private String country_id;
    private String status_id;
    private String typeconteiner_id;
    private String sizeconteiner_id;




    public DeliveryData1(String id, String container, String line_id, String vessel_id, String port_id,
                         String cargo_id, String exportimport_id, String country_id, String status_id,
                         String typeconteiner_id, String sizeconteiner_id) {
        this.id = id;
        this.container=container;
        this.line_id=line_id;
        this.vessel_id=vessel_id;
        this.port_id=port_id;
        this.cargo_id=cargo_id;
        this.exportimport_id=exportimport_id;
        this.country_id=country_id;
        this.status_id=status_id;
        this.typeconteiner_id=typeconteiner_id;
        this.sizeconteiner_id=sizeconteiner_id;

    }


    public String getId() {
        return this.id;
    }

    public String getContainer() {
        return this.container;
    }
    public String getLine_id() {
        return this.line_id;
    }

    public String getVessel_id() {
        return this.vessel_id;
    }

    public String getPort_id() {
        return this.port_id;
    }

    public String getCargo_id() {
        return this.cargo_id;
    }

    public String getExportimport_id() {
        return this.exportimport_id;
    }

    public String getCountry_id() {
        return this.country_id;
    }

    public String getStatus_id() {
        return this.status_id;
    }

    public String getTypeconteiner_id() {
        return this.typeconteiner_id;
    }

    public String getSizeconteiner_id() {
        return this.sizeconteiner_id;
    }
}



