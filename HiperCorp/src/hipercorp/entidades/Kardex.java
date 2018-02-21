package hipercorp.entidades;

import java.sql.Date;

public class Kardex {
    private int idKardex;
    
    private Producto producto;
    private Date fechaEmision;
    private String tipoTransaccion;
    private int existencias;
    private int valorTotal;

    public Kardex() {
    }

    public Kardex(int idKardex, Producto producto, Date fechaEmision, String tipoTransaccion, int existencias, int valorTotal) {
        this.idKardex = idKardex;
        this.producto = producto;
        this.fechaEmision = fechaEmision;
        this.tipoTransaccion = tipoTransaccion;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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