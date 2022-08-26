package com.duxsoftware.sql.repositorios;

import com.duxsoftware.sql.entidades.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteEntidad, Long>{
    
    
    
}
