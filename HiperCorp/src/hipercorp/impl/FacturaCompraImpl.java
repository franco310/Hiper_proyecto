
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IFacturaCompra;
import hipercorp.dao.IProveedor;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaCompraImpl implements IFacturaCompra{
    
     @Override
    public int insertar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturacompra  values "
                +"(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getIdFacturaCompra()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getProveedor().getIdProveedor()));
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
                + "   SET idFacturaCompra=?, fecha=?, idProveedor=?"
                + " where idFacturaCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getIdFacturaCompra()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getProveedor().getIdProveedor()));
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
        String sql = "SELECT idFacturaCompra, fecha,"
                + " idProveedor   FROM facturacompra where idFacturaCompra=?";
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
                facturacompra.setFecha(rst.getString(5));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(10));
                facturacompra.setProveedor(proveedor);
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
         String sql = "SELECT idFacturaCompra, fecha ,"
                 + "idProveedor   FROM facturacompra ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaCompra facturacompra=null;
            while (rst.next()) {
                facturacompra = new FacturaCompra();
                facturacompra.setIdFacturaCompra(rst.getInt(1));
                facturacompra.setFecha(rst.getString(5));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(10));
                facturacompra.setProveedor(proveedor);
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

