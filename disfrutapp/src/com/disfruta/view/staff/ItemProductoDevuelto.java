/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemProductoDevuelto extends JPanel {

    public JLabel nombre;
    public JLabel devuelto;
    public JLabel precio;
    public JComboBox presentacion;
    public JTextField cantidad;
    public JButton btnadd;
    public JLabel total;
    public JButton quitar;
    public ArrayList<PresentacionPrecioVenta> listapresentaciones = null;
    public ProductoCarta productoSelected = null;
    public PresentacionPrecioVenta presentacionSelect = null;
    public DetallePedido detalle = null;
    public double subtotal = 0;
    public ItemProductoDevuelto panel;
    public int idproducto = 0;
    public boolean control = false;// control para verificar si el producto ha sido agregado, False=no ha sido agregado

    public ItemProductoDevuelto(final DetallePedido producto, final PanelTabPedido parent) {
        this.panel = this;
        this.detalle = producto;
        this.idproducto = producto.getPresentacion().getProudcto().getIdproductocarta();
        productoSelected = producto.getPresentacion().getProudcto();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(820, 45));
        this.setBackground(new Color(252, 252, 252));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
        //label nombre
        this.nombre = new JLabel(producto.getPresentacion().getProudcto().getNombre());
        this.nombre.setFont(new Font("Arial", Font.BOLD, 12));
        this.nombre.setBounds(10, 10, 350, 25);
        //estado devuelto
        this.devuelto = new JLabel("");
        this.devuelto.setForeground(new Color(253, 148, 2));
        this.devuelto.setFont(new Font("Arial", Font.PLAIN, 12));
        this.devuelto.setBounds(250, 10, 80, 25);
        //label precio
        this.precio = new JLabel(producto.getPresentacion().getPrecioventa() + "");
        this.precio.setForeground(new Color(149, 149, 149));
        this.precio.setFont(new Font("Arial", Font.BOLD, 12));
        this.precio.setBounds(390, 10, 80, 25);
        //combo presentacion
        this.presentacion = new JComboBox();
        this.listapresentaciones = new ArrayList();
        this.presentacionSelect = producto.getPresentacion();
        this.listapresentaciones.add(this.presentacionSelect);
        this.presentacion.setModel(new resources.comboboxmodel.CboModelCartaPresentacion(this.listapresentaciones));
        this.presentacion.setSelectedIndex(0);
        this.presentacion.setBounds(480, 10, 150, 25);
        this.presentacion.setBackground(new Color(255, 255, 255));
        this.presentacion.setBorder(null);
        this.presentacion.setForeground(new Color(149, 149, 149));
        this.presentacion.setFont(new Font("Arial", Font.PLAIN, 12));
        this.presentacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.presentacion.setFocusable(false);
        //cantidad 
        this.cantidad = new JTextField();
        this.cantidad.setText((int)producto.getCantidad() + "");
        this.cantidad.setBounds(640, 10, 80, 25);
        this.cantidad.setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
        this.cantidad.setForeground(new Color(149, 149, 149));
        this.cantidad.setFont(new Font("Arial", Font.BOLD, 12));
        this.cantidad.setHorizontalAlignment(JTextField.CENTER);
        this.cantidad.setEditable(false);
        //subtotal
        total = new JLabel(redondear(producto.getSubtotal(), 2) + "");
        total.setForeground(new Color(149, 149, 149));
        total.setFont(new Font("Arial", Font.BOLD, 12));
        total.setBounds(790, 10, 80, 25);
        //boton agregar
        this.btnadd = new JButton("");
        this.btnadd.setBounds(730, 8, 28, 28);
        this.btnadd.setContentAreaFilled(false);
        this.btnadd.setBorderPainted(false);
        this.btnadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon estado_ac = new ImageIcon(getClass().getResource("/images/btn_add_producto.png"));
        btnadd.setIcon(estado_ac);
        this.btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!control) {
                    devuelto.setText(" Devuelto");
                    parent.listaProductosElegidosDevueltos.add(panel);
                    subtotal = redondear(Double.parseDouble(total.getText()), 2);
                    parent.montoTotal = parent.montoTotal + subtotal;
                    parent.montoTotal = redondear(parent.montoTotal, 2);
                    parent.cantidadProducto = (int) (parent.cantidadProducto + Double.parseDouble(cantidad.getText()));
                    PanelStaff.lblmontototal.setText(parent.montoTotal + "");
                    PanelStaff.lblTotalProductos.setText(parent.cantidadProducto + "");
                    control = true;//el producto ha sido agregado
                    panel.setBorder(BorderFactory.createMatteBorder(0, 6, 1, 0, new Color(229, 147, 35)));
                    productoSelected = producto.getPresentacion().getProudcto();
                    ImageIcon estado_de = new ImageIcon(getClass().getResource("/images/btn_add_producto_active.png"));
                    btnadd.setIcon(estado_de);
                    ImageIcon estado_qd = new ImageIcon(getClass().getResource("/images/btn_quitar_producto_active.png"));
                    quitar.setIcon(estado_qd);
                }
            }
        });

        this.quitar = new JButton("");
        this.quitar.setBounds(910, 14, 16, 16);
        this.quitar.setContentAreaFilled(false);
        this.quitar.setBorderPainted(false);
        ImageIcon estado_q = new ImageIcon(getClass().getResource("/images/btn_quitar_producto.png"));
        this.quitar.setIcon(estado_q);
        this.quitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (control) {
                    control = false;
                    devuelto.setText("");
                    parent.listaProductosElegidosDevueltos.remove(panel);
                    subtotal = redondear(Double.parseDouble(total.getText()), 2);
                    parent.montoTotal = parent.montoTotal - subtotal;
                    parent.montoTotal = redondear(parent.montoTotal, 2);
                    parent.cantidadProducto = (int) (parent.cantidadProducto - Double.parseDouble(cantidad.getText()));
                    PanelStaff.lblmontototal.setText(parent.montoTotal + "");
                    PanelStaff.lblTotalProductos.setText(parent.cantidadProducto + "");
                    panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                    ImageIcon estado_de = new ImageIcon(getClass().getResource("/images/btn_add_producto.png"));
                    btnadd.setIcon(estado_de);
                    ImageIcon estado_q = new ImageIcon(getClass().getResource("/images/btn_quitar_producto.png"));
                    quitar.setIcon(estado_q);
                    System.out.println("paren.resumen: " + parent.resumen);
                    if (parent.resumen) { // para verificar si estoy en vista Ver Pedido
                        // cuando estoy en esta vista la X deberia borrar el producto de la lista
                        parent.panelContainerProductos.remove(panel);
                    }
                }
            }
        });
        //add components
        this.add(nombre);
        this.add(devuelto);
        this.add(precio);
        this.add(presentacion);
        this.add(cantidad);
        this.add(btnadd);
        this.add(total);
        this.add(quitar);
    }

    public double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }
}
