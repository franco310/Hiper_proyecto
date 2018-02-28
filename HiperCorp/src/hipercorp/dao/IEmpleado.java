
package hipercorp.dao;

import hipercorp.entidades.Empleado;
import java.util.List;

public interface IEmpleado {
     public int insertar(Empleado empleado) throws Exception;
    public int modificar(Empleado empleado) throws Exception;
    public int eliminar(Empleado empleado) throws Exception;
    public Empleado obtener(int idEmpleado) throws Exception;
    public List<Empleado> obtener() throws Exception;  
    
}
