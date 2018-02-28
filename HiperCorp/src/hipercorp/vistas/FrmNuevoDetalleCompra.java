
package hipercorp.vistas;

import hipercorp.dao.IDetalleCompra;
import hipercorp.dao.IFacturaCompra;
import hipercorp.dao.IProducto;
import hipercorp.dao.IProveedor;
import hipercorp.entidades.DetalleCompra;
import hipercorp.entidades.FacturaCompra;
import hipercorp.entidades.Producto;
import hipercorp.entidades.Proveedor;
import hipercorp.impl.DetalleCompraImpl;
import hipercorp.impl.FacturaCompraImpl;
import hipercorp.impl.ProductoImpl;
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

public class FrmNuevoDetalleCompra extends JInternalFrame{
    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
    
    List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    
    List<FacturaCompra> lstFacturaCompra;
    JComboBox<FacturaCompra> cmbFacturaCompra;
    JLabel lblTitulo0;
    JLabel lblidDetalleCompra;
    JLabel lblProveedor;
    JLabel lblProducto;
    JLabel lblFacturaCompra;
    JLabel lblcantidad;
    JLabel lblpreciototal;
    
    
    
    JTextField txtidDetalleCompra;
    JTextField txtcantidad;
    JTextField txtpreciototal;
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoDetalleCompra() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos DetalleCompra");
        
        lblidDetalleCompra = new JLabel("Código:");
        lblProveedor = new JLabel("Proveedores:");
        lblProducto = new JLabel("Productos:");
        lblFacturaCompra = new JLabel("FacturaCompra:");
        lblcantidad = new JLabel("Cantidad:");
        lblpreciototal = new JLabel("PrecioTotal:");

        txtidDetalleCompra = new JTextField(2);
        cargarProveedor();
        cmbProveedor = new JComboBox(lstProveedor.toArray());
        cargarProductos();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarFacturaCompra();
        cmbFacturaCompra = new JComboBox(lstFacturaCompra.toArray());
        txtcantidad = new JTextField(2); 
        txtpreciototal = new JTextField(2); 
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidDetalleCompra);
        pnlCentral.add(txtidDetalleCompra);
        pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblFacturaCompra);
        pnlCentral.add(cmbFacturaCompra);
        pnlCentral.add(lblcantidad);
        pnlCentral.add(txtcantidad);
        pnlCentral.add(lblpreciototal);
        pnlCentral.add(txtpreciototal);
        
                
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
        FrmNuevoDetalleCompra frmMenu= new FrmNuevoDetalleCompra();
        frmMenu.setVisible(true);
    } 
    public void cargarProveedor(){
        IProveedor proveedorDao = new ProveedorImpl();
        try {
            lstProveedor = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
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
    
    public void cargarFacturaCompra(){
        IFacturaCompra facturacompraDao = new FacturaCompraImpl();
        try {
            lstFacturaCompra = facturacompraDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los FacturaCompra!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IDetalleCompra detallecompraDao = new DetalleCompraImpl();
        DetalleCompra detallecompra = new DetalleCompra();
        detallecompra.setIdDetalleCompra(Integer.parseInt(txtidDetalleCompra.getText()));
        detallecompra.setProveedor((Proveedor) cmbProveedor.getSelectedItem());
        detallecompra.setProducto((Producto) cmbProducto.getSelectedItem());
        detallecompra.setFacturacompra((FacturaCompra) cmbFacturaCompra.getSelectedItem());
        detallecompra.setCantidada(Integer.parseInt(txtcantidad.getText()));
        detallecompra.setPreciototal(Integer.parseInt(txtpreciototal.getText()));
        
        try {
            if(detallecompraDao.insertar(detallecompra)>0){
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
