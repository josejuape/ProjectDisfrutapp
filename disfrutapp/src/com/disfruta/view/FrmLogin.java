/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view;

import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.xtbc.Usuario;
import com.disfruta.gestion.login.GestionLogin;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public final class FrmLogin extends javax.swing.JFrame {
    FrmLogin login;
    boolean controlEnter=true;
    
    public FrmLogin() {
        this.setUndecorated(true);
        login=this;
        initComponents();
        this.setPreferredSize(new Dimension(300,490));
        this.progresoLogin.setVisible(false);
        this.setLocationRelativeTo(null);
        PaddingLeft.agregarpadding(txtUsuario);
        PaddingLeft.agregarpadding(txtPassword);  
        this.txtUsuario.addActionListener(tranfiereElFoco);
        this.btnlogearse.registerKeyboardAction(this.btnlogearse.getActionForKeyStroke(
                                      KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                                      KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                                      JComponent.WHEN_FOCUSED);
    }

    public void startTrhead(final UsuarioDesktop useracc,final ArrayList<MenuPerfil> listMenu){
        Thread tread=new Thread(new Runnable() {
            @Override
            public void run() {                
                try {
                    ViewPrincipal cpanel=new ViewPrincipal(useracc,listMenu,login);
                    cpanel.setVisible(true);
                    dispose();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tread.start();
    
    }
    
    public JProgressBar getProgressBar(){
        return progresoLogin;
    }
    
    public JLabel getLabel(){
        return lblmensaje;
    }
    
    private ActionListener  tranfiereElFoco = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // Se transfiere el foco al siguiente elemento.
            ((Component) arg0.getSource()).transferFocus();
        }
    };
    
    
    private void loguearse(){
        UsuarioDesktop user = new UsuarioDesktop();
        
        try {
            user.setEmail(this.txtUsuario.getText());
            user.setPassword(this.txtPassword.getText());
            GestionLogin gestionLogin = new GestionLogin();
            UsuarioDesktop useracc = gestionLogin.validarLogin(user);
            if (useracc != null) {
                //JOptionPane.showMessageDialog(this,"mensaje de prueba "+useracc.getNombres()); 
                //verificamos y obtenemos sus perfiles para los menus
                ArrayList<MenuPerfil> listaMenu= gestionLogin.listarMenuLogin(useracc);
                if(listaMenu.size()>0){
                    startTrhead(user,listaMenu);
                }else{
                    JOptionPane.showMessageDialog(this,"Acceso denegado. No tiene configurado permisos de menu.");
                }
            } else {
                 JOptionPane.showMessageDialog(this,"no encontrado");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnlogearse = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnclose = new javax.swing.JButton();
        lblmensaje = new javax.swing.JLabel();
        progresoLogin = new javax.swing.JProgressBar();

        jMenuItem1.setText("jMenuItem1");

        jTextField2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("     Usuario");
        jTextField2.setToolTipText("");
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        jTextField2.setCaretPosition(5);
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextField2.setName("txtusuario"); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(272, 40));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disfrutapp");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setName("Frmlogin"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Disfrutapp_Big.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 50, 200, 120);

        txtUsuario.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Usuario");
        txtUsuario.setToolTipText("");
        txtUsuario.setAlignmentX(0.0F);
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtUsuario.setCaretPosition(0);
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.setMargin(new java.awt.Insets(0, 10, 0, 0));
        txtUsuario.setName("txtusuario"); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(272, 40));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(20, 220, 260, 35);

        txtPassword.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        txtPassword.setText("Contraseña");
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPassword.setPreferredSize(new java.awt.Dimension(272, 40));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(20, 265, 260, 35);

        btnlogearse.setBackground(new java.awt.Color(229, 147, 35));
        btnlogearse.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnlogearse.setForeground(new java.awt.Color(255, 255, 255));
        btnlogearse.setText("Iniciar sesión");
        btnlogearse.setBorder(null);
        btnlogearse.setBorderPainted(false);
        btnlogearse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogearse.setPreferredSize(new java.awt.Dimension(128, 32));
        btnlogearse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogearseActionPerformed(evt);
            }
        });
        btnlogearse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnlogearseKeyPressed(evt);
            }
        });
        jPanel1.add(btnlogearse);
        btnlogearse.setBounds(150, 310, 128, 30);

        jCheckBox1.setBackground(new java.awt.Color(238, 238, 238));
        jCheckBox1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox1.setText("Recuérdame");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(20, 312, 93, 27);

        jButton2.setBackground(new java.awt.Color(192, 192, 192));
        jButton2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("¿Olvidaste tu contraseña?");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setSelected(true);
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 410, 260, 19);

        jButton3.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Regístrate");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton3);
        jButton3.setBounds(215, 435, 65, 19);

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("¿No tienes cuenta?");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 435, 99, 18);

        btnclose.setBackground(new java.awt.Color(220, 59, 48));
        btnclose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnclose.setBorder(null);
        btnclose.setBorderPainted(false);
        btnclose.setContentAreaFilled(false);
        btnclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclose.setDefaultCapable(false);
        btnclose.setFocusPainted(false);
        btnclose.setFocusable(false);
        btnclose.setMaximumSize(new java.awt.Dimension(45, 20));
        btnclose.setName("btnclose"); // NOI18N
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnclose);
        btnclose.setBounds(243, 1, 52, 20);

        lblmensaje.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel1.add(lblmensaje);
        lblmensaje.setBounds(20, 360, 260, 16);

        progresoLogin.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.add(progresoLogin);
        progresoLogin.setBounds(20, 380, 260, 12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncloseActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
     
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void btnlogearseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogearseActionPerformed
        // TODO add your handling code here:
        loguearse();
    }//GEN-LAST:event_btnlogearseActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        // al de¿arle el focus a este evento activar el enter para iniciar sesion con el boton   
        controlEnter=false;
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER && controlEnter){
            btnlogearse.requestFocus();
            loguearse();
            
        }else{
            if(this.txtPassword.getText().length()>=3){
                controlEnter=true;
            }
        }
        
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnlogearseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnlogearseKeyPressed
        System.out.println("presiono click");
    }//GEN-LAST:event_btnlogearseKeyPressed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnlogearse;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JProgressBar progresoLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
