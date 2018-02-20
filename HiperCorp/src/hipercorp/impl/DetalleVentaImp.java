/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.impl;
import java.sql.ResultSet;
import hipercorp.accesodatos.*;
import hipercorp.dao.*;
import hipercorp.entidades.DetalleVenta;
import hipercorp.entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DetalleVentaImp implements IDetalleVenta{
    
    @Override
    public int insertar(DetalleVenta detalle_venta) throws Exception {
       int numFilasAfectadas = 0;
       String sql = "insert into proveedor  values (?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getCodDetalleVenta()));
        lstPar.add(new Parametro(2, detalle_venta.getCodFacturaVenta()));
        lstPar.add(new Parametro(3, detalle_venta.getCodProducto()));
        lstPar.add(new Parametro(4, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(5, detalle_venta.getPrecioT()));
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
    public int modificar(DetalleVenta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE detalleventa, SET CodDetalleVenta=?, "
                + "CodFacturaVenta=?,CodProducto=?, Cantidad=?,PrecioT=? ";       
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getCodDetalleVenta()));
        lstPar.add(new Parametro(2, detalle_venta.getCodFacturaVenta()));
        lstPar.add(new Parametro(3, detalle_venta.getCodProducto()));
        lstPar.add(new Parametro(4, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(5, detalle_venta.getPrecioT()));
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
    public int eliminar(DetalleVenta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM DetalleVenta where CoddetalleVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getCodDetalleVenta()));
        lstPar.add(new Parametro(2, detalle_venta.getCodFacturaVenta()));
        lstPar.add(new Parametro(3, detalle_venta.getCodProducto()));
        lstPar.add(new Parametro(4, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(5, detalle_venta.getPrecioT()));     
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
    public DetalleVenta obtener(int CodDetalleVenta, IDetalleVenta DetalleVenta) throws Exception {
        DetalleVenta detalle_venta= null;
        String sql="UPDATE detalleventa, SET CodDetalleVenta=?, "
                + "CodFacturaVenta=?,CodProducto=?,Cantidad=?,PrecioT=? ";       
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getCodDetalleVenta()));
        lstPar.add(new Parametro(2, detalle_venta.getCodFacturaVenta()));
        lstPar.add(new Parametro(3, detalle_venta.getCodProducto()));
        lstPar.add(new Parametro(4, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(5, detalle_venta.getPrecioT()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                detalle_venta = new DetalleVenta();
                detalle_venta.setCodDetalleVenta(rst.getInt(1));
                detalle_venta.setCodFacturaVenta(rst.getInt(2));
                detalle_venta.setCodProducto(rst.getInt(3));
                detalle_venta.setCantidad(rst.getInt(4));
                detalle_venta.setPrecioT(rst.getInt(5));   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return detalle_venta;
    }
    
    @Override
    public List<IDetalleVenta> obtener() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(IDetalleVenta detalle_venta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
    
}
