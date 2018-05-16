
package Manejadores;

import ControladoresJPA.DetalleOrdenJpaController;
import ControladoresJPA.OrdenJpaController;
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
            controladorOrden.findOrdenEntities().toArray(ordenes);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ordenes;
    }
    
    public static void actualizar(Orden o){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        DetalleOrdenJpaController controladorDetalle = new DetalleOrdenJpaController();
        List<DetalleOrden> listaDetalle = new ArrayList<DetalleOrden>();
        o.calcularTotal();
        if(o.getTotal().doubleValue() > 0){
            for (int i = 0; i < o.getDetalleOrdenList().size(); i++) {
                DetalleOrdenPK detallePk = new DetalleOrdenPK(o.getIdOrden(), o.getDetalleOrdenList().get(i).getProducto().getIdProducto());
                DetalleOrden detatalle = controladorDetalle.findDetalleOrden(detallePk);
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
    
    public static void insertar(Orden o){
        OrdenJpaController controladorOrden = new OrdenJpaController();
        DetalleOrdenJpaController controladorDetalle = new DetalleOrdenJpaController();
        
        if(!o.getCliente().isEmpty() && !o.getMesero().isEmpty() && !o.getMesa().isEmpty()){
            o.calcularTotal();
            if(o.getTotal().doubleValue() > 0){
                try {
                    controladorOrden.create(o);
                    //falta crear objeto DetalleOrden
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
        } catch (Exception e) {
        }
    }
}
