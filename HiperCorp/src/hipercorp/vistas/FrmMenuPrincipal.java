
package hipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class FrmMenuPrincipal extends JFrame {
    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
     //Producto
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniModificaProducto;
    JMenuItem mniEliminaProducto;
    JMenuItem mniBuscaProducto;
    JMenuItem mniListaProducto;
     
    // Clientes      
    JMenu mnClientes;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    
    //FacturaCompra
    JMenu mnFacturaCompra;
    JMenuItem mniNuevoFacturaCompra;
    JMenuItem mniModificaFacturaCompra;
    JMenuItem mniEliminaFacturaCompra;
    JMenuItem mniBuscaFacturaCompra;
    JMenuItem mniListaFacturaCompra;
    
    //DetalleCompra
    JMenu mnDetalleCompra;
    JMenuItem mniNuevoDetalleCompra;
    JMenuItem mniModificaDetalleCompra;
    JMenuItem mniEliminaDetalleCompra;
    JMenuItem mniBuscaDetalleCompra;
    JMenuItem mniListaDetalleCompra;
    
    
    
    
    
  JDesktopPane dkpEscritorio;
  
   public FrmMenuPrincipal(){
        //Inicio
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));      
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");

        mniSalir.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        
        //FacturaCompra
        mnFacturaCompra = new JMenu("FacturaCompra");
        mniNuevoFacturaCompra = new JMenuItem("Nuevo");
        mniNuevoFacturaCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoFacturaCompraActionPerformed(e);
            }
        });
        mniModificaFacturaCompra = new JMenuItem("Modifica");
        mniEliminaFacturaCompra = new JMenuItem("Elimina");
        mniBuscaFacturaCompra = new JMenuItem("Busca");
         mniBuscaFacturaCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaFacturaCompraActionPerformed(e);
            }
        });
        mniListaFacturaCompra = new JMenuItem("Lista"); 
        mniListaFacturaCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaFacturaCompraActionPerformed(e);
            }
        });
        mnFacturaCompra.add(mniNuevoFacturaCompra);
        mnFacturaCompra.add(mniModificaFacturaCompra);
        mnFacturaCompra.add(mniEliminaFacturaCompra);
        mnFacturaCompra.addSeparator();
        mnFacturaCompra.add(mniBuscaFacturaCompra);
        mnFacturaCompra.add(mniListaFacturaCompra);
        
        //DetalleCompra
        mnDetalleCompra = new JMenu("DetalleCompra");
        mniNuevoDetalleCompra = new JMenuItem("Nuevo");
        mniNuevoDetalleCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleCompraActionPerformed(e);
            }
        });
        mniModificaDetalleCompra = new JMenuItem("Modifica");
        mniEliminaDetalleCompra = new JMenuItem("Elimina");
        mniBuscaDetalleCompra = new JMenuItem("Busca");
        mniBuscaDetalleCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaDetalleCompraActionPerformed(e);
            }
        });
        mniListaDetalleCompra = new JMenuItem("Lista"); 
        mniListaDetalleCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleCompraActionPerformed(e);
            }
        });
        mnDetalleCompra.add(mniNuevoDetalleCompra);
        mnDetalleCompra.add(mniModificaDetalleCompra);
        mnDetalleCompra.add(mniEliminaDetalleCompra);
        mnDetalleCompra.addSeparator();
        mnDetalleCompra.add(mniBuscaDetalleCompra);
        mnDetalleCompra.add(mniListaDetalleCompra);
         
         //Clientes
        mnClientes= new JMenu("Clientes");
        mniNuevoCliente= new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        mniModificaCliente= new JMenuItem("Modifica");
        mniEliminaCliente= new JMenuItem("Elimina");
        mniBuscaCliente= new JMenuItem("Busca");
        mniListaCliente= new JMenuItem("Lista"); 
         mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        mnClientes.add(mniNuevoCliente);
        mnClientes.add(mniModificaCliente);
        mnClientes.add(mniEliminaCliente);
        mnClientes.addSeparator();
        mnClientes.add(mniBuscaCliente);
        mnClientes.add(mniListaCliente);
        
        
         
        //Producto
        mnProducto = new JMenu("Producto");
        mniNuevoProducto = new JMenuItem("Nuevo");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }
        });
        mniModificaProducto = new JMenuItem("Modifica");
        mniEliminaProducto = new JMenuItem("Elimina");
        mniBuscaProducto = new JMenuItem("Busca");
        mniListaProducto = new JMenuItem("Lista");
         mniListaProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProductoActionPerformed(e);
            }
        });
        mnProducto.add(mniNuevoProducto);
        mnProducto.add(mniModificaProducto);
        mnProducto.add(mniEliminaProducto);
        mnProducto.addSeparator();
        mnProducto.add(mniBuscaProducto);
        mnProducto.add(mniListaProducto);
        
        
        
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnClientes);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnFacturaCompra);
        mnbPrincipal.add(mnDetalleCompra);
   
        
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setBounds(450,450,650,650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
        
    } //Fin public FrmMenuPrincipal
    //FacturaCompra
     public void mniNuevoFacturaCompraActionPerformed(ActionEvent e){
        FrmNuevoFacturaCompra frm = new FrmNuevoFacturaCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniBuscaFacturaCompraActionPerformed(ActionEvent e){
        FrmBuscarFacturaCompra frm = new FrmBuscarFacturaCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaFacturaCompraActionPerformed(ActionEvent e){
        FrmListaFacturaCompra frm = new FrmListaFacturaCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
       //DetalleCompra
     public void mniNuevoDetalleCompraActionPerformed(ActionEvent e){
        FrmNuevoDetalleCompra frm = new FrmNuevoDetalleCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniBuscaDetalleCompraActionPerformed(ActionEvent e){
        FrmBuscarDetalleCompra frm = new FrmBuscarDetalleCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaDetalleCompraActionPerformed(ActionEvent e){
        FrmListaDetalleCompra frm = new FrmListaDetalleCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
  
       //Cliente
     public void mniNuevoClienteActionPerformed(ActionEvent e){
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaClienteActionPerformed(ActionEvent e){
        FrmListaCliente frm = new FrmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
        //Producto
     public void mniNuevoProductoActionPerformed(ActionEvent e){
        FrmNuevoProducto frm = new FrmNuevoProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaProductoActionPerformed(ActionEvent e){
        FrmListaProducto frm = new FrmListaProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       
       
   
     public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteSkin"); 
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark. SubstanceBubblesWatermark");//Ejemplo de aplicacion de un watermark de Substance
        SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("e:\\fondo.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.9));//valor aproximado de la opacidad por default de imageWatermark
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }  
}
