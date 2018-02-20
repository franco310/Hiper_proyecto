/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import hipercorp.dao.*;
import hipercorp.impl.*;
import hipercorp.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Usuario
 */
public class FrmDetalleVenta extends JJInternalFrame{
    JLabel lblTitulo;
    JLabel lblCodDetalleVenta;
    JLabel lblCodProducto;
    JLabel lblCodFacturaVenta;
    JLabel lblCantidad;
    JLabel lblPrecio;
    
    
    JTextField txtCodDetalleVenta;
    JTextField txtCodProducto;
    JTextField txtCodFacturaVenta;
    JTextField txtCantidad;
    JTextField txtPrecio;
   
    JButton btnEliminar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmDetalleVenta (){
        this.setSize(400,400);
        this.setLayout(new BorderLayout());
    
     this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(8, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Detalle de la Venta ");
        
        lblCodDetalleVenta= new JLabel("");
        lblCodProducto= new JLabel("");
        lblCodFacturaVenta = new JLabel("");
        lblPrecio = new JLabel("");
        lblCantidad = new JLabel(" ");
       

        txtCodDetalleVenta= new JTextField(2);
        txtCodProducto = new JTextField(2);
        txtCodFacturaVenta = new JTextField(2);
        txtPrecio= new JTextField(2);
        txtCantidad= new JTextField(2);
        
        btnEliminar= new JButton("Eliminar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodDetalleVenta);
        pnlCentral.add(txtCodDetalleVenta);
        pnlCentral.add(lblCodProducto);
        pnlCentral.add(txtCodProducto);
        pnlCentral.add(lblCodFacturaVenta);
        pnlCentral.add(txtCodFacturaVenta);
        pnlCentral.add(lblPrecio);
        pnlCentral.add(txtPrecio);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
              
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
        
        pnlPie.add(btnEliminar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmDetalleVenta frmnuevo= new FrmDetalleVenta();
        frmnuevo.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IDetalleVenta detalleventaDao = new DetalleVentaImp();
        DetalleVenta detalleventa = new DetalleVenta();
        detalleventa.setCodDetalleVenta(Integer.parseInt(txtCodDetalleVenta.getText()));
        detalleventa.setCodProducto(Integer.parseInt(txtCodProducto.getText()));
        
        
        
     
        
        try {
            if(detalleventaDao.insertar(detalleventa)>0){
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

