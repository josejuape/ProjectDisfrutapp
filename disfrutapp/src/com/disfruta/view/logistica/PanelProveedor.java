/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.CategoriaProveedor;
import com.disfruta.bean.logistica.CuentaBancaria;
import com.disfruta.bean.logistica.EntidadBancaria;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.logistica.TipoPersona;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.gestion.logistica.GestionCategoriaProveedor;
import com.disfruta.gestion.logistica.GestionCuentaBancaria;
import com.disfruta.gestion.logistica.GestionEntidadBancaria;
import com.disfruta.gestion.logistica.GestionProveedor;
import com.disfruta.gestion.logistica.GestionTipoPersona;
import com.disfruta.gestion.xtbc.GestionMoneda;
import com.disfruta.gestion.xtbc.GestionUbigeo;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import resources.auxiliar.ListaUbigeo;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class PanelProveedor extends javax.swing.JPanel {

    protected resources.comboboxmodel.CboModelTipoPersona modelTipoPersona;
    protected resources.comboboxmodel.CboModelCategoriaProveedor modelCategoriaProveedor;
    protected resources.comboboxmodel.CboModelEntidadBancaria modelEntidadBancaria;
    protected resources.comboboxmodel.CboModelMoneda modelMoneda;
    protected resources.tablemodel.ModelTableProveedor modelTableProveedor;
    protected resources.tablemodel.ModelTableCuentaBancaria modelCuentaBancaria;
    protected Proveedor beanProveedor;
    protected String tab = "";
    protected String operacion = "";
    protected int controlTab = 0;
    protected ArrayList<CuentaBancaria> listCuentas;
    protected TextAutoCompleter autoCompleteUbigeo;
    protected ArrayList listaAutoCompletar;
    /**
     * Creates new form PanelProveedor
     */
    public PanelProveedor() {
        try {
            this.init();
            initComponents();
            this.cboTipoPersona.setModel(modelTipoPersona);
            autoCompleteUbigeo = new TextAutoCompleter(this.txtUbicacion);
            autoCompleteUbigeo.addItems(this.listaAutoCompletar);
            this.cboTipoPersona.setSelectedIndex(0);
            this.cboCategoriaProveedor.setModel(modelCategoriaProveedor);
            this.cboCategoriaProveedor.setSelectedIndex(0);
            this.cboBanco.setModel(modelEntidadBancaria);
            this.cboMoneda.setModel(modelMoneda);
            this.tblProveedor.setModel(modelTableProveedor);
            this.tblCuentaBancaria.setModel(modelCuentaBancaria);
            this.txtRuc.setEditable(false);
            this.txtNombres.setEditable(false);
            this.txtApellidos.setEditable(false);
            this.txtUbicacion.setEditable(false);
            this.txtDireccion.setEditable(false);
            this.txtReferencia.setEditable(false);
            this.txtContacto1.setEditable(false);
            this.txtContactoTelefono1.setEditable(false);
            this.txtContacto2.setEditable(false);
            this.txtContactoTelefono2.setEditable(false);
            this.txtContacto3.setEditable(false);
            this.txtContactoTelefono3.setEditable(false);
            this.btnGuardarProveedor.setEnabled(false);
            this.btnEliminarProveedor.setEnabled(false);
            this.txtNumeroCuenta.setEditable(false);
            this.txtCuentaInterbancaria.setEditable(false);

            setPadding();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void init() throws ClassNotFoundException, Exception {
        this.listaAutoCompletar = ListaUbigeo.getGetListUbigeo();
        GestionTipoPersona gestiontipopersona = new GestionTipoPersona();
        GestionCategoriaProveedor gestioncategoriaprov = new GestionCategoriaProveedor();
        GestionEntidadBancaria gestionentidad = new GestionEntidadBancaria();
        GestionMoneda gestionmoneda = new GestionMoneda();
        GestionProveedor gestionprov = new GestionProveedor();
        this.modelTipoPersona = new resources.comboboxmodel.CboModelTipoPersona(gestiontipopersona.listar());
        this.modelCategoriaProveedor = new resources.comboboxmodel.CboModelCategoriaProveedor(gestioncategoriaprov.listar());
        this.modelEntidadBancaria = new resources.comboboxmodel.CboModelEntidadBancaria(gestionentidad.listar());
        this.modelMoneda = new resources.comboboxmodel.CboModelMoneda(gestionmoneda.listar());
        this.modelTableProveedor = new resources.tablemodel.ModelTableProveedor(gestionprov.listar());
        this.modelCuentaBancaria = new resources.tablemodel.ModelTableCuentaBancaria();
    }

    private void setPadding() {
        PaddingLeft.agregarpadding(this.txtRuc);
        PaddingLeft.agregarpadding(this.txtNombres);
        PaddingLeft.agregarpadding(this.txtApellidos);
        PaddingLeft.agregarpadding(this.txtUbicacion);
        PaddingLeft.agregarpadding(this.txtDireccion);
        PaddingLeft.agregarpadding(this.txtReferencia);
        PaddingLeft.agregarpadding(this.txtContacto1);
        PaddingLeft.agregarpadding(this.txtContactoTelefono1);
        PaddingLeft.agregarpadding(this.txtContacto2);
        PaddingLeft.agregarpadding(this.txtContactoTelefono2);
        PaddingLeft.agregarpadding(this.txtContacto3);
        PaddingLeft.agregarpadding(this.txtContactoTelefono3);
        PaddingLeft.agregarpadding(this.txtNumeroCuenta);
        PaddingLeft.agregarpadding(this.txtCuentaInterbancaria);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        paneltitlealmacen = new javax.swing.JPanel();
        logoalmacen = new javax.swing.JLabel();
        tituloProveedor = new javax.swing.JLabel();
        btnNuevoProveedor = new javax.swing.JButton();
        btnGuardarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtBuscarDistrito = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtBuscarTelefono = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtBuscarDireccion = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtBuscarDireccion2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        tabPaneProveedor = new javax.swing.JTabbedPane();
        PanelInformacion = new javax.swing.JPanel();
        PanelPersonaNatural1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cboCategoriaProveedor = new javax.swing.JComboBox();
        cboTipoPersona = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtContacto3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtContacto2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtContactoTelefono3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtContactoTelefono1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtContactoTelefono2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtContacto1 = new javax.swing.JTextField();
        PanelCuentas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboBanco = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboMoneda = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCuentaInterbancaria = new javax.swing.JTextField();
        txtNumeroCuenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentaBancaria = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setAlignmentY(0.0F);
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(6, 0));
        setPreferredSize(new java.awt.Dimension(960, 590));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        tituloProveedor.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        tituloProveedor.setForeground(new java.awt.Color(255, 255, 255));
        tituloProveedor.setText("Proveedor");

        btnNuevoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoProveedor.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoProveedor.setForeground(new java.awt.Color(229, 147, 35));
        btnNuevoProveedor.setText("Nuevo");
        btnNuevoProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoProveedor.setBorderPainted(false);
        btnNuevoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProveedor.setFocusPainted(false);
        btnNuevoProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoProveedor.setOpaque(false);
        btnNuevoProveedor.setPreferredSize(new java.awt.Dimension(92, 30));
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        btnGuardarProveedor.setBackground(new java.awt.Color(252, 242, 228));
        btnGuardarProveedor.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardarProveedor.setForeground(new java.awt.Color(83, 71, 65));
        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardarProveedor.setBorderPainted(false);
        btnGuardarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProveedor.setFocusPainted(false);
        btnGuardarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarProveedor.setOpaque(false);
        btnGuardarProveedor.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setBackground(new java.awt.Color(229, 147, 35));
        btnEliminarProveedor.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnEliminarProveedor.setBorderPainted(false);
        btnEliminarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProveedor.setFocusPainted(false);
        btnEliminarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProveedor.setOpaque(false);
        btnEliminarProveedor.setPreferredSize(new java.awt.Dimension(92, 30));
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
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
                .addComponent(tituloProveedor)
                .addGap(193, 193, 193)
                .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloProveedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(250, 233, 211));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));

        txtBuscarNombre.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarNombre.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarNombre.setText("Ruc");
        txtBuscarNombre.setToolTipText("");
        txtBuscarNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarNombre.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarNombre.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });
        txtBuscarNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarNombreFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(18, 18));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtBuscarDistrito.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarDistrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarDistrito.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarDistrito.setText("Nombres");
        txtBuscarDistrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarDistrito.setMinimumSize(new java.awt.Dimension(130, 20));
        txtBuscarDistrito.setPreferredSize(new java.awt.Dimension(130, 20));
        txtBuscarDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDistritoActionPerformed(evt);
            }
        });
        txtBuscarDistrito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarDistritoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarDistritoFocusLost(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarTelefono.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarTelefono.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarTelefono.setText("Apellidos");
        txtBuscarTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarTelefono.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarTelefonoActionPerformed(evt);
            }
        });
        txtBuscarTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarTelefonoFocusLost(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarDireccion.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarDireccion.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarDireccion.setText("Categoría Empresa");
        txtBuscarDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarDireccion.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDireccionActionPerformed(evt);
            }
        });
        txtBuscarDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarDireccionFocusLost(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setPreferredSize(new java.awt.Dimension(18, 18));

        txtBuscarDireccion2.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarDireccion2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarDireccion2.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarDireccion2.setText("Dirección");
        txtBuscarDireccion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 233, 211)));
        txtBuscarDireccion2.setPreferredSize(new java.awt.Dimension(130, 17));
        txtBuscarDireccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDireccion2ActionPerformed(evt);
            }
        });
        txtBuscarDireccion2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarDireccion2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarDireccion2FocusLost(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnBuscar.jpg"))); // NOI18N
        jButton5.setToolTipText("");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setPreferredSize(new java.awt.Dimension(18, 18));

        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 220));

        tblProveedor.setForeground(new java.awt.Color(128, 128, 128));
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedor.setToolTipText("");
        tblProveedor.setAlignmentX(0.0F);
        tblProveedor.setAlignmentY(0.0F);
        tblProveedor.setAutoscrolls(false);
        tblProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProveedor.setGridColor(new java.awt.Color(204, 204, 255));
        tblProveedor.setMinimumSize(new java.awt.Dimension(900, 150));
        tblProveedor.setRowHeight(30);
        tblProveedor.setRowMargin(3);
        tblProveedor.setShowHorizontalLines(false);
        tblProveedor.setShowVerticalLines(false);
        tblProveedor.setTableHeader(null);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProveedor);
        tblProveedor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProveedor.getColumnModel().getColumn(0).setResizable(false);
        tblProveedor.getColumnModel().getColumn(1).setResizable(false);
        tblProveedor.getColumnModel().getColumn(2).setResizable(false);
        tblProveedor.getColumnModel().getColumn(3).setResizable(false);
        tblProveedor.getColumnModel().getColumn(4).setResizable(false);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(250, 233, 211));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtBuscarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBuscarDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPaneProveedor.setBackground(new java.awt.Color(238, 189, 122));
        tabPaneProveedor.setToolTipText("");
        tabPaneProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabPaneProveedor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPaneProveedorStateChanged(evt);
            }
        });

        PanelInformacion.setBackground(new java.awt.Color(255, 255, 255));

        PanelPersonaNatural1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Ruc:");

        txtRuc.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtRuc.setForeground(new java.awt.Color(153, 153, 153));
        txtRuc.setText("   Ejemplo: 11451254788");
        txtRuc.setToolTipText("");
        txtRuc.setAlignmentX(0.0F);
        txtRuc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtRuc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRuc.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtRuc.setName("txtusuario"); // NOI18N
        txtRuc.setPreferredSize(new java.awt.Dimension(280, 24));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });

        jLabel18.setText("Nombres:");

        jLabel19.setText("Apellidos:");

        jLabel20.setText("Categoría de Empresa (Sunat):");

        txtNombres.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(153, 153, 153));
        txtNombres.setText("   Ejemplo: 11451254788");
        txtNombres.setToolTipText("");
        txtNombres.setAlignmentX(0.0F);
        txtNombres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombres.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombres.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombres.setName("txtusuario"); // NOI18N
        txtNombres.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidos.setText("   Ejemplo: 11451254788");
        txtApellidos.setToolTipText("");
        txtApellidos.setAlignmentX(0.0F);
        txtApellidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtApellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApellidos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtApellidos.setName("txtusuario"); // NOI18N
        txtApellidos.setPreferredSize(new java.awt.Dimension(280, 24));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        cboCategoriaProveedor.setForeground(new java.awt.Color(153, 153, 153));
        cboCategoriaProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoría", "Item 2", "Item 3", "Item 4" }));
        cboCategoriaProveedor.setOpaque(false);

        javax.swing.GroupLayout PanelPersonaNatural1Layout = new javax.swing.GroupLayout(PanelPersonaNatural1);
        PanelPersonaNatural1.setLayout(PanelPersonaNatural1Layout);
        PanelPersonaNatural1Layout.setHorizontalGroup(
            PanelPersonaNatural1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPersonaNatural1Layout.createSequentialGroup()
                .addGroup(PanelPersonaNatural1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(cboCategoriaProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPersonaNatural1Layout.setVerticalGroup(
            PanelPersonaNatural1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonaNatural1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCategoriaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboTipoPersona.setForeground(new java.awt.Color(153, 153, 153));
        cboTipoPersona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un tipo de persona", "Persona Natural", "Persona Juridica" }));
        cboTipoPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setText("Tipo de persona:");

        txtContacto3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContacto3.setForeground(new java.awt.Color(153, 153, 153));
        txtContacto3.setText("   Nombres y Apellidos contacto 3");
        txtContacto3.setToolTipText("");
        txtContacto3.setAlignmentX(0.0F);
        txtContacto3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContacto3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContacto3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContacto3.setName("txtusuario"); // NOI18N
        txtContacto3.setPreferredSize(new java.awt.Dimension(280, 24));

        jLabel21.setText("Contacto 3:");

        txtContacto2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContacto2.setForeground(new java.awt.Color(153, 153, 153));
        txtContacto2.setText("   Nombres y Apellidos contacto 2");
        txtContacto2.setToolTipText("");
        txtContacto2.setAlignmentX(0.0F);
        txtContacto2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContacto2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContacto2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContacto2.setName("txtusuario"); // NOI18N
        txtContacto2.setPreferredSize(new java.awt.Dimension(280, 24));

        jLabel22.setText("Contacto 2:");

        txtDireccion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("   Nombres y Apellidos contacto 1");
        txtDireccion.setToolTipText("");
        txtDireccion.setAlignmentX(0.0F);
        txtDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDireccion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtDireccion.setName("txtusuario"); // NOI18N
        txtDireccion.setPreferredSize(new java.awt.Dimension(280, 24));

        jLabel23.setText("Contacto 1:");

        txtReferencia.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtReferencia.setForeground(new java.awt.Color(153, 153, 153));
        txtReferencia.setText("   Ejemplo: Espalda de Iglesia La Consolación");
        txtReferencia.setToolTipText("");
        txtReferencia.setAlignmentX(0.0F);
        txtReferencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtReferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtReferencia.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtReferencia.setMaximumSize(new java.awt.Dimension(2147483590, 2147483647));
        txtReferencia.setMinimumSize(new java.awt.Dimension(590, 20));
        txtReferencia.setName("txtusuario"); // NOI18N
        txtReferencia.setPreferredSize(new java.awt.Dimension(590, 24));
        txtReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReferenciaActionPerformed(evt);
            }
        });

        jLabel24.setText("Referencia:");

        txtUbicacion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtUbicacion.setForeground(new java.awt.Color(153, 153, 153));
        txtUbicacion.setText("   Ejemplo: Sta Victoria - Chiclayo");
        txtUbicacion.setToolTipText("");
        txtUbicacion.setAlignmentX(0.0F);
        txtUbicacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtUbicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUbicacion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtUbicacion.setName("txtusuario"); // NOI18N
        txtUbicacion.setPreferredSize(new java.awt.Dimension(280, 24));
        txtUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionActionPerformed(evt);
            }
        });

        jLabel25.setText("Ciudad/ Distrito");

        jLabel26.setText("Dirección:");

        txtContactoTelefono3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContactoTelefono3.setForeground(new java.awt.Color(153, 153, 153));
        txtContactoTelefono3.setText("   Ejemplo: Av. Jose Balta #512 - Chiclayo");
        txtContactoTelefono3.setToolTipText("");
        txtContactoTelefono3.setAlignmentX(0.0F);
        txtContactoTelefono3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContactoTelefono3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContactoTelefono3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContactoTelefono3.setName("txtusuario"); // NOI18N
        txtContactoTelefono3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtContactoTelefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoTelefono3ActionPerformed(evt);
            }
        });

        jLabel27.setText("Teléfono (s) - Contacto 1");

        txtContactoTelefono1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContactoTelefono1.setForeground(new java.awt.Color(153, 153, 153));
        txtContactoTelefono1.setText("   Ejemplo: 074 - 254841, 074 - 568413. ...");
        txtContactoTelefono1.setToolTipText("");
        txtContactoTelefono1.setAlignmentX(0.0F);
        txtContactoTelefono1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContactoTelefono1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContactoTelefono1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContactoTelefono1.setName("txtusuario"); // NOI18N
        txtContactoTelefono1.setPreferredSize(new java.awt.Dimension(280, 24));
        txtContactoTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoTelefono1ActionPerformed(evt);
            }
        });

        jLabel28.setText("Teléfono (s) - Contacto 2");

        txtContactoTelefono2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContactoTelefono2.setForeground(new java.awt.Color(153, 153, 153));
        txtContactoTelefono2.setText("   Ejemplo: 074 - 254841, 074 - 568413. ...");
        txtContactoTelefono2.setToolTipText("");
        txtContactoTelefono2.setAlignmentX(0.0F);
        txtContactoTelefono2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContactoTelefono2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContactoTelefono2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContactoTelefono2.setName("txtusuario"); // NOI18N
        txtContactoTelefono2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtContactoTelefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoTelefono2ActionPerformed(evt);
            }
        });

        jLabel29.setText("Teléfono (s) - Contacto 3");

        txtContacto1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtContacto1.setForeground(new java.awt.Color(153, 153, 153));
        txtContacto1.setText("   Ejemplo: 074 - 254841, 074 - 568413. ...");
        txtContacto1.setToolTipText("");
        txtContacto1.setAlignmentX(0.0F);
        txtContacto1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtContacto1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContacto1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContacto1.setName("txtusuario"); // NOI18N
        txtContacto1.setPreferredSize(new java.awt.Dimension(280, 24));
        txtContacto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContacto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInformacionLayout = new javax.swing.GroupLayout(PanelInformacion);
        PanelInformacion.setLayout(PanelInformacionLayout);
        PanelInformacionLayout.setHorizontalGroup(
            PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformacionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PanelPersonaNatural1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformacionLayout.createSequentialGroup()
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24))
                        .addGap(28, 28, 28)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInformacionLayout.createSequentialGroup()
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContacto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(txtContacto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtContacto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtContactoTelefono3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtContactoTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtContactoTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(871, Short.MAX_VALUE))
        );
        PanelInformacionLayout.setVerticalGroup(
            PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelInformacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInformacionLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addGap(1, 1, 1)
                                .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContacto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactoTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addGap(6, 6, 6)))
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContactoTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContacto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContacto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactoTelefono3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(PanelInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelPersonaNatural1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabPaneProveedor.addTab("Información personal", PanelInformacion);

        PanelCuentas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Entidad bancaria:");

        cboBanco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione banco", "Item 2", "Item 3", "Item 4" }));
        cboBanco.setPreferredSize(new java.awt.Dimension(180, 20));

        jLabel4.setText("Tipo de moneda:");

        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione moneda", "Item 2", "Item 3", "Item 4" }));
        cboMoneda.setMinimumSize(new java.awt.Dimension(180, 20));
        cboMoneda.setPreferredSize(new java.awt.Dimension(180, 20));

        jLabel5.setText("Número de cuenta:");

        jLabel6.setText("Nº de cuenta Interbancaria:");

        txtCuentaInterbancaria.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCuentaInterbancaria.setForeground(new java.awt.Color(153, 153, 153));
        txtCuentaInterbancaria.setText("   Ejemplo: 11451254788");
        txtCuentaInterbancaria.setToolTipText("");
        txtCuentaInterbancaria.setAlignmentX(0.0F);
        txtCuentaInterbancaria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCuentaInterbancaria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCuentaInterbancaria.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCuentaInterbancaria.setName("txtusuario"); // NOI18N
        txtCuentaInterbancaria.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCuentaInterbancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaInterbancariaActionPerformed(evt);
            }
        });

        txtNumeroCuenta.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroCuenta.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroCuenta.setText("   Ejemplo: 11451254788");
        txtNumeroCuenta.setToolTipText("");
        txtNumeroCuenta.setAlignmentX(0.0F);
        txtNumeroCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroCuenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroCuenta.setName("txtusuario"); // NOI18N
        txtNumeroCuenta.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaActionPerformed(evt);
            }
        });

        tblCuentaBancaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Entidad bancaria", "Tipo de moneda", "Número de cuenta", "Número de cuenta interbancaria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentaBancaria.setAutoscrolls(false);
        tblCuentaBancaria.setMinimumSize(new java.awt.Dimension(800, 150));
        tblCuentaBancaria.setName(""); // NOI18N
        tblCuentaBancaria.setPreferredSize(new java.awt.Dimension(800, 150));
        tblCuentaBancaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentaBancariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCuentaBancaria);
        tblCuentaBancaria.getColumnModel().getColumn(0).setResizable(false);
        tblCuentaBancaria.getColumnModel().getColumn(1).setResizable(false);
        tblCuentaBancaria.getColumnModel().getColumn(2).setResizable(false);
        tblCuentaBancaria.getColumnModel().getColumn(3).setResizable(false);

        javax.swing.GroupLayout PanelCuentasLayout = new javax.swing.GroupLayout(PanelCuentas);
        PanelCuentas.setLayout(PanelCuentasLayout);
        PanelCuentasLayout.setHorizontalGroup(
            PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCuentasLayout.createSequentialGroup()
                        .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuentaInterbancaria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(969, Short.MAX_VALUE))
        );
        PanelCuentasLayout.setVerticalGroup(
            PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuentaInterbancaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabPaneProveedor.addTab("Cuentas bancarias", PanelCuentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneltitlealmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 1809, Short.MAX_VALUE)
                    .addComponent(tabPaneProveedor))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPaneProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtBuscarDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDistritoActionPerformed

    private void txtBuscarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarTelefonoActionPerformed

    private void txtBuscarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDireccionActionPerformed

    private void txtBuscarDireccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDireccion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDireccion2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarDistritoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDistritoFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarDistrito);
    }//GEN-LAST:event_txtBuscarDistritoFocusGained

    private void txtBuscarDistritoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDistritoFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarDistrito, "Distrito");
    }//GEN-LAST:event_txtBuscarDistritoFocusLost

    private void txtBuscarNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarNombre);
    }//GEN-LAST:event_txtBuscarNombreFocusGained

    private void txtBuscarNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarNombre, "Nombre");
    }//GEN-LAST:event_txtBuscarNombreFocusLost

    private void txtBuscarTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarTelefonoFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarTelefono);
    }//GEN-LAST:event_txtBuscarTelefonoFocusGained

    private void txtBuscarTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarTelefonoFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarTelefono, "Teléfono (s)");
    }//GEN-LAST:event_txtBuscarTelefonoFocusLost

    private void txtBuscarDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDireccionFocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarDireccion);
    }//GEN-LAST:event_txtBuscarDireccionFocusGained

    private void txtBuscarDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDireccionFocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarDireccion, "Dirección");
    }//GEN-LAST:event_txtBuscarDireccionFocusLost

    private void txtBuscarDireccion2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDireccion2FocusGained
        // TODO add your handling code here:
        activarCajaBuscar(this.txtBuscarDireccion2);
    }//GEN-LAST:event_txtBuscarDireccion2FocusGained

    private void txtBuscarDireccion2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarDireccion2FocusLost
        // TODO add your handling code here:
        desactivarCajaBuscar(this.txtBuscarDireccion2, "Otra Dirección");
    }//GEN-LAST:event_txtBuscarDireccion2FocusLost

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReferenciaActionPerformed

    private void txtUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionActionPerformed

    private void txtContactoTelefono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoTelefono3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoTelefono3ActionPerformed

    private void txtContactoTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoTelefono1ActionPerformed

    private void txtContactoTelefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoTelefono2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoTelefono2ActionPerformed

    private void txtContacto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContacto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContacto1ActionPerformed

    private void txtCuentaInterbancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaInterbancariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaInterbancariaActionPerformed

    private void txtNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaActionPerformed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        // TODO add your handling code here:
        int row = this.tblProveedor.rowAtPoint(evt.getPoint());
        beanProveedor = new Proveedor();
        beanProveedor = modelTableProveedor.getValue(row);

        GestionCuentaBancaria gestioncuenta = new GestionCuentaBancaria();
        try {
            this.listCuentas = gestioncuenta.listarCuentaUsuario(beanProveedor);
            this.modelCuentaBancaria = new resources.tablemodel.ModelTableCuentaBancaria(this.listCuentas);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.txtRuc.setText(beanProveedor.getRuc());
        this.txtNombres.setText(beanProveedor.getNombres());
        this.txtApellidos.setText(beanProveedor.getApellidos());
        this.txtUbicacion.setText(beanProveedor.getUbicacion());
        this.txtDireccion.setText(beanProveedor.getDireccion());
        this.txtReferencia.setText(beanProveedor.getReferencia());
        this.txtContacto1.setText(beanProveedor.getContacto1());
        this.txtContactoTelefono1.setText(beanProveedor.getTelf_contacto1());
        this.txtContacto2.setText(beanProveedor.getContacto2());
        this.txtContactoTelefono2.setText(beanProveedor.getTelf_contacto2());
        this.txtContacto3.setText(beanProveedor.getContacto3());
        this.txtContactoTelefono3.setText(beanProveedor.getTelf_contacto3());

        this.cboCategoriaProveedor.setSelectedItem(beanProveedor.getCategoria());
        this.cboTipoPersona.setSelectedItem(beanProveedor.getTipopersona());
        this.tblCuentaBancaria.setModel(modelCuentaBancaria);

        this.txtRuc.setEditable(true);
        this.txtNombres.setEditable(true);
        this.txtApellidos.setEditable(true);
        this.txtUbicacion.setEditable(true);
        this.txtDireccion.setEditable(true);
        this.txtReferencia.setEditable(true);
        this.txtContacto1.setEditable(true);
        this.txtContactoTelefono1.setEditable(true);
        this.txtContacto2.setEditable(true);
        this.txtContactoTelefono2.setEditable(true);
        this.txtContacto3.setEditable(true);
        this.txtContactoTelefono3.setEditable(true);
        if (this.tab.equals("proveedor")) {
            this.btnGuardarProveedor.setEnabled(true);
            this.btnEliminarProveedor.setEnabled(true);
            this.btnGuardarProveedor.setText("Actualizar");
            this.operacion = "modificar";
        }
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void tblCuentaBancariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentaBancariaMouseClicked
        // TODO add your handling code here:

        int row = this.tblCuentaBancaria.rowAtPoint(evt.getPoint());
        if(row>=0){
        CuentaBancaria beancuenta = modelCuentaBancaria.getValue(row);
        this.txtNumeroCuenta.setText(beancuenta.getNumerocuenta());
        this.txtCuentaInterbancaria.setText(beancuenta.getCuentainterbancaria());
        this.cboBanco.setSelectedItem(beancuenta.getEntidad().getNombre());
        this.cboMoneda.setSelectedItem(beancuenta.getMoneda().getV_moneda());
        this.btnGuardarProveedor.setText("Actualizar");
        this.txtNumeroCuenta.setEditable(true);
        this.txtCuentaInterbancaria.setEditable(true);
        this.operacion = "modificar";
        }
    }//GEN-LAST:event_tblCuentaBancariaMouseClicked

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        // TODO add your handling code here:
        if (this.tab.equals("proveedor")) {
            if (this.operacion.equals("nuevo")) {
                beanProveedor = new Proveedor();
                beanProveedor.setTipoOperacion("i");
            } else if (this.operacion.equals("modificar")) {
                beanProveedor.setTipoOperacion("a");
            }
            beanProveedor.setRuc(this.txtRuc.getText());
            beanProveedor.setNombres(this.txtNombres.getText());
            beanProveedor.setApellidos(this.txtApellidos.getText());
            beanProveedor.setUbicacion(this.txtUbicacion.getText());
            beanProveedor.setDireccion(this.txtDireccion.getText());
            beanProveedor.setReferencia(this.txtReferencia.getText());
            beanProveedor.setContacto1(this.txtContacto1.getText());
            beanProveedor.setContacto2(this.txtContacto2.getText());
            beanProveedor.setContacto3(this.txtContacto3.getText());
            beanProveedor.setTelf_contacto1(this.txtContactoTelefono1.getText());
            beanProveedor.setTelf_contacto2(this.txtContactoTelefono2.getText());
            beanProveedor.setTelf_contacto3(this.txtContactoTelefono3.getText());
            int tipo = this.cboTipoPersona.getSelectedIndex();
            int categoria = this.cboCategoriaProveedor.getSelectedIndex();
            beanProveedor.setTipopersona((TipoPersona) this.modelTipoPersona.getElement(tipo));
            beanProveedor.setCategoria((CategoriaProveedor) this.modelCategoriaProveedor.getElement(categoria));

            GestionProveedor gestionProv = new GestionProveedor();
            if (this.operacion.equals("nuevo")) {
                String rp = gestionProv.registrar(beanProveedor);
                JOptionPane.showMessageDialog(this, rp);
            } else if (this.operacion.equals("modificar")) {
                String rp = gestionProv.actualizar(beanProveedor);
                JOptionPane.showMessageDialog(this, rp);
            }

            try {
                this.modelTableProveedor.setData(gestionProv.listar());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.modelTableProveedor.fireTableDataChanged();
            this.txtRuc.setText("");
            this.txtNombres.setText("");
            this.txtApellidos.setText("");
            this.txtUbicacion.setText("");
            this.txtDireccion.setText("");
            this.txtReferencia.setText("");
            this.txtContacto1.setText("");
            this.txtContactoTelefono1.setText("");
            this.txtContacto2.setText("");
            this.txtContactoTelefono2.setText("");
            this.txtContacto3.setText("");
            this.txtContactoTelefono3.setText("");
            this.btnGuardarProveedor.setEnabled(false);
        } else if (this.tab.equals("cuenta")) {
            if (this.operacion.equals("nuevo")) {
                try {
                    int prov = this.tblProveedor.getSelectedRow();
                    if (prov != -1) {
                        if(!(this.txtNumeroCuenta.getText().equals("")) && !(this.txtCuentaInterbancaria.getText().equals("")) && this.cboBanco.getSelectedIndex()>=0 && this.cboMoneda.getSelectedIndex()>=0){
                        Proveedor objprov = this.modelTableProveedor.getValue(prov);
                        int posentidad = this.cboBanco.getSelectedIndex();
                        EntidadBancaria entidad = this.modelEntidadBancaria.getElement(posentidad);
                        int posmoneda = this.cboMoneda.getSelectedIndex();
                        Moneda moneda = this.modelMoneda.getElement(posmoneda);
                        CuentaBancaria cuentabc = new CuentaBancaria();
                        cuentabc.setNumerocuenta(this.txtNumeroCuenta.getText());
                        cuentabc.setCuentainterbancaria(this.txtCuentaInterbancaria.getText());
                        cuentabc.setEntidad(entidad);
                        cuentabc.setMoneda(moneda);
                        cuentabc.setProveedor(objprov);
                        cuentabc.setTipoOperacion("i");
                        GestionCuentaBancaria gc = new GestionCuentaBancaria();
                        String r = gc.registrar(cuentabc);
                        JOptionPane.showMessageDialog(this, r);
                        this.modelCuentaBancaria.setData(gc.listarCuentaUsuario(objprov));
                        this.modelCuentaBancaria.fireTableDataChanged();
                        this.txtNumeroCuenta.setText("");
                        this.txtCuentaInterbancaria.setText("");
                        }else{
                            JOptionPane.showMessageDialog(this, "Llene todos los campos!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione un proveedor!");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.operacion.equals("modificar")) {
                try {
                    int prov = this.tblProveedor.getSelectedRow();
                    if (prov != -1) {
                        Proveedor objprov = this.modelTableProveedor.getValue(prov);
                        int posentidad = this.cboBanco.getSelectedIndex();
                        EntidadBancaria entidad = this.modelEntidadBancaria.getElement(posentidad);
                        int posmoneda = this.cboMoneda.getSelectedIndex();
                        Moneda moneda = this.modelMoneda.getElement(posmoneda);
                        int indexcuenta = this.tblCuentaBancaria.getSelectedRow();
                        CuentaBancaria cuentabc = this.modelCuentaBancaria.getValue(indexcuenta);
                        cuentabc.setNumerocuenta(this.txtNumeroCuenta.getText());
                        cuentabc.setCuentainterbancaria(this.txtCuentaInterbancaria.getText());
                        cuentabc.setEntidad(entidad);
                        cuentabc.setMoneda(moneda);
                        cuentabc.setProveedor(objprov);
                        cuentabc.setTipoOperacion("a");
                        GestionCuentaBancaria gc = new GestionCuentaBancaria();
                        String r = gc.actualizar(cuentabc);
                        JOptionPane.showMessageDialog(this, r);
                        this.modelCuentaBancaria.setData(gc.listarCuentaUsuario(objprov));
                        this.modelCuentaBancaria.fireTableDataChanged();
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione un proveedor!");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
        if (this.tab.equals("proveedor")) {
            this.txtRuc.setEditable(true);
            this.txtNombres.setEditable(true);
            this.txtApellidos.setEditable(true);
            this.txtUbicacion.setEditable(true);
            this.txtDireccion.setEditable(true);
            this.txtReferencia.setEditable(true);
            this.txtContacto1.setEditable(true);
            this.txtContactoTelefono1.setEditable(true);
            this.txtContacto2.setEditable(true);
            this.txtContactoTelefono2.setEditable(true);
            this.txtContacto3.setEditable(true);
            this.txtContactoTelefono3.setEditable(true);

        } else if (this.tab.equals("cuenta")) {
            this.txtNumeroCuenta.setEditable(true);
            this.txtCuentaInterbancaria.setEditable(true);
        }
        this.btnGuardarProveedor.setEnabled(true);
        this.operacion = "nuevo";
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void tabPaneProveedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPaneProveedorStateChanged
        // TODO add your handling code here:
        if (controlTab == 0) {
            controlTab = 1;
            tab = "proveedor";
            this.tituloProveedor.setText("Registro de Proveedor");
        } else if (controlTab == 1) {
            controlTab = 0;
            tab = "cuenta";
            this.tituloProveedor.setText("Registro de Cuentas Bancarias de Proveedor");
        }
    }//GEN-LAST:event_tabPaneProveedorStateChanged

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:

        if (this.tab.equals("proveedor")) {
            int pos = this.tblProveedor.getSelectedRow();
            Proveedor prov = this.modelTableProveedor.getValue(pos);
            prov.setTipoOperacion("e");
            GestionProveedor gp = new GestionProveedor();
            String r = gp.eliminar(prov);
            try {
                this.modelTableProveedor.setData(gp.listar());
                this.modelCuentaBancaria.setData(new ArrayList());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.modelTableProveedor.fireTableDataChanged();
            this.modelCuentaBancaria.fireTableDataChanged();
            this.txtRuc.setText("");
            this.txtNombres.setText("");
            this.txtApellidos.setText("");
            this.txtUbicacion.setText("");
            this.txtDireccion.setText("");
            this.txtReferencia.setText("");
            this.txtContacto1.setText("");
            this.txtContactoTelefono1.setText("");
            this.txtContacto2.setText("");
            this.txtContactoTelefono2.setText("");
            this.txtContacto3.setText("");
            this.txtContactoTelefono3.setText("");
            this.btnGuardarProveedor.setEnabled(false);
            this.btnEliminarProveedor.setEnabled(false);
            JOptionPane.showMessageDialog(this, r);

        } else if (this.tab.equals("cuenta")) {
            int pos = this.tblProveedor.getSelectedRow();
            Proveedor prov = this.modelTableProveedor.getValue(pos);
            int posct = this.tblCuentaBancaria.getSelectedRow();
            CuentaBancaria cuenta = this.modelCuentaBancaria.getValue(posct);
            cuenta.setProveedor(prov);
            cuenta.setTipoOperacion("e");
            GestionCuentaBancaria gcb = new GestionCuentaBancaria();
            gcb.eliminar(cuenta);
            this.txtNumeroCuenta.setText("");
            this.txtCuentaInterbancaria.setText("");
            this.btnGuardarProveedor.setEnabled(false);
            this.btnEliminarProveedor.setEnabled(false);
            try {
                this.modelCuentaBancaria.setData(gcb.listarCuentaUsuario(prov));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.modelCuentaBancaria.fireTableDataChanged();
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCuentas;
    private javax.swing.JPanel PanelInformacion;
    private javax.swing.JPanel PanelPersonaNatural1;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JComboBox cboBanco;
    private javax.swing.JComboBox cboCategoriaProveedor;
    private javax.swing.JComboBox cboMoneda;
    private javax.swing.JComboBox cboTipoPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTabbedPane tabPaneProveedor;
    private javax.swing.JTable tblCuentaBancaria;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JLabel tituloProveedor;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscarDireccion;
    private javax.swing.JTextField txtBuscarDireccion2;
    private javax.swing.JTextField txtBuscarDistrito;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtBuscarTelefono;
    private javax.swing.JTextField txtContacto1;
    private javax.swing.JTextField txtContacto2;
    private javax.swing.JTextField txtContacto3;
    private javax.swing.JTextField txtContactoTelefono1;
    private javax.swing.JTextField txtContactoTelefono2;
    private javax.swing.JTextField txtContactoTelefono3;
    private javax.swing.JTextField txtCuentaInterbancaria;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
