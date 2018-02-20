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
    private int IdDetalleVenta ;
    private int IdProducto;
    private int IdFacturaVenta;
    private int Cantidad;
    private int PrecioT; 

    public DetalleVenta() {
    }

    public DetalleVenta(int IdDetalleVenta, int IdProducto, int IdFacturaVenta, int Cantidad, int PrecioT) {
        this.IdDetalleVenta = IdDetalleVenta;
        this.IdProducto = IdProducto;
        this.IdFacturaVenta = IdFacturaVenta;
        this.Cantidad = Cantidad;
        this.PrecioT = PrecioT;
    }

    public int getIdDetalleVenta() {
        return IdDetalleVenta;
    }

    public void setIdDetalleVenta(int IdDetalleVenta) {
        this.IdDetalleVenta = IdDetalleVenta;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdFacturaVenta() {
        return IdFacturaVenta;
    }

    public void setIdFacturaVenta(int IdFacturaVenta) {
        this.IdFacturaVenta = IdFacturaVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecioT() {
        return PrecioT;
    }

    public void setPrecioT(int PrecioT) {
        this.PrecioT = PrecioT;
    }
}
