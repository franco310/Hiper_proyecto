
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
          String sql = "insert into Cliente values"
                  + "(?,?,?,?,?,?,?,?)";
          List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, cliente.getIdCliente()));
          lstPar.add(new Parametro(2, cliente.getCedula()));
          lstPar.add(new Parametro(3, cliente.getNombre()));
          lstPar.add(new Parametro(4, cliente.getApellido()));
          lstPar.add(new Parametro(5, cliente.getDireccion()));
          lstPar.add(new Parametro(6, cliente.getTelefono()));
          lstPar.add(new Parametro(7, cliente.getEmail()));
          lstPar.add(new Parametro(8, cliente.getFecha_nac()));
         
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
        String sql = "UPDATE Cliente"
                + "SET idCliente=?,cedula=?, nombre=?, apellido=?, direccion=?, telefono=?, email=?, fecha_nac=?"
                + " where idCliente= ?";
          List<Parametro> lstPar = new ArrayList<>(); 
          lstPar.add(new Parametro(1, cliente.getIdCliente()));
          lstPar.add(new Parametro(2, cliente.getCedula()));
          lstPar.add(new Parametro(3, cliente.getNombre()));
          lstPar.add(new Parametro(4, cliente.getApellido()));
          lstPar.add(new Parametro(5, cliente.getDireccion()));
          lstPar.add(new Parametro(6, cliente.getTelefono()));
          lstPar.add(new Parametro(7, cliente.getEmail()));
          lstPar.add(new Parametro(8, cliente.getFecha_nac()));
          lstPar.add(new Parametro(9, cliente.getIdCliente()));
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
        String sql = "DELETE FROM cliente  where IdCliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getIdCliente()));       
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
    public Cliente obtener(int idCliente) throws Exception {
        Cliente cliente = null;
        String sql =  "SELECT * FROM cliente where idCliente=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idCliente));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setDireccion(rst.getString(5));                
                cliente.setTelefono(rst.getString(6)); 
                cliente.setEmail(rst.getString(7)); 
                cliente.setFecha_nac(rst.getDate(8)); 
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
         String sql ="SELECT * FROM Cliente ";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setDireccion(rst.getString(5));                
                cliente.setTelefono(rst.getString(6)); 
                cliente.setEmail(rst.getString(7)); 
                cliente.setFecha_nac(rst.getDate(8));  
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
