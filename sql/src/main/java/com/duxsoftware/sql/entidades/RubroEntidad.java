package com.duxsoftware.sql.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RubroEntidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    private long id_rubro;
    private String rubro;

    public RubroEntidad() {
    }
       
    public RubroEntidad(long id_rubro, String rubro) {
        this.id_rubro = id_rubro;
        this.rubro = rubro;
    }

    public long getId_rubro() {
        return id_rubro;
    }

    public void setId_rubro(long id_rubro) {
        this.id_rubro = id_rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
    
}
