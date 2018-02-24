

package hipercorp.entidades;

import java.util.Date;

public class FacturaVenta {
    private int idFacturaVenta;
    private Producto producto;
    private Empleado  emplaedo;
    private Cliente cliente;
      private Date fecha;
      private int cantidad;
    private String tipo_pago;

    public FacturaVenta() {
    }

    public FacturaVenta(int idFacturaVenta, Producto producto, Empleado emplaedo, Cliente cliente, Date fecha, int cantidad, String tipo_pago) {
        this.idFacturaVenta = idFacturaVenta;
        this.producto = producto;
        this.emplaedo = emplaedo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipo_pago = tipo_pago;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empleado getEmplaedo() {
        return emplaedo;
    }

    public void setEmplaedo(Empleado emplaedo) {
        this.emplaedo = emplaedo;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

   
   
    
   
   }