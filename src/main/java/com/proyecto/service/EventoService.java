package com.proyecto.service;

import com.proyecto.domain.Evento;
import java.util.List;


public interface EventoService {
    
    //metodo para consultar los eventos.El parametro define si se muestran solo los activos o todos
    public List<Evento> getEventos(boolean activos);
    
    //Se obtiene una categoría por su id
    public Evento getEvento(Evento evento);
    
    //Insertar: se inserta cuando el idCategora está vacio (valor 0 o null)
    //Modificar: Se modifica cuando el idEvento NO está vacío
    public void save(Evento evento);
    
    
    //Se elimina un registro por su IdProducto
    
    public void delete(Evento evento);
    
}
