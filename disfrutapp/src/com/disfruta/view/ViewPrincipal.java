/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view;

import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.gestion.login.GestionLogin;
import com.disfruta.gestion.xtbc.GestionUbigeo;
import com.disfruta.view.logistica.PanelIngresoAlmacen;
import com.disfruta.view.logistica.PanelOrdenDeCompra;
import com.disfruta.view.staff.PanelStaff;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import resources.MenuBar.*;
import resources.auxiliar.ListaUbigeo;

/**
 *
 * @author Juape
 */
public final class ViewPrincipal extends javax.swing.JFrame {

    protected ArrayList<Menu> itemsStaff = null;
    protected ArrayList<Menu> itemsLogistica = null;
    protected ArrayList<Menu> itemsCocina = null;
    protected ArrayList<Menu> itemsCaja = null;
    protected ArrayList<Menu> itemsAdministracion = null;
    ArrayList<MenuPerfil> menuList;
    public Image imagen;

    /**
     * Creates new form ViewPrincipal
     */
    public ViewPrincipal(UsuarioDesktop usuario, ArrayList<MenuPerfil> listaMenus) throws ClassNotFoundException, Exception {
        this.setUndecorated(true);
//        if(usuario!=null){
        initComponents();
        usuario = new UsuarioDesktop();
        usuario.setIdUser(1);
        this.menuList = new GestionLogin().listarMenuLogin(usuario);
        this.btnMenuStaff.setEnabled(false);
        this.btnMenuLogistica.setEnabled(false);
        this.btnMenuCocina.setEnabled(false);
        this.btnMenuCaja.setEnabled(false);
        this.btnMenuAdmin.setEnabled(false);
        init();
        //JOptionPane.showMessageDialog(this, "Size menus: " + listaMenus.size());
        this.setLocationRelativeTo(null);
        DesktopContainer.setLayout(new BorderLayout());
        PanelTitulo.setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = 0;
        pos.gridy = 0;
        pos.gridwidth = 1;
        pos.gridheight = 1;
        pos.weightx = 0.5;
        pos.weighty = 1.0;
        pos.anchor = GridBagConstraints.WEST;
        pos.insets = new Insets(0, 10, 0, 0);
        lbltitle.setBounds(5, 20, 190, 22);
        PanelTitulo.add(lbltitle, pos);
        pos.gridx = 1;
        pos.gridy = 0;
        pos.gridwidth = 1;
        pos.gridheight = 1;
        pos.weightx = 1.0;
        pos.anchor = GridBagConstraints.WEST;
        PanelTitulo.add(PanelBarra, pos);
        pos.gridx = 2;
        pos.gridy = 0;
        pos.gridwidth = 1;
        pos.gridheight = 1;
        pos.weightx = 0.5;
        pos.anchor = GridBagConstraints.NORTHEAST;
        pos.insets = new Insets(0, 0, 0, 10);
        PanelTitulo.add(btnclose, pos);
//        }else{
//            JOptionPane.showMessageDialog(this, "Debe iniciar sesión!");
//        }
    }

