/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.hlc.dao.impl;

import java.util.HashMap;
import java.util.Map;
import mx.edu.um.mateo.general.dao.BaseDao;
import mx.edu.um.mateo.general.model.Usuario;
import mx.edu.um.mateo.general.utils.Constantes;
import mx.edu.um.mateo.hlc.dao.ArticuloDao;
import mx.edu.um.mateo.hlc.model.Articulo;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author osoto
 */
@Repository
public class ArticuloDaoHibernate extends BaseDao implements ArticuloDao{

    /**
     * @see mx.edu.um.mateo.hlc.dao.ArticuloDao#lista(java.util.Map) 
     */
    @Override
    public Map<String, Object> lista(Map<String, Object> params) {
        log.debug("Buscando lista de articulos con params {}", params);
        if (params == null) {
            params = new HashMap<>();
        }

        if (!params.containsKey("max")) {
            params.put("max", 10);
        } else {
            params.put("max", Math.min((Integer) params.get("max"), 100));
        }

        if (params.containsKey("pagina")) {
            Long pagina = (Long) params.get("pagina");
            Long offset = (pagina - 1) * (Integer) params.get("max");
            params.put("offset", offset.intValue());
        }

        if (!params.containsKey("offset")) {
            params.put("offset", 0);
        }
        Criteria criteria = currentSession().createCriteria(Articulo.class);
        Criteria countCriteria = currentSession().createCriteria(Articulo.class);
        

        if (params.containsKey("empresa")) {
            criteria.createCriteria("empresa").add(Restrictions.idEq(params.get("empresa")));
            countCriteria.createCriteria("empresa").add(Restrictions.idEq(params.get("empresa")));
        }

        if (params.containsKey("filtro")) {
            String filtro = (String) params.get("filtro");
            Disjunction propiedades = Restrictions.disjunction();
            propiedades.add(Restrictions.ilike("descripcion", filtro, MatchMode.ANYWHERE));
            propiedades.add(Restrictions.ilike("sustancia", filtro, MatchMode.ANYWHERE));
            propiedades.add(Restrictions.ilike("cBarra", filtro, MatchMode.ANYWHERE));
            criteria.add(propiedades);
            countCriteria.add(propiedades);
        }

        if (params.containsKey("order")) {
            String campo = (String) params.get("order");
            if (params.get("sort").equals("desc")) {
                criteria.addOrder(Order.desc(campo));
            } else {
                criteria.addOrder(Order.asc(campo));
            }
        }

        if (!params.containsKey("reporte")) {
            criteria.setFirstResult((Integer) params.get("offset"));
            criteria.setMaxResults((Integer) params.get("max"));
        }
        params.put(Constantes.CONTAINSKEY_ARTICULOS, criteria.list());

        countCriteria.setProjection(Projections.rowCount());
        params.put("cantidad", (Long) countCriteria.list().get(0));

        return params;
    }

    /**
     * @see mx.edu.um.mateo.hlc.dao.ArticuloDao#obtiene(java.lang.Long) 
     */
    @Override
    public Articulo obtiene(final Long id) {
        Articulo articulo = (Articulo) currentSession().get(Articulo.class, id);
        if (articulo == null) {
            log.warn("uh oh, articulo with id '" + id + "' not found...");
            //throw new ObjectRetrievalFailureException(Articulo.class, id);
        }

        return articulo;
    }

    /**
     * @see mx.edu.um.mateo.hlc.dao.ArticuloDao#graba(mx.edu.um.mateo.hlc.model.Articulo, mx.edu.um.mateo.general.model.Usuario) 
     */
    @Override
    public void graba(final Articulo articulo, Usuario usuario) {
        if (usuario != null) {
            articulo.setEmpresa(usuario.getEmpresa());
        }
        currentSession().saveOrUpdate(articulo);
        currentSession().merge(articulo);
        currentSession().flush();
    }

    /**
     * @see mx.edu.um.mateo.hlc.dao.ArticuloDao#elimina(java.lang.Long) 
     */
    @Override
    public String elimina(final Long id) {
        log.debug("Eliminando la articulo {}", id);
        Articulo articulo = this.obtiene(id);
        String nombre = articulo.getDescripcion();
        currentSession().delete(articulo);

        currentSession().flush();

        return nombre;


    }   
}
