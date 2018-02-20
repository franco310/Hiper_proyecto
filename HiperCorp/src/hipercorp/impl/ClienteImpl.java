/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.ICliente;
import hipercorp.entidades.Cliente;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Francisco
 */
public class ClienteImpl  implements ICliente{
    @Override
    public int insertar(Cliente cliente) throws Exception{
        int numFilasAfectadas=0;
          String sql = "insert into cliente values"
                  + "(?,?,?,?,?,?,?)";
          List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, cliente.getCedula()));
          lstPar.add(new Parametro(2, cliente.getNombres()));
          lstPar.add(new Parametro(3, cliente.getApellidos()));
          lstPar.add(new Parametro(4, cliente.getDireccion()));
          lstPar.add(new Parametro(5, cliente.getTelefono()));
          lstPar.add(new Parametro(6, cliente.getEmail()));
          lstPar.add(new Parametro(7, cliente.getFecha_Nace()));
          
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
   @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET cedula=?,nombres=?, apellidos=?,  direccion=?, telefono=? "
                + " email=?,fecha_Nace=?"
                + " where cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
          lstPar.add(new Parametro(2, cliente.getNombres()));
          lstPar.add(new Parametro(3, cliente.getApellidos()));
          lstPar.add(new Parametro(4, cliente.getDireccion()));
          lstPar.add(new Parametro(5, cliente.getTelefono()));  
          lstPar.add(new Parametro(6, cliente.getEmail()));
          lstPar.add(new Parametro(7, cliente.getFecha_Nace()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));       
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
    public Cliente obtener(int cedula) throws Exception {
        Cliente cliente = null;
        String sql =  "SELECT * FROM cliente where cedula=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCedula(rst.getInt(1));
                cliente.setNombres(rst.getString(2));
                cliente.setApellidos(rst.getString(3));
                cliente.setDireccion(rst.getString(4));                
                cliente.setTelefono(rst.getString(5)); 
                cliente.setEmail(rst.getString(6)); 
                cliente.setFecha_Nace(rst.getDate(7)); 
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql ="SELECT * FROM cliente ";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCedula(rst.getInt(1));
                cliente.setNombres(rst.getString(2));
                cliente.setApellidos(rst.getString(3));
                cliente.setDireccion(rst.getString(4));                
                cliente.setTelefono(rst.getString(5));   
                cliente.setEmail(rst.getString(6)); 
                cliente.setFecha_Nace(rst.getDate(7)); 
                lista.add(cliente);
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
