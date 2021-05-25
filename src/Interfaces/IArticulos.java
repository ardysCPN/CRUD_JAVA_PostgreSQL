/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import java.util.Vector;
import modelos.Articulos;

/**
 *
 * @author Ardys CPN
 */
public interface IArticulos {
    //realizamos la declaracion del contrato o la declaracion de los metos a utilizar por las clases implementadoras
    
    /*
    *Metodo para listar los Articulos de la base de datos
    */
    public List<Articulos> listarDatos();
    
    
    /*
    * Metodo para insertar datos en la Base de Datos
    */
    public boolean InsertarArticulo(Articulos articulo);
    
    /*
    * Metodo para actualizar un dato de la Base de Datos
    */
    public boolean ActualizarArticulo(Articulos articulo);
    
    /*
    * Metodo para eliminar datos en la Base de Datos
    */
    public boolean EliminarArticulo(long codigo);
    
}
