
package hipercorp.vistas;

import hipercorp.dao.IFacturaCompra;
import hipercorp.dao.IProveedor;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.Proveedor;
import hipercorp.impl.FacturaCompraImpl;
import hipercorp.impl.ProveedorImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmNuevoFacturaCompra extends JInternalFrame {
    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
    JLabel lblTitulo0;
    JLabel lblidFacturaCompra;
    JLabel lblfecha;
    JLabel lblProveedor;
    
    
    JTextField txtidFacturaCompra;
    JTextField txtfecha;
 
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoFacturaCompra() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos FacturaCompra");
        
        lblidFacturaCompra= new JLabel("idFacturaCompra:");
        lblfecha = new JLabel("Fecha:");
        lblProveedor = new JLabel("Proveedor:");

        txtidFacturaCompra = new JTextField(2);
        txtfecha= new JTextField(2);
        cargarProveedores();
        cmbProveedor = new JComboBox(lstProveedor.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidFacturaCompra);
        pnlCentral.add(txtidFacturaCompra);
        pnlCentral.add(lblfecha);
        pnlCentral.add(txtfecha);
        pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);
        
                
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoFacturaCompra frmMenu= new FrmNuevoFacturaCompra();
        frmMenu.setVisible(true);
    } 
    public void cargarProveedores(){
        IProveedor proveedorDao = new ProveedorImpl();
        try {
            lstProveedor = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los cursos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IFacturaCompra facturacompraDao = new FacturaCompraImpl();
        FacturaCompra  facturacompra = new FacturaCompra ();
        facturacompra.setIdFacturaCompra(Integer.parseInt(txtidFacturaCompra.getText()));
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            facturacompra.setFecha(formatoFecha.parse(txtfecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        facturacompra.setProveedor((Proveedor) cmbProveedor.getSelectedItem());
        
        try {
            if(facturacompraDao.insertar(facturacompra)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

   
    
}
