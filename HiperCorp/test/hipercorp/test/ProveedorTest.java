package hipercorp.test;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import hipercorp.dao.*;
import hipercorp.entidades.*;
import hipercorp.impl.*;
public class ProveedorTest {

    public ProveedorTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IProveedor proveedorDao = new ProveedorImpl();
       
        Proveedor proveedor = new Proveedor(
                5, "Diego", "Loja" , "0983851377","dc@gmail.com");
        try {
            filasAfectadas = proveedorDao.insertar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        proveedor = null;
        try {
            proveedor = proveedorDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        try {
            proveedor.setNombre("Prueba");
            filasAfectadas= proveedorDao.modificar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Proveedor> lista = new ArrayList<>();
        try {
            lista = proveedorDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= proveedorDao.eliminar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
