/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.xtbc.Ubigeo;
import com.disfruta.gestion.logistica.GestionAlmacen;
import com.disfruta.gestion.xtbc.GestionUbigeo;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.TableRowSorter;
import resources.auxiliar.ListaUbigeo;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class PanelAlmacen extends javax.swing.JPanel {

    private resources.tablemodel.ModelTableAlmacen modelTableAlmacen;
    private Almacen beanAlmacen;
    private String control = "nuevo";
    protected TextAutoCompleter autoCompleteUbigeo;
    protected ArrayList listaAutoCompletar;
    protected Ubigeo ubigeoSelected=null;

    /**
     * Creates new form PanelAlmacen
     */
    public PanelAlmacen() {
        try {
            this.init();
            initComponents();
            this.tblAlmacen.setModel(modelTableAlmacen);
            autoCompleteUbigeo = new TextAutoCompleter(this.txtCiudad, new AutoCompleterCallback() {
                    @Override
                    public void callback(Object selectedItem) {
                        String cad=selectedItem.toString();                        
                        for (int i = 0; i < listaAutoCompletar.size(); i++) {
                            if(cad.equals(((Ubigeo)listaAutoCompletar.get(i)).getBuscar())){
                                try {
                                    ubigeoSelected=(Ubigeo)listaAutoCompletar.get(i);
                                } catch (Exception ex) {
                                    Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
            });
            autoCompleteUbigeo.addItems(this.listaAutoCompletar);
            setPadding();
            this.btnEliminarAlmacen.setEnabled(false);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(PanelAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void init() throws ClassNotFoundException, Exception {
        GestionAlmacen gestionAlmacen = new GestionAlmacen();
        modelTableAlmacen = new resources.tablemodel.ModelTableAlmacen(gestionAlmacen.listar());
        this.listaAutoCompletar = ListaUbigeo.getGetListUbigeo();
    }
    
    private void setPadding(){
        PaddingLeft.agregarpadding(this.txtNombreAlmacen);
        PaddingLeft.agregarpadding(this.txtCiudad);
        PaddingLeft.agregarpadding(this.txtTelefono);
        PaddingLeft.agregarpadding(this.txtDireccion1);
        PaddingLeft.agregarpadding(this.txtDireccion2);
    }

    private void filtrarTablaNombre(JTable tabla,resources.tablemodel.ModelTableAlmacen model){
        TableRowSorter<resources.tablemodel.ModelTableAlmacen> rowSorte=new TableRowSorter<resources.tablemodel.ModelTableAlmacen>(model);
        RowFilter<resources.tablemodel.ModelTableAlmacen,Object> r1=null;
        RowFilter<resources.tablemodel.ModelTableAlmacen,Object> r2=null;
        List<RowFilter<resources.tablemodel.ModelTableAlmacen,Object>> listaFiltros=new ArrayList();
        r1=RowFilter.regexFilter(this.txtBuscarNombre.getText(), 1);
        //r2=RowFilter.regexFilter(this.txtfechabusqueda.getText(), 2);
        listaFiltros.add(r1);
        //listaFiltros.add(r2);
        RowFilter<resources.tablemodel.ModelTableAlmacen,Object> rf=RowFilter.andFilter(listaFiltros);
        rowSorte.setRowFilter(rf);
        tabla.setRowSorter(rowSorte);
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
        jLabel1 = new javax.swing.JLabel();
        btnNuevoAlmacen = new javax.swing.JButton();
        btnGuardarAlmacen = new javax.swing.JButton();
        btnEliminarAlmacen = new javax.swing.JButton();
        chkrecepcion = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreAlmacen = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion2 = new javax.swing.JTextField();
        txtDireccion1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReferencia1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReferencia2 = new javax.swing.JTextArea();
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
        tblAlmacen = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setAlignmentY(0.0F);
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(960, 590));
        setPreferredSize(new java.awt.Dimension(960, 590));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Almacén");

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

        btnGuardarAlmacen.setBackground(new java.awt.Color(229, 147, 35));
        btnGuardarAlmacen.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardarAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAlmacen.setText("Guardar");
        btnGuardarAlmacen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardarAlmacen.setBorderPainted(false);
        btnGuardarAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarAlmacen.setFocusPainted(false);
        btnGuardarAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarAlmacen.setOpaque(false);
        btnGuardarAlmacen.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlmacenActionPerformed(evt);
            }
        });

        btnEliminarAlmacen.setBackground(new java.awt.Color(252, 242, 228));
        btnEliminarAlmacen.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnEliminarAlmacen.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminarAlmacen.setText("Eliminar");
        btnEliminarAlmacen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnEliminarAlmacen.setBorderPainted(false);
        btnEliminarAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarAlmacen.setFocusPainted(false);
        btnEliminarAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarAlmacen.setOpaque(false);
        btnEliminarAlmacen.setPreferredSize(new java.awt.Dimension(92, 30));
        btnEliminarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlmacenActionPerformed(evt);
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
                .addComponent(btnGuardarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
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
                        .addComponent(btnGuardarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chkrecepcion.setBackground(new java.awt.Color(255, 255, 255));
        chkrecepcion.setText("Recepción de mercadería externa");
        chkrecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkrecepcionActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de Almacén");

        jLabel3.setText(" Distrito/Ciudad/Departamento");

        jLabel4.setText("Teléfono(s)");

        jLabel5.setText("Dirección 1");

        jLabel6.setText("Referencia");

        jLabel7.setText("Dirección 2");

        jLabel8.setText("Referencia");

        txtNombreAlmacen.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombreAlmacen.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreAlmacen.setText("   Ejemplo: Cocina #2 - 2do piso");
        txtNombreAlmacen.setToolTipText("");
        txtNombreAlmacen.setAlignmentX(0.0F);
        txtNombreAlmacen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombreAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreAlmacen.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombreAlmacen.setName("txtusuario"); // NOI18N
        txtNombreAlmacen.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombreAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAlmacenActionPerformed(evt);
            }
        });

        txtCiudad.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCiudad.setForeground(new java.awt.Color(153, 153, 153));
        txtCiudad.setText("Ejemplo: La Victoria, Chiclayo, Lambayeque");
        txtCiudad.setToolTipText("");
        txtCiudad.setAlignmentX(0.0F);
        txtCiudad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCiudad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCiudad.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCiudad.setName("txtusuario"); // NOI18N
        txtCiudad.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setText("   Ejemplo: 074 - 254845, 074 - 254178");
        txtTelefono.setToolTipText("");
        txtTelefono.setAlignmentX(0.0F);
        txtTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtTelefono.setName("txtusuario"); // NOI18N
        txtTelefono.setPreferredSize(new java.awt.Dimension(280, 24));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtDireccion2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtDireccion2.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion2.setText("   Ejemplo: Av. Jose Balta #512 - Chiclayo");
        txtDireccion2.setToolTipText("");
        txtDireccion2.setAlignmentX(0.0F);
        txtDireccion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtDireccion2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDireccion2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtDireccion2.setName("txtusuario"); // NOI18N
        txtDireccion2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtDireccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccion2ActionPerformed(evt);
            }
        });

        txtDireccion1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtDireccion1.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion1.setText("   Ejemplo: Av. Jose Balta #511 - Chiclayo");
        txtDireccion1.setToolTipText("");
        txtDireccion1.setAlignmentX(0.0F);
        txtDireccion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtDireccion1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDireccion1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtDireccion1.setName("txtusuario"); // NOI18N
        txtDireccion1.setPreferredSize(new java.awt.Dimension(280, 24));
        txtDireccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccion1ActionPerformed(evt);
            }
        });

        txtReferencia1.setColumns(20);
        txtReferencia1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtReferencia1.setForeground(new java.awt.Color(153, 153, 153));
        txtReferencia1.setRows(3);
        txtReferencia1.setText("  Ejemplo: Espalda del Colegio Basadre...\n");
        txtReferencia1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtReferencia1.setCaretPosition(5);
        txtReferencia1.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtReferencia1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(txtReferencia1);

        txtReferencia2.setColumns(20);
        txtReferencia2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtReferencia2.setForeground(new java.awt.Color(153, 153, 153));
        txtReferencia2.setRows(3);
        txtReferencia2.setText("  Ejemplo: Espalda del Colegio Basadre...\n");
        jScrollPane2.setViewportView(txtReferencia2);

        jPanel1.setBackground(new java.awt.Color(250, 233, 211));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));

        txtBuscarNombre.setBackground(new java.awt.Color(250, 233, 211));
        txtBuscarNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarNombre.setForeground(new java.awt.Color(83, 71, 65));
        txtBuscarNombre.setText("Nombre");
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
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyReleased(evt);
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
        txtBuscarDistrito.setText("Distrito");
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
        txtBuscarTelefono.setText("Teléfono (s)");
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
        txtBuscarDireccion.setText("Dirección");
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
        txtBuscarDireccion2.setText("Otra Dirección");
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

        tblAlmacen.setForeground(new java.awt.Color(128, 128, 128));
        tblAlmacen.setModel(new javax.swing.table.DefaultTableModel(
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlmacen.setToolTipText("");
        tblAlmacen.setAlignmentX(0.0F);
        tblAlmacen.setAlignmentY(0.0F);
        tblAlmacen.setAutoscrolls(false);
        tblAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblAlmacen.setGridColor(new java.awt.Color(238, 189, 122));
        tblAlmacen.setMinimumSize(new java.awt.Dimension(900, 150));
        tblAlmacen.setRowHeight(30);
        tblAlmacen.setRowMargin(3);
        tblAlmacen.setSelectionBackground(new java.awt.Color(238, 189, 122));
        tblAlmacen.setShowHorizontalLines(false);
        tblAlmacen.setShowVerticalLines(false);
        tblAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAlmacen);
        tblAlmacen.getColumnModel().getColumn(0).setResizable(false);
        tblAlmacen.getColumnModel().getColumn(1).setResizable(false);
        tblAlmacen.getColumnModel().getColumn(2).setResizable(false);
        tblAlmacen.getColumnModel().getColumn(3).setResizable(false);
        tblAlmacen.getColumnModel().getColumn(4).setResizable(false);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkrecepcion)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(171, 171, 171)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkrecepcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkrecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkrecepcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkrecepcionActionPerformed

    private void txtNombreAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlmacenActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccion2ActionPerformed

    private void txtDireccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccion1ActionPerformed

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

    private void btnGuardarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlmacenActionPerformed
        // TODO add your handling code here:
        if(!(this.txtNombreAlmacen.getText().equals("") || !(this.txtCiudad.getText().equals("")) || !(this.txtDireccion1.getText().equals("")))){
        if (this.control.equalsIgnoreCase("nuevo")) {
            beanAlmacen = new Almacen();
            beanAlmacen.setDescripcion(this.txtNombreAlmacen.getText());
            beanAlmacen.setUbicacion(this.txtCiudad.getText());
            beanAlmacen.setTelefono(this.txtTelefono.getText());
            beanAlmacen.setDireccion1(this.txtDireccion1.getText());
            beanAlmacen.setDireccion2(this.txtDireccion2.getText());
            beanAlmacen.setReferencia1(this.txtReferencia1.getText());
            beanAlmacen.setReferencia2(this.txtReferencia2.getText());
            beanAlmacen.setTipoOperacion("i");
            if (this.chkrecepcion.isSelected() == true) {
                beanAlmacen.setRecepcion("S");
            } else {
                beanAlmacen.setRecepcion("N");
            }
            beanAlmacen.setUbigeo(ubigeoSelected);
            GestionAlmacen gestionAlmacen = new GestionAlmacen();
            String mensaje = gestionAlmacen.registrar(beanAlmacen);
            JOptionPane.showMessageDialog(null, mensaje);
        } else if (this.control.equalsIgnoreCase("modificar")) {
            beanAlmacen.setDescripcion(this.txtNombreAlmacen.getText());
            beanAlmacen.setUbicacion(this.txtCiudad.getText());
            beanAlmacen.setTelefono(this.txtTelefono.getText());
            beanAlmacen.setDireccion1(this.txtDireccion1.getText());
            beanAlmacen.setDireccion2(this.txtDireccion2.getText());
            beanAlmacen.setReferencia1(this.txtReferencia1.getText());
            beanAlmacen.setReferencia2(this.txtReferencia2.getText());
            beanAlmacen.setTipoOperacion("a");
            if (this.chkrecepcion.isSelected() == true) {
                beanAlmacen.setRecepcion("S");
            } else {
                beanAlmacen.setRecepcion("N");
            }
            beanAlmacen.setUbigeo(ubigeoSelected);
            GestionAlmacen gestionAlmacen = new GestionAlmacen();
            String mensaje = gestionAlmacen.actualizar(beanAlmacen);
            JOptionPane.showMessageDialog(null, mensaje);
        }
        try {
            modelTableAlmacen.setData(new GestionAlmacen().listar());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelTableAlmacen.fireTableDataChanged();
        }else{
            JOptionPane.showMessageDialog(this,"Debe llenar todos los campos !");
        }
    }//GEN-LAST:event_btnGuardarAlmacenActionPerformed

    private void tblAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenMouseClicked
        // TODO add your handling code here:
        int row = this.tblAlmacen.rowAtPoint(evt.getPoint());
        beanAlmacen = new Almacen();
        beanAlmacen = modelTableAlmacen.getValue(row);
        this.txtNombreAlmacen.setText(beanAlmacen.getDescripcion());
        this.txtCiudad.setText(beanAlmacen.getUbicacion());
        this.txtTelefono.setText(beanAlmacen.getTelefono());
        this.txtDireccion1.setText(beanAlmacen.getDireccion1());
        this.txtReferencia1.setText(beanAlmacen.getReferencia1());
        this.txtDireccion2.setText(beanAlmacen.getDireccion2());
        this.txtReferencia2.setText(beanAlmacen.getReferencia2());
        this.ubigeoSelected=beanAlmacen.getUbigeo();
        if (beanAlmacen.getRecepcion().equals("S")) {
            this.chkrecepcion.isSelected();
        }
        this.btnEliminarAlmacen.setEnabled(true);
        this.control = "modificar";
    }//GEN-LAST:event_tblAlmacenMouseClicked

    private void btnNuevoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlmacenActionPerformed
        // TODO add your handling code here:
        this.txtNombreAlmacen.setText("");
        this.txtCiudad.setText("");
        this.txtTelefono.setText("");
        this.txtDireccion1.setText("");
        this.txtReferencia1.setText("");
        this.txtDireccion2.setText("");
        this.txtReferencia2.setText("");
        this.chkrecepcion.isSelected();
        this.ubigeoSelected=null;
        this.btnEliminarAlmacen.setEnabled(false);
        this.control = "nuevo";
    }//GEN-LAST:event_btnNuevoAlmacenActionPerformed

    private void btnEliminarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlmacenActionPerformed
        // TODO add your handling code here:
        if (this.control.equalsIgnoreCase("modificar")) {
            GestionAlmacen gestionAlmacen = new GestionAlmacen();
            beanAlmacen.setTipoOperacion("e");
            String mensaje = gestionAlmacen.eliminar(beanAlmacen);
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }//GEN-LAST:event_btnEliminarAlmacenActionPerformed

    private void txtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyReleased
        // TODO add your handling code here:
        if (evt.getSource().equals(this.txtBuscarNombre)) {
            filtrarTablaNombre(this.tblAlmacen, modelTableAlmacen);
        }
    }//GEN-LAST:event_txtBuscarNombreKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarAlmacen;
    private javax.swing.JButton btnGuardarAlmacen;
    private javax.swing.JButton btnNuevoAlmacen;
    private javax.swing.JCheckBox chkrecepcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTable tblAlmacen;
    private javax.swing.JTextField txtBuscarDireccion;
    private javax.swing.JTextField txtBuscarDireccion2;
    private javax.swing.JTextField txtBuscarDistrito;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtBuscarTelefono;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtDireccion2;
    private javax.swing.JTextField txtNombreAlmacen;
    private javax.swing.JTextArea txtReferencia1;
    private javax.swing.JTextArea txtReferencia2;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
