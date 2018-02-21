
package hipercorp.dao;

import hipercorp.entidades.Categoria;
import java.util.*;


public interface ICategoria {
    public int insertar(Categoria categoria) throws Exception;
    public int modificar(Categoria categoria) throws Exception;
    public int eliminar(Categoria categoria) throws Exception;
    public Categoria obtener(int idCategoria) throws Exception;
    public List<Categoria> obtener() throws Exception;   
    
}
