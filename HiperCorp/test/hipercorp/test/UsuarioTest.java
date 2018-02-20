/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.test;

import hipercorp.dao.IUsuario;
import hipercorp.entidades.Usuario;
import hipercorp.impl.UsuarioImpl;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Segovia
 */
public class UsuarioTest {
    

    public UsuarioTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IUsuario usuarioDao = new UsuarioImpl();
       
        Usuario usuario = new Usuario(
                2, "Kimberly", "Morales" , "bvdgy123");
        try {
            filasAfectadas = usuarioDao.insertar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        usuario = null;
        try {
            usuario = usuarioDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        try {
            usuario.setNombre("Prueba");
            filasAfectadas= usuarioDao.modificar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Usuario> lista = new ArrayList<>();
        try {
            lista = usuarioDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= usuarioDao.eliminar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }
    
}
