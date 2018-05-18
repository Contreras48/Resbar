
package Manejadores;

import ControladoresJPA.CategoriaJpaController;
import ControladoresJPA.exceptions.NonexistentEntityException;
import Entidades.Categoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class ManejadorCategorias {
    //Sin terminar
    public static Categoria[] obtener(boolean producto){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        Categoria[] categorias = null;
        try {
            List<Categoria> lista = controladorC.findCategoriaEntities();
            categorias = new Categoria[lista.size()];
            lista.toArray(categorias);
            System.out.println("categorias cargadas");
        } catch (Exception e) {
            System.out.println(e);
        }
        return categorias;
    }
    
    public static void actualizar(Categoria c){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        System.out.println(c.getIdCategoria());
        System.out.println(c.getNombre());
        try {
            controladorC.edit(c);
            System.out.println("Categoria modificada");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ManejadorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ManejadorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void insertar(Categoria c){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        try {
            controladorC.create(c);
            System.out.println("Categoria creada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void eliminar(Categoria c){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        try {
            controladorC.destroy(c.getIdCategoria());
            System.out.println("Categoria eliminada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Integer obtenerId(){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        Integer id = 0;
        try {
            id = controladorC.FindId();
            System.out.println(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if(id == null){
            id = 0;
        }
        
        return id+1;
    }
    
    public static Categoria buscar(String categoria){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        Categoria c = new Categoria();
        try {
           c = controladorC.findCategoriaByName(categoria);
           System.out.println(c.getIdCategoria()+" "+c.getNombre());
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }
    
}
