
package hipercorp.vistas;

import hipercorp.dao.IFacturaCompra;
import hipercorp.entidades.FacturaCompra;
import hipercorp.impl.FacturaCompraImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaFacturaCompra extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaFacturaCompra(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Facturacompra");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("fecha");
       
        
        List<FacturaCompra> lista = new ArrayList<>();
        try {
            IFacturaCompra facturacompraDao = new FacturaCompraImpl();
            lista = facturacompraDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(FacturaCompra est : lista){
            modelo.addRow(new Object[] { est.getIdFacturaCompra(), est.getFecha()});
            }
           tabla.setModel(modelo); 
        }
    
}
