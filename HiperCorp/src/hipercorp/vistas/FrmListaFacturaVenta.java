/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IFacturaVenta;
import hipercorp.entidades.FacturaVenta;
import hipercorp.impl.FacturaVentaImpl;
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
 * @author HP
 */
public class FrmListaFacturaVenta extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
  
     public FrmListaFacturaVenta(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
       lblTitulo = new JLabel("Listado Factura-Venta");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
        
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Factura:");
        modelo.addColumn("Id Producto:");
        modelo.addColumn("Id Empleado:");
        modelo.addColumn("Id Cliente:");
        modelo.addColumn("Fecha:");
        modelo.addColumn("Cantidad :");
        modelo.addColumn("Modo de pago");
        
        List<FacturaVenta> lista = new ArrayList<>();
        try {
            IFacturaVenta facturaventaDao = new FacturaVentaImpl();
            lista = facturaventaDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(FacturaVenta est : lista){
            modelo.addRow(new Object[] {est.getIdFacturaVenta(), est.getProducto(), est.getEmpleado(),
                est.getCliente(),est.getFecha(),est.getCantidad(),est.getTipo_pago()});
            
            }
           tabla.setModel(modelo); 
        }
    
}
