/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.admin;

import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.gestion.admin.GestionMenu;
import com.disfruta.gestion.admin.GestionMenuPerfil;
import com.disfruta.gestion.admin.GestionPerfilUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author user
 */
public class PanelPerfilUsuario extends javax.swing.JPanel {
    
    protected resources.tablemodel.ModelTablePerfilUsuario modelTablePerfilUser;
    private ArrayList<Menu> lista;
    private ArrayList<Menu> itemsMenuSelect = new ArrayList<>();
    protected DefaultTreeModel modelo = null;
    private CheckTreeManager checkTreeManager = null;
    private String control = "nuevo";

    /**
     * Creates new form PanelPerfilUsuario
     */
    public PanelPerfilUsuario() throws ClassNotFoundException, Exception {
        init();
        initComponents();
        this.tblPerfiles.setModel(modelTablePerfilUser);
        cargarPermisos(null);
        PaddingLeft.agregarpadding(txtDescripcionPerfil);
        this.cboEstado.setBackground(Color.WHITE);
    }
    
    private void init() {
        try {
            modelTablePerfilUser = new resources.tablemodel.ModelTablePerfilUsuario(new GestionPerfilUsuario().listar());
            lista = new ArrayList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarPermisos(ArrayList<Menu> permisosUser) throws ClassNotFoundException, Exception {
        if (permisosUser != null) {
            System.out.println("size permisos: " + permisosUser.size());
        }
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Opciones de Menu");
        GestionMenu gm = new GestionMenu();
        lista = gm.listar();
        for (com.disfruta.bean.admin.Menu menu : lista) {
            if (menu.getNodo() == menu.getNodopadre()) {
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
                String des = menu.getDescripcion();
                nodo.setUserObject(des);
                for (com.disfruta.bean.admin.Menu item : lista) {
                    if (item.getNodopadre() == menu.getNodo() && item.getNodo() != item.getNodopadre()) {
                        DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode();
                        String des2 = item.getDescripcion();
                        nodo1.setUserObject(des2);
                        for (com.disfruta.bean.admin.Menu item2 : lista) {
                            if (item2.getNodopadre() == item.getNodo() && item2.getNodo() != item2.getNodopadre()) {
                                DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode();
                                System.out.println("iditem: " + item2.getId());
                                boolean control = true;
                                if (permisosUser != null && permisosUser.size() > 0) {
                                    for (int i = 0; i < permisosUser.size(); i++) {
                                        Menu itemmenu = permisosUser.get(i);
                                        if (itemmenu.getId() == item2.getId()) {
                                            control = false;
                                            break;
                                        }
                                    }
                                }
                                String des3 = item2.getDescripcion();
                                if (control) {
                                    nodo2.setUserObject(des3);
                                } else {
                                    System.out.println("iditem Selected: " + item2.getId());
                                    nodo2.setUserObject(des3);
                                }
                                nodo1.add(nodo2);
                            }
                        }
                        nodo.add(nodo1);
                    }
                }
                raiz.add(nodo);
            }
        }
        
        this.modelo = new DefaultTreeModel(raiz);
        this.permisosTree.setModel(modelo);
        this.checkTreeManager = new CheckTreeManager(this.permisosTree);
    }

//    private void cargarPermisos(ArrayList<Menu> permisosUser) throws ClassNotFoundException, Exception {
//        if (permisosUser != null) {
//            System.out.println("size permisos: " + permisosUser.size());
//        }
//        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Opciones de Menu");
//        GestionMenu gm = new GestionMenu();
//        lista = gm.listar();
//        for (com.disfruta.bean.admin.Menu menu : lista) {
//            if (menu.getNodo() == menu.getNodopadre()) {
//                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
//                String des = menu.getDescripcion();
//                nodo.setUserObject(new CheckBoxNode(des, Status.SELECTED));
//                for (com.disfruta.bean.admin.Menu item : lista) {
//                    if (item.getNodopadre() == menu.getNodo() && item.getNodo() != item.getNodopadre()) {
//                        DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode();
//                        String des2 = item.getDescripcion();
//                        nodo1.setUserObject(new CheckBoxNode(des2, Status.SELECTED));
//                        for (com.disfruta.bean.admin.Menu item2 : lista) {
//                            if (item2.getNodopadre() == item.getNodo() && item2.getNodo() != item2.getNodopadre()) {
//                                DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode();
//                                System.out.println("iditem: " + item2.getId());
//                                boolean control = true;
//                                if (permisosUser != null && permisosUser.size() > 0) {
//                                    for (int i = 0; i < permisosUser.size(); i++) {
//                                        Menu itemmenu = permisosUser.get(i);
//                                        if (itemmenu.getId() == item2.getId()) {
//                                            control = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                                String des3 = item2.getDescripcion();
//                                if (control) {
//                                    nodo2.setUserObject(new CheckBoxNode(des3, Status.DESELECTED));
//                                } else {
//                                    System.out.println("iditem Selected: " + item2.getId());
//                                    nodo2.setUserObject(new CheckBoxNode(des3, Status.SELECTED));
//                                }
//                                nodo1.add(nodo2);
//                            }
//                        }
//                        nodo.add(nodo1);
//                    }
//                }
//                raiz.add(nodo);
//            }
//        }
//
//        this.modelo = new DefaultTreeModel(raiz);
//        this.permisosTree.setModel(modelo);
//        checkTreeManager = new CheckTreeManager(this.permisosTree);
//    }
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
        btnNuevoUsuario = new javax.swing.JButton();
        btnGuardarUsuario = new javax.swing.JButton();
        btnEliminarPerfil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcionPerfil = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPerfiles = new javax.swing.JTable();
        permisosTree = new javax.swing.JTree();

        setBackground(new java.awt.Color(255, 255, 255));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Perfil de usuario");

        btnNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoUsuario.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoUsuario.setForeground(new java.awt.Color(229, 147, 35));
        btnNuevoUsuario.setText("Nuevo");
        btnNuevoUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoUsuario.setBorderPainted(false);
        btnNuevoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoUsuario.setFocusPainted(false);
        btnNuevoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoUsuario.setOpaque(false);
        btnNuevoUsuario.setPreferredSize(new java.awt.Dimension(92, 30));
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnGuardarUsuario.setBackground(new java.awt.Color(252, 242, 228));
        btnGuardarUsuario.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnGuardarUsuario.setForeground(new java.awt.Color(83, 71, 65));
        btnGuardarUsuario.setText("Guardar");
        btnGuardarUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnGuardarUsuario.setBorderPainted(false);
        btnGuardarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarUsuario.setFocusPainted(false);
        btnGuardarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarUsuario.setOpaque(false);
        btnGuardarUsuario.setPreferredSize(new java.awt.Dimension(92, 30));
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarPerfil.setBackground(new java.awt.Color(229, 147, 35));
        btnEliminarPerfil.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnEliminarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPerfil.setText("Eliminar");
        btnEliminarPerfil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnEliminarPerfil.setBorderPainted(false);
        btnEliminarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarPerfil.setFocusPainted(false);
        btnEliminarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarPerfil.setOpaque(false);
        btnEliminarPerfil.setPreferredSize(new java.awt.Dimension(92, 30));
        btnEliminarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPerfilActionPerformed(evt);
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
                .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
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
                        .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Descripción:");

        txtDescripcionPerfil.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtDescripcionPerfil.setToolTipText("");
        txtDescripcionPerfil.setAlignmentX(0.0F);
        txtDescripcionPerfil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtDescripcionPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescripcionPerfil.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtDescripcionPerfil.setName("txtusuario"); // NOI18N
        txtDescripcionPerfil.setPreferredSize(new java.awt.Dimension(280, 24));
        txtDescripcionPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionPerfilActionPerformed(evt);
            }
        });

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Desactivo" }));

        jLabel3.setText("Estado:");

        tblPerfiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPerfiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPerfiles.setSelectionBackground(new java.awt.Color(238, 189, 122));
        tblPerfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerfilesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPerfiles);

        permisosTree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        permisosTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permisosTreeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitlealmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescripcionPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(58, 58, 58))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(permisosTree, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcionPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(permisosTree, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        this.txtDescripcionPerfil.setText("");
        this.cboEstado.setSelectedIndex(0);
        this.control = "nuevo";
        this.itemsMenuSelect = new ArrayList();
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed
    
    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        try {
            // TODO add your handling code here:
            String cad = this.txtDescripcionPerfil.getText();
            if (!(cad.equals(""))) {
                TreePath checkedPaths[] = checkTreeManager.getSelectionModel().getSelectionPaths();
                for (int i = 0; i < checkedPaths.length; i++) {
                    Object items[] = checkedPaths[i].getPath();
                    for (int j = 0; j < items.length; j++) {
                        String name = items[j].toString();
                        for (int k = 0; k < lista.size(); k++) {
                            if (name.equals(lista.get(k).getDescripcion())) {
                                Menu menu = lista.get(k);
                                if (itemsMenuSelect.contains(menu)) {
                                    System.out.println("ya esta en lista !");
                                } else {
                                    System.out.println("item seleccionado: " + menu.getDescripcion());
                                    itemsMenuSelect.add(menu);
                                }
                            }
                        }
                    }
                }
                
                if (this.control.equals("nuevo")) {
                    GestionPerfilUsuario gestion = new GestionPerfilUsuario();
                    PerfilUsuario perfil = new PerfilUsuario();
                    perfil.setIdprefil(0);
                    perfil.setDescripcion(this.txtDescripcionPerfil.getText());
                    if (this.cboEstado.getSelectedIndex() == 0) {
                        perfil.setEstado("A");
                    } else {
                        perfil.setEstado("D");
                    }
                    perfil.setTipoOperacion("i");
                    gestion.registrar(perfil);
                    
                    
                    PerfilUsuario ultimoPerfil = gestion.getUltimoObject();
                    GestionMenuPerfil gm = new GestionMenuPerfil();
                    for (int i = 0; i < this.itemsMenuSelect.size(); i++) {
                        MenuPerfil menuPerfil = new MenuPerfil();
                        menuPerfil.setPerfil(ultimoPerfil);
                        menuPerfil.setMenu(this.itemsMenuSelect.get(i));
                        menuPerfil.setVisible("S");
                        menuPerfil.setEstado("A");
                        menuPerfil.setTipoOperacion("i");
                        gm.registrarMenu(menuPerfil);
                    }
                    
                    JOptionPane.showMessageDialog(this, "Registrado Correctamente !");
                } else if (this.control.equals("modificar")) {
                    GestionPerfilUsuario gestion = new GestionPerfilUsuario();
                    PerfilUsuario perfil = this.modelTablePerfilUser.getValue(this.tblPerfiles.getSelectedRow());
                    perfil.setTipoOperacion("a");
                    gestion.actualizar(perfil);
                    
                    GestionMenuPerfil gm = new GestionMenuPerfil();
                    MenuPerfil menuP = new MenuPerfil();
                    menuP.setPerfil(perfil);
                    Menu omenu = new Menu();
                    omenu.setId(0);
                    menuP.setMenu(omenu);
                    menuP.setVisible("S");
                    menuP.setEstado("A");
                    menuP.setTipoOperacion("e");
                    gm.eliminar(menuP);
                    for (int i = 0; i < this.itemsMenuSelect.size(); i++) {
                        MenuPerfil menuPerfil = new MenuPerfil();
                        menuPerfil.setPerfil(perfil);
                        menuPerfil.setMenu(this.itemsMenuSelect.get(i));
                        menuPerfil.setVisible("S");
                        menuPerfil.setEstado("A");
                        menuPerfil.setTipoOperacion("i");
                        gm.registrarMenu(menuPerfil);
                    }
                    
                    JOptionPane.showMessageDialog(this, "Actualizado Correctamente !");
                }
                this.modelTablePerfilUser.setData(new GestionPerfilUsuario().listar());
                this.modelTablePerfilUser.fireTableDataChanged();
            }else{
                JOptionPane.showMessageDialog(this,"Llene todos los campos!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed
    
    private void txtDescripcionPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionPerfilActionPerformed
    
    private void permisosTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permisosTreeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_permisosTreeMouseClicked
    
    private void tblPerfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerfilesMouseClicked
        // TODO add your handling code here:
        int row = this.tblPerfiles.getSelectedRow();
        if (row >= 0) {
            PerfilUsuario perfil = this.modelTablePerfilUser.getValue(row);
            this.txtDescripcionPerfil.setText(perfil.getDescripcion());
            if (perfil.getEstado().equals("A")) {
                this.cboEstado.setSelectedIndex(0);
            } else {
                this.cboEstado.setSelectedIndex(1);
            }
        }
        this.control = "modificar";
    }//GEN-LAST:event_tblPerfilesMouseClicked
    
    private void btnEliminarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPerfilActionPerformed
        // TODO add your handling code here:
        int row = this.tblPerfiles.getSelectedRow();
        if (row >= 0) {
            try {
                GestionMenuPerfil gmp = new GestionMenuPerfil();
                PerfilUsuario perfil = this.modelTablePerfilUser.getValue(row);
                MenuPerfil menuPerfil = new MenuPerfil();
                menuPerfil.setPerfil(perfil);
                Menu omenu = new Menu();
                omenu.setId(0);
                menuPerfil.setMenu(omenu);
                menuPerfil.setVisible("S");
                menuPerfil.setEstado("A");
                menuPerfil.setTipoOperacion("e");
                gmp.eliminar(menuPerfil);
                
                GestionPerfilUsuario gperfil = new GestionPerfilUsuario();
                perfil.setTipoOperacion("e");
                gperfil.eliminar(perfil);
                
                JOptionPane.showMessageDialog(this, "Eliminado Correctamente !");
                this.modelTablePerfilUser.setData(new GestionPerfilUsuario().listar());
                this.modelTablePerfilUser.fireTableDataChanged();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PanelPerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnEliminarPerfilActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPerfil;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTree permisosTree;
    private javax.swing.JTable tblPerfiles;
    private javax.swing.JTextField txtDescripcionPerfil;
    // End of variables declaration//GEN-END:variables
}

class CheckTreeSelectionModel extends DefaultTreeSelectionModel {
    
    private TreeModel model;
    
    public CheckTreeSelectionModel(TreeModel model) {
        this.model = model;
        setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    }

    // tests whether there is any unselected node in the subtree of given path 
    public boolean isPartiallySelected(TreePath path) {
        if (isPathSelected(path, true)) {
            return false;
        }
        TreePath[] selectionPaths = getSelectionPaths();
        if (selectionPaths == null) {
            return false;
        }
        for (int j = 0; j < selectionPaths.length; j++) {
            if (isDescendant(selectionPaths[j], path)) {
                return true;
            }
        }
        return false;
    }

    // tells whether given path is selected. 
    // if dig is true, then a path is assumed to be selected, if 
    // one of its ancestor is selected. 
    public boolean isPathSelected(TreePath path, boolean dig) {
        if (!dig) {
            return super.isPathSelected(path);
        }
        while (path != null && !super.isPathSelected(path)) {
            path = path.getParentPath();
        }
        return path != null;
    }

    // is path1 descendant of path2 
    private boolean isDescendant(TreePath path1, TreePath path2) {
        Object obj1[] = path1.getPath();
        Object obj2[] = path2.getPath();
        for (int i = 0; i < obj2.length; i++) {
            if (obj1[i] != obj2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void setSelectionPaths(TreePath[] pPaths) {
        throw new UnsupportedOperationException("not implemented yet!!!");
    }
    
    public void addSelectionPaths(TreePath[] paths) {
        // unselect all descendants of paths[] 
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            TreePath[] selectionPaths = getSelectionPaths();
            if (selectionPaths == null) {
                break;
            }
            ArrayList toBeRemoved = new ArrayList();
            for (int j = 0; j < selectionPaths.length; j++) {
                if (isDescendant(selectionPaths[j], path)) {
                    toBeRemoved.add(selectionPaths[j]);
                }
            }
            super.removeSelectionPaths((TreePath[]) toBeRemoved.toArray(new TreePath[0]));
        }

        // if all siblings are selected then unselect them and select parent recursively 
        // otherwize just select that path. 
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            TreePath temp = null;
            while (areSiblingsSelected(path)) {
                temp = path;
                if (path.getParentPath() == null) {
                    break;
                }
                path = path.getParentPath();
            }
            if (temp != null) {
                if (temp.getParentPath() != null) {
                    addSelectionPath(temp.getParentPath());
                } else {
                    if (!isSelectionEmpty()) {
                        removeSelectionPaths(getSelectionPaths());
                    }
                    super.addSelectionPaths(new TreePath[]{temp});
                }
            } else {
                super.addSelectionPaths(new TreePath[]{path});
            }
        }
    }

    // tells whether all siblings of given path are selected. 
    private boolean areSiblingsSelected(TreePath path) {
        TreePath parent = path.getParentPath();
        if (parent == null) {
            return true;
        }
        Object node = path.getLastPathComponent();
        Object parentNode = parent.getLastPathComponent();
        
        int childCount = model.getChildCount(parentNode);
        for (int i = 0; i < childCount; i++) {
            Object childNode = model.getChild(parentNode, i);
            if (childNode == node) {
                continue;
            }
            if (!isPathSelected(parent.pathByAddingChild(childNode))) {
                return false;
            }
        }
        return true;
    }
    
    public void removeSelectionPaths(TreePath[] paths) {
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            if (path.getPathCount() == 1) {
                super.removeSelectionPaths(new TreePath[]{path});
            } else {
                toggleRemoveSelection(path);
            }
        }
    }

    // if any ancestor node of given path is selected then unselect it 
    //  and selection all its descendants except given path and descendants. 
    // otherwise just unselect the given path 
    private void toggleRemoveSelection(TreePath path) {
        Stack stack = new Stack();
        TreePath parent = path.getParentPath();
        while (parent != null && !isPathSelected(parent)) {
            stack.push(parent);
            parent = parent.getParentPath();
        }
        if (parent != null) {
            stack.push(parent);
        } else {
            super.removeSelectionPaths(new TreePath[]{path});
            return;
        }
        
        while (!stack.isEmpty()) {
            TreePath temp = (TreePath) stack.pop();
            TreePath peekPath = stack.isEmpty() ? path : (TreePath) stack.peek();
            Object node = temp.getLastPathComponent();
            Object peekNode = peekPath.getLastPathComponent();
            int childCount = model.getChildCount(node);
            for (int i = 0; i < childCount; i++) {
                Object childNode = model.getChild(node, i);
                if (childNode != peekNode) {
                    super.addSelectionPaths(new TreePath[]{temp.pathByAddingChild(childNode)});
                }
            }
        }
        super.removeSelectionPaths(new TreePath[]{parent});
    }
}

class TristateCheckBox extends JCheckBox {
    
    private final TristateCheckBox.TristateDecorator model;
    
    public TristateCheckBox(String text, Icon icon, Boolean initial) {
        super(text, icon);
        // Add a listener for when the mouse is pressed
        super.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                grabFocus();
                model.nextState();
            }
        });
        // Reset the keyboard action map
        ActionMap map = new ActionMapUIResource();
        map.put("pressed", new AbstractAction() {      //NOI18N
            public void actionPerformed(ActionEvent e) {
                grabFocus();
                model.nextState();
            }
        });
        map.put("released", null);                     //NOI18N
        SwingUtilities.replaceUIActionMap(this, map);
        // set the model to the adapted model
        model = new TristateCheckBox.TristateDecorator(getModel());
        setModel((ButtonModel) model);
        setState(initial);
    }
    
    public TristateCheckBox(String text, Boolean initial) {
        this(text, null, initial);
    }
    
    public TristateCheckBox(String text) {
        this(text, null);
    }
    
    public TristateCheckBox() {
        this(null);
    }

    /**
     * No one may add mouse listeners, not even Swing!
     */
    public void addMouseListener(MouseListener l) {
    }

    /**
     * Set the new state to either SELECTED, NOT_SELECTED or DONT_CARE. If state
     * == null, it is treated as DONT_CARE.
     */
    public void setState(Boolean state) {
        model.setState(state);
    }

    /**
     * Return the current state, which is determined by the selection status of
     * the model.
     */
    public Boolean getState() {
        return model.getState();
    }

    /**
     * Exactly which Design Pattern is this? Is it an Adapter, a Proxy or a
     * Decorator? In this case, my vote lies with the Decorator, because we are
     * extending functionality and "decorating" the original model with a more
     * powerful model.
     */
    private class TristateDecorator implements ButtonModel {
        
        private final ButtonModel other;
        
        private TristateDecorator(ButtonModel other) {
            this.other = other;
        }
        
        private void setState(Boolean state) {
            if (state == Boolean.FALSE) {
                other.setArmed(false);
                setPressed(false);
                setSelected(false);
            } else if (state == Boolean.TRUE) {
                other.setArmed(false);
                setPressed(false);
                setSelected(true);
            } else {
                other.setArmed(true);
                setPressed(true);
                setSelected(true);
            }
        }

        /**
         * The current state is embedded in the selection / armed state of the
         * model.
         *
         * We return the SELECTED state when the checkbox is selected but not
         * armed, DONT_CARE state when the checkbox is selected and armed (grey)
         * and NOT_SELECTED when the checkbox is deselected.
         */
        private Boolean getState() {
            if (isSelected() && !isArmed()) {
                // normal black tick
                return Boolean.TRUE;
            } else if (isSelected() && isArmed()) {
                // don't care grey tick
                return null;
            } else {
                // normal deselected
                return Boolean.FALSE;
            }
        }

        /**
         * We rotate between NOT_SELECTED, SELECTED and DONT_CARE.
         */
        private void nextState() {
            Boolean current = getState();
            if (current == Boolean.FALSE) {
                setState(Boolean.TRUE);
            } else if (current == Boolean.TRUE) {
                setState(null);
            } else if (current == null) {
                setState(Boolean.FALSE);
            }
        }

        /**
         * Filter: No one may change the armed status except us.
         */
        public void setArmed(boolean b) {
        }
        
        public boolean isFocusTraversable() {
            return isEnabled();
        }

        /**
         * We disable focusing on the component when it is not enabled.
         */
        public void setEnabled(boolean b) {
//            setFocusable(b);
            other.setEnabled(b);
        }

        /**
         * All these methods simply delegate to the "other" model that is being
         * decorated.
         */
        public boolean isArmed() {
            return other.isArmed();
        }
        
        public boolean isSelected() {
            return other.isSelected();
        }
        
        public boolean isEnabled() {
            return other.isEnabled();
        }
        
        public boolean isPressed() {
            return other.isPressed();
        }
        
        public boolean isRollover() {
            return other.isRollover();
        }
        
        public void setSelected(boolean b) {
            other.setSelected(b);
        }
        
        public void setPressed(boolean b) {
            other.setPressed(b);
        }
        
        public void setRollover(boolean b) {
            other.setRollover(b);
        }
        
        public void setMnemonic(int key) {
            other.setMnemonic(key);
        }
        
        public int getMnemonic() {
            return other.getMnemonic();
        }
        
        public void setActionCommand(String s) {
            other.setActionCommand(s);
        }
        
        public String getActionCommand() {
            return other.getActionCommand();
        }
        
        public void setGroup(ButtonGroup group) {
            other.setGroup(group);
        }
        
        public void addActionListener(ActionListener l) {
            other.addActionListener(l);
        }
        
        public void removeActionListener(ActionListener l) {
            other.removeActionListener(l);
        }
        
        public void addItemListener(ItemListener l) {
            other.addItemListener(l);
        }
        
        public void removeItemListener(ItemListener l) {
            other.removeItemListener(l);
        }
        
        public void addChangeListener(ChangeListener l) {
            other.addChangeListener(l);
        }
        
        public void removeChangeListener(ChangeListener l) {
            other.removeChangeListener(l);
        }
        
        public Object[] getSelectedObjects() {
            return other.getSelectedObjects();
        }
    }
    
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("TristateCheckBoxTest");     //NOI18N
        frame.getContentPane().setLayout(new GridLayout(0, 1, 5, 5));
        final TristateCheckBox swingBox = new TristateCheckBox(
                "Testing the tristate checkbox");  //NOI18N
        swingBox.setMnemonic('T');
        frame.getContentPane().add(swingBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class CheckTreeCellRenderer extends JPanel implements TreeCellRenderer {
    
    private CheckTreeSelectionModel selectionModel;
    private TreeCellRenderer delegate;
    private TristateCheckBox checkBox = new TristateCheckBox();
    
    public CheckTreeCellRenderer(TreeCellRenderer delegate, CheckTreeSelectionModel selectionModel) {
        this.delegate = delegate;
        this.selectionModel = selectionModel;
        setLayout(new BorderLayout());
        setOpaque(false);
        checkBox.setOpaque(false);
    }
    
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component renderer = delegate.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        
        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            if (selectionModel.isPathSelected(path, true)) {
                System.out.println("esntro aqui...1");
                checkBox.setState(Boolean.TRUE);
            } else {
                checkBox.setState(selectionModel.isPartiallySelected(path) ? null : Boolean.FALSE);
            }
        }
        removeAll();
        add(checkBox, BorderLayout.WEST);
        add(renderer, BorderLayout.CENTER);
        return this;
    }
}

class CheckTreeManager extends MouseAdapter implements TreeSelectionListener {
    
    private CheckTreeSelectionModel selectionModel;
    private JTree tree = new JTree();
    int hotspot = new JCheckBox().getPreferredSize().width;
    
    public CheckTreeManager(JTree tree) {
        this.tree = tree;
        selectionModel = new CheckTreeSelectionModel(tree.getModel());
        tree.setCellRenderer(new CheckTreeCellRenderer(tree.getCellRenderer(), selectionModel));
        tree.addMouseListener(this);
        selectionModel.addTreeSelectionListener(this);
    }
    
    public void mouseClicked(MouseEvent me) {
        TreePath path = tree.getPathForLocation(me.getX(), me.getY());
        if (path == null) {
            return;
        }
        if (me.getX() > tree.getPathBounds(path).x + hotspot) {
            return;
        }
        
        boolean selected = selectionModel.isPathSelected(path, true);
        selectionModel.removeTreeSelectionListener(this);
        
        try {
            if (selected) {
                selectionModel.removeSelectionPath(path);
            } else {
                selectionModel.addSelectionPath(path);
            }
        } finally {
            selectionModel.addTreeSelectionListener(this);
            tree.treeDidChange();
        }
    }
    
    public CheckTreeSelectionModel getSelectionModel() {
        return selectionModel;
    }
    
    public void valueChanged(TreeSelectionEvent e) {
        tree.treeDidChange();
    }
}
