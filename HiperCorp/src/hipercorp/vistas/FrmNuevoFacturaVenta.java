/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IFacturaVenta;
import hipercorp.entidades.FacturaVenta;
import hipercorp.impl.FacturaVentaImpl;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Segovia
 */
public class FrmNuevoFacturaVenta extends JInternalFrame {
 
    JLabel lblTitulo0;
    JLabel lblidFacturaVenta;
    JLabel lblFecha;
    JLabel lblCedula;
    
    
    
    JTextField txtidFacturaVenta;
    JTextField txtFeecha;
    JTextField txtCedula;
   
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public  FrmNuevoFacturaVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Factura Venta");
        
        lblidFacturaVenta= new JLabel("Codigo factura:");
        lblFecha= new JLabel("Fecha:");
        lblCedula = new JLabel("Cedula:");
   
       

        txtidFacturaVenta = new JTextField(2);
        txtFeecha = new JTextField(2);
        txtCedula = new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidFacturaVenta);
        pnlCentral.add(txtidFacturaVenta);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFeecha);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
       
              
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
         FrmNuevoFacturaVenta frmMenu= new  FrmNuevoFacturaVenta();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IFacturaVenta facturaventaDao = new FacturaVentaImpl();
        FacturaVenta facturaventa = new FacturaVenta();
        facturaventa.setIdFacturaVenta(Integer.parseInt(txtidFacturaVenta.getText()));
       DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            facturaventa.setFecha(formatoFecha.parse(txtFeecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        facturaventa.setCedula(Integer.parseInt(txtCedula.getText()));
        
        try {
            if(facturaventaDao.insertar(facturaventa)>0){
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
