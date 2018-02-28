/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IDetalleVenta;
import hipercorp.dao.IFacturaVenta;
import hipercorp.dao.IProducto;
import hipercorp.entidades.DetalleVenta;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.FacturaVenta;
import hipercorp.entidades.Producto;
import hipercorp.entidades.Proveedor;
import hipercorp.impl.DetalleVentaImpl;
import hipercorp.impl.FacturaVentaImpl;
import hipercorp.impl.ProductoImpl;
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

/**
 *
 * @author Usuario
 */
public class FrmNuevoDetalleVenta extends JInternalFrame{
 
    List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    
    
    
    JLabel lblTitulo;
    JLabel lblCodDetalleVenta;
    JLabel lblCodProducto;
    JLabel lblCantidad;
    JLabel lblPrecio;
    
    
    JTextField txtCodDetalleVenta;;
    JTextField txtCantidad;
    JTextField txtPrecio;
   
    JButton btnEliminar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoDetalleVenta (){
        this.setSize(400,400);
        this.setLayout(new BorderLayout());
    
     this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(8, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Detalle de la Venta ");
        
        lblCodDetalleVenta= new JLabel("idDetalleVenta");
        lblCodProducto= new JLabel("Producto");
        lblPrecio = new JLabel("Precio");
        lblCantidad = new JLabel("Cantidad");
       

        txtCodDetalleVenta= new JTextField(2);
        cargarProductos();
        cmbProducto= new JComboBox(lstProducto.toArray());
        txtPrecio= new JTextField(2);
        txtCantidad= new JTextField(2);
        
        btnEliminar= new JButton("Eliminar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodDetalleVenta);
        pnlCentral.add(txtCodDetalleVenta);
        pnlCentral.add(lblCodProducto);
        pnlCentral.add(cmbProducto);
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
        FrmNuevoDetalleVenta frmnuevo= new FrmNuevoDetalleVenta();
        frmnuevo.setVisible(true);
    } 
    
         
    
     public void cargarProductos(){
        IProducto productoDao = new ProductoImpl();
        try {
            lstProducto = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Productos",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    
   
    public void btnAceptarActionListener(ActionEvent e){
        IDetalleVenta detalleventaDao = new DetalleVentaImpl();
        DetalleVenta detalleventa = new DetalleVenta();
        detalleventa.setIdDetalleVenta(Integer.parseInt(txtCodDetalleVenta.getText()));
        detalleventa.setProducto((Producto) cmbProducto.getSelectedItem());
        detalleventa.setCantidad(Integer.parseInt(txtCantidad.getText()));
        detalleventa.setPreciototal(Integer.parseInt(txtPrecio.getText()));
        
        
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
