/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.DetalleInsumo;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.gestion.logistica.GestionDetalleInsumo;
import com.disfruta.gestion.logistica.GestionInsumo;
import com.disfruta.gestion.logistica.GestionPresentacionInsumo;
import com.disfruta.gestion.logistica.GestionPresentacionPrecioVenta;
import com.disfruta.gestion.logistica.GestionPresentacionVenta;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class DialogPresComercialCarta extends javax.swing.JDialog {

    protected ProductoCarta producto;
    protected resources.tablemodel.ModelTablePresentacionPrecioVenta modelTablePrecioVenta;
    protected resources.tablemodel.ModelTableDetalleInsumo modelTableDetalleInsumo;
    protected resources.comboboxmodel.CboModelPresentacionCompra cboModelPresentacionInsumo;
    protected ArrayList<PresentacionPrecioVenta> listaprecios;
    protected ArrayList listaAutoCompletar;
    protected ArrayList<PresentacionVenta> nuevasPresentaciones;
    protected ArrayList listaInsumos;
    protected ArrayList<DetalleInsumo> detalleInsumos;
    protected TextAutoCompleter autocomp;
    protected TextAutoCompleter cajainsumo;
    protected Insumo insumoselected = null;
    protected int controlDetalleInsumo = -1;

    /**
     * Creates new form DialogPresComercialCarta
     */
    public DialogPresComercialCarta(java.awt.Frame parent, boolean modal, ProductoCarta producto) {
        super(parent, modal);
        try {
            this.producto = producto;
            init();
            initComponents();
            this.setLocationRelativeTo(null);            
            autocomp = new TextAutoCompleter(this.txtPresentacionVenta);
            this.cboPresentacionInsumo.setModel(this.cboModelPresentacionInsumo);
            cajainsumo = new TextAutoCompleter(this.txtNombreInsumo, new AutoCompleterCallback() {
                @Override
                public void callback(Object selectedItem) {
                    String cad = selectedItem.toString();
                    for (int i = 0; i < listaInsumos.size(); i++) {
                        if (cad.equals(((Insumo) listaInsumos.get(i)).getNombre())) {
                            try {
                                insumoselected = (Insumo) listaInsumos.get(i);
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

            autocomp.addItems(this.listaAutoCompletar);
            cajainsumo.addItems(this.listaInsumos);
            this.tblPresentacionPrecioVenta.setModel(modelTablePrecioVenta);
            this.tblTableDetalleInsumo.setModel(modelTableDetalleInsumo);
            setPadding();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws ClassNotFoundException, Exception {
        this.listaAutoCompletar = new GestionPresentacionVenta().listarPorFamilia(this.producto);
        this.listaprecios = new GestionPresentacionPrecioVenta().listarPorProducto(this.producto);
        this.modelTablePrecioVenta = new resources.tablemodel.ModelTablePresentacionPrecioVenta(this.listaprecios);
        this.detalleInsumos = new ArrayList();
        this.modelTableDetalleInsumo = new resources.tablemodel.ModelTableDetalleInsumo(this.detalleInsumos);
        this.nuevasPresentaciones = new ArrayList();
        this.listaInsumos = new ArrayList();
        this.listaInsumos = new GestionInsumo().listar();
        this.cboModelPresentacionInsumo = new resources.comboboxmodel.CboModelPresentacionCompra(null);
        for (int i = 0; i < this.listaprecios.size(); i++) {
            this.detalleInsumos.addAll(new GestionDetalleInsumo().listarPorPresentacion(this.listaprecios.get(i)));
        }
    }
    
    private void setPadding(){
        PaddingLeft.agregarpadding(txtPresentacionVenta);
        PaddingLeft.agregarpadding(txtProporcion);
        PaddingLeft.agregarpadding(txtPrecioVenta);
        PaddingLeft.agregarpadding(txtNombreInsumo);
        PaddingLeft.agregarpadding(txtCantidadInsumo);
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
        btnGuardar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPresentacionPrecioVenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProporcion = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        btnAddPresentacionPrecio = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        txtPresentacionVenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblNombrePresentacion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombreInsumo = new javax.swing.JTextField();
        txtCantidadInsumo = new javax.swing.JTextField();
        cboPresentacionInsumo = new javax.swing.JComboBox();
        cboUnidadInsumo = new javax.swing.JComboBox();
        btnAddInsumo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTableDetalleInsumo = new javax.swing.JTable();
        btnQuitarInsumo = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Presentación comercial de venta:");

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblPresentacionPrecioVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Presentación comercial de venta", "Precio (S/)", "Proporción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPresentacionPrecioVenta.getTableHeader().setReorderingAllowed(false);
        tblPresentacionPrecioVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPresentacionPrecioVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPresentacionPrecioVenta);

        jLabel2.setText("Nombre de producto de venta:");

        jLabel3.setText("Precio de venta:");

        jLabel4.setText("Proporción:");

        txtProporcion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtProporcion.setForeground(new java.awt.Color(153, 153, 153));
        txtProporcion.setToolTipText("");
        txtProporcion.setAlignmentX(0.0F);
        txtProporcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtProporcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtProporcion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtProporcion.setName("txtusuario"); // NOI18N
        txtProporcion.setPreferredSize(new java.awt.Dimension(280, 24));
        txtProporcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProporcionActionPerformed(evt);
            }
        });

        txtPrecioVenta.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioVenta.setToolTipText("");
        txtPrecioVenta.setAlignmentX(0.0F);
        txtPrecioVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPrecioVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioVenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPrecioVenta.setName("txtusuario"); // NOI18N
        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });

        btnAddPresentacionPrecio.setText("+");
        btnAddPresentacionPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddPresentacionPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPresentacionPrecioActionPerformed(evt);
            }
        });

        jLabel5.setText("Unidad");

        jLabel6.setText("minima");

        btnQuitar.setText("-");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        txtPresentacionVenta.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPresentacionVenta.setForeground(new java.awt.Color(153, 153, 153));
        txtPresentacionVenta.setToolTipText("");
        txtPresentacionVenta.setAlignmentX(0.0F);
        txtPresentacionVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPresentacionVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPresentacionVenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPresentacionVenta.setName("txtusuario"); // NOI18N
        txtPresentacionVenta.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPresentacionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresentacionVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtPresentacionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProporcion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(btnAddPresentacionPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar)
                                .addContainerGap(56, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProporcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddPresentacionPrecio)
                        .addComponent(btnQuitar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPresentacionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(244, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Presentación de venta", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombrePresentacion.setText("Fuente familiar");

        jLabel9.setText("Nombre de insumo:");

        jLabel10.setText("Presentación comercial:");

        jLabel11.setText("Cantidad:");

        jLabel12.setText("Unidad:");

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

        cboPresentacionInsumo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboUnidadInsumo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddInsumo.setText("+");
        btnAddInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumoActionPerformed(evt);
            }
        });

        tblTableDetalleInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Contenido/ Cap.", "Presentación compra", "Cantidad", "Unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTableDetalleInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableDetalleInsumoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTableDetalleInsumo);

        btnQuitarInsumo.setText("-");
        btnQuitarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarInsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cboPresentacionInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cboUnidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddInsumo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnQuitarInsumo))))
                            .addComponent(lblNombrePresentacion))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNombrePresentacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPresentacionInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInsumo)
                    .addComponent(cboUnidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarInsumo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingredientes (Insumos)", jPanel2);

        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProporcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProporcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProporcionActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtNombreInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInsumoActionPerformed

    private void txtCantidadInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInsumoActionPerformed

    private void btnAddPresentacionPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPresentacionPrecioActionPerformed
        // TODO add your handling code here:
        String cadpres = this.txtPresentacionVenta.getText();
        String pre = this.txtPrecioVenta.getText();
        String pro = this.txtProporcion.getText();
        if (!(cadpres.equalsIgnoreCase("")) && !(pre.equalsIgnoreCase("")) && !(pro.equalsIgnoreCase(""))) {
            int control = 0;
            PresentacionVenta pres = new PresentacionVenta();
            for (int i = 0; i < this.listaAutoCompletar.size(); i++) {
                PresentacionVenta obj = (PresentacionVenta) this.listaAutoCompletar.get(i);
                if (cadpres.equalsIgnoreCase(obj.getDescripcion())) {
                    pres = obj;
                    control = 1;
                    break;
                }
            }
            if (control == 0) {
                pres.setId(0);
                pres.setDescripcion(cadpres);
                pres.setTipoOperacion("i");
                pres.setFamilia(this.producto.getFamilia());
                this.nuevasPresentaciones.add(pres);
            }

            PresentacionPrecioVenta precioventa = new PresentacionPrecioVenta();
            precioventa.setPresentacion(pres);
            precioventa.setProudcto(this.producto);
            precioventa.setPrecioventa(Double.parseDouble(this.txtPrecioVenta.getText()));
            precioventa.setProporcion(Double.parseDouble(this.txtProporcion.getText()));
            precioventa.setTipoOperacion("i");
            this.listaprecios.add(precioventa);
            this.modelTablePrecioVenta.setData(this.listaprecios);
            this.modelTablePrecioVenta.fireTableDataChanged();
            this.txtPresentacionVenta.setText("");
            this.txtPrecioVenta.setText("");
            this.txtProporcion.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "¡Llene todos los campos!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddPresentacionPrecioActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int pos = this.tblPresentacionPrecioVenta.getSelectedRow();
        if (pos >= 0) {
            PresentacionPrecioVenta ppp = this.listaprecios.get(pos);
            PresentacionVenta p = ppp.getPresentacion();
            this.nuevasPresentaciones.remove(p);
            this.listaprecios.remove(pos);
            //eliminamos sus detalles de insumos
            for (int i = 0; i < this.detalleInsumos.size(); i++) {
                if (this.detalleInsumos.get(i).getPresentacion().equals(ppp)) {
                    this.detalleInsumos.remove(i);
                    i = -1;
                    System.out.println("elimino insumo");
                }
            }

            this.modelTablePrecioVenta.setData(this.listaprecios);
            this.modelTablePrecioVenta.fireTableDataChanged();
            this.modelTableDetalleInsumo.setData(new ArrayList());
            this.modelTableDetalleInsumo.fireTableDataChanged();
            this.txtPresentacionVenta.setText("");
            this.txtProporcion.setText("");
            this.txtPrecioVenta.setText("");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tblPresentacionPrecioVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPresentacionPrecioVentaMouseClicked

        // TODO add your handling code here:
        int fila = this.tblPresentacionPrecioVenta.getSelectedRow();
        if (fila >= 0) {
            PresentacionPrecioVenta pres = this.modelTablePrecioVenta.getValue(fila);
            this.lblNombrePresentacion.setText(pres.getPresentacion().getDescripcion());
            System.out.println("id pres: " + pres.getPresentacion().getId());
            System.out.println("id prod: " + pres.getProudcto().getIdproductocarta());
            System.out.println("size: " + this.detalleInsumos.size());
            ArrayList resultados = new ArrayList();
            for (int i = 0; i < this.detalleInsumos.size(); i++) {
                if (this.detalleInsumos.get(i).getPresentacion().getPresentacion().getDescripcion().equals(pres.getPresentacion().getDescripcion())) {
                    resultados.add(this.detalleInsumos.get(i));
                }
            }
            this.modelTableDetalleInsumo.setData(resultados);
            this.modelTableDetalleInsumo.fireTableDataChanged();
        }
    }//GEN-LAST:event_tblPresentacionPrecioVentaMouseClicked

    private void txtPresentacionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresentacionVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionVentaActionPerformed

    private void btnAddInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumoActionPerformed
        // TODO add your handling code here:
        int fila = this.tblPresentacionPrecioVenta.getSelectedRow();
        if (fila >= 0 && !(this.txtNombreInsumo.getText().equals("")) && !(this.txtCantidadInsumo.getText().equals(""))) {
            PresentacionPrecioVenta precio = this.modelTablePrecioVenta.getValue(fila);
            System.out.println("pres selected: " + precio.getPresentacion().getDescripcion());
            DetalleInsumo detalle = new DetalleInsumo();
            int c = -1;
            for (int i = 0; i < this.detalleInsumos.size(); i++) {
                if (this.detalleInsumos.get(i).getInsumo().getIdinsumo() == this.insumoselected.getIdinsumo() && this.detalleInsumos.get(i).getPresentacion().equals(precio)) {
                    c = i;
                    System.out.println("encontro similar");
                    break;
                }
            }
            detalle.setControlInsercion(false);
            detalle.setPresentacion(precio);
            detalle.setInsumo(this.insumoselected);
            System.out.println("imprmie: " + this.insumoselected.getCapacidad());
            detalle.setCantidad(Double.parseDouble(this.txtCantidadInsumo.getText()));
            detalle.setUnidad("---");
            detalle.setTipoOperacion("i");           // es nuevo
            if (c == -1) {
                this.detalleInsumos.add(detalle);
                System.out.println("entro aqui 2");
            } else {
                JOptionPane.showMessageDialog(this, "Este insumo ya está en lista!");
            }
            System.out.println("lista size: " + this.detalleInsumos.size());
            this.txtNombreInsumo.setText("");
            this.txtCantidadInsumo.setText("");
            ArrayList resultados = new ArrayList();
            for (int i = 0; i < this.detalleInsumos.size(); i++) {
                if (this.detalleInsumos.get(i).getPresentacion().equals(precio)) {
                    resultados.add(this.detalleInsumos.get(i));
                }
            }
            this.modelTableDetalleInsumo.setData(resultados);
            this.modelTableDetalleInsumo.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Presentación de producto y/o ingrese un nombre y cantidad de insumo.");
        }
    }//GEN-LAST:event_btnAddInsumoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //Guardar las presentaciones nuevas y extraer su id
        if (this.listaprecios.size() > 0) {
            GestionPresentacionVenta gestionpv = new GestionPresentacionVenta();
            GestionPresentacionPrecioVenta gestionppv = new GestionPresentacionPrecioVenta();
            GestionDetalleInsumo gestionDetalle = new GestionDetalleInsumo();
            //eliminamos lo que tiene en la tabla precio_presentacion y en la tabla detalle_insumo
            this.producto.setTipoOperacion("e2");
            String rpa = gestionDetalle.eliminarPorProducto(this.producto);
            this.producto.setTipoOperacion("e1");            
            String rp = gestionppv.eliminarPorProducto(this.producto);
            
            //----------------------------- guardamos nuevamente lo actual        
            for (int i = 0; i < this.listaprecios.size(); i++) {
                PresentacionVenta obj = this.listaprecios.get(i).getPresentacion();
                if (obj.getId() == 0) {
                    try {
                        gestionpv.registrar(obj);
                        this.listaprecios.get(i).setPresentacion(gestionpv.getUltimoObject());
                        for (int j = 0; j < this.detalleInsumos.size(); j++) {
                            if (this.detalleInsumos.get(j).getPresentacion().getPresentacion().getDescripcion().equals(this.listaprecios.get(i).getPresentacion().getDescripcion())) {
                                this.detalleInsumos.get(j).setPresentacion(this.listaprecios.get(i));
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Guardar en la tabla presentacion_precio que une a los productos y a su presentacion            
                if (this.listaprecios.get(i).getTipoOperacion().equals("i")) {
                    gestionppv.registrar(this.listaprecios.get(i));
                    System.out.println("precio venta registrado - tabla logtbc_presentacion_precio");
                } else {
                    System.out.println("ya esta insertado");
                }
            }
            for (int j = 0; j < this.detalleInsumos.size(); j++) {
                System.out.println("oper: " + this.detalleInsumos.get(j).getTipoOperacion());
                gestionDetalle.registrar(this.detalleInsumos.get(j));
            }
            JOptionPane.showMessageDialog(this, "Guardado correctamente!");
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblTableDetalleInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableDetalleInsumoMouseClicked
        // TODO add your handling code here:
//            int fila = this.tblTableDetalleInsumo.getSelectedRow();
//
//            DetalleInsumo detalle = this.modelTableDetalleInsumo.getValue(fila);
//            for (int i = 0; i < this.detalleInsumos.size(); i++) {
//                if (this.detalleInsumos.get(i).equals(detalle)) {
//                    this.controlDetalleInsumo = i;
//                    System.out.println("encontrado-posicion: " + i);
//                    break;
//                }
//            }
//            txtNombreInsumo.setText(detalle.getInsumo().getNombre());
//            txtCantidadInsumo.setText(detalle.getCantidad() + "");
//            cboModelPresentacionInsumo.setData(new GestionPresentacionInsumo().listarPorInsumo(detalle.getInsumo()));
//            cboPresentacionInsumo.setModel(cboModelPresentacionInsumo);
    }//GEN-LAST:event_tblTableDetalleInsumoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.txtCantidadInsumo.setText("");
        this.txtNombreInsumo.setText("");
        this.txtPrecioVenta.setText("");
        this.txtProporcion.setText("");
        this.txtPresentacionVenta.setText("");
        this.insumoselected = null;
        this.controlDetalleInsumo = -1;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnQuitarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarInsumoActionPerformed
        // TODO add your handling code here:
        int n = this.tblTableDetalleInsumo.getSelectedRow();
        if (n >= 0) {
            DetalleInsumo detalle = this.modelTableDetalleInsumo.getValue(n);
            this.detalleInsumos.remove(detalle);
            ArrayList resultados = new ArrayList();
            for (int i = 0; i < this.detalleInsumos.size(); i++) {
                if (this.detalleInsumos.get(i).getPresentacion().getPresentacion().getDescripcion().equals(detalle.getPresentacion().getPresentacion().getDescripcion())) {
                    resultados.add(this.detalleInsumos.get(i));
                }
            }
            this.modelTableDetalleInsumo.setData(resultados);
            this.modelTableDetalleInsumo.fireTableDataChanged();
            System.out.println("size-detalle: " + this.detalleInsumos.size());
        }
    }//GEN-LAST:event_btnQuitarInsumoActionPerformed

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
            java.util.logging.Logger.getLogger(DialogPresComercialCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPresComercialCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogPresComercialCarta dialog = new DialogPresComercialCarta(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnAddInsumo;
    private javax.swing.JButton btnAddPresentacionPrecio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarInsumo;
    private javax.swing.JComboBox cboPresentacionInsumo;
    private javax.swing.JComboBox cboUnidadInsumo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNombrePresentacion;
    private javax.swing.JTable tblPresentacionPrecioVenta;
    private javax.swing.JTable tblTableDetalleInsumo;
    private javax.swing.JTextField txtCantidadInsumo;
    private javax.swing.JTextField txtNombreInsumo;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtPresentacionVenta;
    private javax.swing.JTextField txtProporcion;
    // End of variables declaration//GEN-END:variables
}
