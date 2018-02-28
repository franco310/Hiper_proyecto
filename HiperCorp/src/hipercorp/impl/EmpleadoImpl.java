
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.IEmpleado;
import hipercorp.dao.IUsuario;
import hipercorp.entidades.Empleado;
import hipercorp.entidades.Usuario;
import hipercorp.impl.UsuarioImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoImpl implements IEmpleado{
    
     @Override
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into empleado  values "
                 + "(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdEmpleado()));
        lstPar.add(new Parametro(2, empleado.getUsuario().getIdUsuario()));
        lstPar.add(new Parametro(3, empleado.getCedula()));
        lstPar.add(new Parametro(4, empleado.getNombre()));
        lstPar.add(new Parametro(5, empleado.getApellido()));
        lstPar.add(new Parametro(6, empleado.getFechaIngreso()));
        lstPar.add(new Parametro(7, empleado.getFechaSalida()));
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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE empleado"
                + "   SET idEmpleado=?,idUsuario=?, cedula=?,nombre=?,apellido=?,fechaingreso=?,"
                + "fechasalida=? where idEmpleado=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, empleado.getIdEmpleado()));
        lstPar.add(new Parametro(2, empleado.getUsuario().getIdUsuario()));
        lstPar.add(new Parametro(3, empleado.getCedula()));
        lstPar.add(new Parametro(4, empleado.getNombre()));
        lstPar.add(new Parametro(5, empleado.getApellido()));
        lstPar.add(new Parametro(6, empleado.getFechaIngreso()));
        lstPar.add(new Parametro(7, empleado.getFechaSalida()));
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
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM empleado  where idEmpleado=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdEmpleado()));       
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
    public Empleado obtener(int idEmpleado) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT idEmpleado,idUsuario,cedula,nombre,apellido,fechaIngreso,"
                + "fechaSalida FROM empleado where idEmpleado";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idEmpleado));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rst.getInt(1));
               IUsuario usuariodao = new UsuarioImpl();
               Usuario usuario = usuariodao.obtener(rst.getInt(2));
               empleado.setUsuario(usuario);
                empleado.setCedula(rst.getString(3));
                empleado.setNombre(rst.getString(4));
                empleado.setApellido(rst.getString(5));
                empleado.setFechaIngreso(rst.getDate(6));
                empleado.setFechaSalida(rst.getDate(7));
          
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
         String sql = "SELECT idEmpleado,idUsuario,cedula,nombre,apellido,fechaIngreso,"
                 + " fechaSalida FROM Empleado ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Empleado empleado=null;
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rst.getInt(1));
               IUsuario usuariodao = new UsuarioImpl();
               Usuario usuario = usuariodao.obtener(rst.getInt(2));
               empleado.setUsuario(usuario);
                empleado.setCedula(rst.getString(3));
                empleado.setNombre(rst.getString(4));
                empleado.setApellido(rst.getString(5));
                empleado.setFechaIngreso(rst.getDate(6));
                empleado.setFechaSalida(rst.getDate(7));
                lista.add(empleado);
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