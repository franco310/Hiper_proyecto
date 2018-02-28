
package hipercorp.entidades;

import java.util.Date;

public class FacturaCompra {
    
    private int idFacturaCompra;
    private Proveedor proveedor;
    private Producto producto;
    private Date fecha;
    private int cantidad;
    private String tipo_pago;

    public FacturaCompra() {
    }

    public FacturaCompra(int idFacturaCompra, Proveedor proveedor, Producto producto, Date fecha, int cantidad, String tipo_pago) {
        this.idFacturaCompra = idFacturaCompra;
        this.proveedor = proveedor;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipo_pago = tipo_pago;
    }

    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    @Override 
    public String toString(){
        return tipo_pago;
    }
    
   
}