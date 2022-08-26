package com.duxsoftware.sql.repositorios;

import com.duxsoftware.sql.entidades.ProductoEntidad;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<ProductoEntidad, Long>{
    
  
    
    @Query("Select p from ProductoEntidad p where p.id_rubro.rubro LIKE %:libreria% AND p.fecha_creacion LIKE %:fechaHoy%")   
    public List <ProductoEntidad> findProductosLibreria(@Param("fechaHoy") Date fechaHoy);


    
}
