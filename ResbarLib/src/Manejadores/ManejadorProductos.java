
package Manejadores;

import ControladoresJPA.ProductoJpaController;
import Entidades.Producto;

/**
 *
 * @author mateo
 */
public class ManejadorProductos {
    
    public static Producto[] obtenerxCategoria(Integer idCategoria){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        Producto[] productos = null;
        try {
            productos = controladorProducto.findProductoByCategoria(idCategoria).toArray(productos);
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
    }
    
    public static Producto[] buscar(String nombre){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        Producto[] productos = null;
        try {
            productos = controladorProducto.findProductoByName(nombre).toArray(productos);
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
    }
    
    public static void insertar(Producto p){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        try {
            controladorProducto.create(p);
            System.out.println("Producto agregado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void actualizar(Producto p){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        try {
            controladorProducto.edit(p);
            System.out.println("Producto editado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void eliminar(Producto p){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        try {
            controladorProducto.destroy(p.getIdProducto());
            System.out.println("Producto eliminado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Producto obtener(Integer idProducto){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        Producto producto = new Producto();
        try {
            producto = controladorProducto.findProducto(idProducto);
            System.out.println("Producto encontrado");
        } catch (Exception e) {
            System.out.println(e);
        }
        return producto;
    }
    
    public static Integer obtenerId(){
        ProductoJpaController controladorProducto = new ProductoJpaController();
        Integer id = 0;
        try {
            id = controladorProducto.FindId();
        } catch (Exception e) {
        }
        return id+1;
    }
}
