package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IFacturaVenta;
import hipercorp.entidades.FacturaVenta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacturaVentaImpl implements IFacturaVenta{
      @Override
    public int insertar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturaventa  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getIdFacturaVenta()));
        lstPar.add(new Parametro(2, facturaventa.getCliente().getIdCliente()));
        lstPar.add(new Parametro(3, facturaventa.getFecha()));
        lstPar.add(new Parametro(4, facturaventa.getCedula()));
    
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
    public int modificar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facuraventa"
                + "   SET idFacturaVenta=?, idCliente=?"
                + " fecha=?,cedula=?,where idFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
            lstPar.add(new Parametro(1, facturaventa.getIdFacturaVenta()));
        lstPar.add(new Parametro(2, facturaventa.getCliente().getIdCliente()));
        lstPar.add(new Parametro(3, facturaventa.getFecha()));
        lstPar.add(new Parametro(4, facturaventa.getCedula()));
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
    public int eliminar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM facturaventa  where idFacturaventa=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getIdFacturaVenta()));       
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
    public FacturaVenta obtener(int IdFacturaVenta) throws Exception {
        FacturaVenta facturaventa = null;
        String sql =  "UPDATE facuraventa"
                + "   SET idFacturaVenta=?, idCliente=?"
                + " fecha=?,cedula=?,where idFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdFacturaVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                facturaventa = new FacturaVenta();
              facturaventa.setIdFacturaVenta(rst.getInt(1));
              
                facturaventa.setFecha(rst.getDate(3));
                facturaventa.setCedula(rst.getInt(4));
                 
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return facturaventa;
    }

    @Override
    public List<FacturaVenta> obtener() throws Exception {
        List<FacturaVenta> lista = new ArrayList<>();
         String sql = "SELECT idFacturaVenta , fecha, cedula, FROM proveedor ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaVenta facturaventa=null;
            while (rst.next()) {
                facturaventa = new FacturaVenta();
               facturaventa.setIdFacturaVenta(rst.getInt(1));
                facturaventa.setFecha(rst.getDate(2));
                facturaventa.setCedula(rst.getInt(3));
                               
                lista.add(facturaventa);
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
