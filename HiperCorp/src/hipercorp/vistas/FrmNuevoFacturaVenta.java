/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.ICliente;
import hipercorp.dao.IEmpleado;
import hipercorp.dao.IFacturaVenta;
import hipercorp.dao.IProducto;
import hipercorp.entidades.Cliente;
import hipercorp.entidades.Empleado;
import hipercorp.entidades.FacturaVenta;
import hipercorp.entidades.Producto;
import hipercorp.impl.ClienteImpl;
import hipercorp.impl.EmpleadoImpl;
import hipercorp.impl.FacturaVentaImpl;
import hipercorp.impl.ProductoImpl;
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
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Segovia
 */
public class FrmNuevoFacturaVenta extends JInternalFrame {
 
   List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    
    List<Empleado> lstEmpleado;
    JComboBox<Empleado> cmbEmpleado;
    
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    
    JLabel lblTitulo0;
    JLabel lblidFacturaVenta;
    JLabel lblIdproducto;
    JLabel lblIdempleado;
    JLabel lblidcliente;
    JLabel lblFecha;
    JLabel lblcantidad;
    JLabel lbltipo_pago;
    
    
    
    JTextField txtidfacturaventa;
    JTextField txtFecha;
    JTextField txtcantidad;
    JTextField txttipo_pago;
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoFacturaVenta () {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Factura Venta");
        
        lblidFacturaVenta = new JLabel("Codigo:");
        lblIdproducto = new JLabel("Codigo Facutura:");
        lblIdempleado = new JLabel("Codigo Empleado:");
        lblidcliente = new JLabel("Codigo Cliente :");
        lblFecha = new JLabel("Fecha:");
        lblcantidad = new JLabel("Cantidad:");
        lbltipo_pago = new JLabel("Modo de pago:");

        txtidfacturaventa = new JTextField(2);
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarEmpleado();
        cmbEmpleado = new JComboBox(lstEmpleado.toArray());
        cargarCliente();
        cmbCliente = new JComboBox(lstCliente.toArray()); 
        txtFecha = new JTextField(2);
        txtcantidad = new JTextField(2);
        txttipo_pago = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidFacturaVenta);
        pnlCentral.add(txtidfacturaventa);
        pnlCentral.add(lblIdproducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblIdempleado);
        pnlCentral.add(cmbEmpleado);
        pnlCentral.add(lblidcliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblcantidad);
        pnlCentral.add(txtcantidad);
        pnlCentral.add(lbltipo_pago);
        pnlCentral.add(txttipo_pago);
                
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
        FrmNuevoFacturaVenta  frmMenu= new FrmNuevoFacturaVenta ();
        frmMenu.setVisible(true);
    } 
    
     public void cargarProducto(){
        IProducto productoDao = new ProductoImpl();
        try {
            lstProducto = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Productos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
     public void cargarEmpleado(){
        IEmpleado empleadoDao = new EmpleadoImpl();
        try {
            lstEmpleado = empleadoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public void cargarCliente(){
        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los FacturaCompra!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IFacturaVenta facturaventaDao = new FacturaVentaImpl();
        FacturaVenta facturaventa = new FacturaVenta();
       facturaventa.setIdFacturaVenta(Integer.parseInt(txtidfacturaventa.getText()));
       facturaventa.setProducto((Producto) cmbProducto.getSelectedItem());
       facturaventa.setEmpleado((Empleado) cmbEmpleado.getSelectedItem());
       facturaventa.setCliente((Cliente) cmbCliente.getSelectedItem());
     
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            facturaventa.setFecha(formatoFecha.parse(txtFecha.getText()));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
          facturaventa.setCantidad(Integer.parseInt(txtcantidad.getText()));
         facturaventa.setTipo_pago(txttipo_pago.getText());
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
