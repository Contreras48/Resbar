
package Manejadores;

import ControladoresJPA.CategoriaJpaController;
import Entidades.Categoria;

/**
 *
 * @author mateo
 */
public class ManejadorCategorias {
    
    //Sin terminar
    public static Categoria[] obtener(boolean producto){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        Categoria[] categorias = null;
        return controladorC.findCategoriaEntities().toArray(categorias);
    }
    
    public static void actualizar(Categoria c){
        CategoriaJpaController controladorC = new CategoriaJpaController();
        try {
            controladorC.edit(c);
            System.out.println("Categoria modificada");
        } catch (Exception e) {
            System.out.println(e);
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
        return controladorC.FindId()+1;
    }
}
