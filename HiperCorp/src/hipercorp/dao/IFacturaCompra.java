
package hipercorp.dao;
import hipercorp.entidades.FacturaCompra;
import java.util.List;


public interface IFacturaCompra {
    
     public int insertar(FacturaCompra facturacompra) throws Exception;
    public int modificar(FacturaCompra facturacompra) throws Exception;
    public int eliminar(FacturaCompra facturacompra) throws Exception;
    public FacturaCompra obtener(int idFacturaCompra) throws Exception;
    public List<FacturaCompra> obtener() throws Exception;  
    
}
