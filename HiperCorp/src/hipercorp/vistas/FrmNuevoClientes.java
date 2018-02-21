
package hipercorp.vistas;

import hipercorp.dao.ICliente;
import hipercorp.entidades.Cliente;
import hipercorp.impl.ClienteImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class FrmNuevoClientes extends JInternalFrame {
 
    JLabel lblTitulo0;
    JLabel lblidCliente;
    JLabel lblcedula;
    JLabel lblnombres;
    JLabel lblapellidos;
    JLabel lbldireccion;
    JLabel lbltelefono;
    JLabel lblemail;
    JLabel lblfecha;

    
    JTextField txtidCliente;
    JTextField txtcedula;
    JTextField txtnombres;
    JTextField txtapellidos;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtemail;
    JTextField txtfecha;
    
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoClientes() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del cliente");
        
        lblidCliente= new JLabel("Id del Cliente:");
        lblcedula= new JLabel("Cedula:");
        lblnombres= new JLabel("Nombre:");
        lblapellidos= new JLabel("Apellidos:");
        lbldireccion = new JLabel("Direccion:");
        lbltelefono = new JLabel("Telefono:");
        lblemail = new JLabel("Email:");
        lblnombres= new JLabel("Fecha de Nacimiento:");
       

        txtidCliente= new JTextField(2);
        txtcedula= new JTextField(2);
        txtnombres = new JTextField(2);
        txtapellidos = new JTextField(2);
        txtdireccion = new JTextField(2);
        txttelefono= new JTextField(2);
        txtemail= new JTextField(2);
        txtfecha = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidCliente);
        pnlCentral.add(txtcedula);
        pnlCentral.add(lblnombres);
        pnlCentral.add(txtnombres);
        pnlCentral.add(lblapellidos);
        pnlCentral.add(txtapellidos);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(lbltelefono);
        pnlCentral.add(txttelefono);
        pnlCentral.add(lblemail);
        pnlCentral.add(txtemail);
        pnlCentral.add(lblfecha);
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
        FrmNuevoProveedor frmMenu= new FrmNuevoProveedor();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ICliente clienteDao = new ClienteImpl();
        Cliente  cliente  = new Cliente ();
        cliente.setIdCliente(Integer.parseInt(txtidCliente.getText()));
        cliente.setCedula(txtcedula.getText());
        cliente.setNombres(txtnombres.getText());
        cliente.setApellidos(txtapellidos.getText());
        cliente.setDireccion(txtdireccion.getText());
        cliente.setTelefono(txttelefono.getText());
        cliente.setEmail(txtemail.getText());
       DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            cliente.setFecha(formatoFecha.parse(txtfecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        
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
        
    }}
    
    
    
  
    
    
    
    
    
    
    
    
    

