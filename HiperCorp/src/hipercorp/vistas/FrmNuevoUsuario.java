/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IUsuario;
import hipercorp.entidades.Usuario;
import hipercorp.impl.UsuarioImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Segovia
 */
public class FrmNuevoUsuario extends JInternalFrame {
 
    JLabel lblTitulo0;
    JLabel lblidUsuario;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lblcontraseña;
    
    
    JTextField txtidusuario;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtcontraseña;
   
    
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public  FrmNuevoUsuario() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Usuario");
        
        lblidUsuario= new JLabel("Codigo Usuario:");
        lblnombre= new JLabel("Nombre:");
        lblapellido = new JLabel("Apellido:");
        lblcontraseña = new JLabel("Contraseña:");
        

        txtidusuario = new JTextField(2);
        txtnombre = new JTextField(2);
        txtapellido = new JTextField(2);
        txtcontraseña= new JTextField(2);

        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidUsuario);
        pnlCentral.add(txtidusuario);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lblcontraseña);
        pnlCentral.add(txtcontraseña);
        
              
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
         FrmNuevoUsuario frmMenu= new  FrmNuevoUsuario();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IUsuario usuarioDao = new UsuarioImpl();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(txtidusuario.getText()));
        usuario.setNombre(txtnombre.getText());
        usuario.setApellido(txtapellido.getText());
        usuario.setContraseña(txtcontraseña.getText());
        
     
        
        try {
            if(usuarioDao.insertar(usuario)>0){
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
