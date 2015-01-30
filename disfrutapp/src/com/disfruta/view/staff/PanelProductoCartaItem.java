/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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
public class PanelProductoCartaItem extends JPanel {

    public JLabel nombre;
    public JLabel precio;
    public JComboBox presentacion;
    public JTextField cantidad;
    public JButton btnadd;
    public JLabel total;
    public JButton agregarOtro;
    public JButton quitar;
    public ArrayList<PresentacionPrecioVenta> listapresentaciones = null;
    public ProductoCarta productoSelected = null;
    public PresentacionPrecioVenta presentacionSelect = null;
    public double subtotal = 0;
    public JPanel panel;
    public int band_cant = 0;
    public int idproducto = 0;
    public boolean control = false;// control para verificar si el producto ha sido agregado, False=no ha sido agregado

    public PanelProductoCartaItem(final ProductoCarta producto, final PanelTabPedido parent) {
        this.panel = this;
        this.idproducto = producto.getIdproductocarta();
        this.listapresentaciones = producto.getPresentaciones();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(860, 45));
        this.setBackground(new Color(252, 252, 252));
        //this.setBorder(null);        
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
        //label nombre
        this.nombre = new JLabel(producto.getNombre());
        this.nombre.setFont(new Font("Arial", Font.BOLD, 12));
        this.nombre.setBounds(10, 10, 350, 25);
        //label precio
        this.precio = new JLabel("0.00");
        this.precio.setForeground(new Color(149, 149, 149));
        this.precio.setFont(new Font("Arial", Font.BOLD, 12));
        this.precio.setBounds(390, 10, 80, 25);
        //combo presentacion
        this.presentacion = new JComboBox();
        this.presentacion.setModel(new resources.comboboxmodel.CboModelCartaPresentacion(this.listapresentaciones));
//        this.presentacion.setRenderer(new ListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                final JLabel renderer = new JLabel(value.toString());
//                if (isSelected) {
//                    renderer.setOpaque(true);
//                    renderer.setForeground(Color.white);
//                    renderer.setBackground(new Color(229, 147, 35));
//                    renderer.setFont(new Font("Arial", Font.BOLD, 12));
//                }
//                return renderer;
//            }
//        });
        this.presentacion.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int row = presentacion.getSelectedIndex();
                presentacionSelect = listapresentaciones.get(row);
                precio.setText(redondear(presentacionSelect.getPrecioventa(), 2) + "");
            }
        });
        this.presentacion.setBounds(480, 10, 150, 25);
        this.presentacion.setBackground(new Color(255, 255, 255));
        this.presentacion.setBorder(null);
        this.presentacion.setForeground(new Color(149, 149, 149));
        this.presentacion.setFont(new Font("Arial", Font.PLAIN, 12));
        this.presentacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.presentacion.setFocusable(false);
        //cantidad 
        this.cantidad = new JTextField();
        this.cantidad.setBounds(640, 10, 80, 25);
        this.cantidad.setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
        this.cantidad.setForeground(new Color(149, 149, 149));
        this.cantidad.setFont(new Font("Arial", Font.BOLD, 12));
        this.cantidad.setHorizontalAlignment(JTextField.CENTER);
        //subtotal
        total = new JLabel("0.00");
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

                productoSelected = producto;
                if (!(cantidad.getText().equals("")) && presentacionSelect != null) {
                    if (control) {
                        parent.cantidadProducto = parent.cantidadProducto - band_cant;
                        if(parent.cantidadProducto<0){parent.cantidadProducto=(-1)*parent.cantidadProducto;}
                        band_cant=Integer.parseInt(cantidad.getText());
                        parent.cantidadProducto = parent.cantidadProducto +band_cant ;
                        parent.montoTotal = parent.montoTotal - subtotal;
                        subtotal=Integer.parseInt(cantidad.getText()) * Double.parseDouble(precio.getText());
                        parent.montoTotal = parent.montoTotal + subtotal;
                        parent.montoTotal = redondear(parent.montoTotal, 2);                        
                        PanelStaff.lblmontototal.setText(parent.montoTotal + "");
                        PanelStaff.lblTotalProductos.setText(parent.cantidadProducto + "");
                    } else {
                        band_cant = Integer.parseInt(cantidad.getText());
                        subtotal = Integer.parseInt(cantidad.getText()) * Double.parseDouble(precio.getText());
                        parent.cantidadProducto = parent.cantidadProducto + Integer.parseInt(cantidad.getText());
                        parent.montoTotal = parent.montoTotal + subtotal;
                        parent.montoTotal = redondear(parent.montoTotal, 2);
                        PanelStaff.lblmontototal.setText(parent.montoTotal + "");
                        PanelStaff.lblTotalProductos.setText(parent.cantidadProducto + "");
                    }
                    
                    total.setText(subtotal + "");

                    control = true;
                    panel.setBorder(BorderFactory.createMatteBorder(0, 6, 1, 0, new Color(229, 147, 35)));
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
                    panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                    subtotal = redondear(Double.parseDouble(total.getText()), 2);
                    parent.montoTotal = parent.montoTotal - subtotal;
                    parent.montoTotal = redondear(parent.montoTotal, 2);
                    parent.cantidadProducto = parent.cantidadProducto - Integer.parseInt(cantidad.getText());
                    PanelStaff.lblmontototal.setText(parent.montoTotal + "");
                    PanelStaff.lblTotalProductos.setText(parent.cantidadProducto + "");
                    productoSelected = null;
                    total.setText("0.00");
                    cantidad.setText("");
                    ImageIcon estado_de = new ImageIcon(getClass().getResource("/images/btn_add_producto.png"));
                    btnadd.setIcon(estado_de);
                    ImageIcon estado_q = new ImageIcon(getClass().getResource("/images/btn_quitar_producto.png"));
                    quitar.setIcon(estado_q);
                    if (parent.resumen) { // para verificar si estoy en vista Ver Pedido
                        // cuando estoy en esta vista la X deberia borrar el producto de la lista
                        parent.panelContainerProductos.remove(panel);
                    }
                }
            }
        });
        
        this.agregarOtro=new JButton("+");
        this.agregarOtro.setBounds(850,10,25,25);
        this.agregarOtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point c=panel.getLocation();                
                System.out.println("position: x "+c.x+" - y "+c.y);
                PanelProductoCartaItem item=new PanelProductoCartaItem(producto,parent);
                Point p=new Point(0,c.y+45);
                parent.add(item);
            }
        });
        
        //add components
        this.add(nombre);
        this.add(precio);
        this.add(presentacion);
        this.add(cantidad);
        this.add(btnadd);
        this.add(total);
        this.add(agregarOtro);
        this.add(quitar);
    }

    public double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }
}
