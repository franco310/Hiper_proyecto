/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.accesodatos;

import java.sql.Connection;
import javax.activation.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Usuario
 */
public class Pool {
     public DataSource dataSource;
    final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Ejemplo1";
    final String USER = "Ejemplo1";
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
}