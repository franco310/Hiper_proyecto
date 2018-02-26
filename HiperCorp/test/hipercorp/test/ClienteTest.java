
package hipercorp.test;

import hipercorp.dao.ICliente;
import hipercorp.entidades.Cliente;
import hipercorp.impl.ClienteImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class ClienteTest {
    
     public ClienteTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente (107,"172374239-9","Francisco", "Acipuela","Av.Mariscal Sucre",
               "0998540000","franco10_@outlook.com", new Date());
        try {
            filasAfectadas = clienteDao.insertar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        cliente = null;
        try {
            cliente = clienteDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        

        try {
            cliente.setNombre("Prueba");
            filasAfectadas= clienteDao.modificar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= clienteDao.eliminar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
