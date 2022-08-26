package com.duxsoftware.sql.servicios;

import com.duxsoftware.sql.entidades.RubroEntidad;
import com.duxsoftware.sql.repositorios.RubroRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServicio {

    public final RubroRepositorio rubroRepositorio;

    @Autowired
    public RubroServicio(RubroRepositorio rubroRepositorio) {
        this.rubroRepositorio = rubroRepositorio;
    }
    
    @Transactional
    public void nuevoRubro(String rubro){
        RubroEntidad rubroNuevo = new RubroEntidad();
        rubroNuevo.setRubro(rubro);
        
        rubroRepositorio.save(rubroNuevo);
    }
    
    
    
    
}
