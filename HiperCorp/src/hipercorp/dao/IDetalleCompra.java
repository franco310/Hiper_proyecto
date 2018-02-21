
package hipercorp.dao;

import hipercorp.entidades.DetalleCompra;
import java.util.List;

public interface IDetalleCompra {
    public int insertar(DetalleCompra detallecompra) throws Exception;
    public int modificar(DetalleCompra detallecompra) throws Exception;
    public int eliminar(DetalleCompra detallecompra) throws Exception;
    public DetalleCompra obtener(int idDetalleCompra) throws Exception;
    public List<DetalleCompra> obtener() throws Exception;
    
}
