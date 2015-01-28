/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.gestion.logistica.GestionDetallePedido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juape
 */
public class ItemDevolverProducto extends JPanel {

    protected JLabel nombre;
    protected JLabel presentacion;
    protected JLabel cantidad;
    protected JLabel precio;
    protected JButton devolver;
    protected boolean control = false;
    protected boolean control2 = true;

    public ItemDevolverProducto(final DetallePedido detalle) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500, 45));
        this.setBackground(new Color(252, 252, 252));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

        this.nombre = new JLabel(detalle.getPresentacion().getProudcto().getNombre());
        this.nombre.setForeground(new Color(149, 149, 149));
        this.nombre.setFont(new Font("Arial", Font.PLAIN, 12));
        this.nombre.setBounds(10, 10, 120, 25);

        this.presentacion = new JLabel(detalle.getPresentacion().getPresentacion().getDescripcion());
        this.presentacion.setForeground(new Color(149, 149, 149));
        this.presentacion.setFont(new Font("Arial", Font.PLAIN, 12));
        this.presentacion.setBounds(130, 10, 100, 25);

        this.cantidad = new JLabel(detalle.getCantidad() + "");
        this.cantidad.setForeground(new Color(149, 149, 149));
        this.cantidad.setFont(new Font("Arial", Font.PLAIN, 12));
        this.cantidad.setBounds(250, 10, 80, 25);

        this.precio = new JLabel(detalle.getSubtotal() + "");
        this.precio.setForeground(new Color(149, 149, 149));
        this.precio.setFont(new Font("Arial", Font.PLAIN, 12));
        this.precio.setBounds(330, 10, 80, 25);

        if (detalle.getEstado().equals("AC") || detalle.getEstado().equals("EE")) {
            devolver = new JButton("Devolver");
            devolver.setBounds(420, 7, 120, 28);
            devolver.setBackground(new Color(253, 148, 2));
            devolver.setForeground(Color.WHITE);
            devolver.setFont(new Font("Arial", Font.BOLD, 12));
            devolver.setBorder(null);
            devolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            devolver.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GestionDetallePedido gestion = new GestionDetallePedido();
                    if (control) {//registramos
                        detalle.setTipoOperacion("ac");
                        gestion.actualizarEstadoPlato(detalle);
                        devolver.setText("Devolver");
                        control = false;
                    } else {//cancelamos                    
                        detalle.setTipoOperacion("de");
                        gestion.actualizarEstadoPlato(detalle);
                        devolver.setBackground(new Color(179, 179, 179));
                        devolver.setText("Cancelar devol.");
                        control = true;
                    }
                }
            });

        } else {
            if (detalle.getEstado().equals("EN")) {//en este estado que es EN=enviado (el cocinero todavia ni lo empieza a preparar)
                //aqui podemos quitar producto del pedido
                devolver = new JButton("Quitar de pedido");
                devolver.setBounds(420, 7, 120, 28);
                devolver.setBackground(new Color(253, 148, 2));
                devolver.setForeground(Color.WHITE);
                devolver.setFont(new Font("Arial", Font.BOLD, 12));
                devolver.setBorder(null);
                devolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                devolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GestionDetallePedido gestion = new GestionDetallePedido();
                        detalle.setTipoOperacion("cc");
                        gestion.actualizarEstadoPlato(detalle);
                        devolver.setText("Quitado");
                        devolver.setBackground(new Color(179, 179, 179));
                        devolver.setEnabled(false);
                    }
                });

            } else {
                if (detalle.getEstado().equals("CC")) {//en este estado que es EN=enviado (el cocinero todavia ni lo empieza a preparar)
                    //aqui podemos quitar producto del pedido
                    devolver = new JButton("Quitado");
                    devolver.setBounds(420, 7, 120, 28);
                    devolver.setBackground(new Color(179, 179, 179));
                    devolver.setForeground(Color.WHITE);
                    devolver.setFont(new Font("Arial", Font.BOLD, 12));
                    devolver.setBorder(null);
                    devolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    devolver.setEnabled(false);

                } else {
                    if (detalle.getEstado().equals("DE")) {//en este estado que es EN=enviado (el cocinero todavia ni lo empieza a preparar)
                        //aqui podemos quitar producto del pedido
                        devolver = new JButton("Cancelar devol.");
                        devolver.setBounds(420, 7, 120, 28);
                        devolver.setBackground(new Color(179, 179, 179));
                        devolver.setForeground(Color.WHITE);
                        devolver.setFont(new Font("Arial", Font.BOLD, 12));
                        devolver.setBorder(null);
                        devolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        devolver.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GestionDetallePedido gestion = new GestionDetallePedido();
                                if (control2) {//registramos
                                    detalle.setTipoOperacion("ac");
                                    gestion.actualizarEstadoPlato(detalle);
                                    devolver.setText("Devolver");
                                    control2 = false;
                                } else {//cancelamos                    
                                    detalle.setTipoOperacion("de");
                                    gestion.actualizarEstadoPlato(detalle);
                                    devolver.setBackground(new Color(179, 179, 179));
                                    devolver.setText("Cancelar devol.");
                                    control2 = true;
                                }
                            }
                        });
                    }
                }
            }

        }
        this.add(nombre);
        this.add(presentacion);
        this.add(cantidad);
        this.add(precio);
        this.add(devolver);
    }
}
