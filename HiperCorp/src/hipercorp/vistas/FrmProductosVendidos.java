/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IProductosVendidos;
import hipercorp.impl.ProductoVendidoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmProductosVendidos  extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    
    public FrmProductosVendidos(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Productos mas vendidos");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();   
    }

    private void cargarTabla() {
         modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombres Completos");
        modelo.addColumn("Promedio");        
        
        List<String[]> lista = new ArrayList<>();
        try {
            IProductosVendidos consultaDao = new ProductoVendidoImpl();
            lista = consultaDao.obtenerProductosVendidos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(String[] fila : lista){
            modelo.addRow(new Object[]{ fila[0],fila[1], fila[2] });            
        }
        tabla.setModel(modelo);        
    }
        
        
       }

