/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.DetalleInsumo;
import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionInsumo;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.gestion.logistica.GestionDetalleInsumo;
import com.disfruta.gestion.logistica.GestionFamiliaProducto;
import com.disfruta.gestion.logistica.GestionInsumo;
import com.disfruta.gestion.logistica.GestionPresentacionInsumo;
import com.disfruta.gestion.xtbc.GestionMoneda;
import com.disfruta.gestion.logistica.GestionUnidadMedida;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import resources.auxiliar.PaddingLeft;
import resources.comboboxmodel.CboModelFamiliaProducto;
import resources.comboboxmodel.CboModelMoneda;
import resources.comboboxmodel.CboModelUnidadMedida;
import resources.tablemodel.ModelTablePresentacionCompraMostrar;

/**
 *
 * @author Juape
 */
public class PanelProductoInsumo extends javax.swing.JPanel {

    private CboModelFamiliaProducto modelcboFamilia;
    private CboModelUnidadMedida modelcbounidad;
    private CboModelMoneda modelcbomoneda;
    private ArrayList<PresentacionInsumo> presentacion;
    private ModelTablePresentacionCompraMostrar tablapresentacion;
    private resources.tablemodel.ModelTableInsumos modelTableInsumos;
    private String control_save = "nuevo";
    private Insumo insumoSelected = null;
    private boolean control_presentacion = false;

