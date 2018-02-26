
package hipercorp.dao;

import hipercorp.entidades.Cliente;
import java.util.*;

/**
 *
 * @author Francisco
 */
public interface ICliente {
     public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(int idCliente) throws Exception;
    public List<Cliente> obtener() throws Exception;    
    
}
