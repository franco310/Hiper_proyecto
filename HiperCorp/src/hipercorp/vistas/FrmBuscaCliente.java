/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.ICliente;
import hipercorp.entidades.Cliente;
import hipercorp.impl.ClienteImpl;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class FrmBuscaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public FrmBuscaCliente() {
        initComponents();
       // this.setClosable(true);
        this.setSize(560,520);
        this.setLayout(new BorderLayout());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblidCliente = new javax.swing.JLabel();
        lblcedula = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        txtidCliente = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        lblbuscar = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().setLayout(null);

        lblidCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblidCliente.setText("Id Cliente");
        getContentPane().add(lblidCliente);
        lblidCliente.setBounds(27, 155, 73, 17);

        lblcedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcedula.setText("Cedula");
        getContentPane().add(lblcedula);
        lblcedula.setBounds(30, 220, 53, 17);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnombre.setText("Nombre");
        getContentPane().add(lblnombre);
        lblnombre.setBounds(27, 255, 70, 17);

        lblapellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblapellido.setText("Apellido");
        getContentPane().add(lblapellido);
        lblapellido.setBounds(27, 301, 70, 17);

        lbldireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldireccion.setText("Direccion");
        getContentPane().add(lbldireccion);
        lbldireccion.setBounds(27, 351, 70, 17);

        lblemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail.setText("Email");
        getContentPane().add(lblemail);
        lblemail.setBounds(27, 400, 50, 17);

        lbltelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltelefono.setText("Teléfono");
        getContentPane().add(lbltelefono);
        lbltelefono.setBounds(27, 451, 80, 17);

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfecha.setText("Fecha de nacimiento");
        getContentPane().add(lblfecha);
        lblfecha.setBounds(27, 503, 140, 17);
        getContentPane().add(txtidCliente);
        txtidCliente.setBounds(184, 163, 172, 20);
        getContentPane().add(txtcedula);
        txtcedula.setBounds(184, 214, 172, 20);
        getContentPane().add(txtnombre);
        txtnombre.setBounds(184, 252, 172, 20);
        getContentPane().add(txtapellido);
        txtapellido.setBounds(184, 301, 172, 20);
        getContentPane().add(txtdireccion);
        txtdireccion.setBounds(184, 351, 172, 20);
        getContentPane().add(txtemail);
        txtemail.setBounds(184, 400, 172, 20);
        getContentPane().add(txttelefono);
        txttelefono.setBounds(184, 451, 172, 20);

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtfecha);
        txtfecha.setBounds(184, 503, 172, 20);

        lblbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblbuscar.setForeground(new java.awt.Color(51, 51, 51));
        lblbuscar.setText("Codigo a Buscar");
        getContentPane().add(lblbuscar);
        lblbuscar.setBounds(27, 74, 120, 17);
        getContentPane().add(txtBuscarCodigo);
        txtBuscarCodigo.setBounds(184, 74, 172, 20);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/iconBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(443, 56, 111, 57);

        btnElimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/delete.png"))); // NOI18N
        btnElimina.setText("Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });
        getContentPane().add(btnElimina);
        btnElimina.setBounds(443, 144, 111, 59);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("                     CLIENTES");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 46);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(443, 233, 111, 59);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/background-159244_960_720.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 640, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

      private void limpiarControles(){
        txtidCliente.setText("");
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtfecha.setText("");
      
      }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
         ICliente clienteDao = new ClienteImpl();
        try {
            limpiarControles();
            cliente = clienteDao.obtener(
                    Integer.parseInt(txtBuscarCodigo.getText()));
            if (cliente != null) {
                txtidCliente.setText(Integer.toString(cliente.getIdCliente()));
                txtcedula.setText(cliente.getCedula());
                txtnombre.setText(cliente.getNombre());
                txtapellido.setText(cliente.getApellido());
                txtdireccion.setText(cliente.getDireccion());
                txttelefono.setText(cliente.getTelefono());
                txtemail.setText(cliente.getEmail());
                txtfecha.setText(String.valueOf(cliente.getFecha_nac()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el curso!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
   
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        // TODO add your handling code here:
        
        ICliente clienteDao = new ClienteImpl();
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Realmente quiere eliminar al cliente?", "Confirme",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                if (clienteDao.eliminar(cliente) > 0) {
                    JOptionPane.showMessageDialog(this, 
                            "Cliente eliminado correctamente!!",
                            "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
                    limpiarControles();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el cliente!!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    ICliente clienteDao = new ClienteImpl();
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Realmente quiere modificar el registro de un cliente?", "Confirme",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
        try {      
            cliente.setIdCliente(Integer.parseInt(txtidCliente.getText()));
            cliente.setCedula(txtcedula.getText()); 
            cliente.setNombre(txtnombre.getText()); 
            cliente.setApellido(txtapellido.getText());   
            cliente.setDireccion(txtdireccion.getText()); 
            cliente.setTelefono(txttelefono.getText()); 
            cliente.setEmail(txtemail.getText());    
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                cliente.setFecha_nac(formatoFecha.parse(txtfecha.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            };
            if(clienteDao.modificar(cliente)>0 ){
                JOptionPane.showMessageDialog(this,"Modificado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }             
        }

    }//GEN-LAST:event_btnModificarActionPerformed

Cliente cliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblidCliente;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
