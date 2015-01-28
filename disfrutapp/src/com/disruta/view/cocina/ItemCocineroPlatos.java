/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disruta.view.cocina;

import com.disfruta.bean.logistica.CocineroPlatos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemCocineroPlatos extends JPanel{
    protected JLabel foto;
    protected JLabel nombre;
    protected JButton verdetalle;
    protected JLabel cantidad;
    protected JPanel panel;
    
    public ItemCocineroPlatos(final CocineroPlatos cocinero){
        panel=this;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(420, 50));
        this.setBackground(new Color(242, 242, 242));
        this.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        Image fotoimg = getToolkit().getImage(getClass().getResource("/images/fotoPerfil.png"));
        fotoimg = fotoimg.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        foto=new JLabel();
        foto.setIcon(new ImageIcon(fotoimg));
        foto.setBounds(20, 5, 40, 40);
        nombre=new JLabel(cocinero.getUsuario().getNombres()+" "+cocinero.getUsuario().getApellidos());
        nombre.setBounds(80, 5, 250, 40);
        verdetalle=new JButton("Ver Platos");
        verdetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog=new JDialog();
                dialog.setSize(700, 400);
                JPanel panelplatos=new JPanel();
                panelplatos.setLayout(new GridLayout(10, 1, 10, 10));
                panelplatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
                panelplatos.setBackground(Color.WHITE);
                JScrollPane scroll=new JScrollPane();
                scroll.setPreferredSize(new Dimension(700,400));
                scroll .setViewportView(panelplatos);
                scroll .getViewport().setView(panelplatos);
                dialog.add(scroll);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                for (int i = 0; i < cocinero.getPlatos().size(); i++) {
                    ItemPlatoEnEspera item=new ItemPlatoEnEspera(cocinero.getPlatos().get(i),panelplatos);
                    panelplatos.add(item);
                }
            }
        });
        verdetalle.setBounds(350, 5, 80, 40);
        cantidad=new JLabel();
        cantidad.setText(cocinero.getPlatos().size()+"");
        cantidad.setBounds(450, 5, 60, 40);
        this.add(foto);
        this.add(nombre);
        this.add(verdetalle);
        this.add(cantidad);
    }
    
}
