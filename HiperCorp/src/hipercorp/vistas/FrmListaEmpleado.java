
package hipercorp.vistas;

import hipercorp.dao.IEmpleado;
import hipercorp.entidades.Empleado;
import hipercorp.impl.EmpleadoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaEmpleado extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
  
     public FrmListaEmpleado(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
       lblTitulo = new JLabel("Listado de Empleados");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
        
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Empleado:");
        modelo.addColumn("Cedula:");
        modelo.addColumn("Nombre:");
        modelo.addColumn("Apellido:");
        modelo.addColumn("Fecha de ingreso :");
        modelo.addColumn("Fecha de salida");
        
        List<Empleado> lista = new ArrayList<>();
        try {
            IEmpleado empleadoDao = new EmpleadoImpl();
            lista = empleadoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Empleado est : lista){
            modelo.addRow(new Object[] {est.getIdEmpleado(),est.getCedula(),
                est.getNombre(),est.getApellido(),est.getFechaIngreso().toString(),est.getFechaSalida().toString()});
            
            }
           tabla.setModel(modelo); 
        }
    
    
}