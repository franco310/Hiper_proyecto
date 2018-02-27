
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.ICategoria;
import hipercorp.entidades.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class CategoriaImpl implements ICategoria{
    
     @Override
    public int insertar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into categoria  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getIdCategoria()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getDescripcion()));
     
        
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
    public int modificar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE categoria"
                + "   SET idCategoria=?, nombre=?,  "
                + "descripcion=? where idCategoria=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, categoria.getIdCategoria()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getDescripcion()));
         
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
    public int eliminar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM categoria  where idCategoria=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getIdCategoria()));       
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
    public Categoria obtener(int IdCategoria) throws Exception {
        Categoria categoria = null;
        String sql = "SELECT idCategoria,nombre , "
                + "decripcion FROM categoria where idCategoria=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdCategoria));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                 
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return categoria;
    }

    @Override
    public List<Categoria> obtener() throws Exception {
        List<Categoria> lista = new ArrayList<>();
         String sql = "SELECT idCategoria, nombre,descripcion "
                 + " FROM categoria";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Categoria categoria=null;
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                lista.add(categoria);
               
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
