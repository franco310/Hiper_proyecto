
package hipercorp.test;

import hipercorp.dao.ICategoria;
import hipercorp.entidades.Categoria;
import hipercorp.impl.CategoriaImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CategoriaTest {

    public CategoriaTest() {
    }
    
     @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        ICategoria categoriaDao = new CategoriaImpl();
        Categoria categoria = new Categoria(5,"Frutas","ninguna");
        try {
            filasAfectadas = categoriaDao.insertar(categoria);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        categoria = null;
        try {
            categoria = categoriaDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        

        try {
            categoria.setNombre("Prueba");
            filasAfectadas= categoriaDao.modificar(categoria);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Categoria> lista = new ArrayList<>();
        try {
            lista = categoriaDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= categoriaDao.eliminar(categoria);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }
    
}
