
package hipercorp.dao;

import java.util.*;


public interface ICategoria {
    public int insertar(ICategoria categoria) throws Exception;
    public int modificar(ICategoria categoria) throws Exception;
    public int eliminar(ICategoria categoria) throws Exception;
    public ICategoria obtener(int CodCategoria) throws Exception;
    public List<ICategoria> obtener() throws Exception;   
    
}
