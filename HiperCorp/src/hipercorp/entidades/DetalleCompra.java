
package hipercorp.entidades;


public class DetalleCompra {
    
    private int idDetalleCompra;
    private Proveedor proveedor;
    private FacturaCompra facturacompra;
    private int cantidada;
    private int preciototal;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalleCompra, Proveedor proveedor, FacturaCompra facturacompra, int cantidada, int preciototal) {
        this.idDetalleCompra = idDetalleCompra;
        this.proveedor = proveedor;
        this.facturacompra = facturacompra;
        this.cantidada = cantidada;
        this.preciototal = preciototal;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public FacturaCompra getFacturacompra() {
        return facturacompra;
    }

    public void setFacturacompra(FacturaCompra facturacompra) {
        this.facturacompra = facturacompra;
    }

    public int getCantidada() {
        return cantidada;
    }

    public void setCantidada(int cantidada) {
        this.cantidada = cantidada;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }
    
    
    
}
