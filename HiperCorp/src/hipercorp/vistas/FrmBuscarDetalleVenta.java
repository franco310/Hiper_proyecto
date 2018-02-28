/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.vistas;

import hipercorp.dao.IDetalleVenta;
import hipercorp.entidades.DetalleVenta;
import hipercorp.impl.DetalleVentaImpl;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmBuscarDetalleVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmBuscarDetalleVenta
     */
    public FrmBuscarDetalleVenta() {
        initComponents();
        this.setClosable(true);
        this.setSize(400,397);
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
        txtPrecioTotal.setText("");        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BuscarCodigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 60, 101, 17);

        txtBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarCodigo);
        txtBuscarCodigo.setBounds(259, 65, 110, 20);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/iconBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(180, 110, 109, 41);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DetallesVenta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 170, 99, 17);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(258, 222, 111, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(66, 222, 60, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PrecioTotal:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(66, 268, 82, 17);
        getContentPane().add(txtPrecioTotal);
        txtPrecioTotal.setBounds(258, 268, 111, 20);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(63, 306, 115, 41);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        getContentPane().add(btnModificar);
        btnModificar.setBounds(248, 306, 121, 41);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("DETALLE VENTA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 0, 145, 31);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/background-159244_960_720.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 440, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCodigoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        IDetalleVenta detalleventaDao = new DetalleVentaImpl();
        try {
            limpiarControles();
            detalleventa = detalleventaDao.obtener(
                    Integer.parseInt(txtBuscarCodigo.getText()));
            if (detalleventa != null) {
                txtCodigo.setText(Integer.toString(detalleventa.getIdDetalleVenta()));
                txtPrecioTotal.setText(Integer.toString(detalleventa.getPreciototal()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar al Buscar la Venta!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         IDetalleVenta detalleventaDao = new DetalleVentaImpl();
        int confirmation = JOptionPane.showConfirmDialog(this, 
               "Desea Eliminar la Materia", "Confirme",
               JOptionPane.YES_NO_OPTION);
       if(confirmation == JOptionPane.YES_NO_OPTION)
        try {
            if(detalleventaDao.eliminar(detalleventa)>0){
                JOptionPane.showMessageDialog(this, "Venta eliminada correctamente!!",
                        "Transaccion Correcta", JOptionPane.INFORMATION_MESSAGE);
                limpiarControles();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar Venta",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

DetalleVenta detalleventa;
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
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
