package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.ICliente;
import hipercorp.dao.IFacturaVenta;
import hipercorp.dao.IProducto;
import hipercorp.entidades.Cliente;
import hipercorp.entidades.FacturaVenta;
import hipercorp.entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacturaVentaImpl implements IFacturaVenta{
      @Override
    public int insertar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturaventa  values "
                + "(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getIdFacturaVenta()));
        lstPar.add(new Parametro(2, facturaventa.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, facturaventa.getEmplaedo().getIdEmpleado()));
        lstPar.add(new Parametro(4, facturaventa.getCliente().getIdCliente()));
        lstPar.add(new Parametro(5, facturaventa.getFecha()));
        lstPar.add(new Parametro(6, facturaventa.getCantidad()));
        lstPar.add(new Parametro(7, facturaventa.getTipo_pago()));
    
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
                + "   SET idFacturaVenta=?, idProducto=?, idEmpleado=?, idCliente=?"
                + " fecha=?, cantidad=?, tipo_pago=? where idFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getIdFacturaVenta()));
        lstPar.add(new Parametro(2, facturaventa.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, facturaventa.getEmplaedo().getIdEmpleado()));
        lstPar.add(new Parametro(4, facturaventa.getCliente().getIdCliente()));
        lstPar.add(new Parametro(5, facturaventa.getFecha()));
        lstPar.add(new Parametro(6, facturaventa.getCantidad()));
        lstPar.add(new Parametro(7, facturaventa.getTipo_pago()));
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
                + "   SET idFacturaVenta,idProducto, idEmpleado, idCliente"
                + " fecha, cantidad, tipo_pago where idFacturaVenta";
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
               IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
//                IEmpleado empleadodao = new EmpleadoImpl();
//                Producto producto = productodao.obtener(rst.getInt(3));
               ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(4));
                facturaventa.setFecha(rst.getDate(5));
                facturaventa.setCantidad(rst.getInt(6));
                facturaventa.setTipo_pago(rst.getString(7));
                
                facturaventa.setProducto(producto);
//                facturaventa.setEmplaedo(empleado)
                facturaventa.setCliente(cliente);
                 
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
               IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
//                IEmpleado empleadodao = new EmpleadoImpl();
//                Producto producto = productodao.obtener(rst.getInt(3));
               ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(4));
                facturaventa.setFecha(rst.getDate(5));
                facturaventa.setCantidad(rst.getInt(6));
                facturaventa.setTipo_pago(rst.getString(7));
                
                facturaventa.setProducto(producto);
//                facturaventa.setEmplaedo(empleado)
                facturaventa.setCliente(cliente);
                               
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
