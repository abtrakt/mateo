/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.hlc.dao;

import java.util.Map;
import mx.edu.um.mateo.general.model.Usuario;
import mx.edu.um.mateo.hlc.model.Articulo;

/**
 *
 * @author osoto
 */
public interface ArticuloDao {
    
    /**
     * Regresa una lista de articulos.
     * @param articulo
     * @return 
     */
    public Map<String, Object> lista (Map<String, Object> params);

    /**
     * Obtiene una articulo
     * @param id
     * @return 
     */
    public Articulo obtiene(final Long id);

    /**
     * Guarda la informacion de la articulo
     * @param articulo el objeto que sera guardado
     */    
    public void graba(Articulo articulo, Usuario usuario);

    /**
     * Borra la articulo de la base de datos mediante el id
     * @param id id de la articulo
     */
    public String elimina(final Long id);
}
