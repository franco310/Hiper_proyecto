/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.ICategoria;
import hipercorp.entidades.Categoria;
import hipercorp.impl.CategoriaImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmListaCategoria extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
  
     public FrmListaCategoria(){
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
       lblTitulo = new JLabel("Categorias ");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
        
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Categoria :");
        modelo.addColumn("Tipo :");
        modelo.addColumn("Nombre :");
        modelo.addColumn("Descripcion :");
        
        
        List<Categoria> lista = new ArrayList<>();
        try {
            ICategoria categoriaDao = new CategoriaImpl();
            lista = categoriaDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Categoria est : lista){
            modelo.addRow(new Object[] {est.getIdCategoria(), est.getTipo(), est.getNombre(),
                est.getDescripcion()});
            
            }
           tabla.setModel(modelo); 
        }
    
    
}
