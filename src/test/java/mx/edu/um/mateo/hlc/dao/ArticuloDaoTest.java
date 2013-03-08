/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.hlc.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.edu.um.mateo.general.model.Empresa;
import mx.edu.um.mateo.general.model.Organizacion;
import mx.edu.um.mateo.general.utils.Constantes;
import mx.edu.um.mateo.hlc.model.Articulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author osoto
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mateo.xml", "classpath:security.xml"})
@Transactional
public class ArticuloDaoTest {
    @Autowired
    private ArticuloDao instance;
    
    private static final Logger log= LoggerFactory.getLogger(ArticuloDaoTest.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Test
     public void testObtenerListaDeArticulos() {     
        log.debug("Muestra lista de articulos");
        Organizacion organizacion = new Organizacion("tst-01", "test-02", "test-03");
        currentSession().save(organizacion);
        Empresa empresa = new Empresa( "test01","test-01", "test-01", "000000000001", organizacion);
        currentSession().save(empresa);
        
        Articulo articulo = null;
        for(int i=0; i<5; i++){
            articulo = new Articulo();
            articulo.setCodigo(new BigInteger(String.valueOf(i)));
            articulo.setDescripcion("Prueba");
            articulo.setDescripcion1("Prueba1");
            articulo.setFecha(new Date());
            articulo.setGpoProducto("prueba");
            articulo.setSustancia("sustanciaX");
            articulo.setUm("umprueba");
            articulo.setcBarra(BigInteger.TEN);
            articulo.setEmpresa(empresa);
            
            instance.graba(articulo, null);
            assertNotNull(articulo.getId());
        }
         Map<String, Object> params= new HashMap<>();
         params.put("empresa",empresa.getId());
         Map<String, Object> result=instance.lista(params);
         assertNotNull(params.get(Constantes.CONTAINSKEY_ARTICULOS));
         assertEquals(5, ((List)params.get(Constantes.CONTAINSKEY_ARTICULOS)).size());
    }

     
    @Test
    public void testObtiene() {
        Organizacion organizacion = new Organizacion("tst-01", "test-02", "test-03");
        currentSession().save(organizacion);
        Empresa empresa = new Empresa("tst01", "test-02", "test-03", "000000000001", organizacion);
        currentSession().save(empresa);
        
        Articulo articulo = null;
        for(int i=0; i<5; i++){
            articulo = new Articulo();
            articulo.setCodigo(new BigInteger(String.valueOf(i)));
            articulo.setDescripcion("Prueba"+i);
            articulo.setDescripcion1("Prueba1");
            articulo.setFecha(new Date());
            articulo.setGpoProducto("prueba");
            articulo.setSustancia("sustanciaX");
            articulo.setUm("umprueba");
            articulo.setcBarra(BigInteger.TEN);
            articulo.setEmpresa(empresa);
            
            instance.graba(articulo, null);
            assertNotNull(articulo.getId());
        }
        
        Articulo articulo1= instance.obtiene(articulo.getId());
        assertEquals(articulo.getDescripcion(),"Prueba4");
        
       
    }
    @Test
    public void testGraba() throws Exception {
        Organizacion organizacion = new Organizacion("tst-01", "test-02", "test-03");
        currentSession().save(organizacion);
        Empresa empresa = new Empresa("tst01", "test-02", "test-03", "000000000001", organizacion);
        currentSession().save(empresa);
        Articulo articulo = new Articulo();
        articulo.setCodigo(new BigInteger(String.valueOf(1)));
        articulo.setDescripcion("Prueba");
        articulo.setDescripcion1("Prueba1");
        articulo.setFecha(new Date());
        articulo.setGpoProducto("prueba");
        articulo.setSustancia("sustanciaX");
        articulo.setUm("umprueba");
        articulo.setcBarra(BigInteger.TEN);
        articulo.setEmpresa(empresa);

        instance.graba(articulo, null);        
        assertNotNull(articulo.getId());
        
        assertEquals(articulo.getDescripcion(),"Prueba");
    }
    
    @Test
    public void testElimina() throws Exception {
        Organizacion organizacion = new Organizacion("tst-01", "test-02", "test-03");
        currentSession().save(organizacion);
        Empresa empresa = new Empresa("tst-01", "test-02", "test-03", "000000000001", organizacion);
        currentSession().save(empresa); 
        Articulo articulo = new Articulo();
        articulo.setCodigo(new BigInteger(String.valueOf(1)));
        articulo.setDescripcion("Prueba");
        articulo.setDescripcion1("Prueba1");
        articulo.setFecha(new Date());
        articulo.setGpoProducto("prueba");
        articulo.setSustancia("sustanciaX");
        articulo.setUm("umprueba");
        articulo.setcBarra(BigInteger.TEN);
        articulo.setEmpresa(empresa);

        instance.graba(articulo, null);        
        assertNotNull(articulo.getId());
        
        Articulo articuloTmp = instance.obtiene(articulo.getId());
        assertNotNull(articuloTmp);
        
        assertEquals(articuloTmp.getDescripcion(),instance.elimina(articulo.getId()));
        
    }
}

