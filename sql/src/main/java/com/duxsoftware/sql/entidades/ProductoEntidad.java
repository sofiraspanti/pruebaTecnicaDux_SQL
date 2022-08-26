package com.duxsoftware.sql.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProductoEntidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    private String codigo;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    @ManyToOne
    private RubroEntidad id_rubro;

    public ProductoEntidad() {
    }
   
    public ProductoEntidad(String codigo, String nombre, Date fecha_creacion, RubroEntidad id_rubro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.id_rubro = id_rubro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public RubroEntidad getId_rubro() {
        return id_rubro;
    }

    public void setId_rubro(RubroEntidad id_rubro) {
        this.id_rubro = id_rubro;
    }
    
    
    
    
}
