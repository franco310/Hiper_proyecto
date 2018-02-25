/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IEmpleado;
import hipercorp.dao.IUsuario;
import hipercorp.entidades.Empleado;
import hipercorp.entidades.Usuario;
import hipercorp.impl.EmpleadoImpl;
import hipercorp.impl.UsuarioImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FrmNuevoEmpleado  extends JInternalFrame {
 
    List<Usuario> lstUsuario;
    JComboBox<Usuario> cmbUsuario;
   
    JLabel lblTitulo0;
    JLabel lblidEmpleado;
    JLabel lblIdUsuario;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblFechaIngreso;
    JLabel lblFechaSalida;    
    
    
    JTextField txtidEmpleado;
    JTextField txtidUsuario;
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtFechaIngreso;
    JTextField txtFechaSalida;
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoEmpleado () {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Empleado");
        
        lblidEmpleado = new JLabel("Empleado:");
        lblIdUsuario = new JLabel("Usuario}:");
        lblCedula = new JLabel("Cedula:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblFechaIngreso = new JLabel("Fecha de ingreso:");
        lblFechaSalida = new JLabel("Fecha de salida:");
        
        txtidEmpleado= new JTextField(2);
        cargarUsuario();
        cmbUsuario = new JComboBox(lstUsuario.toArray());
        txtCedula = new JTextField(2); 
        txtNombre = new JTextField(2); 
        txtApellido = new JTextField(2); 
        txtFechaIngreso = new JTextField(2); 
        txtFechaSalida = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidEmpleado);
        pnlCentral.add(txtidEmpleado);
        pnlCentral.add(lblIdUsuario);
        pnlCentral.add(cmbUsuario);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblFechaIngreso);
        pnlCentral.add(txtFechaIngreso);
         pnlCentral.add(lblFechaSalida);
        pnlCentral.add(txtFechaSalida);
                
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
       FrmNuevoEmpleado  frmMenu= new FrmNuevoEmpleado ();
        frmMenu.setVisible(true);
    } 
    public void cargarUsuario(){
        IUsuario usuarioDao = new UsuarioImpl();
        try {
            lstUsuario = usuarioDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
   
    public void btnAceptarActionListener(ActionEvent e){
        IEmpleado empleadoDao = new EmpleadoImpl();
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(Integer.parseInt(txtApellido.getText()));
        empleado.setUsuario((Usuario) cmbUsuario.getSelectedItem());
        empleado.setCedula(txtCedula.getText());
        empleado.setNombre(txtNombre.getText());
        empleado.setApellido(txtApellido.getText());
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            empleado.setFechaIngreso(formatoFecha.parse(txtFechaIngreso.getText()));
            empleado.setFechaSalida(formatoFecha.parse(txtFechaSalida.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        
       
        
        try {
            if(empleadoDao.insertar(empleado)>0){
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
