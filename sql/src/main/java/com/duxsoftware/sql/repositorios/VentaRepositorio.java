package com.duxsoftware.sql.repositorios;

import com.duxsoftware.sql.entidades.VentaEntidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<VentaEntidad, Long> {

    @Query("Select v from VentaEntidad v where v.codigo_producto.id_rubro.rubro LIKE %:bazar%")
    public List<VentaEntidad> findVentasRubroBazar();

    @Query("Select v.codigo_producto.nombre, COUNT(*) from VentaEntidad v GROUP BY v.codigo_producto.nombre")
    public List<VentaEntidad> findVentasPorProducto();

    @Query("Select v.id_cliente.nombre, SUM(v.precio_unitario) from VentaEntidad v GROUP BY v.id_cliente.nombre")
    public List<VentaEntidad> findMontoVendidoPorCliente();

    @Query("Select SUM(v.cantidad), c.nombre from VentaEntidad v INNER JOIN ClienteEntidad c ON v.id_cliente = c.id_cliente where v.fecha = MONTH(GETDATE()) GROUP BY c.nombre")
    public List<VentaEntidad> findCantidadProductosComprados();

    @Query("Select r.rubro from RubroEntidad r where r.id_rubro = (Select p.id_rubro from ProductoEntidad p where p.codigo = (Select v.codigo_producto from VentaEntidad v where v.fecha <> MONTH(GETDATE()-2)))")
    public List<VentaEntidad> rubrosSinVentas();
}
