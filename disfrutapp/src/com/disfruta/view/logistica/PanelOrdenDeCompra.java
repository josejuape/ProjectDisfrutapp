/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.OrdenCompraInsumo;
import com.disfruta.gestion.logistica.GestionAlmacen;
import com.disfruta.gestion.logistica.GestionFormaPago;
import com.disfruta.gestion.logistica.GestionInsumo;
import com.disfruta.gestion.logistica.GestionOrdenCompra;
import com.disfruta.gestion.logistica.GestionOrdenCompraInsumo;
import com.disfruta.gestion.logistica.GestionPresentacionInsumo;
import com.disfruta.gestion.logistica.GestionProveedor;
import com.disfruta.gestion.logistica.GestionUnidadMedida;
import com.disfruta.gestion.xtbc.GestionMoneda;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class PanelOrdenDeCompra extends javax.swing.JPanel {

    private resources.comboboxmodel.CboModelProveedor modelCboProveedor;
    private resources.comboboxmodel.CboModelFormaPago modelCboFormaPago;
    private resources.comboboxmodel.CboModelMoneda modelCboMoneda;
    private resources.comboboxmodel.CboModelUnidadMedida modelCboUnidad;
    private resources.comboboxmodel.CboModelAlmacen modelCboAlmacen;
    private resources.tablemodel.ModelTableOrdenCompra tblModelOrdenCompra;
    protected resources.comboboxmodel.CboModelPresentacionCompra cboModelPresentacionInsumo;
    protected resources.tablemodel.ModelTableOrdenCompraInsumo tableModelDetalle;
    protected ArrayList listaAutoCompletar;
    protected ArrayList listaInsumos;
    protected Insumo insumoselected = null;
    protected TextAutoCompleter autoCompleteInsumo;
    protected ArrayList<OrdenCompraInsumo> listaDetalle;
    protected int controlTab = 0;

    /**
     * Creates new form PanelOrdenDeCompra
     */
    public PanelOrdenDeCompra() {
        init();
        initComponents();
        this.cboProveedor.setModel(modelCboProveedor);
        this.cboMoneda.setModel(modelCboMoneda);
        this.cboFormaPago.setModel(modelCboFormaPago);
        this.cboAlmacen.setModel(modelCboAlmacen);
        this.cboUnidad.setModel(modelCboUnidad);
        this.cboMonedaInsumo.setModel(modelCboMoneda);
        this.tblOrdenCompra.setModel(tblModelOrdenCompra);
        autoCompleteInsumo = new TextAutoCompleter(this.txtNombreInsumo, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                String cad = selectedItem.toString();
                for (int i = 0; i < listaInsumos.size(); i++) {
                    if (cad.equals(((Insumo) listaInsumos.get(i)).getNombre())) {
                        try {
                            insumoselected = (Insumo) listaInsumos.get(i);
                            txtCodigoInsumo.setText(insumoselected.getIdinsumo() + "");
                            cboModelPresentacionInsumo = new resources.comboboxmodel.CboModelPresentacionCompra(new GestionPresentacionInsumo().listarPorInsumo(insumoselected));
                            cboPresentacionInsumo.setModel(cboModelPresentacionInsumo);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        autoCompleteInsumo.addItems(this.listaInsumos);
        setPaddingLeft();
    }

    private void init() {
        try {
            this.modelCboAlmacen = new resources.comboboxmodel.CboModelAlmacen(new GestionAlmacen().listar());
            this.modelCboProveedor = new resources.comboboxmodel.CboModelProveedor(new GestionProveedor().listar());
            this.modelCboFormaPago = new resources.comboboxmodel.CboModelFormaPago(new GestionFormaPago().listar());
            this.modelCboUnidad = new resources.comboboxmodel.CboModelUnidadMedida(new GestionUnidadMedida().listar());
            this.modelCboMoneda = new resources.comboboxmodel.CboModelMoneda(new GestionMoneda().listar());
            this.tblModelOrdenCompra = new resources.tablemodel.ModelTableOrdenCompra(new GestionOrdenCompra().listar());
            this.listaInsumos = new ArrayList();
            this.listaInsumos = new GestionInsumo().listar();
            this.listaDetalle = new ArrayList();
            this.tableModelDetalle = new resources.tablemodel.ModelTableOrdenCompraInsumo(this.listaDetalle);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setPaddingLeft() {
        PaddingLeft.agregarpadding(txtCodigoInsumo);
        PaddingLeft.agregarpadding(txtNombreInsumo);
        PaddingLeft.agregarpadding(txtCantidadInsumo);
        PaddingLeft.agregarpadding(txtPrecioInsumo);
        PaddingLeft.agregarpadding(txtLugarRecepcion);
    }

    public void activarCajaBuscar(JTextField campo) {
        campo.setSize(130, 22);
        campo.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.decode("#999999"));
        campo.setBorder(border);
        campo.setText("  ");
        campo.requestFocus(true);
    }

    public void desactivarCajaBuscar(JTextField campo, String name) {
        campo.setBackground(null);
        campo.setBorder(null);
        campo.setText("  " + name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneltitlealmacen = new javax.swing.JPanel();
        logoalmacen = new javax.swing.JLabel();
        btnNuevoOrden = new javax.swing.JButton();
        btnGuardarOrden = new javax.swing.JButton();
        btnEliminarOrden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblFechaActual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboProveedor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboMoneda = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboFormaPago = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboAlmacen = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLugarRecepcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarioReferencia = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        txtFechaRecepcion = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCodigoInsumo = new javax.swing.JTextField();
        txtNombreInsumo = new javax.swing.JTextField();
        txtCantidadInsumo = new javax.swing.JTextField();
        txtPrecioInsumo = new javax.swing.JTextField();
        cboPresentacionInsumo = new javax.swing.JComboBox();
        cboUnidad = new javax.swing.JComboBox();
        cboMonedaInsumo = new javax.swing.JComboBox();
        btnAddInsumo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDetalleInsumos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        txtBuscarProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        txtBuscarReferencia = new javax.swing.JTextField();
        btnBuscarReferencia = new javax.swing.JButton();
        txtBuscarFechaEmision = new javax.swing.JTextField();
        btnBuscarFechaEmision = new javax.swing.JButton();
        txtBuscarFechaRecepcion = new javax.swing.JTextField();
        btnBuscarFechaRecepcion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrdenCompra = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(960, 590));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(960, 590));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        btnNuevoOrden.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoOrden.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoOrden.setForeground(new java.awt.Color(229, 147, 35));
        btnNuevoOrden.setText("Nuevo");
        btnNuevoOrden.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoOrden.setBorderPainted(false);
        btnNuevoOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoOrden.setFocusPainted(false);
        btnNuevoOrden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoOrden.setOpaque(false);
        btnNuevoOrden.setPreferredSize(new java.awt.Dimension(92, 30));

        btnGuardarOrden.setBackground(new java.awt.Color(252, 242, 228));
        btnGuardarOrden.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardarOrden.setForeground(new java.awt.Color(83, 71, 65));
        btnGuardarOrden.setText("Guardar");
        btnGuardarOrden.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardarOrden.setBorderPainted(false);
        btnGuardarOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarOrden.setFocusPainted(false);
        btnGuardarOrden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarOrden.setOpaque(false);
        btnGuardarOrden.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOrdenActionPerformed(evt);
            }
        });

        btnEliminarOrden.setBackground(new java.awt.Color(229, 147, 35));
        btnEliminarOrden.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnEliminarOrden.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarOrden.setText("Eliminar");
        btnEliminarOrden.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnEliminarOrden.setBorderPainted(false);
        btnEliminarOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarOrden.setFocusPainted(false);
        btnEliminarOrden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarOrden.setOpaque(false);
        btnEliminarOrden.setPreferredSize(new java.awt.Dimension(92, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Orden de compra: ");

        jLabel9.setText("7008-1245");

        javax.swing.GroupLayout paneltitlealmacenLayout = new javax.swing.GroupLayout(paneltitlealmacen);
        paneltitlealmacen.setLayout(paneltitlealmacenLayout);
        paneltitlealmacenLayout.setHorizontalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltitlealmacenLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logoalmacen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(102, 102, 102)
                .addComponent(btnNuevoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneltitlealmacenLayout.setVerticalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltitlealmacenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoalmacen))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltitlealmacenLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(960, 300));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(960, 300));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblFechaActual.setText("03 de julio de 2014");

        jLabel3.setText("Proveedor:");

        cboProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Comentario de referencia:");

        jLabel5.setText("Moneda:");

        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Forma de pago:");

        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFormaPagoActionPerformed(evt);
            }
        });

        jLabel7.setText("Almacen de recepción:");

        cboAlmacen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboAlmacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAlmacenItemStateChanged(evt);
            }
        });

        jLabel8.setText("Fecha de recepción:");

        jLabel10.setText("Lugar de recepción:");

        txtLugarRecepcion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtLugarRecepcion.setForeground(new java.awt.Color(153, 153, 153));
        txtLugarRecepcion.setText("   Dirección del almacen");
        txtLugarRecepcion.setToolTipText("");
        txtLugarRecepcion.setAlignmentX(0.0F);
        txtLugarRecepcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtLugarRecepcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLugarRecepcion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtLugarRecepcion.setName("txtusuario"); // NOI18N
        txtLugarRecepcion.setPreferredSize(new java.awt.Dimension(280, 24));
        txtLugarRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugarRecepcionActionPerformed(evt);
            }
        });

        jLabel11.setText("Observaciones:");

        txtComentarioReferencia.setColumns(20);
        txtComentarioReferencia.setForeground(new java.awt.Color(153, 153, 153));
        txtComentarioReferencia.setLineWrap(true);
        txtComentarioReferencia.setRows(5);
        txtComentarioReferencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jScrollPane1.setViewportView(txtComentarioReferencia);

        txtObservaciones.setColumns(20);
        txtObservaciones.setForeground(new java.awt.Color(153, 153, 153));
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setRows(5);
        txtObservaciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jScrollPane2.setViewportView(txtObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblFechaActual)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(cboAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cboFormaPago, 0, 158, Short.MAX_VALUE)))
                    .addComponent(txtFechaRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(txtLugarRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaActual)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLugarRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orden de compra", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Código:");

        jLabel13.setText("Nombre de producto:");

        jLabel14.setText("Presentación comercial:");

        jLabel15.setText("Cantidad:");

        jLabel16.setText("Unidad:");

        jLabel17.setText("Precio de compra:");

        jLabel18.setText("Moneda");

        txtCodigoInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCodigoInsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigoInsumo.setToolTipText("");
        txtCodigoInsumo.setAlignmentX(0.0F);
        txtCodigoInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCodigoInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoInsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCodigoInsumo.setName("txtusuario"); // NOI18N
        txtCodigoInsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCodigoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoInsumoActionPerformed(evt);
            }
        });

        txtNombreInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombreInsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreInsumo.setToolTipText("");
        txtNombreInsumo.setAlignmentX(0.0F);
        txtNombreInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombreInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreInsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombreInsumo.setName("txtusuario"); // NOI18N
        txtNombreInsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombreInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreInsumoActionPerformed(evt);
            }
        });

        txtCantidadInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCantidadInsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidadInsumo.setToolTipText("");
        txtCantidadInsumo.setAlignmentX(0.0F);
        txtCantidadInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCantidadInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidadInsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCantidadInsumo.setName("txtusuario"); // NOI18N
        txtCantidadInsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCantidadInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadInsumoActionPerformed(evt);
            }
        });

        txtPrecioInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPrecioInsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioInsumo.setToolTipText("");
        txtPrecioInsumo.setAlignmentX(0.0F);
        txtPrecioInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPrecioInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioInsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPrecioInsumo.setName("txtusuario"); // NOI18N
        txtPrecioInsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPrecioInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioInsumoActionPerformed(evt);
            }
        });

        cboUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMonedaInsumo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddInsumo.setText("Add");
        btnAddInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumoActionPerformed(evt);
            }
        });

        jScrollPane4.setOpaque(false);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(450, 220));

        tblDetalleInsumos.setForeground(new java.awt.Color(128, 128, 128));
        tblDetalleInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Contenido", "Presentación comercial", "Cantidad", "Precio", "Moneda", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleInsumos.setToolTipText("");
        tblDetalleInsumos.setAlignmentX(0.0F);
        tblDetalleInsumos.setAlignmentY(0.0F);
        tblDetalleInsumos.setAutoscrolls(false);
        tblDetalleInsumos.setColumnSelectionAllowed(true);
        tblDetalleInsumos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDetalleInsumos.setGridColor(new java.awt.Color(204, 204, 255));
        tblDetalleInsumos.setMinimumSize(new java.awt.Dimension(900, 150));
        tblDetalleInsumos.setRowHeight(30);
        tblDetalleInsumos.setRowMargin(3);
        tblDetalleInsumos.setShowHorizontalLines(false);
        tblDetalleInsumos.setShowVerticalLines(false);
        tblDetalleInsumos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblDetalleInsumos);
        tblDetalleInsumos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleInsumos.getColumnModel().getColumn(0).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(1).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(2).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(3).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(4).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(5).setResizable(false);
        tblDetalleInsumos.getColumnModel().getColumn(6).setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtCodigoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cboPresentacionInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtPrecioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboMonedaInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddInsumo)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPresentacionInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMonedaInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInsumo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(250, 233, 211));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));

        txtBuscarCodigo.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarCodigo.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarCodigo.setText("Codigo");
        txtBuscarCodigo.setToolTipText("");
        txtBuscarCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarCodigo.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarCodigo.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCodigoActionPerformed(evt);
            }
        });
        txtBuscarCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCodigoFocusLost(evt);
            }
        });

        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarCodigo.setToolTipText("");
        btnBuscarCodigo.setBorderPainted(false);
        btnBuscarCodigo.setContentAreaFilled(false);
        btnBuscarCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCodigo.setPreferredSize(new java.awt.Dimension(18, 18));
        btnBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoActionPerformed(evt);
            }
        });

        txtBuscarProveedor.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarProveedor.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarProveedor.setText("Proveedor");
        txtBuscarProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarProveedor.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarProveedor.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProveedorActionPerformed(evt);
            }
        });
        txtBuscarProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarProveedorFocusLost(evt);
            }
        });

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarProveedor.setToolTipText("");
        btnBuscarProveedor.setBorderPainted(false);
        btnBuscarProveedor.setContentAreaFilled(false);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarReferencia.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarReferencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarReferencia.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarReferencia.setText("Referencia");
        txtBuscarReferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarReferencia.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarReferenciaActionPerformed(evt);
            }
        });
        txtBuscarReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarReferenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarReferenciaFocusLost(evt);
            }
        });

        btnBuscarReferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarReferencia.setToolTipText("");
        btnBuscarReferencia.setBorderPainted(false);
        btnBuscarReferencia.setContentAreaFilled(false);
        btnBuscarReferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarReferencia.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarFechaEmision.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarFechaEmision.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarFechaEmision.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarFechaEmision.setText("Fecha de emisión");
        txtBuscarFechaEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarFechaEmision.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarFechaEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarFechaEmisionActionPerformed(evt);
            }
        });
        txtBuscarFechaEmision.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFechaEmisionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFechaEmisionFocusLost(evt);
            }
        });

        btnBuscarFechaEmision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarFechaEmision.setToolTipText("");
        btnBuscarFechaEmision.setBorderPainted(false);
        btnBuscarFechaEmision.setContentAreaFilled(false);
        btnBuscarFechaEmision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarFechaEmision.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarFechaRecepcion.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarFechaRecepcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarFechaRecepcion.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarFechaRecepcion.setText("Fecha de recepción");
        txtBuscarFechaRecepcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarFechaRecepcion.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarFechaRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarFechaRecepcionActionPerformed(evt);
            }
        });
        txtBuscarFechaRecepcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFechaRecepcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFechaRecepcionFocusLost(evt);
            }
        });

        btnBuscarFechaRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarFechaRecepcion.setToolTipText("");
        btnBuscarFechaRecepcion.setBorderPainted(false);
        btnBuscarFechaRecepcion.setContentAreaFilled(false);
        btnBuscarFechaRecepcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarFechaRecepcion.setPreferredSize(new java.awt.Dimension(18, 18));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 220));

        tblOrdenCompra.setForeground(new java.awt.Color(128, 128, 128));
        tblOrdenCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblOrdenCompra.setToolTipText("");
        tblOrdenCompra.setAlignmentX(0.0F);
        tblOrdenCompra.setAlignmentY(0.0F);
        tblOrdenCompra.setAutoscrolls(false);
        tblOrdenCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblOrdenCompra.setGridColor(new java.awt.Color(204, 204, 255));
        tblOrdenCompra.setMinimumSize(new java.awt.Dimension(900, 150));
        tblOrdenCompra.setRowHeight(30);
        tblOrdenCompra.setRowMargin(3);
        tblOrdenCompra.setShowHorizontalLines(false);
        tblOrdenCompra.setShowVerticalLines(false);
        tblOrdenCompra.setTableHeader(null);
        tblOrdenCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenCompraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOrdenCompra);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscarReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtBuscarFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitlealmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtLugarRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarRecepcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarRecepcionActionPerformed

    private void txtBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCodigoActionPerformed

    private void txtBuscarCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCodigoFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarCodigo);
    }//GEN-LAST:event_txtBuscarCodigoFocusGained

    private void txtBuscarCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCodigoFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarCodigo, "Código");
    }//GEN-LAST:event_txtBuscarCodigoFocusLost

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void txtBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProveedorActionPerformed

    private void txtBuscarProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarProveedorFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarProveedor);
    }//GEN-LAST:event_txtBuscarProveedorFocusGained

    private void txtBuscarProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarProveedorFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarProveedor, "Proveedor");
    }//GEN-LAST:event_txtBuscarProveedorFocusLost

    private void txtBuscarReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarReferenciaActionPerformed

    private void txtBuscarReferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarReferenciaFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarReferencia);
    }//GEN-LAST:event_txtBuscarReferenciaFocusGained

    private void txtBuscarReferenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarReferenciaFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarReferencia, "Referencia");
    }//GEN-LAST:event_txtBuscarReferenciaFocusLost

    private void txtBuscarFechaEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarFechaEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarFechaEmisionActionPerformed

    private void txtBuscarFechaEmisionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFechaEmisionFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarFechaEmision);
    }//GEN-LAST:event_txtBuscarFechaEmisionFocusGained

    private void txtBuscarFechaEmisionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFechaEmisionFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarFechaEmision, "Fecha de emisión");
    }//GEN-LAST:event_txtBuscarFechaEmisionFocusLost

    private void txtBuscarFechaRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarFechaRecepcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarFechaRecepcionActionPerformed

    private void txtBuscarFechaRecepcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFechaRecepcionFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarFechaRecepcion);
    }//GEN-LAST:event_txtBuscarFechaRecepcionFocusGained

    private void txtBuscarFechaRecepcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFechaRecepcionFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarFechaRecepcion, "Fecha de recepción");
    }//GEN-LAST:event_txtBuscarFechaRecepcionFocusLost

    private void txtCodigoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoInsumoActionPerformed

    private void txtNombreInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInsumoActionPerformed

    private void txtCantidadInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInsumoActionPerformed

    private void txtPrecioInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioInsumoActionPerformed

    private void cboFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFormaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFormaPagoActionPerformed

    private void btnGuardarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOrdenActionPerformed
        // TODO add your handling code here:
        if (this.controlTab == 0) { //aqui entramos a registrar un nuevo orden de compra
            String comentario = this.txtComentarioReferencia.getText();
            Date date = this.txtFechaRecepcion.getDate();
            String lugar = this.txtLugarRecepcion.getText();
            int pos_prov = this.cboProveedor.getSelectedIndex();
            int pos_mon = this.cboMoneda.getSelectedIndex();
            int pos_forma = this.cboFormaPago.getSelectedIndex();
            int pos_almacen = this.cboAlmacen.getSelectedIndex();
            if (!(comentario.equals("")) && date != null && !(lugar.equals("")) && pos_prov >= 0 && pos_mon >= 0 && pos_forma >= 0 && pos_almacen >= 0) {
                try {
                    OrdenCompra orden = new OrdenCompra();
                    orden.setComentario(comentario);
                    SimpleDateFormat formato = new SimpleDateFormat("DD/MM/YY");
                    orden.setFechaRecepcion("" + formato.format(date));
                    orden.setLugarRecepcion(lugar);
                    orden.setProveedor(this.modelCboProveedor.getElement(pos_prov));
                    orden.setMoneda(this.modelCboMoneda.getElement(pos_mon));
                    orden.setAlmacen(this.modelCboAlmacen.getElement(pos_almacen));
                    orden.setFormaPago(this.modelCboFormaPago.getElement(pos_forma));
                    orden.setTipoOperacion("i");
                    GestionOrdenCompra gestionOrden = new GestionOrdenCompra();
                    String r = gestionOrden.registrar(orden);
                    JOptionPane.showMessageDialog(this, r);
                    this.tblModelOrdenCompra.setData(new GestionOrdenCompra().listar());
                    this.tblModelOrdenCompra.fireTableDataChanged();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            if (this.controlTab == 1) {
                //aqui entramos a registrar la lista de productos de una orden de compra
            }
        }

    }//GEN-LAST:event_btnGuardarOrdenActionPerformed

    private void cboAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAlmacenItemStateChanged
        // TODO add your handling code here:
        int pos = this.cboAlmacen.getSelectedIndex();
        if (pos >= 0) {
            Almacen almacen = this.modelCboAlmacen.getElement(pos);
            this.txtLugarRecepcion.setText(almacen.getDireccion1());
        }
    }//GEN-LAST:event_cboAlmacenItemStateChanged

    private void btnAddInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumoActionPerformed
        // TODO add your handling code here:
        int fila = this.tblOrdenCompra.getSelectedRow();
        if (fila >= 0 && !(this.txtNombreInsumo.getText().equals("")) && !(this.txtCantidadInsumo.getText().equals(""))) {
            OrdenCompraInsumo detalle = new OrdenCompraInsumo();
            detalle.setInsumo(insumoselected);
            OrdenCompra orden = this.tblModelOrdenCompra.getValue(this.tblOrdenCompra.getSelectedRow());
            detalle.setOrden(orden);
            detalle.setCantidad(Double.parseDouble(this.txtCantidadInsumo.getText()));
            detalle.setPrecio(Double.parseDouble(this.txtPrecioInsumo.getText()));
            detalle.setUnidad(this.modelCboUnidad.getElement(cboUnidad.getSelectedIndex()));
            detalle.setMoneda(this.modelCboMoneda.getElement(cboMonedaInsumo.getSelectedIndex()));
            this.listaDetalle.add(detalle);
            this.tableModelDetalle.setData(listaDetalle);
            this.tableModelDetalle.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una orden de compra registrada y/o llene todos los campos!");
        }
    }//GEN-LAST:event_btnAddInsumoActionPerformed

    private void tblOrdenCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenCompraMouseClicked
        // TODO add your handling code here:
        int fila = this.tblOrdenCompra.getSelectedRow();
        if (fila >= 0) {
            try {
                OrdenCompra orden = this.tblModelOrdenCompra.getValue(fila);
                this.txtLugarRecepcion.setText(orden.getLugarRecepcion());
                this.txtComentarioReferencia.setText(orden.getComentario());
                Date date = new Date(orden.getFechaRecepcion());
                this.txtFechaRecepcion.setDate(date);
                this.txtObservaciones.setText(orden.getObservaciones());
                this.cboProveedor.setSelectedItem(orden.getProveedor().getNombres() + " " + orden.getProveedor().getApellidos());
                this.cboMoneda.setSelectedItem(orden.getMoneda().getV_moneda());
                this.cboFormaPago.setSelectedItem(orden.getFormaPago().getDescripcion());
                this.cboAlmacen.setSelectedItem(orden.getAlmacen().getDescripcion());
                
                this.listaDetalle = new GestionOrdenCompraInsumo().listar(orden);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelOrdenDeCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblOrdenCompraMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        System.out.println("idtab: " + jTabbedPane1.getSelectedIndex());
        this.controlTab = jTabbedPane1.getSelectedIndex();
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInsumo;
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarFechaEmision;
    private javax.swing.JButton btnBuscarFechaRecepcion;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnBuscarReferencia;
    private javax.swing.JButton btnEliminarOrden;
    private javax.swing.JButton btnGuardarOrden;
    private javax.swing.JButton btnNuevoOrden;
    private javax.swing.JComboBox cboAlmacen;
    private javax.swing.JComboBox cboFormaPago;
    private javax.swing.JComboBox cboMoneda;
    private javax.swing.JComboBox cboMonedaInsumo;
    private javax.swing.JComboBox cboPresentacionInsumo;
    private javax.swing.JComboBox cboProveedor;
    private javax.swing.JComboBox cboUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTable tblDetalleInsumos;
    private javax.swing.JTable tblOrdenCompra;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtBuscarFechaEmision;
    private javax.swing.JTextField txtBuscarFechaRecepcion;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtBuscarReferencia;
    private javax.swing.JTextField txtCantidadInsumo;
    private javax.swing.JTextField txtCodigoInsumo;
    private javax.swing.JTextArea txtComentarioReferencia;
    private com.toedter.calendar.JDateChooser txtFechaRecepcion;
    private javax.swing.JTextField txtLugarRecepcion;
    private javax.swing.JTextField txtNombreInsumo;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtPrecioInsumo;
    // End of variables declaration//GEN-END:variables
}
