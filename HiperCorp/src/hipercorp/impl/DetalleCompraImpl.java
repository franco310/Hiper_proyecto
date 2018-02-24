
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IDetalleCompra;
import hipercorp.dao.IFacturaCompra;
import hipercorp.dao.IProducto;
import hipercorp.dao.IProveedor;
import hipercorp.entidades.DetalleCompra;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.Producto;
import hipercorp.entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraImpl implements IDetalleCompra {
    
    
    @Override
    public int insertar(DetalleCompra detallecompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detallecompra  values "
                +"(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detallecompra.getIdDetalleCompra()));
        lstPar.add(new Parametro(2, detallecompra.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, detallecompra.getProducto().getIdProducto()));
        lstPar.add(new Parametro(4, detallecompra.getFacturacompra().getIdFacturaCompra()));
        lstPar.add(new Parametro(5, detallecompra.getCantidada()));
        lstPar.add(new Parametro(6, detallecompra.getPreciototal()));
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
    public int modificar(DetalleCompra detallecompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE detallecompra"
                + "   SET idDetalleCompra=?, idProveedor, idProducto, idFacturaCompra, catnidad, preciototal=?"
                + " where idDetalleCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detallecompra.getIdDetalleCompra()));
        lstPar.add(new Parametro(2, detallecompra.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, detallecompra.getProducto().getIdProducto()));
        lstPar.add(new Parametro(4, detallecompra.getFacturacompra().getIdFacturaCompra()));
        lstPar.add(new Parametro(5, detallecompra.getCantidada()));
        lstPar.add(new Parametro(6, detallecompra.getPreciototal()));
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
    public int eliminar(DetalleCompra detallecompra) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM detallecompra  where idDetalleCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detallecompra.getIdDetalleCompra()));       
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
    public DetalleCompra obtener(int idDetalleCompra) throws Exception {
        DetalleCompra detallecompra = null;
        String sql = "SELECT idDetalleCompra, idProveedor,idProducto, idFacturaCompra, cantidad, preciototal"
                + "   FROM detallecompra where idDetalleCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idDetalleCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                detallecompra = new DetalleCompra();
                detallecompra.setIdDetalleCompra(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                detallecompra.setProveedor(proveedor);
                 IProducto prodcutodao = new ProductoImpl();
                Producto producto = prodcutodao.obtener(rst.getInt(3));
                detallecompra.setProducto(producto);
                IFacturaCompra facturacompradao = new FacturaCompraImpl();
                FacturaCompra facturacompra = facturacompradao.obtener(rst.getInt(4));
                detallecompra.setFacturacompra(facturacompra);
                detallecompra.setCantidada(rst.getInt(5));
                detallecompra.setPreciototal(rst.getInt(6));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return detallecompra;
    }

    @Override
    public List<DetalleCompra> obtener() throws Exception {
        List<DetalleCompra> lista = new ArrayList<>();
         String sql = "SELECT idDetalleCompra,idProveedor,idProducto, idFacturaCompra, cantidad,"
                 + " preciototal   FROM detallecompra ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            DetalleCompra detallecompra=null;
            while (rst.next()) {
                detallecompra = new DetalleCompra();
                detallecompra.setIdDetalleCompra(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                detallecompra.setProveedor(proveedor);
                IProducto prodcutodao = new ProductoImpl();
                Producto producto = prodcutodao.obtener(rst.getInt(3));
                detallecompra.setProducto(producto);
                IFacturaCompra facturacompradao = new FacturaCompraImpl();
                FacturaCompra facturacompra = facturacompradao.obtener(rst.getInt(4));
                detallecompra.setFacturacompra(facturacompra);
                detallecompra.setCantidada(rst.getInt(5));
                detallecompra.setPreciototal(rst.getInt(6));
                lista.add(detallecompra);
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
