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
import sun.management.GcInfoCompositeData;

/**
 *
 * @author Usuario
 */
public class DetalleVentaImpl implements IDetalleVenta {
    @Override
    public int insertar(DetalleVenta detalle_venta) throws Exception {
      int numFilasAfectadas = 0;
       String sql = "insert into DetalleVenta values (?,?,?,?,?)";
        List<Parametro> lst;
        lst = new ArrayList<>();
        lst.add(new Parametro(1, detalle_venta.getidDetalleVenta()));
        lst.add(new Parametro(2, detalle_venta.getidProducto().getCodigoProducto()));
        lst.add(new Parametro(3, detalle_venta.getidFacturaVenta().getIdFacturaVenta()));
        lst.add(new Parametro(4, detalle_venta.getcantidad()));
        lst.add(new Parametro(5, detalle_venta.getprecioTotal()));
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
    public int modificar(DetalleVenta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE detalleventa, SET idDetalleVenta=?, "
                + "idFacturaVenta=?,idProducto=?, cantidad=?,precioTotal=? ";       
        List<Parametro> lst = new ArrayList<>();
        lst.add(new Parametro(1, detalle_venta.getidDetalleVenta()));
        lst.add(new Parametro(2, detalle_venta.getidProducto().getCodigoProducto()));
        lst.add(new Parametro(3, detalle_venta.getidFacturaVenta().getIdFacturaVenta()));
        lst.add(new Parametro(4, detalle_venta.getcantidad()));
        lst.add(new Parametro(5, detalle_venta.getprecioTotal()));
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
    public int eliminar(DetalleVenta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM DetalleVenta where idDetalleVenta=?";
        List<Parametro> lst = new ArrayList<>();
         lst.add(new Parametro(1, detalle_venta.getidDetalleVenta()));
       lst.add(new Parametro(2, detalle_venta.getidProducto().getCodigoProducto()));
        lst.add(new Parametro(3, detalle_venta.getidFacturaVenta().getIdFacturaVenta()));
        lst.add(new Parametro(4, detalle_venta.getcantidad()));
        lst.add(new Parametro(5, detalle_venta.getprecioTotal()));   
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
    public DetalleVenta obtener(int IdDetalleVenta) throws Exception {
        DetalleVenta detalle_venta= null;
        String sql="UPDATE detalleventa, SET idDetalleVenta=?, "
                + "idFacturaVenta=?,idProducto=?,cantidad=?,precioTotal=? ";       
        List<Parametro> lst = new ArrayList<>();
         lst.add(new Parametro(1, detalle_venta.getidDetalleVenta()));
      lst.add(new Parametro(2, detalle_venta.getidProducto().getCodigoProducto()));
        lst.add(new Parametro(3, detalle_venta.getidFacturaVenta().getIdFacturaVenta()));
        lst.add(new Parametro(4, detalle_venta.getcantidad()));
        lst.add(new Parametro(5, detalle_venta.getprecioTotal()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lst);
            while (rst.next()) {
                detalle_venta = new DetalleVenta();
                detalle_venta.setidDetalleVenta(rst.getInt(1));
                IFacturaVenta facturaVentaDao= new FacturaVentaImpl();
                FacturaVenta facturaventa= facturaVentaDao.obtener(rst.getInt(2));
     //           detalle_venta.setidFacturaVenta(rst.getInt(2));
            IProducto productoDao=new ProductoImpl();
            Producto producto =productoDao.obtener(rst.getInt(3));

//                detalle_venta.setidProducto(rst.getInt(3));
                detalle_venta.setcantidad(rst.getInt(4));
                detalle_venta.setprecioTotal(rst.getInt(5));   
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
    public List<DetalleVenta> obtener() throws Exception {
         List<DetalleVenta > lst = new ArrayList<>();
         String sql ="SELECT * FROM cliente ";   
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql,null);
            DetalleVenta detalle_venta=null;
            while (rst.next()) {
                detalle_venta = new DetalleVenta();
                detalle_venta.setidDetalleVenta(rst.getInt(1));
                IFacturaVenta facturaVentaDao= new FacturaVentaImpl();
                FacturaVenta facturaventa= facturaVentaDao.obtener(rst.getInt(2));
//                detalle_venta.setidFacturaVenta(rst.getInt(2));
                IProducto productoDao=new ProductoImpl();
                Producto producto=productoDao.obtener(rst.getInt(3));

//                detalle_venta.setidProducto(rst.getInt(3));
                detalle_venta.setcantidad(rst.getInt(4));
                detalle_venta.setprecioTotal(rst.getInt(5));   
                
                lst.add(detalle_venta);
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
