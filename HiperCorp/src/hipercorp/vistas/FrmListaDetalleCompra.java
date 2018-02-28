
package hipercorp.vistas;

import hipercorp.dao.IDetalleCompra;
import hipercorp.entidades.DetalleCompra;
import hipercorp.impl.DetalleCompraImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaDetalleCompra extends JInternalFrame {
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaDetalleCompra(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado DetalleCompra");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Cantidad");
        modelo.addColumn("PrecioTotal");
        
        List<DetalleCompra> lista = new ArrayList<>();
        try {
            IDetalleCompra estudianteDao = new DetalleCompraImpl();
            lista = estudianteDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(DetalleCompra est : lista){
            modelo.addRow(new Object[] { est.getIdDetalleCompra(), est.getProveedor().getNombre(),
                 est.getCantidada(),est.getPreciototal()});
            }
           tabla.setModel(modelo); 
        }
    
}
