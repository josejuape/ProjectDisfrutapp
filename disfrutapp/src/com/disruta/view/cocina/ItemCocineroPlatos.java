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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemCocineroPlatos extends JPanel{
    protected JPanel container;
    protected JLabel foto;
    protected JLabel nombre;
    protected JButton verdetalle;
    protected JLabel cantidad;
    protected JPanel panel;
    
    public ItemCocineroPlatos(final CocineroPlatos cocinero){
        panel=this;
        container=new JPanel();
        container.setLayout(null);
        this.setLayout(new GridLayout(1, 1, 10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        container.setPreferredSize(new Dimension(420, 50));
        container.setBackground(new Color(242, 242, 242));
        container.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
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
                panel.setLayout(new GridLayout(cocinero.getPlatos().size(), 1, 10, 10));
                
                for (int i = 0; i < cocinero.getPlatos().size(); i++) {
                    ItemPlatoEnEspera item=new ItemPlatoEnEspera(cocinero.getPlatos().get(i),panel);
                    panel.add(item);
                    panel.setMaximumSize(new Dimension(520,400));
                    panel.setMinimumSize(new Dimension(520,400));
                }
            }
        });
        verdetalle.setBounds(350, 5, 80, 40);
        cantidad=new JLabel();
        cantidad.setText(cocinero.getPlatos().size()+"");
        cantidad.setBounds(450, 5, 60, 40);
        container.add(foto);
        container.add(nombre);
        container.add(verdetalle);
        container.add(cantidad);
        
        this.add(container);
    }
    
}
