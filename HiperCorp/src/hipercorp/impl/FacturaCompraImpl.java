
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IFacturaCompra;
import hipercorp.dao.IProducto;
import hipercorp.dao.IProveedor;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.Producto;
import hipercorp.entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaCompraImpl implements IFacturaCompra{
    
     @Override
    public int insertar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturacompra  values "
                +"(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getIdFacturaCompra()));
        lstPar.add(new Parametro(2, facturacompra.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, facturacompra.getProducto().getIdProducto()));
        lstPar.add(new Parametro(4, facturacompra.getFecha()));
        lstPar.add(new Parametro(5, facturacompra.getCantidad()));
        lstPar.add(new Parametro(6, facturacompra.getTipo_pago()));
        
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
    public int modificar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facturacompra"
                + "   SET idFacturaCompra=?,idProveedor=?, idProducto=?, fecha=?, cantidad, tipo_pago"
                + " where idFacturaCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getIdFacturaCompra()));
        lstPar.add(new Parametro(2, facturacompra.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, facturacompra.getProducto().getIdProducto()));
        lstPar.add(new Parametro(4, facturacompra.getFecha()));
        lstPar.add(new Parametro(5, facturacompra.getCantidad()));
        lstPar.add(new Parametro(6, facturacompra.getTipo_pago()));
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
    public int eliminar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM facturacompra  where idFacturaCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getIdFacturaCompra()));       
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
    public FacturaCompra obtener(int idFacturaCompra) throws Exception {
        FacturaCompra facturacompra = null;
        String sql = "SELECT idFacturaCompra,idProveedor,idProducto ,fecha, cantidad,"
                + "tipo_pago  FROM facturacompra where idFacturaCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idFacturaCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                
                facturacompra = new FacturaCompra();
                facturacompra.setIdFacturaCompra(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                facturacompra.setProveedor(proveedor);
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(3));
                facturacompra.setProducto(producto);
                facturacompra.setFecha(rst.getDate(4));
                facturacompra.setCantidad(rst.getInt(5));
                facturacompra.setTipo_pago(rst.getString(6));
              
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return facturacompra;
    }

    @Override
    public List<FacturaCompra> obtener() throws Exception {
        List<FacturaCompra> lista = new ArrayList<>();
         String sql = "SELECT idFacturaCompra,idProveedor,idProducto ,fecha, cantidad,"
                + "tipo_pago  FROM facturacompra ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaCompra facturacompra=null;
            while (rst.next()) {
                
                facturacompra = new FacturaCompra();
                facturacompra.setIdFacturaCompra(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                facturacompra.setProveedor(proveedor);
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(3));
                facturacompra.setProducto(producto);
                facturacompra.setFecha(rst.getDate(4));
                facturacompra.setCantidad(rst.getInt(5));
                facturacompra.setTipo_pago(rst.getString(6));
                lista.add(facturacompra);
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

