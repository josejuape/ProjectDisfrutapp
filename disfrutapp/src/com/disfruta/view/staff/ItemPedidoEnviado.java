/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.Pedido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemPedidoEnviado extends JPanel {
    protected JLabel codigo;
    protected JLabel nombre;
    protected JLabel mesa;
    protected JLabel fecha;
    protected JLabel total;
    protected JLabel cantidad;
    protected double cant=0;
    protected JButton verdetalle;
    protected JPanel panel;
    
    public ItemPedidoEnviado(Pedido pedido){
        panel=this;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(820, 45));
        this.setBackground(new Color(242, 242, 242));
        this.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        codigo=new JLabel(""+pedido.getId());
        codigo.setBounds(10, 10, 60, 25);
        fecha=new JLabel(pedido.getFecha());
        fecha.setBounds(80, 10, 150, 25);
        mesa=new JLabel(pedido.getMesa());
        mesa.setBounds(240, 10, 100, 25);
        nombre=new JLabel(pedido.getUsuario().getNombres()+" "+pedido.getUsuario().getApellidos());
        nombre.setBounds(350, 10, 300, 25);
        cantidad=new JLabel("0.00");
        cantidad.setBounds(610, 10, 100, 25);
        total=new JLabel(pedido.getMontototal()+"");
        total.setBounds(710, 10, 80, 25);
        
        verdetalle=new JButton("Ver detalle");
        verdetalle.setBounds(790, 10, 120, 28);
        verdetalle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        verdetalle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        
        });
        
        
        this.add(codigo);
        this.add(fecha);
        this.add(mesa);
        this.add(nombre);
        this.add(cantidad);        
        this.add(total);
        this.add(verdetalle);
    }
    
}
