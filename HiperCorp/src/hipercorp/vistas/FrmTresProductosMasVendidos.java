
package hipercorp.vistas;

import hipercorp.dao.IConsulta;
import hipercorp.impl.ConsultaImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmTresProductosMasVendidos extends JInternalFrame{
    
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmTresProductosMasVendidos() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Productos más Vendidos");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombres");
        modelo.addColumn("Precio");        
        
        List<String[]> lista = new ArrayList<>();
        try {
            IConsulta consultaDao = new ConsultaImpl();
            lista = consultaDao.obtenerMejoresProductos();
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
