

package hipercorp.entidades;

import java.util.Date;

public class FacturaVenta {
    private int idFacturaVenta;
    private Cliente cliente;
    private Date fecha;
    private int cedula;

    public FacturaVenta() {
    }

    public FacturaVenta(int idFacturaVenta, Cliente cliente, Date fecha, int cedula) {
        this.idFacturaVenta = idFacturaVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.cedula = cedula;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
