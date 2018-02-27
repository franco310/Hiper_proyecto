
package hipercorp.vistas;

import hipercorp.dao.ICategoria;
import hipercorp.entidades.Categoria;
import hipercorp.impl.CategoriaImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrmNuevoCategoria extends JInternalFrame{
    
    JLabel lblTitulo;
    JLabel lblidCategoria;
    JLabel lblNombre;
    JLabel lblDescripcion;
   
    JTextField txtidCategoria;
    JTextField txtNombre;
    JTextField txtDescripcion;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
    
  public FrmNuevoCategoria() {
  this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Categoria");
        
        lblidCategoria = new JLabel("IdCategoria:");
        lblNombre = new JLabel("Nombre:");
        lblDescripcion = new JLabel("Descripcion:");
        

        txtidCategoria= new JTextField(2);
        txtNombre = new JTextField(2); 
        txtDescripcion = new JTextField(2); 
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidCategoria);
        pnlCentral.add(txtidCategoria);;
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);
        
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
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoCategoria frmMenu= new FrmNuevoCategoria();
        frmMenu.setVisible(true);
    } 
  
    public void btnAceptarActionListener(ActionEvent e){
        ICategoria categoriaDao = new CategoriaImpl();
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(Integer.parseInt(txtidCategoria.getText()));
        categoria.setNombre(txtNombre.getText());
        categoria.setDescripcion(txtDescripcion.getText());
       
        
        try {
            if(categoriaDao.insertar(categoria)>0){
                JOptionPane.showMessageDialog(this,"Guardado correctamente ",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar : " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}

    

