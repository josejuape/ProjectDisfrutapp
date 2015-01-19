/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.PresentacionInsumo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import resources.auxiliar.PaddingLeft;
import resources.auxiliar.Validate;
import resources.comboboxmodel.CboModelPresentacionCompra;

/**
 *
 * @author user
 */
public class DialogPresComercialInsumo extends javax.swing.JDialog {

    public CboModelPresentacionCompra cboModelPresentacion;
    public resources.tablemodel.ModelTablePresentacionCompra modelTablePresentacion;
    public ArrayList<PresentacionInsumo> listpresentacion;
    public int control = 0;// control cero signififca que no se ha guardado la edicion del JDialog
    public int saveorupdate = 0;
    public int objupdate = -1;

    /**
     * Creates new form DialogPresComercialInsumo
     */
    public DialogPresComercialInsumo(java.awt.Frame parent, boolean modal, ArrayList lista) {
        super(parent, modal);
        init();
        initComponents();
        this.setLocationRelativeTo(null);
        this.listpresentacion = lista;
        this.cboModelPresentacion = new resources.comboboxmodel.CboModelPresentacionCompra(this.listpresentacion);
        this.modelTablePresentacion = new resources.tablemodel.ModelTablePresentacionCompra(this.listpresentacion);
        this.cbounidad.setModel(cboModelPresentacion);
        this.tblpresentacion.setModel(modelTablePresentacion);
        this.btneliminar.setEnabled(false);
        PaddingLeft.agregarpadding(this.txtcantidad);
        PaddingLeft.agregarpadding(this.txtnombrepresentacion);
    }

    public void init() {
        this.listpresentacion = new <PresentacionInsumo>ArrayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpresentacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtnombrepresentacion = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        cbounidad = new javax.swing.JComboBox();
        btnagregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnNuevoPres = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblpresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblpresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpresentacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpresentacion);
        tblpresentacion.getColumnModel().getColumn(0).setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Presentación comercial de compra");

        txtnombrepresentacion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtnombrepresentacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtnombrepresentacion.setPreferredSize(new java.awt.Dimension(2, 24));

        txtcantidad.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtcantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtcantidad.setMinimumSize(new java.awt.Dimension(2, 24));
        txtcantidad.setPreferredSize(new java.awt.Dimension(2, 24));

        cbounidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbounidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnagregar.setText("Agregar");
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Presentación Comercial:");

        jLabel2.setText("Cantidad:");

        jLabel4.setText("Unidad:");

        btnCancelar.setBackground(new java.awt.Color(252, 242, 228));
        btnCancelar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(83, 71, 65));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setOpaque(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(92, 30));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(229, 147, 35));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardar.setBorderPainted(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setOpaque(false);
        btnGuardar.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btneliminar.setText("Quitar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnNuevoPres.setText("Nuevo");
        btnNuevoPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnNuevoPres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnombrepresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(cbounidad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombrepresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbounidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btneliminar)
                    .addComponent(btnNuevoPres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblpresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpresentacionMouseClicked
        // TODO add your handling code here:
        int pos = this.tblpresentacion.getSelectedRow();
        if (pos >= 0) {
            PresentacionInsumo obj = this.modelTablePresentacion.getValue(pos);
            this.txtnombrepresentacion.setText(obj.getNombre_presentacion());
            this.txtcantidad.setText(obj.getCantidad() + "");
            this.cbounidad.setSelectedItem(obj.getUnidad());
            this.btneliminar.setEnabled(true);
            this.btnagregar.setText("Modificar");
            this.saveorupdate = 1;
            this.objupdate = pos;
        }
    }//GEN-LAST:event_tblpresentacionMouseClicked

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtnombrepresentacion.getText();
        String cantidad = this.txtcantidad.getText();
        int un = this.cbounidad.getSelectedIndex();
        if (!(nombre.equals("")) && !(cantidad.equals("")) && un >= 0) {
            if(Validate.isNumero(cantidad)){
            PresentacionInsumo objpre = new PresentacionInsumo();
            objpre.setNombre_presentacion(nombre);
            objpre.setCantidad(Integer.parseInt(cantidad));
            String unidad = this.cbounidad.getSelectedItem().toString();
            objpre.setUnidad(unidad);
            if (this.saveorupdate == 0) {
                this.listpresentacion.add(objpre);
            } else if (this.saveorupdate == 1) {
                String unidadup = this.tblpresentacion.getValueAt(this.objupdate, 0).toString();
                for (int i = objupdate; i < this.listpresentacion.size(); i++) {
                    PresentacionInsumo objup = this.listpresentacion.get(i);
                    if (unidadup.equalsIgnoreCase(objup.getUnidad())) {
                        objup.setUnidad(objpre.getNombre_presentacion());
                        this.listpresentacion.set(i, objup);
                    }
                }
                if (objupdate == 0) {
                    objpre.setUnidad("Unidad");
                }
                this.listpresentacion.set(this.objupdate, objpre);
                this.btneliminar.setEnabled(false);
                this.btnagregar.setText("Agregar");
                this.saveorupdate = 0;
                this.txtcantidad.setText("");
                this.txtnombrepresentacion.setText("");
            }
            this.modelTablePresentacion.setData(listpresentacion);
            this.modelTablePresentacion.fireTableDataChanged();
            this.cbounidad.setModel(new resources.comboboxmodel.CboModelPresentacionCompra(this.listpresentacion));
            this.txtnombrepresentacion.setText("");
            this.txtcantidad.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Cantidad debe ser un número !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos !");
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.control = 0;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.control = 1;
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPresActionPerformed
        // TODO add your handling code here:
        this.txtcantidad.setText("");
        this.txtnombrepresentacion.setText("");
        this.btnagregar.setEnabled(true);
        this.btnagregar.setText("Agregar");
        this.btneliminar.setEnabled(false);
        this.cbounidad.setSelectedItem("");
        this.saveorupdate = 0;
    }//GEN-LAST:event_btnNuevoPresActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int r=this.tblpresentacion.getSelectedRow();
        if(r>=1){
            this.listpresentacion.remove(r);
            this.modelTablePresentacion.setData(listpresentacion);
            this.modelTablePresentacion.fireTableDataChanged();
        }
        
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogPresComercialInsumo dialog = new DialogPresComercialInsumo(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoPres;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox cbounidad;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblpresentacion;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnombrepresentacion;
    // End of variables declaration//GEN-END:variables
}