package com.duxsoftware.sql.servicios;

import com.duxsoftware.sql.entidades.ProductoEntidad;
import com.duxsoftware.sql.entidades.RubroEntidad;
import com.duxsoftware.sql.repositorios.ProductoRepositorio;
import com.duxsoftware.sql.repositorios.RubroRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    public final ProductoRepositorio productoRepositorio;
    public final RubroRepositorio rubroRepositorio;

    @Autowired
    public ProductoServicio(ProductoRepositorio productoRepositorio, RubroRepositorio rubroRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.rubroRepositorio = rubroRepositorio;
    }

    @Transactional
    public void nuevoProducto(String nombre, Long id_rubro) {
        ProductoEntidad producto = new ProductoEntidad();
        producto.setNombre(nombre);
        producto.setFecha_creacion(new Date());

        Optional<RubroEntidad> respuesta = rubroRepositorio.findById(id_rubro);
        if (respuesta.isPresent()) {
            RubroEntidad rubro = respuesta.get();
            producto.setId_rubro(rubro);
        }

        productoRepositorio.save(producto);
    }

    public List<ProductoEntidad> productosDeLibreria() { //Todos los productos del rubro "libreria" creados hoy
        Date fechaHoy = new Date();
        return productoRepositorio.findProductosLibreria(fechaHoy);
    }
    
}
