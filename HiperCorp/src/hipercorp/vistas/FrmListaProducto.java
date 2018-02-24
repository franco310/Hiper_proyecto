/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IProducto;
import hipercorp.entidades.Producto;
import hipercorp.impl.ProductoImpl;
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
 * @author Francisco
 */
public class FrmListaProducto extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaProducto(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Productos");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Categoria");
   
        List<Producto> lista = new ArrayList<>();
        try {
            IProducto productoDao = new ProductoImpl();
            lista = productoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Producto est : lista){
            modelo.addRow(new Object[] { est.getIdProducto(), est.getNombre(),
                est.getPrecio(),est.getDescripcion(),est.getCategoria()});
            }
           tabla.setModel(modelo); 
        }
}
    

