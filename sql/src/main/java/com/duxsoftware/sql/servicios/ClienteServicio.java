package com.duxsoftware.sql.servicios;

import com.duxsoftware.sql.entidades.ClienteEntidad;
import com.duxsoftware.sql.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {

    public final ClienteRepositorio clienteRepositorio;

    @Autowired
    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public void nuevoCliente(String nombre, String apellido, int cuit) {
        ClienteEntidad cliente = new ClienteEntidad();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCuit(cuit);
        
        clienteRepositorio.save(cliente);
    }
    
    

}
