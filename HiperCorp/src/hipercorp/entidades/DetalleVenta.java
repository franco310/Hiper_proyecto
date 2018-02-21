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
    private int idProducto;
    private int idFacturaVenta;
    private int cantidad;
    private int precioTotal; 

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int idProducto, int idFacturaVenta, int cantidad, int precioTotal) {
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

    public int getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getidFacturaVenta() {
        return idFacturaVenta;
    }

    public void setidFacturaVenta(int idFacturaVenta) {
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