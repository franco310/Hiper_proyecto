
package hipercorp.vistas;

import hipercorp.dao.ICliente;
import hipercorp.entidades.Cliente;
import hipercorp.impl.ClienteImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco
 */
public class FrmNuevoCliente extends JInternalFrame {
    
    JLabel lblTitulo0;
    JLabel lblidCliente;
    JLabel lblcedula;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lbldireccion;
    JLabel lbltelefono;
    JLabel lblemail;
    JLabel lblFecha;
    
    JTextField txtidCliente;
    JTextField txtcedula;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtemail;
    JTextField txtfecha;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoCliente() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Cliente");
        
        lblidCliente= new JLabel("Id Cliente:");
        lblcedula= new JLabel("Cedula de Identidad:");
        lblnombre= new JLabel("Nombre:");
        lblapellido= new JLabel("Apelldio:");
        lbldireccion= new JLabel("Direccion:");
        lbltelefono= new JLabel("Telefono:");
        lblemail= new JLabel("Email:");
        lblFecha= new JLabel("Fecha de nacimiento:"); 

        txtidCliente = new JTextField(2);
        txtcedula = new JTextField(2);
        txtnombre= new JTextField(2);
        txtapellido= new JTextField(2);
        txtdireccion= new JTextField(2);
        txttelefono= new JTextField(2);
        txtemail= new JTextField(2);
        txtfecha= new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
       
        
        pnlCentral.add(lblidCliente);
        pnlCentral.add(txtidCliente);
        pnlCentral.add(lblcedula);
        pnlCentral.add(txtcedula);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(lbltelefono);
        pnlCentral.add(txttelefono);
        pnlCentral.add(lblemail);
        pnlCentral.add(txtemail);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtfecha);       
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
        FrmNuevoCliente frmMenu= new FrmNuevoCliente();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(Integer.parseInt(txtidCliente.getText()));
        cliente.setCedula(txtcedula.getText());
        cliente.setNombre(txtnombre.getText());
        cliente.setApellido(txtapellido.getText());
        cliente.setDireccion(txtdireccion.getText());
        cliente.setTelefono(txttelefono.getText());
        cliente.setEmail(txtemail.getText());
      DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                cliente.setFecha_nac(formatoFecha.parse(txtfecha.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            };
        
        try {
            if(clienteDao.insertar(cliente)>0){
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