    private void init() {
        try {
            System.out.println("size: " + menuList.size());
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i).getMenu();
                if (menu.getNodo() == menu.getNodopadre()) {
                    System.out.println("Modulo: "+menu.getDescripcion());
                    switch (menu.getDescripcion()) {
                        case "STAFF":
                            this.itemsStaff = new ArrayList();
                            this.btnMenuStaff.setEnabled(true);
                            encontrarHijos(menu.getNodo(),"STAFF");
                            break;
                        case "LOGISTICA":
                            this.itemsLogistica = new ArrayList();
                            this.btnMenuLogistica.setEnabled(true);
                            encontrarHijos(menu.getNodo(),"LOGISTICA");
                            break;
                        case "COCINA":
                            this.itemsCocina = new ArrayList();
                            this.btnMenuCocina.setEnabled(true);
                            encontrarHijos(menu.getNodo(),"COCINA");
                            break;
                        case "CAJA":
                            this.itemsCaja = new ArrayList();
                            this.btnMenuCaja.setEnabled(true);
                            encontrarHijos(menu.getNodo(),"CAJA");
                            break;
                        case "ADMINISTRACION":
                            this.itemsAdministracion = new ArrayList();
                            this.btnMenuAdmin.setEnabled(true);
                            encontrarHijos(menu.getNodo(),"ADMINISTRACION");
                            break;
                        default:
                            System.out.println("no encontro modulo..!");
                            break;
                    }
                }
            }
            ListaUbigeo.setGetListUbigeo(new GestionUbigeo().listar());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void encontrarHijos(int padre, String modulo) {
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i).getMenu();
            if (menu.getNodo()!=menu.getNodopadre() && menu.getNodopadre() == padre) {
                switch (modulo) {
                    case "STAFF":
                        this.itemsStaff.add(menu);
                        encontrarHijos(menu.getNodo(),"STAFF");
                        break;
                    case "LOGISTICA":
                        System.out.println("item: " + menu.getDescripcion());
                        this.itemsLogistica.add(menu);
                        encontrarHijos(menu.getNodo(),"LOGISTICA");
                        break;
                    case "COCINA":
                        this.itemsCocina.add(menu);
                        encontrarHijos(menu.getNodo(),"COCINA");
                        break;
                    case "CAJA":
                        this.itemsCaja.add(menu);
                        encontrarHijos(menu.getNodo(),"CAJA");
                        break;
                    case "ADMINISTRACION":
                        this.itemsAdministracion.add(menu);
                        encontrarHijos(menu.getNodo(),"ADMINISTRACION");
                        break;
                    default:
                        System.out.println("no modulo..!");
                        break;
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu6 = new javax.swing.JPopupMenu();
        jPopupMenu7 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu8 = new javax.swing.JPopupMenu();
        jPopupMenu9 = new javax.swing.JPopupMenu();
        PanelContainer = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        btnclose = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        PanelBarra = new javax.swing.JPanel();
        btnMenuStaff = new javax.swing.JButton();
        btnMenuLogistica = new javax.swing.JButton();
        btnMenuCocina = new javax.swing.JButton();
        btnMenuCaja = new javax.swing.JButton();
        btnMenuAdmin = new javax.swing.JButton();
        lblContainerMenu = new javax.swing.JLabel();
        PanelBarrasIconos = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        btnSalidaAlmacen = new javax.swing.JButton();
        btnIngresoAlmacen = new javax.swing.JButton();
        btnOrdenCompra = new javax.swing.JButton();
        DesktopContainer = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        jMenu6.setText("File");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(960, 2147483647));

        PanelContainer.setBackground(new java.awt.Color(242, 242, 242));
        PanelContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        PanelContainer.setMinimumSize(new java.awt.Dimension(960, 640));
        PanelContainer.setName(""); // NOI18N
        PanelContainer.setPreferredSize(new java.awt.Dimension(960, 640));

        PanelTitulo.setBackground(new java.awt.Color(153, 153, 153));
        PanelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelTitulo.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        PanelTitulo.setPreferredSize(new java.awt.Dimension(960, 32));

        btnclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnclose.setToolTipText("");
        btnclose.setBorder(null);
        btnclose.setBorderPainted(false);
        btnclose.setContentAreaFilled(false);
        btnclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclose.setFocusPainted(false);
        btnclose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnclose.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        lbltitle.setBackground(new java.awt.Color(252, 252, 252));
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disfrutapp.png"))); // NOI18N
        lbltitle.setAlignmentX(5.0F);
        lbltitle.setAlignmentY(5f);

        PanelBarra.setBackground(new java.awt.Color(255, 255, 0));
        PanelBarra.setOpaque(false);
        PanelBarra.setPreferredSize(new java.awt.Dimension(445, 22));
        PanelBarra.setLayout(null);

        btnMenuStaff.setForeground(new java.awt.Color(255, 0, 0));
        btnMenuStaff.setBorder(null);
        btnMenuStaff.setBorderPainted(false);
        btnMenuStaff.setContentAreaFilled(false);
        btnMenuStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuStaff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuStaff.setIconTextGap(-3);
        btnMenuStaff.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnMenuStaff.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnventas.png"))); // NOI18N
        btnMenuStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnventas.png"))); // NOI18N
        btnMenuStaff.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnventas.png"))); // NOI18N
        btnMenuStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuStaffActionPerformed(evt);
            }
        });
        PanelBarra.add(btnMenuStaff);
        btnMenuStaff.setBounds(0, 0, 90, 22);

        btnMenuLogistica.setForeground(new java.awt.Color(255, 0, 51));
        btnMenuLogistica.setBorder(null);
        btnMenuLogistica.setBorderPainted(false);
        btnMenuLogistica.setContentAreaFilled(false);
        btnMenuLogistica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuLogistica.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnMenuLogistica.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnlogistica.png"))); // NOI18N
        btnMenuLogistica.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnlogistica.png"))); // NOI18N
        btnMenuLogistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLogisticaActionPerformed(evt);
            }
        });
        PanelBarra.add(btnMenuLogistica);
        btnMenuLogistica.setBounds(90, 0, 88, 22);

        btnMenuCocina.setBorder(null);
        btnMenuCocina.setBorderPainted(false);
        btnMenuCocina.setContentAreaFilled(false);
        btnMenuCocina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuCocina.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnMenuCocina.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btncocina.png"))); // NOI18N
        btnMenuCocina.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btncocina.png"))); // NOI18N
        btnMenuCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuCocinaActionPerformed(evt);
            }
        });
        PanelBarra.add(btnMenuCocina);
        btnMenuCocina.setBounds(180, 0, 88, 22);

        btnMenuCaja.setBackground(new java.awt.Color(204, 0, 0));
        btnMenuCaja.setText("button");
        btnMenuCaja.setBorder(null);
        btnMenuCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuCaja.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnMenuCaja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btncaja.png"))); // NOI18N
        btnMenuCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btncaja.png"))); // NOI18N
        btnMenuCaja.setSelected(true);
        PanelBarra.add(btnMenuCaja);
        btnMenuCaja.setBounds(-79, 0, 80, 20);

        btnMenuAdmin.setBorder(null);
        btnMenuAdmin.setBorderPainted(false);
        btnMenuAdmin.setContentAreaFilled(false);
        btnMenuAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuAdmin.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnMenuAdmin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnadm.png"))); // NOI18N
        btnMenuAdmin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnadm.png"))); // NOI18N
        btnMenuAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAdminActionPerformed(evt);
            }
        });
        PanelBarra.add(btnMenuAdmin);
        btnMenuAdmin.setBounds(355, 0, 90, 22);

        lblContainerMenu.setBackground(new java.awt.Color(204, 0, 51));
        lblContainerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        PanelBarra.add(lblContainerMenu);
        lblContainerMenu.setBounds(0, 0, 445, 22);

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(PanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(btnclose)
                .addContainerGap())
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelBarrasIconos.setBackground(new java.awt.Color(242, 242, 242));

        PanelMenu.setBackground(new java.awt.Color(204, 0, 0));
        PanelMenu.setMaximumSize(new java.awt.Dimension(900, 32767));
        PanelMenu.setMinimumSize(new java.awt.Dimension(450, 22));
        PanelMenu.setOpaque(false);
        PanelMenu.setPreferredSize(new java.awt.Dimension(450, 22));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        btnSalidaAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salidaalmacen.png"))); // NOI18N
        btnSalidaAlmacen.setBorderPainted(false);
        btnSalidaAlmacen.setContentAreaFilled(false);
        btnSalidaAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalidaAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaAlmacenActionPerformed(evt);
            }
        });

        btnIngresoAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ingresoalmacen.png"))); // NOI18N
        btnIngresoAlmacen.setBorderPainted(false);
        btnIngresoAlmacen.setContentAreaFilled(false);
        btnIngresoAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresoAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoAlmacenActionPerformed(evt);
            }
        });

        btnOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ordencompra.png"))); // NOI18N
        btnOrdenCompra.setBorderPainted(false);
        btnOrdenCompra.setContentAreaFilled(false);
        btnOrdenCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBarrasIconosLayout = new javax.swing.GroupLayout(PanelBarrasIconos);
        PanelBarrasIconos.setLayout(PanelBarrasIconosLayout);
        PanelBarrasIconosLayout.setHorizontalGroup(
            PanelBarrasIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBarrasIconosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnSalidaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBarrasIconosLayout.setVerticalGroup(
            PanelBarrasIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBarrasIconosLayout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBarrasIconosLayout.createSequentialGroup()
                .addGroup(PanelBarrasIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalidaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        DesktopContainer.setBackground(new java.awt.Color(255, 255, 255));
        DesktopContainer.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout PanelContainerLayout = new javax.swing.GroupLayout(PanelContainer);
        PanelContainer.setLayout(PanelContainerLayout);
        PanelContainerLayout.setHorizontalGroup(
            PanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
            .addComponent(PanelBarrasIconos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DesktopContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelContainerLayout.setVerticalGroup(
            PanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainerLayout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(PanelBarrasIconos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DesktopContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnMenuLogisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLogisticaActionPerformed
        // TODO add your handling code here: 
        btnMenuLogistica.setIcon(new ImageIcon(getClass().getResource("/images/btnlogistica.png")));
        btnMenuStaff.setIcon(null);
        btnMenuAdmin.setIcon(null);
        btnMenuCaja.setIcon(null);
        btnMenuCocina.setIcon(null);
        PanelMenu.removeAll();
        PanelMenu.setLayout(new BorderLayout());
        PanelMenu.add(new MenuLogistica(DesktopContainer,this.itemsLogistica), BorderLayout.NORTH);
        this.PanelBarrasIconos.setVisible(true);
        DesktopContainer.removeAll();
    }//GEN-LAST:event_btnMenuLogisticaActionPerformed

    private void btnMenuStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuStaffActionPerformed
        // TODO add your handling code here:
        btnMenuStaff.setIcon(new ImageIcon(getClass().getResource("/images/btnventas.png")));
        btnMenuLogistica.setIcon(null);
        btnMenuAdmin.setIcon(null);
        btnMenuCaja.setIcon(null);
//        btnMenuCocina.setIcon(null);
        this.PanelBarrasIconos.setVisible(false);
        PanelStaff ps = new PanelStaff();
        this.DesktopContainer.removeAll();
        this.DesktopContainer.add(ps);
        this.DesktopContainer.updateUI();

    }//GEN-LAST:event_btnMenuStaffActionPerformed

    private void btnMenuAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAdminActionPerformed
        // TODO add your handling code here: 
        btnMenuAdmin.setIcon(new ImageIcon(getClass().getResource("/images/btnadm.png")));
        btnMenuLogistica.setIcon(null);
        btnMenuStaff.setIcon(null);
        btnMenuCaja.setIcon(null);
////        btnMenuCocina.setIcon(null);
        PanelMenu.removeAll();
        PanelMenu.setLayout(new BorderLayout());
        PanelMenu.add(new MenuAdmin(DesktopContainer,this.itemsAdministracion), BorderLayout.NORTH);
    }//GEN-LAST:event_btnMenuAdminActionPerformed

    private void btnSalidaAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaAlmacenActionPerformed
        // TODO add your handling code here:
//        PanelAlmacen pu = new PanelAlmacen();
//        panelctn.removeAll();
//        panelctn.add(pu);
//        panelctn.updateUI();
    }//GEN-LAST:event_btnSalidaAlmacenActionPerformed

    private void btnOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenCompraActionPerformed
        // TODO add your handling code here:
        PanelOrdenDeCompra odc = new PanelOrdenDeCompra();
        DesktopContainer.removeAll();
        DesktopContainer.add(odc);
        DesktopContainer.updateUI();
    }//GEN-LAST:event_btnOrdenCompraActionPerformed

    private void btnIngresoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoAlmacenActionPerformed
        // TODO add your handling code here:
        PanelIngresoAlmacen ia = new PanelIngresoAlmacen();
        DesktopContainer.removeAll();
        DesktopContainer.add(ia);
        DesktopContainer.updateUI();
    }//GEN-LAST:event_btnIngresoAlmacenActionPerformed

    private void btnMenuCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuCocinaActionPerformed
        // TODO add your handling code here:
        btnMenuCocina.setIcon(new ImageIcon(getClass().getResource("/images/btncocina.png")));
        btnMenuLogistica.setIcon(null);
        btnMenuAdmin.setIcon(null);
        btnMenuCaja.setIcon(null);
        btnMenuStaff.setIcon(null);
    }//GEN-LAST:event_btnMenuCocinaActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewPrincipal(null, null).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DesktopContainer;
    private javax.swing.JPanel PanelBarra;
    private javax.swing.JPanel PanelBarrasIconos;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnIngresoAlmacen;
    private javax.swing.JButton btnMenuAdmin;
    private javax.swing.JButton btnMenuCaja;
    private javax.swing.JButton btnMenuCocina;
    private javax.swing.JButton btnMenuLogistica;
    private javax.swing.JButton btnMenuStaff;
    private javax.swing.JButton btnOrdenCompra;
    private javax.swing.JButton btnSalidaAlmacen;
    private javax.swing.JButton btnclose;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JPopupMenu jPopupMenu6;
    private javax.swing.JPopupMenu jPopupMenu7;
    private javax.swing.JPopupMenu jPopupMenu8;
    private javax.swing.JPopupMenu jPopupMenu9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel lblContainerMenu;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables
}