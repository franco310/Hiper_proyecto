/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.metodos;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Pool;
import hipercorp.entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MetodoGuardar {
    Pool metodospool= new Pool();
            
    
public int Guardar(String IdRegistro, String nombre, String apellido, String pass){
    
    
     int resultado = 0;

     Connection con = null;

     String SSQL = "INSERT INTO Usuario (IdRegistro, nombre, apellido, pass) "
                    + "VALUES (?, ?, ?, ?)";


    try {
    
        con = (Connection)metodospool.dataSource.getInputStream();
        
        PreparedStatement psql = con.prepareStatement(SSQL);
        psql.setString(1, IdRegistro);
        psql.setString(2, nombre);
        psql.setString(3, apellido);
        psql.setString(4, pass);
        
        resultado = psql.executeUpdate();
        
        psql.close();
                    
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                     + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
        
    }   catch (IOException ex) {
            Logger.getLogger(MetodoGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
    
        try {
            
            if(con!=null){
            
                con.close();
                
            }
            
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                     + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            
        }
    
    }

    return resultado;
    
}    
    
    
    
}
