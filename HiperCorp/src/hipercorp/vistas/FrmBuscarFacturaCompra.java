
package hipercorp.vistas;

import hipercorp.dao.IFacturaCompra;
import hipercorp.entidades.FacturaCompra;
import hipercorp.impl.FacturaCompraImpl;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class FrmBuscarFacturaCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmBuscarFacturaCompra
     */
    public FrmBuscarFacturaCompra() {
        initComponents();
        this.setClosable(true);
        this.setSize(402,385);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BuscarCodigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(53, 70, 101, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("FacturaCompra:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(116, 168, 112, 17);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/iconBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(167, 111, 130, 41);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(60, 290, 130, 41);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        getContentPane().add(btnModificar);
        btnModificar.setBounds(220, 290, 140, 41);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Código:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(72, 214, 54, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(72, 249, 67, 17);
        getContentPane().add(txtBuscarCodigo);
        txtBuscarCodigo.setBounds(239, 70, 88, 20);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(247, 211, 80, 20);
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(247, 249, 80, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("FACTURA COMPRA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(89, 11, 177, 32);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hipercorp/imagenes/background-159244_960_720.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-4, 0, 390, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiarControles(){
        txtCodigo.setText("");
        txtCantidad.setText("");
               
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        IFacturaCompra facturacompraDao = new FacturaCompraImpl();
        try {
            limpiarControles();
            facturacompra = facturacompraDao.obtener(
                    Integer.parseInt(txtBuscarCodigo.getText()));
            if (facturacompra != null) {
                txtCodigo.setText(Integer.toString(facturacompra.getIdFacturaCompra()));
                txtCantidad.setText(Integer.toString(facturacompra.getCantidad()));
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar al Buscar FacturaCompra!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       IFacturaCompra facturacompraDao = new FacturaCompraImpl();
       int confirmation = JOptionPane.showConfirmDialog(this, 
               "Desea Eliminar la Materia", "Confirme",
               JOptionPane.YES_NO_OPTION);
       if(confirmation == JOptionPane.YES_NO_OPTION)
        try {
            if(facturacompraDao.eliminar(facturacompra)>0){
                JOptionPane.showMessageDialog(this, "FacturaCompra eliminada correctamente!!",
                        "Transaccion Correcta", JOptionPane.INFORMATION_MESSAGE);
                limpiarControles();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar FacturaCompra",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

        FacturaCompra facturacompra;
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
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
