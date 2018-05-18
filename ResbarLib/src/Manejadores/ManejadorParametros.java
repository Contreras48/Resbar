
package Manejadores;

import ControladoresJPA.ParametroJpaController;
import Entidades.Parametro;

/**
 *
 * @author mateo
 */
public class ManejadorParametros {
    
    public static Parametro[] obtener(){
        ParametroJpaController controladorParametro = new ParametroJpaController();
        Parametro[] parametros = null;
        try {
            parametros = controladorParametro.findParametroEntities().toArray(parametros);
        } catch (Exception e) {
            System.out.println(e);
        }
        return parametros;
    }
    
    public void actualizar(Parametro p){
        ParametroJpaController controladorParametro = new ParametroJpaController();
        try {
            controladorParametro.edit(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Parametro obtener(int idParametro){
        ParametroJpaController controladorParametro = new ParametroJpaController();
        Parametro p = null;
        try {
            p = controladorParametro.findParametro(idParametro);
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
}
