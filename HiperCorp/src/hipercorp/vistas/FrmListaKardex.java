package hipercorp.vistas;

import hipercorp.dao.IKardex;
import hipercorp.entidades.Kardex;
import hipercorp.impl.KardexImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaKardex extends JInternalFrame {
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaKardex(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Kardex");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("DetalleCompra");
        modelo.addColumn("DetalleVenta");
        modelo.addColumn("FechaEmision");
        modelo.addColumn("Existencias");
        modelo.addColumn("ValorTotal");
        
        List<Kardex> lista = new ArrayList<>();
        try {
            IKardex kardexDao = new KardexImpl();
            lista = kardexDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Kardex est : lista){
            modelo.addRow(new Object[] { est.getIdKardex(), est.getProducto().getIdProducto(),
                est.getDetalleCompra().getIdDetalleCompra(), est.getDetalleVenta().getIdDetalleVenta(),est.getFechaEmision(), est.getExistencias(),
            est.getValorTotal()});
            }
           tabla.setModel(modelo); 
        }
    
}
