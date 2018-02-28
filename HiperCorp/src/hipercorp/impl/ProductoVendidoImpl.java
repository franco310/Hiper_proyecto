/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.impl;

import hipercorp.accesodatos.Conexion;
import hipercorp.dao.IProductosVendidos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoVendidoImpl  implements IProductosVendidos{
     

    @Override
    public List<String[]> obtenerProductosVendidos() throws Exception {
      List<String[]> lista= new ArrayList<>();
        String sql= "";               
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
