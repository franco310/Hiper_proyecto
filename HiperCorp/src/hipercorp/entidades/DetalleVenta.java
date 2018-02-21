/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.entidades;

/**
 *
 * @author Usuario
 */
public class DetalleVenta {
    private int idDetalleVenta ;
    private Producto idProducto;
    private FacturaVenta idFacturaVenta;
    private int cantidad;
    private int precioTotal; 

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, Producto idProducto, FacturaVenta idFacturaVenta, int cantidad, int precioTotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idFacturaVenta = idFacturaVenta;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getidDetalleVenta() {
        return idDetalleVenta;
    }

    public void setidDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Producto getidProducto() {
        return idProducto;
    }

    public void setidProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public FacturaVenta getidFacturaVenta() {
        return idFacturaVenta;
    }

    public void setidFacturaVenta(FacturaVenta idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getprecioTotal() {
        return precioTotal;
    }

    public void setprecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    
    

   

   
}