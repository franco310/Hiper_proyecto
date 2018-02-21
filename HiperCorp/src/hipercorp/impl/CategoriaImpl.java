
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.ICategoria;
import hipercorp.entidades.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class CategoriaImpl implements ICategoria {
    @Override
    public int insertar(Categoria categoria) throws Exception {
       int numFilasAfectadas = 0;
       String sql = "insert into categoria values (?,?,?)";
        List<Parametro> lst;
        lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getidCategoria()));
        lst.add(new Parametro(2, categoria.gettipo()));
        lst.add(new Parametro(3, categoria.getdescripcion()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lst);
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
        String sql = "UPDATE categoria, SET idCategoria=?, "
                + "tipo=?,descripcion=?";       
        List<Parametro> lst = new ArrayList<>();
        lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getidCategoria()));
        lst.add(new Parametro(2, categoria.gettipo()));
        lst.add(new Parametro(3, categoria.getdescripcion()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lst);
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
         String sql = "DELETE FROM Categoria where idCategoria=?";
        List<Parametro> lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getidCategoria()));
        lst.add(new Parametro(2, categoria.gettipo()));
        lst.add(new Parametro(3, categoria.getdescripcion()));   
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lst);
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
    public  Categoria obtener(int idCategoria ) throws Exception {
        Categoria categoria= null;
        String sql="UPDATE idCategoria, SET idCategoria=?, "
                + "tipo=?,descripcion=? FROM categoria WHERE idCategoria";       
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getidCategoria()));
        lstPar.add(new Parametro(2, categoria.gettipo()));
        lstPar.add(new Parametro(3, categoria.getdescripcion()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                categoria= new Categoria();
                categoria.setidCategoria(rst.getInt(1));
                categoria.settipo(rst.getString(2));
                categoria.setdescripcion(rst.getString(3));
                 
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
         List<Categoria> lst = new ArrayList<>();
         String sql="UPDATE categoria, SET idCategoria=?, "
                + "tipo=?,descripcion=? FROM categoria"; 
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql,null);
            Categoria categoria=null;
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setidCategoria(rst.getInt(1));
                categoria.settipo(rst.getString(2));
                categoria.setdescripcion(rst.getString(3));
                    
                
                lst.add(categoria);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lst;
    }

  

   
}
