package com.duxsoftware.sql.repositorios;

import com.duxsoftware.sql.entidades.RubroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepositorio extends JpaRepository<RubroEntidad, Long> {
    
    
}
