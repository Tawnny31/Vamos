
package com.proyecto.service;

import com.proyecto.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    //metodo para consultar las categorias.El parametro define si se muestran solo las activas o todas
    public List<Categoria> getCategorias(boolean activos);
    
    //Se obtiene una categoría por su id
    public Categoria getCategoria(Categoria categoria);
    
    //Insertar: se inserta cuando el idCategora está vacio (valor 0 o null)
    //Modificar: Se modifica cuando el idCategoria NO está vacío
    public void save(Categoria categoria);
    
    
    //Se elimina un registro por su IdCategoria
    
    public void delete(Categoria categoria);
    
}
