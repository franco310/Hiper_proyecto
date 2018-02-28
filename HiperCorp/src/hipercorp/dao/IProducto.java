
package hipercorp.dao;

import hipercorp.entidades.Producto;
import java.util.List;
import java.util.*;

public interface IProducto {
    public int insertar(Producto producto) throws Exception;
    public int modificar(Producto producto) throws Exception;
    public int eliminar(Producto producto) throws Exception;
    public Producto obtener(int idProducto) throws Exception;
    public List<Producto> obtener() throws Exception;   
}
