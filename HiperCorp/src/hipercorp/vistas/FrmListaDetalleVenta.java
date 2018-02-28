/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IDetalleVenta;
import hipercorp.entidades.DetalleVenta;
import hipercorp.impl.DetalleVentaImpl;
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
public class FrmListaDetalleVenta extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaDetalleVenta(){
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Detalles de venta");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo de la venta ");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Total");
        
        List<DetalleVenta> lista = new ArrayList<>();
        try {
            IDetalleVenta ventaDao = new DetalleVentaImpl();
            lista = ventaDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(DetalleVenta est : lista){
            modelo.addRow(new Object[] { est.getIdDetalleVenta(),est.getCantidad(), est.getPreciototal()});
            }
           tabla.setModel(modelo); 
        }
}
