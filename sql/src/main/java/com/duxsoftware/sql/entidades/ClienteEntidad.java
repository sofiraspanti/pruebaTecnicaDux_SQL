package com.duxsoftware.sql.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClienteEntidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    private long id_cliente;
    private String nombre;
    private String apellido;
    private int cuit;

    public ClienteEntidad() {
    }

    public ClienteEntidad(long id_cliente, String nombre, String apellido, int cuit) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuit = cuit;
    }
        
    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    
    
    
}
