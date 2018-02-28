/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IProveedor;
import hipercorp.entidades.Proveedor;
import hipercorp.impl.ProveedorImpl;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
public class FrmBuscarProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmBuscarDetalleCompra
     */
    public FrmBuscarProveedor() {
        initComponents();
         this.setClosable(true);
         this.setSize(580,320);
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

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar Codigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(77, 65, 105, 17);
        getContentPane().add(txtBuscarCodigo);
        txtBuscarCodigo.setBounds(259, 65, 89, 20);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/iconBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(160, 112, 109, 41);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Datos Proveedor");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(143, 159, 116, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(77, 194, 54, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(77, 232, 61, 17);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(257, 194, 111, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(257, 232, 111, 20);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(77, 283, 115, 41);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        getContentPane().add(btnModificar);
        btnModificar.setBounds(247, 283, 121, 41);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PROVEEDOR");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(185, 11, 183, 28);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/background-159244_960_720.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 390, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarControles(){
        txtCodigo.setText("");
        txtNombre.setText("");
  
    
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 IProveedor proveedorDao = new ProveedorImpl();
        try {
            limpiarControles();
            proveedor = proveedorDao.obtener(
                    Integer.parseInt(txtBuscarCodigo.getText()));
            if (proveedor != null) {
                txtCodigo.setText(Integer.toString(proveedor.getIdProveedor()));
                txtNombre.setText(proveedor.getNombre());
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar Proveedor!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }      
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed


        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        IProveedor ProveedorDao = new ProveedorImpl();
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Realmente quiere eliminar al proveedor?", "Confirme",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                if (ProveedorDao.eliminar(proveedor) > 0) {
                    JOptionPane.showMessageDialog(this, 
                            "Proveedor eliminado correctamente!!",
                            "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
                    limpiarControles();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el cliente!!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    
    }//GEN-LAST:event_btnEliminarActionPerformed

Proveedor proveedor;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
