package com.duxsoftware.sql.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VentaEntidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    private long id_venta;    
    @ManyToOne
    private ProductoEntidad codigo_producto;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private long cantidad;
    private double precio_unitario;
    @ManyToOne
    private ClienteEntidad id_cliente;

    public VentaEntidad() {
    }

    public VentaEntidad(long id_venta, ProductoEntidad codigo_producto, Date fecha, long cantidad, double precio_unitario, ClienteEntidad id_cliente) {
        this.id_venta = id_venta;
        this.codigo_producto = codigo_producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.id_cliente = id_cliente;
    }

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id_venta) {
        this.id_venta = id_venta;
    }

    public ProductoEntidad getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(ProductoEntidad codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public ClienteEntidad getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteEntidad id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
    
    
}
