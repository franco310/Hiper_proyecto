
package hipercorp.impl;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.*;
import hipercorp.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorImpl implements IProveedor {

    @Override
    public int insertar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into proveedor values(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getIdProveedor()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));
        lstPar.add(new Parametro(5, proveedor.getEmail()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  proveedor set idProveedor=?, nombre=?, direccion=?, telefono=?, email=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getIdProveedor()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));
        lstPar.add(new Parametro(5, proveedor.getEmail()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Proveedor obtener(int idProveedor) throws Exception {
        Proveedor proveedor = null;
         String sql = "select idProveedor, nombre, direccion, telefono, email from proveedor where idProveedor=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idProveedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                proveedor= new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));            
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtener() throws Exception {
        List<Proveedor> lista = new ArrayList<>();
         String sql = "select idProveedor, nombre, direccion, telefono, email from proveedor";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Proveedor proveedor= null;
            while(rst.next()){
                proveedor= new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));
                lista.add(proveedor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
