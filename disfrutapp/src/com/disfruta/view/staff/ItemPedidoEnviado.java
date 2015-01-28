/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.Pedido;
import com.disfruta.gestion.logistica.GestionDetallePedido;
import com.disruta.view.cocina.ItemPlatoEnEspera;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    protected double cant = 0;
    protected JButton verdetalle;
    protected JPanel panel;
    protected Pedido pedido;

    public ItemPedidoEnviado(final Pedido pedido) {
        panel = this;
        this.pedido = pedido;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(840, 45));
        this.setBackground(new Color(252, 252, 252));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
        codigo = new JLabel("" + pedido.getId());
        codigo.setForeground(new Color(149, 149, 149));
        codigo.setFont(new Font("Arial", Font.BOLD, 12));
        codigo.setBounds(50, 10, 60, 25);
        fecha = new JLabel(pedido.getFecha());
        fecha.setForeground(new Color(149, 149, 149));
        fecha.setFont(new Font("Arial", Font.BOLD, 12));
        fecha.setBounds(110, 10, 150, 25);
        mesa = new JLabel(pedido.getMesa());
        mesa.setForeground(new Color(149, 149, 149));
        mesa.setFont(new Font("Arial", Font.BOLD, 12));
        mesa.setBounds(280, 10, 100, 25);
        nombre = new JLabel(pedido.getUsuario().getNombres() + " " + pedido.getUsuario().getApellidos());
        nombre.setForeground(new Color(149, 149, 149));
        nombre.setFont(new Font("Arial", Font.BOLD, 12));
        nombre.setBounds(360, 10, 300, 25);
        cantidad = new JLabel("0.00");
        cantidad.setForeground(new Color(149, 149, 149));
        cantidad.setFont(new Font("Arial", Font.BOLD, 12));
        cantidad.setBounds(610, 10, 100, 25);
        total = new JLabel(pedido.getMontototal() + "");
        total.setForeground(new Color(149, 149, 149));
        total.setFont(new Font("Arial", Font.BOLD, 12));
        total.setBounds(700, 10, 80, 25);

        verdetalle = new JButton("Ver detalle");
        verdetalle.setBounds(790, 7, 120, 28);
        verdetalle.setBackground(new Color(109, 109,109));
        verdetalle.setForeground(Color.WHITE);
        verdetalle.setFont(new Font("Arial", Font.BOLD, 12));
        verdetalle.setBorder(null);
        verdetalle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        verdetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<DetallePedido> lista = new GestionDetallePedido().listar(pedido);
                    if (lista.size() > 0) {
                        verdetalle.setBackground(new Color(253, 148, 2));
                        JDialog dialog = new JDialog();
                        dialog.setSize(600, 350);
                        JPanel panelplatos = new JPanel();
                        panelplatos.setLayout(new GridLayout(10, 1, 0, 0));
                        panelplatos.setBorder(null);
                        panelplatos.setBackground(Color.WHITE);
                        JScrollPane scroll = new JScrollPane();
                        scroll.setPreferredSize(new Dimension(600, 350));
                        scroll.setViewportView(panelplatos);
                        scroll.getViewport().setView(panelplatos);
                        dialog.add(scroll);
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                        for (int i = 0; i < lista.size(); i++) {
                            ItemDevolverProducto item = new ItemDevolverProducto(lista.get(i));
                            panelplatos.add(item);
                            if (i % 2 != 0) {
                                item.setBackground(new Color(252, 249, 245));
                            }
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No tiene Productos");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ItemPedidoEnviado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ItemPedidoEnviado.class.getName()).log(Level.SEVERE, null, ex);
                }
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
