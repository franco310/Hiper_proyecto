/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.accesodatos;

import com.sun.webkit.ContextMenu;
import java.sql.Connection;
import javax.activation.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Usuario
 */
public class Pool {
     public DataSource dataSource;
    final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BaseFinal";
    final String USER = "BaseFinal";
    final String PASS = "123";
    Connection con = null;
    
 public Pool () {
     
    iniciarDataSource();
    
    
}   
      
    private void iniciarDataSource(){
        BasicDataSource  basicdata= new BasicDataSource();
        
        basicdata.setDriverClassName(DRIVER);
        basicdata.setUsername (USER);
        basicdata.setPassword(PASS);
        basicdata.setUrl(URL);
        basicdata.setMaxActive(10);
                
        dataSource = (DataSource) basicdata;
       
        
}
     private void  Prueba (){
         
         Pool metodopool= new Pool();
         
         java.sql.Connection cn= null;
         
         try {
             cn=(Connection) metodopool.dataSource.getOutputStream();
             
             if (cn!= null ){
                 System.out.println("Conectado");
                 
             }
         } catch (Exception e) {
             
         }
         
         
     }
}
