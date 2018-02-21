
package hipercorp.entidades;

import java.util.Date;

public class FacturaCompra {
    
    private int idFacturaCompra;
    private String fecha;
    private Proveedor proveedor;

    public FacturaCompra() {
    }

    public FacturaCompra(int idFacturaCompra, String fecha, Proveedor proveedor) {
        this.idFacturaCompra = idFacturaCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }

    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
  @Override
  public String toString(){
      return fecha;
  }  
    
   
}