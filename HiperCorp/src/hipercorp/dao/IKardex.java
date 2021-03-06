package hipercorp.dao;
import hipercorp.entidades.*;
import java.util.*;

public interface IKardex {
    public int insertar(Kardex kardex) throws Exception;
    public int modificar(Kardex kardex) throws Exception;
    public int eliminar(Kardex kardex) throws Exception;
    public Kardex obtener(int idKardex) throws Exception;
    public List<Kardex> obtener() throws Exception;    
}
