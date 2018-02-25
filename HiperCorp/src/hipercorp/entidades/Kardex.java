package hipercorp.entidades;

import java.sql.Date;

public class Kardex {
    private int idKardex;
    private Producto producto;
    private DetalleCompra detalleCompra;
    private DetalleVenta detalleVenta;
    private Date fechaEmision;
    private int existencias;
    private int valorTotal;

    public Kardex() {
    }

    public Kardex(int idKardex, Producto producto, DetalleCompra detalleCompra, DetalleVenta detalleVenta, Date fechaEmision, int existencias, int valorTotal) {
        this.idKardex = idKardex;
        this.producto = producto;
        this.detalleCompra = detalleCompra;
        this.detalleVenta = detalleVenta;
        this.fechaEmision = fechaEmision;
        this.existencias = existencias;
        this.valorTotal = valorTotal;
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
    