    /**
     * Creates new form PanelProducto
     */
    public PanelProductoInsumo() {
        try {
            this.init();
            initComponents();
            this.cboFamilia.setModel(modelcboFamilia);
            this.cboFamilia.setSelectedIndex(0);
            this.cboUnidadMedida.setModel(modelcbounidad);
            this.cboUnidadMedida.setSelectedIndex(0);
            this.cboMonedaCompra.setModel(modelcbomoneda);
            this.cboMonedaCompra.setSelectedIndex(0);
            this.cboMonedaVenta.setModel(modelcbomoneda);
            this.cboMonedaVenta.setSelectedIndex(0);
            this.tblPresentacionCompraMuestra.setModel(tablapresentacion);
            this.tblinsumos.setModel(this.modelTableInsumos);

            PresentacionInsumo bean = new PresentacionInsumo();
            bean.setNombre_presentacion("Unidad");
            bean.setCantidad(1);
            bean.setUnidad("Unidad");
            this.presentacion = new <PresentacionInsumo>ArrayList();
            this.presentacion.add(bean);
            setPadding();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void init() throws ClassNotFoundException, Exception {
        this.modelcboFamilia = new resources.comboboxmodel.CboModelFamiliaProducto(new GestionFamiliaProducto().listar());
        this.modelcbounidad = new resources.comboboxmodel.CboModelUnidadMedida(new GestionUnidadMedida().listar());
        this.modelcbomoneda = new resources.comboboxmodel.CboModelMoneda(new GestionMoneda().listar());
        this.presentacion = new ArrayList();
        this.tablapresentacion = new resources.tablemodel.ModelTablePresentacionCompraMostrar(this.presentacion);
        this.modelTableInsumos = new resources.tablemodel.ModelTableInsumos(new GestionInsumo().listar());
        this.insumoSelected = new Insumo();
    }

    private void setPadding() {
        PaddingLeft.agregarpadding(txtnombreinsumo);
        PaddingLeft.agregarpadding(txtcapacidadinsumo);
        PaddingLeft.agregarpadding(txtpreciocomprainsumo);
        PaddingLeft.agregarpadding(txtprecioventainsumo);
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
    
    private static boolean isNumero(String string){
        if(string==null || string.isEmpty()){
            return false;
        }
        int i=0;
        if(string.charAt(0)=='-'){
            if(string.length()>1){
                i++;
            }else{
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i))){
                return false;
            }
        }
        return true;
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
        jLabel1 = new javax.swing.JLabel();
        btnNuevoAlmacen = new javax.swing.JButton();
        btnGuardarInsumo = new javax.swing.JButton();
        btnEliminarInsumo = new javax.swing.JButton();
        txtcapacidadinsumo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboFamilia = new javax.swing.JComboBox();
        chkcontrolstock = new javax.swing.JCheckBox();
        txtnombreinsumo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboUnidadMedida = new javax.swing.JComboBox();
        chkventadirecta = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtpreciocomprainsumo = new javax.swing.JTextField();
        cboMonedaCompra = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtprecioventainsumo = new javax.swing.JTextField();
        cboMonedaVenta = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cboCuentaContable = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        txtBuscarNombrePro = new javax.swing.JTextField();
        btnBuscarNombrePro = new javax.swing.JButton();
        txtBuscarCategoriaPro = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        txtBuscarCapacidadPro = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        txtBuscarPrecioComPro = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        txtBuscarCuentaPro = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblinsumos = new javax.swing.JTable();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnEditarPresentacion = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPresentacionCompraMuestra = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Insumos");

        btnNuevoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoAlmacen.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoAlmacen.setForeground(new java.awt.Color(229, 147, 35));
        btnNuevoAlmacen.setText("Nuevo");
        btnNuevoAlmacen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoAlmacen.setBorderPainted(false);
        btnNuevoAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAlmacen.setFocusPainted(false);
        btnNuevoAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoAlmacen.setOpaque(false);
        btnNuevoAlmacen.setPreferredSize(new java.awt.Dimension(92, 30));
        btnNuevoAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlmacenActionPerformed(evt);
            }
        });

        btnGuardarInsumo.setBackground(new java.awt.Color(252, 242, 228));
        btnGuardarInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardarInsumo.setForeground(new java.awt.Color(83, 71, 65));
        btnGuardarInsumo.setText("Guardar");
        btnGuardarInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardarInsumo.setBorderPainted(false);
        btnGuardarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarInsumo.setFocusPainted(false);
        btnGuardarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarInsumo.setOpaque(false);
        btnGuardarInsumo.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInsumoActionPerformed(evt);
            }
        });

        btnEliminarInsumo.setBackground(new java.awt.Color(229, 147, 35));
        btnEliminarInsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnEliminarInsumo.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarInsumo.setText("Eliminar");
        btnEliminarInsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnEliminarInsumo.setBorderPainted(false);
        btnEliminarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarInsumo.setFocusPainted(false);
        btnEliminarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarInsumo.setOpaque(false);
        btnEliminarInsumo.setPreferredSize(new java.awt.Dimension(92, 30));
        btnEliminarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneltitlealmacenLayout = new javax.swing.GroupLayout(paneltitlealmacen);
        paneltitlealmacen.setLayout(paneltitlealmacenLayout);
        paneltitlealmacenLayout.setHorizontalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltitlealmacenLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(logoalmacen)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(193, 193, 193)
                .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        paneltitlealmacenLayout.setVerticalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltitlealmacenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoalmacen)
                .addGap(16, 16, 16))
            .addGroup(paneltitlealmacenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtcapacidadinsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtcapacidadinsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtcapacidadinsumo.setText("   Ej: 1.5 L,2 kg, 1.2 Hz");
        txtcapacidadinsumo.setToolTipText("");
        txtcapacidadinsumo.setAlignmentX(0.0F);
        txtcapacidadinsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtcapacidadinsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtcapacidadinsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtcapacidadinsumo.setName("txtusuario"); // NOI18N
        txtcapacidadinsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtcapacidadinsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcapacidadinsumoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre de insumo:");

        jLabel6.setText("Familia:");

        cboFamilia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chkcontrolstock.setText("Control de Stock");
        chkcontrolstock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtnombreinsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtnombreinsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtnombreinsumo.setText("Ejemplo: Cerveza Cristal 1.5 L");
        txtnombreinsumo.setToolTipText("");
        txtnombreinsumo.setAlignmentX(0.0F);
        txtnombreinsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtnombreinsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtnombreinsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtnombreinsumo.setName("txtusuario"); // NOI18N
        txtnombreinsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtnombreinsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreinsumoActionPerformed(evt);
            }
        });

        jLabel7.setText("Capacidad/ Contenido:");

        jLabel8.setText("Unidad de medida:");

        cboUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUnidadMedida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        chkventadirecta.setText("Se vende directamente");
        chkventadirecta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setText("Precio de compra:");

        txtpreciocomprainsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtpreciocomprainsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtpreciocomprainsumo.setText(" 125.00");
        txtpreciocomprainsumo.setToolTipText("");
        txtpreciocomprainsumo.setAlignmentX(0.0F);
        txtpreciocomprainsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtpreciocomprainsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtpreciocomprainsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtpreciocomprainsumo.setName("txtusuario"); // NOI18N
        txtpreciocomprainsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtpreciocomprainsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreciocomprainsumoActionPerformed(evt);
            }
        });

        cboMonedaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMonedaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10.setText("Precio de venta:");

        txtprecioventainsumo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtprecioventainsumo.setForeground(new java.awt.Color(153, 153, 153));
        txtprecioventainsumo.setText(" 135.00");
        txtprecioventainsumo.setToolTipText("");
        txtprecioventainsumo.setAlignmentX(0.0F);
        txtprecioventainsumo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtprecioventainsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtprecioventainsumo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtprecioventainsumo.setName("txtusuario"); // NOI18N
        txtprecioventainsumo.setPreferredSize(new java.awt.Dimension(280, 24));
        txtprecioventainsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioventainsumoActionPerformed(evt);
            }
        });

        cboMonedaVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMonedaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setText("Cuenta contable:");

        cboCuentaContable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel4.setBackground(new java.awt.Color(250, 233, 211));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));

        txtBuscarNombrePro.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarNombrePro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarNombrePro.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarNombrePro.setText("Nombre");
        txtBuscarNombrePro.setToolTipText("");
        txtBuscarNombrePro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarNombrePro.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarNombrePro.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarNombrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreProActionPerformed(evt);
            }
        });
        txtBuscarNombrePro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarNombreProFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarNombreProFocusLost(evt);
            }
        });

        btnBuscarNombrePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        btnBuscarNombrePro.setToolTipText("");
        btnBuscarNombrePro.setBorderPainted(false);
        btnBuscarNombrePro.setContentAreaFilled(false);
        btnBuscarNombrePro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarNombrePro.setPreferredSize(new java.awt.Dimension(18, 18));
        btnBuscarNombrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNombreProActionPerformed(evt);
            }
        });

        txtBuscarCategoriaPro.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarCategoriaPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarCategoriaPro.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarCategoriaPro.setText("Categoria");
        txtBuscarCategoriaPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarCategoriaPro.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarCategoriaPro.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarCategoriaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCategoriaProActionPerformed(evt);
            }
        });
        txtBuscarCategoriaPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCategoriaProFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCategoriaProFocusLost(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton17.setToolTipText("");
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarCapacidadPro.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarCapacidadPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarCapacidadPro.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarCapacidadPro.setText("Capacidad/ Contenido");
        txtBuscarCapacidadPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarCapacidadPro.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarCapacidadPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCapacidadProActionPerformed(evt);
            }
        });
        txtBuscarCapacidadPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCapacidadProFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCapacidadProFocusLost(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton18.setToolTipText("");
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarPrecioComPro.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarPrecioComPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarPrecioComPro.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarPrecioComPro.setText("Precio de compra");
        txtBuscarPrecioComPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarPrecioComPro.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarPrecioComPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPrecioComProActionPerformed(evt);
            }
        });
        txtBuscarPrecioComPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarPrecioComProFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarPrecioComProFocusLost(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton19.setToolTipText("");
        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarCuentaPro.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarCuentaPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarCuentaPro.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarCuentaPro.setText("Cuenta contable");
        txtBuscarCuentaPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarCuentaPro.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarCuentaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCuentaProActionPerformed(evt);
            }
        });
        txtBuscarCuentaPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCuentaProFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCuentaProFocusLost(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton20.setToolTipText("");
        jButton20.setBorderPainted(false);
        jButton20.setContentAreaFilled(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setPreferredSize(new java.awt.Dimension(18, 18));

        jScrollPane5.setOpaque(false);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(450, 220));

        tblinsumos.setForeground(new java.awt.Color(128, 128, 128));
        tblinsumos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblinsumos.setToolTipText("");
        tblinsumos.setAlignmentX(0.0F);
        tblinsumos.setAlignmentY(0.0F);
        tblinsumos.setAutoscrolls(false);
        tblinsumos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblinsumos.setGridColor(new java.awt.Color(204, 204, 255));
        tblinsumos.setMinimumSize(new java.awt.Dimension(900, 150));
        tblinsumos.setRowHeight(30);
        tblinsumos.setRowMargin(3);
        tblinsumos.setShowHorizontalLines(false);
        tblinsumos.setShowVerticalLines(false);
        tblinsumos.setTableHeader(null);
        tblinsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblinsumosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblinsumos);

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator14.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator15.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator16.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnBuscarNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCapacidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtBuscarPrecioComPro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarCuentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtBuscarNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBuscarCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCapacidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarPrecioComPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarCuentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Editar presentación comercial de compra");

        btnEditarPresentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarPresentacion.setBorderPainted(false);
        btnEditarPresentacion.setContentAreaFilled(false);
        btnEditarPresentacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPresentacionActionPerformed(evt);
            }
        });

        jScrollPane6.setOpaque(false);
        jScrollPane6.setPreferredSize(new java.awt.Dimension(450, 220));

        tblPresentacionCompraMuestra.setForeground(new java.awt.Color(128, 128, 128));
        tblPresentacionCompraMuestra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Presentación comercial", "Cantidad de este producto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPresentacionCompraMuestra.setToolTipText("");
        tblPresentacionCompraMuestra.setAlignmentX(0.0F);
        tblPresentacionCompraMuestra.setAlignmentY(0.0F);
        tblPresentacionCompraMuestra.setAutoscrolls(false);
        tblPresentacionCompraMuestra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPresentacionCompraMuestra.setGridColor(new java.awt.Color(204, 204, 255));
        tblPresentacionCompraMuestra.setMinimumSize(new java.awt.Dimension(900, 150));
        tblPresentacionCompraMuestra.setRowHeight(30);
        tblPresentacionCompraMuestra.setRowMargin(3);
        tblPresentacionCompraMuestra.setShowHorizontalLines(false);
        tblPresentacionCompraMuestra.setShowVerticalLines(false);
        tblPresentacionCompraMuestra.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblPresentacionCompraMuestra);
        tblPresentacionCompraMuestra.getColumnModel().getColumn(0).setResizable(false);
        tblPresentacionCompraMuestra.getColumnModel().getColumn(1).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8)
                                .addComponent(cboFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtcapacidadinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboUnidadMedida, 0, 110, Short.MAX_VALUE))
                                .addComponent(txtnombreinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(chkcontrolstock))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkventadirecta)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtpreciocomprainsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboMonedaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtprecioventainsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboMonedaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel11)
                            .addComponent(cboCuentaContable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditarPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(chkventadirecta)
                        .addComponent(btnEditarPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombreinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtpreciocomprainsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboMonedaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtprecioventainsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboMonedaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkcontrolstock))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcapacidadinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcapacidadinsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcapacidadinsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapacidadinsumoActionPerformed

    private void txtnombreinsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreinsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreinsumoActionPerformed

    private void txtpreciocomprainsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreciocomprainsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreciocomprainsumoActionPerformed

    private void txtprecioventainsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioventainsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioventainsumoActionPerformed

    private void txtBuscarNombreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreProActionPerformed

    private void txtBuscarNombreProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreProFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarNombrePro);
    }//GEN-LAST:event_txtBuscarNombreProFocusGained

    private void txtBuscarNombreProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreProFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarNombrePro, "Nombre");
    }//GEN-LAST:event_txtBuscarNombreProFocusLost

    private void btnBuscarNombreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarNombreProActionPerformed

    private void txtBuscarCategoriaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCategoriaProActionPerformed

    private void txtBuscarCategoriaProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaProFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarCategoriaPro);
    }//GEN-LAST:event_txtBuscarCategoriaProFocusGained

    private void txtBuscarCategoriaProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaProFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarCategoriaPro, "Distrito");
    }//GEN-LAST:event_txtBuscarCategoriaProFocusLost

    private void txtBuscarCapacidadProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCapacidadProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCapacidadProActionPerformed

    private void txtBuscarCapacidadProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCapacidadProFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarCapacidadPro);
    }//GEN-LAST:event_txtBuscarCapacidadProFocusGained

    private void txtBuscarCapacidadProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCapacidadProFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarCapacidadPro, "Teléfono (s)");
    }//GEN-LAST:event_txtBuscarCapacidadProFocusLost

    private void txtBuscarPrecioComProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPrecioComProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPrecioComProActionPerformed

    private void txtBuscarPrecioComProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarPrecioComProFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarPrecioComPro);
    }//GEN-LAST:event_txtBuscarPrecioComProFocusGained

    private void txtBuscarPrecioComProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarPrecioComProFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarPrecioComPro, "Dirección");
    }//GEN-LAST:event_txtBuscarPrecioComProFocusLost

    private void txtBuscarCuentaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCuentaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCuentaProActionPerformed

    private void txtBuscarCuentaProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCuentaProFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarCuentaPro);
    }//GEN-LAST:event_txtBuscarCuentaProFocusGained

    private void txtBuscarCuentaProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCuentaProFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarCuentaPro, "Otra Dirección");
    }//GEN-LAST:event_txtBuscarCuentaProFocusLost

    private void btnEditarPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPresentacionActionPerformed
        // TODO add your handling code here:
        if (this.presentacion.isEmpty()) {
            PresentacionInsumo bean = new PresentacionInsumo();
            bean.setNombre_presentacion("Unidad");
            bean.setCantidad(1);
            bean.setUnidad("Unidad");
            this.presentacion.add(bean);
        }
        DialogPresComercialInsumo dialog = new DialogPresComercialInsumo(null, true, this.presentacion);
        dialog.setVisible(true);
        if (dialog.control == 1) {
            this.presentacion = new ArrayList();
            this.presentacion = dialog.listpresentacion;
            this.tablapresentacion = new resources.tablemodel.ModelTablePresentacionCompraMostrar(this.presentacion);
            this.tblPresentacionCompraMuestra.setModel(tablapresentacion);
            this.control_presentacion = true;
        }

    }//GEN-LAST:event_btnEditarPresentacionActionPerformed

    private void tblinsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblinsumosMouseClicked
        // TODO add your handling code here:
        int pos = this.tblinsumos.getSelectedRow();
        if (pos >= 0) {
            try {
                insumoSelected = this.modelTableInsumos.getValue(pos);
                this.txtnombreinsumo.setText(insumoSelected.getNombre());
                this.txtcapacidadinsumo.setText(insumoSelected.getCapacidad() + "");
                this.txtpreciocomprainsumo.setText(insumoSelected.getPreciocompra() + "");
                this.txtprecioventainsumo.setText(insumoSelected.getPrecioventa() + "");
                this.cboFamilia.setSelectedItem(insumoSelected.getCategoria().getV_familia().toString());
                if (insumoSelected.getControlstock().equals("S")) {
                    this.chkcontrolstock.setSelected(true);
                }
                if (insumoSelected.getVentadirecta().equals("S")) {
                    this.chkventadirecta.setSelected(true);
                }
                GestionPresentacionInsumo gestion = new GestionPresentacionInsumo();
                this.presentacion = gestion.listarPorInsumo(insumoSelected);
                this.tablapresentacion = new resources.tablemodel.ModelTablePresentacionCompraMostrar(this.presentacion);
                this.tblPresentacionCompraMuestra.setModel(tablapresentacion);
                this.control_save = "modificar";
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblinsumosMouseClicked

    private void btnGuardarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInsumoActionPerformed
        // TODO add your handling code here:
        int r1 = this.cboFamilia.getSelectedIndex();
        int r2 = this.cboUnidadMedida.getSelectedIndex();
        int r3 = this.cboMonedaCompra.getSelectedIndex();
        int r4 = this.cboMonedaVenta.getSelectedIndex();
        String c1 = this.txtnombreinsumo.getText();
        String c2 = this.txtcapacidadinsumo.getText();
        String c3 = this.txtpreciocomprainsumo.getText();
        String c4 = this.txtprecioventainsumo.getText();
        if (r1 >= 0 && r2 >= 0 && r3 >= 0 && r4 >= 0 && !(c1.equals("")) & !(c2.equals("")) & !(c3.equals("")) & !(c4.equals(""))) {
            if(isNumero(c2) && isNumero(c3) && isNumero(c4)){
            this.insumoSelected.setNombre(c1);
            this.insumoSelected.setCapacidad(Double.parseDouble(c2));
            this.insumoSelected.setPreciocompra(Double.parseDouble(c3));
            this.insumoSelected.setPrecioventa(Double.parseDouble(c4));
            if (this.chkcontrolstock.isSelected()) {
                this.insumoSelected.setControlstock("S");
            }else {
                this.insumoSelected.setControlstock("N");
            }
            if (this.chkventadirecta.isSelected()) {
                this.insumoSelected.setVentadirecta("S");
            } else {
                this.insumoSelected.setVentadirecta("N");
            }

            int idfamilia = this.cboFamilia.getSelectedIndex();
            FamiliaProducto familia = (FamiliaProducto) this.modelcboFamilia.getElement(idfamilia);
            int idunidad = this.cboUnidadMedida.getSelectedIndex();
            UnidadMedida unidad = (UnidadMedida) this.modelcbounidad.getElement(idunidad);
            int idmonc = this.cboMonedaCompra.getSelectedIndex();
            Moneda monedacompra = (Moneda) this.modelcbomoneda.getElement(idmonc);
            int idmonv = this.cboMonedaCompra.getSelectedIndex();
            Moneda monedaventa = (Moneda) this.modelcbomoneda.getElement(idmonv);
            this.insumoSelected.setCategoria(familia);
            this.insumoSelected.setUnidad(unidad);
            this.insumoSelected.setMonedacompra(monedacompra);
            this.insumoSelected.setMonedaventa(monedaventa);
            GestionInsumo gestionInsumo = new GestionInsumo();
            GestionPresentacionInsumo gestionPres = new GestionPresentacionInsumo();
            if (this.control_save.equals("nuevo")) {
                try {
                    this.insumoSelected.setTipoOperacion("i");
                    gestionInsumo.registrar(insumoSelected);
                    Insumo ultimo = gestionInsumo.getUltimoObject();
                    if (this.control_presentacion && this.presentacion.size() > 0) {
                        for (int i = 0; i < this.presentacion.size(); i++) {
                            PresentacionInsumo ob = this.presentacion.get(i);
                            ob.setProducto(ultimo);
                            ob.setTipoOperacion("i");
                            gestionPres.registrar(ob);
                        }
                        JOptionPane.showMessageDialog(null, "Registro correcto!");
                        this.modelTableInsumos.setData(new GestionInsumo().listar());
                        this.modelTableInsumos.fireTableDataChanged();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.control_save.equals("modificar")) {
                try {
                    this.insumoSelected.setTipoOperacion("a");
                    gestionInsumo.actualizar(insumoSelected);
                    if (this.control_presentacion && this.presentacion.size() > 0) {
                        PresentacionInsumo del = new PresentacionInsumo();
                        del.setProducto(insumoSelected);
                        del.setTipoOperacion("e");
                        gestionPres.eliminar(del);
                        for (int i = 0; i < this.presentacion.size(); i++) {
                            PresentacionInsumo ob = this.presentacion.get(i);
                            ob.setProducto(insumoSelected);
                            ob.setTipoOperacion("i");
                            gestionPres.registrar(ob);
                        }
                        JOptionPane.showMessageDialog(null, "Actualización correcta!");
                        this.modelTableInsumos.setData(new GestionInsumo().listar());
                        this.modelTableInsumos.fireTableDataChanged();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }else{
                JOptionPane.showMessageDialog(null, "La capcidad y los precios deben ser números !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos !");
        }

    }//GEN-LAST:event_btnGuardarInsumoActionPerformed

    private void btnNuevoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlmacenActionPerformed
        // TODO add your handling code here:
        this.txtnombreinsumo.setText("");
        this.txtpreciocomprainsumo.setText("");
        this.txtprecioventainsumo.setText("");
        this.txtcapacidadinsumo.setText("");
        this.control_save = "nuevo";
        this.chkcontrolstock.setSelected(false);
        this.chkventadirecta.setSelected(false);
        this.insumoSelected = new Insumo();
        this.presentacion=new ArrayList();
        this.tablapresentacion.setData(this.presentacion);
        this.tablapresentacion.fireTableDataChanged();
    }//GEN-LAST:event_btnNuevoAlmacenActionPerformed

    private void btnEliminarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInsumoActionPerformed
        // TODO add your handling code here:
        int pos = this.tblinsumos.getSelectedRow();
        if (pos >= 0) {
            try {
                Insumo insumo=this.modelTableInsumos.getValue(pos);
                PresentacionInsumo pres=new PresentacionInsumo();
                pres.setProducto(insumo);
                pres.setTipoOperacion("e");
                pres.setIdpresentacion_compra(0);
                pres.setCantidad(0);
                pres.setNombre_presentacion("");
                pres.setUnidad("");
                String rp=new GestionPresentacionInsumo().eliminar(pres);
                //eliminamos el insumo de la tabla detalle_insumo                
                insumo.setTipoOperacion("e1");
                String r=new GestionDetalleInsumo().eliminarPorInsumo(insumo);
                //eliminamos el insumo
                insumo.setTipoOperacion("e");
                GestionInsumo gestion=new GestionInsumo();
                String rp2=gestion.eliminar(insumo);                
                JOptionPane.showMessageDialog(this,"Eliminado correctamente !");
                this.modelTableInsumos.setData(gestion.listar());
                this.modelTableInsumos.fireTableDataChanged();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelProductoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarInsumoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarNombrePro;
    private javax.swing.JButton btnEditarPresentacion;
    private javax.swing.JButton btnEliminarInsumo;
    private javax.swing.JButton btnGuardarInsumo;
    private javax.swing.JButton btnNuevoAlmacen;
    private javax.swing.JComboBox cboCuentaContable;
    private javax.swing.JComboBox cboFamilia;
    private javax.swing.JComboBox cboMonedaCompra;
    private javax.swing.JComboBox cboMonedaVenta;
    private javax.swing.JComboBox cboUnidadMedida;
    private javax.swing.JCheckBox chkcontrolstock;
    private javax.swing.JCheckBox chkventadirecta;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTable tblPresentacionCompraMuestra;
    private javax.swing.JTable tblinsumos;
    private javax.swing.JTextField txtBuscarCapacidadPro;
    private javax.swing.JTextField txtBuscarCategoriaPro;
    private javax.swing.JTextField txtBuscarCuentaPro;
    private javax.swing.JTextField txtBuscarNombrePro;
    private javax.swing.JTextField txtBuscarPrecioComPro;
    private javax.swing.JTextField txtcapacidadinsumo;
    private javax.swing.JTextField txtnombreinsumo;
    private javax.swing.JTextField txtpreciocomprainsumo;
    private javax.swing.JTextField txtprecioventainsumo;
    // End of variables declaration//GEN-END:variables
}
