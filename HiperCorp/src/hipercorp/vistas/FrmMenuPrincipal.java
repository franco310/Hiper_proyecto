
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
                mniNuevoFacturaVentaActionPerformed(e);
            }
        });
        mniModificaFacturaCompra = new JMenuItem("Modifica");
        mniEliminaFacturaCompra = new JMenuItem("Elimina");
        mniBuscaFacturaCompra = new JMenuItem("Busca");
        mniListaFacturaCompra = new JMenuItem("Lista"); 
        mniListaFacturaCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaFacturaVentaActionPerformed(e);
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
         
        
        
        
        
        mnbPrincipal.add(mnInicio);
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
     public void mniNuevoFacturaVentaActionPerformed(ActionEvent e){
        FrmNuevoFacturaCompra frm = new FrmNuevoFacturaCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaFacturaVentaActionPerformed(ActionEvent e){
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
       public void mniListaDetalleCompraActionPerformed(ActionEvent e){
        FrmListaDetalleCompra frm = new FrmListaDetalleCompra();
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
