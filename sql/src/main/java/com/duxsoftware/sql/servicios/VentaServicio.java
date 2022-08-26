package com.duxsoftware.sql.servicios;

import com.duxsoftware.sql.entidades.ClienteEntidad;
import com.duxsoftware.sql.entidades.ProductoEntidad;
import com.duxsoftware.sql.entidades.RubroEntidad;
import com.duxsoftware.sql.entidades.VentaEntidad;
import com.duxsoftware.sql.repositorios.ClienteRepositorio;
import com.duxsoftware.sql.repositorios.ProductoRepositorio;
import com.duxsoftware.sql.repositorios.VentaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServicio {
    
    public final VentaRepositorio ventaRepositorio;
    public final ProductoRepositorio productoRepositorio;
    public final ClienteRepositorio clienteRepositorio;

    @Autowired
    public VentaServicio(VentaRepositorio ventaRepositorio, ProductoRepositorio productoRepositorio, ClienteRepositorio clienteRepositorio) {
        this.ventaRepositorio = ventaRepositorio;
        this.productoRepositorio = productoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }
    
    public void nuevaVenta(Long codigo_producto, Long cantidad, double precio_unitario, Long id_cliente){
        VentaEntidad venta = new VentaEntidad();
        
        Optional <ProductoEntidad> respuesta1 = productoRepositorio.findById(codigo_producto);
        if(respuesta1.isPresent()){
            ProductoEntidad producto = respuesta1.get();
            venta.setCodigo_producto(producto);            
        }
        
        venta.setCantidad(cantidad);
        venta.setPrecio_unitario(precio_unitario);
        
        Optional <ClienteEntidad> respuesta2 = clienteRepositorio.findById(id_cliente);
        if(respuesta2.isPresent()){
            ClienteEntidad cliente = respuesta2.get();
            venta.setId_cliente(cliente);
        }       
        
        ventaRepositorio.save(venta);
    }
    
    public List <VentaEntidad> ventaRubroBazar(){ //Ventas que tienen al menos un producto del rubro "bazar"
        
        return ventaRepositorio.findVentasRubroBazar();
    } 
    
    public List <VentaEntidad> ventasPorProducto(){ // Cantidad de ventas por producto
        return ventaRepositorio.findVentasPorProducto();
    }
    
    public List <VentaEntidad> montoVendidoPorCliente(){ // Monto total vendido por cliente 
        return ventaRepositorio.findMontoVendidoPorCliente();        
    }
    
    public List <VentaEntidad> cantidadProductosComprados (){ //Cantidad de prdductos comprados por cliente en el mes actual
        return ventaRepositorio.findCantidadProductosComprados();
    }
}
