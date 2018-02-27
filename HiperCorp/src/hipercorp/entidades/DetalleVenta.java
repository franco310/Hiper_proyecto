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
    private Producto producto;
    private FacturaVenta facturaventa;
    private int cantidad;
    private int preciototal; 

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, Producto producto, FacturaVenta facturaventa, int cantidad, int preciototal) {
        this.idDetalleVenta = idDetalleVenta;
        this.producto = producto;
        this.facturaventa = facturaventa;
        this.cantidad = cantidad;
        this.preciototal = preciototal;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaventa() {
        return facturaventa;
    }

    public void setFacturaventa(FacturaVenta facturaventa) {
        this.facturaventa = facturaventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }
    
    
   
}