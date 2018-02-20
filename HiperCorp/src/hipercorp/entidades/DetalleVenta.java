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
    private int CodDetalleVenta ;
    private int CodProducto;
    private int CodFacturaVenta;
    private int Cantidad;
    private int PrecioT; 

    public DetalleVenta() {
    }

    public DetalleVenta(int CodDetalleVenta, int CodProducto, int CodFacturaVenta, int Cantidad, int PrecioT) {
        this.CodDetalleVenta = CodDetalleVenta;
        this.CodProducto = CodProducto;
        this.CodFacturaVenta = CodFacturaVenta;
        this.Cantidad = Cantidad;
        this.PrecioT = PrecioT;
    }

    public int getCodDetalleVenta() {
        return CodDetalleVenta;
    }

    public void setCodDetalleVenta(int CodDetalleVenta) {
        this.CodDetalleVenta = CodDetalleVenta;
    }

    public int getCodProducto() {
        return CodProducto;
    }

    public void setCodProducto(int CodProducto) {
        this.CodProducto = CodProducto;
    }

    public int getCodFacturaVenta() {
        return CodFacturaVenta;
    }

    public void setCodFacturaVenta(int CodFacturaVenta) {
        this.CodFacturaVenta = CodFacturaVenta;
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
