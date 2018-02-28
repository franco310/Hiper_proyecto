
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

import org.jvnet.substance.watermark.SubstanceImageWatermark;
import org.jvnet.substance.SubstanceLookAndFeel;
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
    
     //Categoria
    JMenu mnCategoria;
    JMenuItem mniNuevoCategoria;
    JMenuItem mniModificaCategoria;
    JMenuItem mniEliminaCategoria;
    JMenuItem mniBuscaCategoria;
    JMenuItem mniListaCategoria;
     
    // Clientes      
    JMenu mnClientes;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    //Usuario
    JMenu mnUsuario;
    JMenuItem mniNuevoUsuario;
    JMenuItem mniModificaUsuario;
    JMenuItem mniEliminaUsuario;
    JMenuItem mniBuscaUsuario;
    JMenuItem mniListaUsuario;
    //Empleado
    JMenu mnEmpleado;
    JMenuItem mniNuevoEmpleado;
    JMenuItem mniModificaEmpleado;
    JMenuItem mniEliminaEmpleado;
    JMenuItem mniBuscaEmpleado;
    JMenuItem mniListaEmpleado;
    //FacturaCompra
    JMenu mnFacturaCompra;
    JMenuItem mniNuevoFacturaCompra;
    JMenuItem mniModificaFacturaCompra;
    JMenuItem mniEliminaFacturaCompra;
    JMenuItem mniBuscaFacturaCompra;
    JMenuItem mniListaFacturaCompra;
    //FacturaVenta
    
    JMenu mnFacturaVenta;
    JMenuItem mniNuevoFacturaVenta;
    JMenuItem mniModificaFacturaVenta;
    JMenuItem mniEliminaFacturaVenta;
    JMenuItem mniBuscaFacturaVenta;
    JMenuItem mniListaFacturaVenta;
    //DetalleCompra
    JMenu mnDetalleCompra;
    JMenuItem mniNuevoDetalleCompra;
    JMenuItem mniModificaDetalleCompra;
    JMenuItem mniEliminaDetalleCompra;
    JMenuItem mniBuscaDetalleCompra;
    JMenuItem mniListaDetalleCompra;
    //DetalleVenta
    JMenu mnDetalleVenta;
    JMenuItem mniNuevoDetalleVenta;
    JMenuItem mniModificaDetalleVenta;
    JMenuItem mniEliminaDetalleVenta;
    JMenuItem mniBuscaDetalleVenta;
    JMenuItem mniListaDetalleVenta;
    
    //Proveedor
    JMenu mnProveedor;
    JMenuItem mniNuevoProveedor;
    JMenuItem mniModificaProveedor;
    JMenuItem mniEliminaProveedor;
    JMenuItem mniBuscaProveedor;
    JMenuItem mniListaProveedor;
    
    //Kardex
    JMenu mnKardex;
    JMenuItem mniNuevoKardex;
    JMenuItem mniModificaKardex;
    JMenuItem mniEliminaKardex;
    JMenuItem mniBuscaKardex;
    JMenuItem mniListaKardex;
    
    
    
    
    
  JDesktopPane dkpEscritorio;
  
   public FrmMenuPrincipal(){
        //Inicio
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));      
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniLoginActionPerformed(e);
             
            }
        });
        
        
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
        
         //DetalleVenta
        mnDetalleVenta = new JMenu("DetalleVenta");
        mniNuevoDetalleVenta = new JMenuItem("Nuevo");
        mniNuevoDetalleVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleVentaActionPerformed(e);
            }
        });
        mniModificaDetalleVenta = new JMenuItem("Modifica");
        mniEliminaDetalleVenta = new JMenuItem("Elimina");
        mniBuscaDetalleVenta = new JMenuItem("Busca");
        mniBuscaDetalleVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaDetalleVentaActionPerformed(e);
            }
        });
        mniListaDetalleVenta = new JMenuItem("Lista"); 
        mniListaDetalleVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleVentaActionPerformed(e);
            }
        });
        mnDetalleVenta.add(mniNuevoDetalleVenta);
        mnDetalleVenta.add(mniModificaDetalleVenta);
        mnDetalleVenta.add(mniEliminaDetalleVenta);
        mnDetalleVenta.addSeparator();
        mnDetalleVenta.add(mniBuscaDetalleVenta);
        mnDetalleVenta.add(mniListaDetalleVenta);
        
        //FacturaVenta
        mnFacturaVenta = new JMenu("Factura Venta");
        mniNuevoFacturaVenta = new JMenuItem("Nuevo");
        mniNuevoFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoFacturaVentaActionPerformed(e);
            }
        });
        mniModificaFacturaVenta = new JMenuItem("Modifica");
        mniEliminaFacturaVenta = new JMenuItem("Elimina");
        mniBuscaFacturaVenta = new JMenuItem("Busca");
         mniBuscaFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mniBuscarFacturaVentaActionPerformed(e);
            }
        });
         
        mniListaFacturaVenta = new JMenuItem("Lista"); 
        mniListaFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaFacturaVentaActionPerformed(e);
            }
        });
        mnFacturaVenta.add(mniNuevoFacturaVenta);
        mnFacturaVenta.add(mniModificaFacturaVenta);
        mnFacturaVenta.add(mniEliminaFacturaVenta);
        mnFacturaVenta.addSeparator();
        mnFacturaVenta.add(mniBuscaFacturaVenta);
        mnFacturaVenta.add(mniListaFacturaVenta);
        
        
        //Usuario
        mnUsuario = new JMenu("Usuario");
        mniNuevoUsuario = new JMenuItem("Nuevo");
        mniNuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoUsuarioActionPerformed(e);
            }
        });
        mniModificaUsuario = new JMenuItem("Modifica");
        mniEliminaUsuario = new JMenuItem("Elimina");
        mniBuscaUsuario = new JMenuItem("Busca");
         /*mniBuscaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaUsuarioActionPerformed(e);
            }
        });
         
        */
        mniListaUsuario = new JMenuItem("Lista"); 
        mniListaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaUsuarioActionPerformed(e);
            }
        });
        mnUsuario.add(mniNuevoUsuario);
        mnUsuario.add(mniModificaUsuario);
        mnUsuario.add(mniEliminaUsuario);
        mnUsuario.addSeparator();
        mnUsuario.add(mniBuscaUsuario);
        mnUsuario.add(mniListaUsuario);
        //Empleado
         mnEmpleado= new JMenu("Empleado");
        mniNuevoEmpleado = new JMenuItem("Nuevo");
        mniNuevoEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEmpleadoActionPerformed(e);
            }
        });
        mniModificaEmpleado = new JMenuItem("Modifica");
        mniEliminaEmpleado = new JMenuItem("Elimina");
        mniBuscaEmpleado = new JMenuItem("Busca");
        /* mniBuscaFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaFacturaVentaActionPerformed(e);
            }
        });
         */
        mniListaEmpleado = new JMenuItem("Lista"); 
        mniListaEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEmpleadoActionPerformed(e);
            }
        });
        mnEmpleado.add(mniNuevoEmpleado);
        mnEmpleado.add(mniModificaEmpleado);
        mnEmpleado.add(mniEliminaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniBuscaEmpleado);
        mnEmpleado.add(mniListaEmpleado);
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
        mniBuscaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaClienteActionPerformed(e);
            }
        });
        
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
        
        //Categoria
        mnCategoria = new JMenu("Categoria");
        mniNuevoCategoria = new JMenuItem("Nuevo");
        mniNuevoCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCategoriaActionPerformed(e);
            }
        });
        mniModificaCategoria = new JMenuItem("Modifica");
        mniEliminaCategoria = new JMenuItem("Elimina");
        mniBuscaCategoria = new JMenuItem("Busca");
        mniBuscaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaCategoriaActionPerformed(e);
            }
        });
        mniListaCategoria = new JMenuItem("Lista");
        mniListaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaCategoriaActionPerformed(e);
            }
        });
        mnCategoria.add(mniNuevoCategoria);
        mnCategoria.add(mniModificaCategoria);
        mnCategoria.add(mniEliminaCategoria);
        mnCategoria.addSeparator();
        mnCategoria.add(mniBuscaCategoria);
        mnCategoria.add(mniListaCategoria);
        
        //Proveedor
         mnProveedor= new JMenu("Proveedor");
        mniNuevoProveedor = new JMenuItem("Nuevo");
        mniNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProveedorActionPerformed(e);
            }
        });
        mniModificaProveedor = new JMenuItem("Modifica");
        mniEliminaProveedor = new JMenuItem("Elimina");
        mniBuscaProveedor = new JMenuItem("Busca");
        mniBuscaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaProveedorActionPerformed(e);
            }
        });
        
        mniListaProveedor = new JMenuItem("Lista"); 
        mniListaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProveedorActionPerformed(e);
            }
        });
        mnProveedor.add(mniNuevoProveedor);
        mnProveedor.add(mniModificaProveedor);
        mnProveedor.add(mniEliminaProveedor);
        mnProveedor.addSeparator();
        mnProveedor.add(mniBuscaProveedor);
        mnProveedor.add(mniListaProveedor);
        
     //Kardex
        mnKardex= new JMenu("Kardex");
        mniNuevoKardex = new JMenuItem("Nuevo");
        mniNuevoKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoKardexActionPerformed(e);
            }
        });
        mniModificaKardex = new JMenuItem("Modifica");
        mniEliminaKardex = new JMenuItem("Elimina");
        mniBuscaKardex = new JMenuItem("Busca");
        mniBuscaKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaKardexActionPerformed(e);
            }
        });
        
        mniListaKardex = new JMenuItem("Lista"); 
        mniListaKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaKardexActionPerformed(e);
            }
        });
        mnKardex.add(mniNuevoKardex);
        mnKardex.add(mniModificaKardex);
        mnKardex.add(mniEliminaKardex);
        mnKardex.addSeparator();
        mnKardex.add(mniBuscaKardex);
        mnKardex.add(mniListaKardex);
        
        
        
        
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnUsuario);
        mnbPrincipal.add(mnEmpleado);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnCategoria);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnKardex);
        mnbPrincipal.add(mnClientes);
        mnbPrincipal.add(mnFacturaCompra);
        mnbPrincipal.add(mnDetalleCompra);
        mnbPrincipal.add(mnDetalleVenta);
        mnbPrincipal.add(mnFacturaVenta);
        
   
        
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setBounds(550,550,750,750);
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
       
       //DetlleVenta
        public void mniNuevoDetalleVentaActionPerformed(ActionEvent e){
        FrmNuevoDetalleVenta frm = new FrmNuevoDetalleVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniBuscaDetalleVentaActionPerformed(ActionEvent e){
        FrmBuscarDetalleVenta frm = new FrmBuscarDetalleVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaDetalleVentaActionPerformed(ActionEvent e){
        FrmListaDetalleVenta frm = new FrmListaDetalleVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

       //facturaVenta
       public void mniNuevoFacturaVentaActionPerformed(ActionEvent e){
        FrmNuevoFacturaVenta frm = new FrmNuevoFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
       }
      public void mniBuscarFacturaVentaActionPerformed(ActionEvent e){
        FrmBuscarFacturaVenta frm = new FrmBuscarFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
      }
       public void mniListaFacturaVentaActionPerformed(ActionEvent e){
        FrmListaFacturaVenta frm = new FrmListaFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
     }
       
       //Usuario
  
       public void mniNuevoUsuarioActionPerformed(ActionEvent e){
        FrmNuevoUsuario frm = new FrmNuevoUsuario();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }/*
     public void mniBuscaUsuarioActionPerformed(ActionEvent e){
        FrmBuscarFacturaUsuario frm = new FrmBuscarUsuario();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }*/
       public void mniListaUsuarioActionPerformed(ActionEvent e){
        FrmListaUsuario frm = new FrmListaUsuario();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       
       //Empleado
       public void mniNuevoEmpleadoActionPerformed(ActionEvent e){
        FrmNuevoEmpleado frm = new FrmNuevoEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }/*
     public void mniBuscaFacturaVentaActionPerformed(ActionEvent e){
        FrmBuscarFacturaVenta frm = new FrmBuscarFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }*/
       public void mniListaEmpleadoActionPerformed(ActionEvent e){
        FrmListaEmpleado frm = new FrmListaEmpleado();
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
      public void mniBuscaClienteActionPerformed(ActionEvent e) {
        FrmBuscaCliente frm = new FrmBuscaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
      
    //Categoria
      public void   mniNuevoCategoriaActionPerformed(ActionEvent e){
        FrmNuevoCategoria frm = new FrmNuevoCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
        public void mniBuscaCategoriaActionPerformed(ActionEvent e) {
        FrmBuscarCategoria frm = new FrmBuscarCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaCategoriaActionPerformed(ActionEvent e){
        FrmListaCategoria frm = new FrmListaCategoria();
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
       
        //Proveedor
     public void mniNuevoProveedorActionPerformed(ActionEvent e){
        FrmNuevoProveedor frm = new FrmNuevoProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaProveedorActionPerformed(ActionEvent e){
        FrmListaProveedor frm = new FrmListaProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
      public void mniBuscaProveedorActionPerformed(ActionEvent e) {
        FrmBuscarProveedor frm = new FrmBuscarProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
      }
       
      //Kardex
     public void mniNuevoKardexActionPerformed(ActionEvent e){
        FrmNuevoKardex frm = new FrmNuevoKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaKardexActionPerformed(ActionEvent e){
        FrmListaKardex frm = new FrmListaKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
      public void mniBuscaKardexActionPerformed(ActionEvent e) {
        FrmBuscarKardex frm = new FrmBuscarKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
      }
       
   
     public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
     public void  mniLoginActionPerformed(ActionEvent e ){
         Login log= new Login();
         dkpEscritorio.add(log);
         log.setVisible(true);
     }
    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteSkin"); 
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark. SubstanceBubblesWatermark");//Ejemplo de aplicacion de un watermark de Substance
        //SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("e:\\fondo.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.9));//valor aproximado de la opacidad por default de imageWatermark
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }  
}
