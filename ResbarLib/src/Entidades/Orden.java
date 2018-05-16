
package Entidades;

import ControladoresJPA.DetalleOrdenJpaController;
import ControladoresJPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "Orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o WHERE o.estado = true")
    , @NamedQuery(name = "Orden.findAllName", query = "SELECT o FROM Orden o WHERE o.estado = true AND o.cliente like CONCAT('%',:cliente,'%')")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Orden.findByMesero", query = "SELECT o FROM Orden o WHERE o.mesero = :mesero")
    , @NamedQuery(name = "Orden.findByMesa", query = "SELECT o FROM Orden o WHERE o.mesa = :mesa")
    , @NamedQuery(name = "Orden.findByCliente", query = "SELECT o FROM Orden o WHERE o.cliente = :cliente")
    , @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Orden.findByComentario", query = "SELECT o FROM Orden o WHERE o.comentario = :comentario")
    , @NamedQuery(name = "Orden.findByTotal", query = "SELECT o FROM Orden o WHERE o.total = :total")
    , @NamedQuery(name = "Orden.findByEstado", query = "SELECT o FROM Orden o WHERE o.estado = :estado")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idOrden")
    private Integer idOrden;
    @Basic(optional = false)
    @Column(name = "mesero")
    private String mesero;
    @Basic(optional = false)
    @Column(name = "mesa")
    private String mesa;
    @Basic(optional = false)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "comentario")
    private String comentario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private List<DetalleOrden> detalleOrdenList;

    public Orden() {
    }

    public Orden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(Integer idOrden, String mesero, String mesa, String cliente, Date fecha, BigDecimal total, boolean estado) {
        this.idOrden = idOrden;
        this.mesero = mesero;
        this.mesa = mesa;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<DetalleOrden> getDetalleOrdenList() {
        return detalleOrdenList;
    }

    public void setDetalleOrdenList(List<DetalleOrden> detalleOrdenList) {
        this.detalleOrdenList = detalleOrdenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Orden[ idOrden=" + idOrden + " ]";
    }
    
    public void calcularTotal(){
        for (int i = 0; i < getDetalleOrdenList().size(); i++) {
            setTotal(new BigDecimal(getTotal().doubleValue() + (getDetalleOrdenList().get(i)).getCantidad().doubleValue() * getDetalleOrdenList().get(i).getProducto().getPrecio().doubleValue()));
        }
    }
    
    public void  agregarProducto(Producto p, Double cant){
        boolean existe = false;
        DetalleOrdenJpaController controladorD = new DetalleOrdenJpaController();
        int indice = 0;
        for (int i = 0; i < getDetalleOrdenList().size(); i++) {
            if(getDetalleOrdenList().get(i).getProducto().equals(p)){
                existe = true;
                indice = i;
                break;
            }
        }
        
        if(existe){
            getDetalleOrdenList().get(indice).setCantidad(new BigDecimal(getDetalleOrdenList().get(indice).getCantidad().doubleValue() + cant));
        }else{
            DetalleOrdenPK detallePk = new DetalleOrdenPK(getIdOrden(), p.getIdProducto());
            DetalleOrden detalle = new DetalleOrden(detallePk, new BigDecimal(cant));
            try {
                controladorD.create(detalle);
            } catch (Exception ex) {
                Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*List<DetalleOrden> listaDetalle = getDetalleOrdenList();
            listaDetalle.add(detalle);
            setDetalleOrdenList(listaDetalle);*/
        }
        calcularTotal();
    }
    
    public void eliminarProducto(Producto p, double cant){
        DetalleOrdenJpaController controladorD = new DetalleOrdenJpaController();
        DetalleOrdenPK detallePk = new DetalleOrdenPK(getIdOrden(), p.getIdProducto());
        try {
            controladorD.destroy(detallePk);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}