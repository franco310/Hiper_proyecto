/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.metodos;

import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Pool;
import hipercorp.vistas.IniciarSesion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MetodoLogin {
      
    Pool conpool = new Pool();
      

public int validar_ingreso() throws IOException{

    String usuario = IniciarSesion.textUsuario.getText();
    String clave = String.valueOf(IniciarSesion.jpassClave.getPassword());

    int resultado=0;
    
    String SSQL="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave=sha1('"+clave+"')";

    Connection conect = null;
     
     
     try {

        conect=(Connection) conpool.dataSource.getInputStream();
        Statement st = conect.createStatement();
        ResultSet rs = st.executeQuery(SSQL);

        if(rs.next()){

            resultado=1;

        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

    }finally{


        try {

            conect.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

        }

    }

return resultado;
}
}