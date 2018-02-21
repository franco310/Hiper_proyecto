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

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

   
}