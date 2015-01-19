/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.gestion.admin.GestionUsuarioDesktop;
import com.disfruta.gestion.logistica.GestionFamiliaProducto;
import com.disfruta.gestion.logistica.GestionProductoCarta;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import resources.auxiliar.PaddingLeft;
import resources.auxiliar.PanelProductoCartaItem;

/**
 *
 * @author Juape
 */
public class PanelTabPedido extends javax.swing.JPanel {

    protected resources.comboboxmodel.CboModelFamiliaProducto cboModelFamilia;
    protected resources.comboboxmodel.CboModelUsuario cboModelUsuario;
    public ArrayList<PanelProductoCartaItem> listaProductosElegidos;
    public ArrayList<PanelProductoCartaItem> listadoProductos;

    /**
     * Creates new form PanelTabPedido
     */
    public PanelTabPedido() {
        init();
        initComponents();
        this.cboBuscarPorCategoria.setModel(cboModelFamilia);
        this.panelContainerProductos.setLayout(new GridLayout(10, 1, 10, 10));//gridLayout es una matriz (filas,columnas,margen de filas,margen de columnas)
        this.panelContainerProductos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));// margenes internos para el panel
        this.txtBuscarPorNombreProducto.setEnabled(false);
        this.cboUsuarioStaff.setModel(cboModelUsuario);
        PaddingLeft.agregarpadding(this.txtBuscarPorNombreProducto);
        PaddingLeft.agregarpadding(this.txtNumeroMesa);
        this.cboBuscarPorCategoria.setBackground(Color.white);
    }

    private void init() {
        try {
            listaProductosElegidos = new ArrayList();
            this.cboModelUsuario=new resources.comboboxmodel.CboModelUsuario(new GestionUsuarioDesktop().listarStaff());
            listadoProductos = new ArrayList();
            this.cboModelFamilia = new resources.comboboxmodel.CboModelFamiliaProducto(new GestionFamiliaProducto().listar());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarUltimaSeleccion() {
        for (int i = 0; i < listadoProductos.size(); i++) {
            PanelProductoCartaItem obj = (PanelProductoCartaItem) listadoProductos.get(i);
            if (obj.productoSelected != null) {
                boolean band = true;
                for (int j = 0; j < listaProductosElegidos.size(); j++) {
                    if (obj.idproducto == listaProductosElegidos.get(j).idproducto) {
                        this.listaProductosElegidos.set(j, obj);
                        band = false;
                        break;
                    }
                }
                if (band) {
                    this.listaProductosElegidos.add(obj);
                }
            }

        }
        this.listadoProductos = new ArrayList();
    }

    public ArrayList<PanelProductoCartaItem> getListaProductosElegidos() {
        return listaProductosElegidos;
    }

    public void setListaProductosElegidos(ArrayList<PanelProductoCartaItem> listaProductosElegidos) {
        this.listaProductosElegidos = listaProductosElegidos;
    }

    public JPanel getPanelContainerProductos() {
        return panelContainerProductos;
    }

    public void setPanelContainerProductos(JPanel panelContainerProductos) {
        this.panelContainerProductos = panelContainerProductos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        cboUsuarioStaff = new javax.swing.JComboBox();
        txtNumeroMesa = new javax.swing.JTextField();
        btnBuscarPorCarta = new javax.swing.JButton();
        btnBuscarPorNombre = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboBuscarPorCategoria = new javax.swing.JComboBox();
        txtBuscarPorNombreProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelContainerProductos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cboStaff.png"))); // NOI18N

        cboUsuarioStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Seleccione Staff -", "Item 2", "Item 3", "Item 4" }));
        cboUsuarioStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsuarioStaffActionPerformed(evt);
            }
        });

        txtNumeroMesa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroMesa.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroMesa.setToolTipText("");
        txtNumeroMesa.setAlignmentX(0.0F);
        txtNumeroMesa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroMesa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroMesa.setName("txtusuario"); // NOI18N
        txtNumeroMesa.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroMesaActionPerformed(evt);
            }
        });
        txtNumeroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroMesaKeyReleased(evt);
            }
        });

        btnBuscarPorCarta.setBackground(new java.awt.Color(253, 148, 2));
        btnBuscarPorCarta.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnBuscarPorCarta.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPorCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_carta.png"))); // NOI18N
        btnBuscarPorCarta.setText("Carta");
        btnBuscarPorCarta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPorCarta.setFocusable(false);
        btnBuscarPorCarta.setRolloverEnabled(false);
        btnBuscarPorCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorCartaActionPerformed(evt);
            }
        });

        btnBuscarPorNombre.setBackground(new java.awt.Color(254, 190, 119));
        btnBuscarPorNombre.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnBuscarPorNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_buscar.png"))); // NOI18N
        btnBuscarPorNombre.setText("Buscar");
        btnBuscarPorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPorNombre.setFocusable(false);
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        cboBuscarPorCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Busqueda por familia de porducto -", "Item 2", "Item 3", "Item 4" }));
        cboBuscarPorCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBuscarPorCategoriaItemStateChanged(evt);
            }
        });
        cboBuscarPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBuscarPorCategoriaActionPerformed(evt);
            }
        });

        txtBuscarPorNombreProducto.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtBuscarPorNombreProducto.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarPorNombreProducto.setText("Buscar por nombre de producto");
        txtBuscarPorNombreProducto.setToolTipText("");
        txtBuscarPorNombreProducto.setAlignmentX(0.0F);
        txtBuscarPorNombreProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtBuscarPorNombreProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscarPorNombreProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtBuscarPorNombreProducto.setName("txtusuario"); // NOI18N
        txtBuscarPorNombreProducto.setOpaque(false);
        txtBuscarPorNombreProducto.setPreferredSize(new java.awt.Dimension(280, 24));
        txtBuscarPorNombreProducto.setSelectionColor(new java.awt.Color(229, 147, 35));
        txtBuscarPorNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPorNombreProductoActionPerformed(evt);
            }
        });
        txtBuscarPorNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorNombreProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboBuscarPorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(txtBuscarPorNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscarPorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarPorNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(179, 179, 179));
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(179, 179, 179));
        jLabel3.setText("Precio unit.");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(179, 179, 179));
        jLabel4.setText("Presentación");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(179, 179, 179));
        jLabel6.setText("SubTotal");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(179, 179, 179));
        jLabel5.setText("Cantidad");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 1, true));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelContainerProductos.setBackground(new java.awt.Color(255, 255, 255));
        panelContainerProductos.setForeground(new java.awt.Color(255, 255, 255));
        panelContainerProductos.setLayout(null);
        jScrollPane1.setViewportView(panelContainerProductos);

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("N° Mesa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(308, 308, 308)
                .addComponent(jLabel3)
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboUsuarioStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscarPorCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboUsuarioStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPorCarta)
                    .addComponent(btnBuscarPorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboUsuarioStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsuarioStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsuarioStaffActionPerformed

    private void txtNumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroMesaActionPerformed

    private void btnBuscarPorCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorCartaActionPerformed
        // TODO add your handling code here:
        this.btnBuscarPorCarta.setBackground(new Color(229, 147, 35));
        this.btnBuscarPorNombre.setBackground(new Color(254, 190, 119));
        this.cboBuscarPorCategoria.setEnabled(true);
        this.txtBuscarPorNombreProducto.setEnabled(false);
    }//GEN-LAST:event_btnBuscarPorCartaActionPerformed

    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        // TODO add your handling code here:
        this.btnBuscarPorNombre.setBackground(new Color(229, 147, 35));
        this.btnBuscarPorCarta.setBackground(new Color(254, 190, 119));
        this.txtBuscarPorNombreProducto.setEnabled(true);
        this.cboBuscarPorCategoria.setEnabled(false);

        //cpodigo de ejemplo

        //        JPanel panel=new JPanel();
        //        panel.setLayout(null);
        //        panel.setPreferredSize(new Dimension(820,45));
        //        panel.setBackground(new Color(242,242,242));
        //        panel.setBorder(new LineBorder(new Color(255,255,255),2,true));
        //
        //        JLabel nombre=new JLabel("nuevo rpdocuto");
        //        nombre.setFont(new Font("Arial",Font.BOLD, 12));
        //        nombre.setBounds(10,10,350, 25);
        //        panel.add(nombre);
        //        JLabel precio=new JLabel("S/ 1452.56");
        //        precio.setForeground(new Color(149,149,149));
        //        precio.setFont(new Font("Arial",Font.BOLD, 12));
        //        precio.setBounds(390,10,80, 25);
        //        panel.add(precio);
        //        JComboBox combo=new JComboBox();
        //        combo.setRenderer(new ListCellRenderer() {
        //    @Override
        //    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //        final JLabel renderer = new JLabel(value.toString());
        //        if (isSelected) {
        //            renderer.setOpaque(true);
        //            renderer.setForeground(Color.white);
        //            renderer.setBackground(new Color(229,147,35));
        //            renderer.setFont(new Font("Arial",Font.BOLD, 12));
        //        }
        //        return renderer;
        //    }
        //});
        //        combo.addItem("uno");
        //        combo.addItem("dos");
        //        combo.setBounds(480, 10,150,25);
        //        combo.setBackground(new Color(255,255,255));
        //        combo.setBorder(new LineBorder(new Color(230,230,230),1,true));
        //        combo.setForeground(new Color(149,149,149));
        //        combo.setFont(new Font("Arial",Font.BOLD, 12));
        //        combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //        combo.setFocusable(false);
        //
        //        panel.add(combo);
        //        JTextField cantidad=new JTextField();
        //        cantidad.setBounds(640, 10,80,25);
        //        cantidad.setBorder(new LineBorder(new Color(230,230,230),1,true));
        //        cantidad.setForeground(new Color(149,149,149));
        //        cantidad.setFont(new Font("Arial",Font.BOLD, 12));
        //        cantidad.setHorizontalAlignment(JTextField.CENTER);
        //        panel.add(cantidad);
        //        JButton add=new JButton("+");
        //        add.setBounds(730, 10,45,25);
        //        add.setBackground(new Color(229,147,35));
        //        add.setForeground(new Color(255,255,255));
        //        add.setFont(new Font("Arial",Font.BOLD, 12));
        //        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //        add.addActionListener(new ActionListener(){
        //            @Override
        //            public void actionPerformed(ActionEvent e) {
        //
        //            }
        //        });
        //        panel.add(add);
        //        JLabel pr=new JLabel("S/ 2452.56");
        //        pr.setForeground(new Color(149,149,149));
        //        pr.setFont(new Font("Arial",Font.BOLD, 12));
        //        pr.setBounds(790,10, 80,25);
        //        panel.add(pr);
        //        this.panelContainerProductos.setLayout(new GridLayout(0,1));

    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

    private void cboBuscarPorCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBuscarPorCategoriaItemStateChanged
        try {
            // TODO add your handling code here:  

            if (listadoProductos.size() > 0) {
                llenarUltimaSeleccion();
            }
            this.panelContainerProductos.removeAll();
            
            int fila = this.cboBuscarPorCategoria.getSelectedIndex();
            FamiliaProducto familia = this.cboModelFamilia.getElement(fila);
            int rows = 10;
            ArrayList<ProductoCarta> lista = new GestionProductoCarta().listarPorFamilia(familia);
            if (lista.size() > 10) {
                rows = lista.size();
            }
            this.panelContainerProductos.setLayout(new GridLayout(rows, 1, 10, 10));
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("listado productos: " + listadoProductos.size());
                boolean band = false;
                PanelProductoCartaItem panelProducto = null;
                for (int j = 0; j < listaProductosElegidos.size(); j++) {
                    if (lista.get(i).getIdproductocarta() == listaProductosElegidos.get(j).idproducto) {
                        band = true;
                        panelProducto = listaProductosElegidos.get(j);
                        break;
                    }
                }
                if (band == false) {
                    panelProducto = new PanelProductoCartaItem(lista.get(i));
                }
                this.listadoProductos.add(panelProducto);
                this.panelContainerProductos.add(panelProducto);
            }
            this.panelContainerProductos.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboBuscarPorCategoriaItemStateChanged

    private void cboBuscarPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBuscarPorCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBuscarPorCategoriaActionPerformed

    private void txtBuscarPorNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPorNombreProductoActionPerformed

    private void txtBuscarPorNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreProductoKeyReleased
        try {
            // TODO add your handling code here:
            this.panelContainerProductos.removeAll();
            
            String cad = this.txtBuscarPorNombreProducto.getText();
            if (cad.length() > 1) {
                System.out.println("busco por: " + cad);
                int rows = 10;
                ArrayList<ProductoCarta> lista = new GestionProductoCarta().listarPorBusqueda(cad);
                System.out.println("size: " + lista.size());
                if (lista.size() > 10) {
                    rows = lista.size();
                }
                this.panelContainerProductos.setLayout(new GridLayout(rows, 1, 10, 10));
                for (int i = 0; i < lista.size(); i++) {
                    boolean band = false;
                    PanelProductoCartaItem panelProducto = null;
                    for (int j = 0; j < listaProductosElegidos.size(); j++) {
                        if (lista.get(i).getIdproductocarta() == listaProductosElegidos.get(j).idproducto) {
                            band = true;
                            panelProducto = listaProductosElegidos.get(j);
                            break;
                        }
                    }
                    if (band == false) {
                        panelProducto = new PanelProductoCartaItem(lista.get(i));
                    }
                    this.panelContainerProductos.add(panelProducto);
                }
            }
            this.panelContainerProductos.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtBuscarPorNombreProductoKeyReleased

    private void txtNumeroMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroMesaKeyReleased
        // TODO add your handling code here:
        JTabbedPane tabbed= (JTabbedPane)this.txtNumeroMesa.getParent().getParent();
        PanelStaff panel= (PanelStaff)this.txtNumeroMesa.getParent().getParent().getParent();
        int select=tabbed.getSelectedIndex();
        String numero=this.txtNumeroMesa.getText();
        tabbed.setTitleAt(select, numero+" ");
        panel.lblnumeromesa.setText(numero);
    }//GEN-LAST:event_txtNumeroMesaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPorCarta;
    private javax.swing.JButton btnBuscarPorNombre;
    protected javax.swing.JComboBox cboBuscarPorCategoria;
    protected javax.swing.JComboBox cboUsuarioStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContainerProductos;
    private javax.swing.JTextField txtBuscarPorNombreProducto;
    protected javax.swing.JTextField txtNumeroMesa;
    // End of variables declaration//GEN-END:variables
}