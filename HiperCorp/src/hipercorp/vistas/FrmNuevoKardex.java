
package hipercorp.vistas;

import hipercorp.dao.IDetalleCompra;
import hipercorp.dao.IDetalleVenta;
import hipercorp.dao.IKardex;
import hipercorp.dao.IProducto;
import hipercorp.entidades.DetalleCompra;
import hipercorp.entidades.DetalleVenta;
import hipercorp.entidades.Kardex;
import hipercorp.entidades.Producto;
import hipercorp.impl.DetalleCompraImpl;
import hipercorp.impl.DetalleVentaImpl;
import hipercorp.impl.KardexImpl;
import hipercorp.impl.ProductoImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmNuevoKardex extends JInternalFrame{
        
    List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    
    List<DetalleCompra> lstDetalleCompra;
    JComboBox<DetalleCompra> cmbDetalleCompra;
    
    List<DetalleVenta> lstDetalleVenta;
    JComboBox<DetalleVenta> cmbDetalleVenta;
    
  
    JLabel lblTitulo0;
    JLabel lblidKardex;
    JLabel lblProducto;
    JLabel lblDetalleCompra;
    JLabel lblDetalleVenta;
    JLabel lblfechaEmision;
    JLabel lblexistencias;
    JLabel lblvalorTotal;
    
    
    
    JTextField txtidKardex;
    JTextField txtfechaEmision;
    JTextField txtexistencias;
    JTextField txtvalorTotal;
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoKardex() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Kardex");
        
        lblidKardex = new JLabel("Código: ");
        lblProducto = new JLabel("Productos: ");
        lblDetalleCompra = new JLabel("Detalle Compra: ");
        lblDetalleVenta = new JLabel("Detalle Venta: ");
        lblfechaEmision= new JLabel("Fecha de Emision:");
        lblexistencias= new JLabel("Existencias:");
        lblvalorTotal = new JLabel("Valor Total:");

        
        txtidKardex = new JTextField(2);
        
        cargarProductos();
        cmbProducto = new JComboBox(lstProducto.toArray());
        
        cargarDetalleCompra();
        cmbDetalleCompra = new JComboBox(lstDetalleCompra.toArray());
        
        cargarDetalleVenta();
        cmbDetalleVenta = new JComboBox(lstDetalleVenta.toArray());
        
        txtfechaEmision = new JTextField(2); 
        txtexistencias = new JTextField(2); 
        txtvalorTotal = new JTextField(2); 
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidKardex);
        pnlCentral.add(txtidKardex);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblDetalleCompra);
        pnlCentral.add(cmbDetalleCompra);
        pnlCentral.add(lblDetalleVenta);
        pnlCentral.add(cmbDetalleVenta);
        pnlCentral.add(lblfechaEmision);
        pnlCentral.add(txtfechaEmision);
        pnlCentral.add(lblexistencias);
        pnlCentral.add(txtexistencias);
        pnlCentral.add(lblvalorTotal);
        pnlCentral.add(txtvalorTotal);
        
        
                
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
        FrmNuevoKardex frmMenu= new FrmNuevoKardex();
       
        frmMenu.setVisible(true);
    } 
    
    
     public void cargarProductos(){
        IProducto productoDao = new ProductoImpl();
        try {
            lstProducto = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Productos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
     
     public void cargarDetalleCompra(){
        IDetalleCompra detalleCompraDao = new DetalleCompraImpl();
        try {
            lstDetalleCompra = detalleCompraDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar Detalle Compra!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
     }
     public void cargarDetalleVenta(){
        IDetalleVenta detalleVentaDao = new DetalleVentaImpl();
        try {
            lstDetalleVenta = detalleVentaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar Detalle Venta!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
     
     }

    
    public void btnAceptarActionListener(ActionEvent e){
        IKardex kardexDao = new KardexImpl();
        Kardex kardex = new Kardex();
        kardex.setIdKardex(Integer.parseInt(txtidKardex.getText()));
        kardex.setProducto((Producto) cmbProducto.getSelectedItem());
        kardex.setDetalleCompra((DetalleCompra) cmbDetalleCompra.getSelectedItem());
        kardex.setDetalleVenta((DetalleVenta) cmbDetalleVenta.getSelectedItem());
        kardex.setValorTotal(Integer.parseInt(txtvalorTotal.getText()));
        
        try {
            if(kardexDao.insertar(kardex)>0){
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
