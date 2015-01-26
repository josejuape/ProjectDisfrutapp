/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disruta.view.cocina;

import com.disfruta.bean.admin.UsuarioDesktop;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemStaffSelected extends JPanel {

//    public JLabel estado;
    public JLabel fotoperfil;
    public JLabel nombre;
    public JButton activar;
    public JPanel panel=null;
    public boolean estado=false;
//    public ImageIcon estado_ac = new ImageIcon(getClass().getResource("/images/staff_activo.png"));
//    public ImageIcon estado_des = new ImageIcon(getClass().getResource("/images/staff_inactivo.png"));
//    public String status = "Inactivo";

    public ItemStaffSelected(final UsuarioDesktop user) {
        this.panel=this;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(420, 50));
        this.setBackground(new Color(242, 242, 242));
        this.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
//        estado = new JLabel();
//        this.estado.setBounds(10, 15, 25, 25);
//        estado.setIcon(estado_des);
        fotoperfil = new JLabel();
        Image foto = getToolkit().getImage(getClass().getResource("/images/fotoPerfil.png"));
        foto = foto.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        fotoperfil.setIcon(new ImageIcon(foto));
        this.fotoperfil.setBounds(45, 5, 40, 40);
        nombre = new JLabel(user.getNombres());
        this.nombre.setBounds(100, 15, 200, 25);
        activar = new JButton("Seleccionar");
        this.activar.setBounds(320, 15, 120, 25);
        this.activar.setBackground(Color.GREEN);
        this.activar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.activar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estado==false){
                    DialogSelectedStaffCocina.cocinero=user;
                    panel.setBackground(Color.green);
                    activar.setText("Deseleccionar");
                    estado=true;
                }else{
                    DialogSelectedStaffCocina.cocinero=null;
                    panel.setBackground(new Color(242, 242, 242));
                    activar.setText("Seleccionar");
                    estado=false;
                }
            }
        });

//        this.add(estado);
        this.add(fotoperfil);
        this.add(nombre);
        this.add(activar);
    }
    
}
