
package hipercorp.impl;
import java.sql.ResultSet;
import hipercorp.accesodatos.*;
import hipercorp.dao.*;
import hipercorp.entidades.DetalleVenta;
import hipercorp.entidades.*;
import java.util.ArrayList;
import java.util.List;
import sun.management.GcInfoCompositeData;

public class DetalleVentaImpl implements IDetalleVenta {
   @Override
    public int insertar(DetalleVenta detalleventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detalleventa  values "
                +"(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleventa.getIdDetalleVenta()));
        lstPar.add(new Parametro(2, detalleventa.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, detalleventa.getCantidad()));
        lstPar.add(new Parametro(4, detalleventa.getPreciototal()));
        
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
    public int modificar(DetalleVenta detalleventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE detalleventa"
                + "   SET idDetalleVenta=?, idProducto=?,cantidad=?, "
                + "preciototal=? where idDetalleVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, detalleventa.getIdDetalleVenta()));
        lstPar.add(new Parametro(2, detalleventa.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, detalleventa.getCantidad()));
        lstPar.add(new Parametro(4, detalleventa.getPreciototal()));
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
    public int eliminar(DetalleVenta detalleventa) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM detalleventa  where idDetalleVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleventa.getIdDetalleVenta()));       
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
    public DetalleVenta obtener(int idDetalleVenta) throws Exception {
        DetalleVenta detalleventa = null;
        String sql = "SELECT idDetalleVenta, idProducto,cantidad,"
                + " preciototal  FROM detalleventa where idDetalleVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idDetalleVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                detalleventa = new DetalleVenta();
                detalleventa.setIdDetalleVenta(rst.getInt(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                detalleventa.setCantidad(rst.getInt(3));
                detalleventa.setPreciototal(rst.getInt(4));
                
                detalleventa.setProducto(producto);
  
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return detalleventa;
    }

    @Override
    public List<DetalleVenta> obtener() throws Exception {
        List<DetalleVenta> lista = new ArrayList<>();
         String sql = "SELECT idDetalleVenta, idProducto, idFacturaVenta, cantidad,"
                 + " preciototal FROM detalleventa ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            DetalleVenta detalleventa=null;
            while (rst.next()) {
                detalleventa = new DetalleVenta();
                detalleventa.setIdDetalleVenta(rst.getInt(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                detalleventa.setCantidad(rst.getInt(3));
                detalleventa.setPreciototal(rst.getInt(4));
                
                detalleventa.setProducto(producto);
                lista.add(detalleventa);
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
