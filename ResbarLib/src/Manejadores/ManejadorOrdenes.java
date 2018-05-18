
package Manejadores;

import ControladoresJPA.DetalleOrdenJpaController;
import ControladoresJPA.OrdenJpaController;
import ControladoresJPA.exceptions.IllegalOrphanException;
import ControladoresJPA.exceptions.NonexistentEntityException;
import Entidades.DetalleOrden;
import Entidades.DetalleOrdenPK;
import Entidades.Orden;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class ManejadorOrdenes {
    
    public static Orden[] ordenesActivas(){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        Orden[] ordenes = null;
        try {
            ordenes = controladorOrden.findOrdenEntities().toArray(ordenes);
            System.out.println("Ordenes Activas");
        } catch (Exception e) {
            System.out.println(e);
        }
        return ordenes;
    }
    
    public static void actualizar(Orden o){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        DetalleOrdenJpaController controladorDetalle = new DetalleOrdenJpaController();
        List<DetalleOrden> listaDetalle = new ArrayList<>();
        o.calcularTotal();
        if(o.getTotal().doubleValue() > 0){
            for (int i = 0; i < o.getDetalleOrdenList().size(); i++) {
                DetalleOrdenPK detallePk = new DetalleOrdenPK(o.getIdOrden(), o.getDetalleOrdenList().get(i).getProducto().getIdProducto());
                listaDetalle.add(controladorDetalle.findDetalleOrden(detallePk));
                try {
                    controladorDetalle.destroy(detallePk);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ManejadorOrdenes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                controladorOrden.edit(o);
                for (int i = 0; i < listaDetalle.size(); i++) {
                    controladorDetalle.create(listaDetalle.get(i));
                }
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ManejadorOrdenes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ManejadorOrdenes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static Orden[] obtener(String nombre, String filtro){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        List<Orden> ordenes = new ArrayList<>();
        Orden[] listaOrdenes = null;
        try {
            switch(filtro){
                case "Mesa":
                   ordenes.add(controladorOrden.findProductoByMesa(nombre));
                   break;
                case "Cliente":
                    ordenes = controladorOrden.findProductoByCliente(nombre);
                    break;
                case "Mesero":
                    ordenes = controladorOrden.findProductoByMesero(nombre);
                    break;
                case "Comentario":
                    ordenes = controladorOrden.findProductoByComentario(nombre);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ordenes.toArray(listaOrdenes);
    }
    
    public static void insertar(Orden o, DetalleOrden[] dOrden){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        DetalleOrdenJpaController controladorDetalle = new DetalleOrdenJpaController();
        
        if(!o.getCliente().isEmpty() && !o.getMesero().isEmpty() && !o.getMesa().isEmpty()){
            o.calcularTotal();
            if(o.getTotal().doubleValue() > 0){
                try {
                    controladorOrden.create(o);
                    for (DetalleOrden dOrden1 : dOrden) {
                        controladorDetalle.create(dOrden1);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ManejadorOrdenes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void eliminar(Orden o){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        DetalleOrdenJpaController controladorDetalle = new DetalleOrdenJpaController();
        
        try {
            for (int i = 0; i < o.getDetalleOrdenList().size(); i++) {
                DetalleOrdenPK detallePk = new DetalleOrdenPK(o.getIdOrden(), o.getDetalleOrdenList().get(i).getProducto().getIdProducto());
                controladorDetalle.destroy(detallePk);
            }
            controladorOrden.destroy(o.getIdOrden());
        } catch (IllegalOrphanException | NonexistentEntityException e) {
        }
    }
    
    public static Integer ObtenerId(){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        Integer id = 0;
        try {
            id = controladorOrden.FindId();
            System.out.println(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return id+1;
    }
}
