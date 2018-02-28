/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IProducto;
import hipercorp.entidades.Producto;
import hipercorp.impl.ProductoImpl;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmBuscarProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmBuscarProducto
     */
    public FrmBuscarProducto() {
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
     private void limpiarControles(){
        txtCodigo.setText("");
        txtNombre.setText("");
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BuscarCódigo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(72, 51, 96, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DatosProducto:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(132, 162, 109, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Código:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(96, 197, 54, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(96, 235, 61, 17);

        txtBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarCodigo);
        txtBuscarCodigo.setBounds(240, 51, 97, 20);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/iconBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(162, 103, 101, 41);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(243, 197, 94, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(243, 235, 94, 20);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(52, 285, 105, 41);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        getContentPane().add(btnModificar);
        btnModificar.setBounds(250, 285, 111, 41);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PRODUCTO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 11, 113, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/background-159244_960_720.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 400, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IProducto productoDao = new ProductoImpl();
        try {
            limpiarControles();
            producto = productoDao.obtener(
                    Integer.parseInt(txtBuscarCodigo.getText()));
            if (producto != null) {
                txtCodigo.setText(Integer.toString(producto.getIdProducto()));
                txtNombre.setText(producto.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar al Buscar Producto!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         IProducto productoDao = new ProductoImpl();
        int confirmation = JOptionPane.showConfirmDialog(this, 
               "Desea Eliminar la Materia", "Confirme",
               JOptionPane.YES_NO_OPTION);
       if(confirmation == JOptionPane.YES_NO_OPTION)
        try {
            if(productoDao.eliminar(producto)>0){
                JOptionPane.showMessageDialog(this, "Producto eliminada correctamente!!",
                        "Transaccion Correcta", JOptionPane.INFORMATION_MESSAGE);
                limpiarControles();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar Producto",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

Producto producto;
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
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
