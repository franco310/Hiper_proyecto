
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.dao.IConsulta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ConsultaImpl implements IConsulta {
    @Override
    public List<String[]> obtenerMejoresProductos() throws Exception {
        List<String[]> lista= new ArrayList<>();
        
        String sql= "select idProducto from [dbo].[detalleventa] where cantidad > 5";               
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);            
            while (rst.next()) {
              String[] fila = new String[3];
              fila[0]= rst.getString(0);
              fila[1]= rst.getString(1);
              fila[2]= rst.getString(2);
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
