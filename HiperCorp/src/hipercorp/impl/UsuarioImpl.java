/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IUsuario;
import hipercorp.entidades.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Segovia
 */
public class UsuarioImpl  implements IUsuario{

      @Override
    public int insertar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into usuario  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getIdUsuario()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getApellido()));
        lstPar.add(new Parametro(4, usuario.getContraseña()));
                    
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE usuario"
                + "   SET idUsuario=?, nombre=?, "
                + " apellido=?,contraseña=? , where idUsuario=?";
        List<Parametro> lstPar = new ArrayList<>();
         lstPar.add(new Parametro(1, usuario.getIdUsuario()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getApellido()));
        lstPar.add(new Parametro(4, usuario.getContraseña()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM usuario  where idUsuario=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getIdUsuario()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Usuario obtener(int idUsuario) throws Exception {
        Usuario usuario = null;
        String sql =  "UPDATE usuario"
                + "   SET idUsuario=?, nombre=?, "
                + " apellido=?,contraseña=? , where idUsuario=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idUsuario));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                 usuario= new Usuario();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setApellido(rst.getString(3));
                usuario.setContraseña(rst.getString(4));
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtener() throws Exception {
        List<Usuario> lista = new ArrayList<>();
         String sql = "SELECT idUsuario,nombre , apellido,contraseña"
                 + " FROM usuario ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Usuario usuario=null;
            while (rst.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setApellido(rst.getString(3));
                usuario.setContraseña(rst.getString(4));
                               
                lista.add(usuario);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
}
