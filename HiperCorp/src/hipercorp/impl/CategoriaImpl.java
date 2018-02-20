/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.*;
import hipercorp.entidades.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CategoriaImpl implements ICategoria {

    @Override
    public int insertar(Categoria categoria) throws Exception {
       int numFilasAfectadas = 0;
       String sql = "insert into categoria values (?,?,?)";
        List<Parametro> lst;
        lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getCodCategoria()));
        lst.add(new Parametro(2, categoria.getNombreCategoria()));
        lst.add(new Parametro(3, categoria.getDescripcionCat()));
        
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
        String sql = "UPDATE categoria, SET CodCategoria=?, "
                + "Nombre=?,Desripcion=?";       
        List<Parametro> lst = new ArrayList<>();
        lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getCodCategoria()));
        lst.add(new Parametro(2, categoria.getNombreCategoria()));
        lst.add(new Parametro(3, categoria.getDescripcionCat()));
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
         String sql = "DELETE FROM Categoria where CodCategoria=?";
        List<Parametro> lst = new ArrayList<>();
        lst.add(new Parametro(1, categoria.getCodCategoria()));
        lst.add(new Parametro(2, categoria.getNombreCategoria()));
        lst.add(new Parametro(3, categoria.getDescripcionCat()));   
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
    public  Categoria obtener(int CodCategoria ) throws Exception {
        Categoria categoria= null;
        String sql="UPDATE categoria, SET CodCategoria=?, "
                + "NombreCategoria=?,Descripcion=? ";       
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodCategoria()));
        lstPar.add(new Parametro(2, categoria.getNombreCategoria()));
        lstPar.add(new Parametro(3, categoria.getDescripcionCat()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                categoria= new Categoria();
                categoria.setCodCategoria(rst.getInt(1));
                categoria.setNombreCategoria(rst.getString(2));
                categoria.setDescripcionCat(rst.getString(3));
                 
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
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql,null);
            Categoria categoria=null;
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setCodCategoria(rst.getInt(1));
                categoria.setNombreCategoria(rst.getString(2));
                categoria.setDescripcionCat(rst.getString(3));
                    
                
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
