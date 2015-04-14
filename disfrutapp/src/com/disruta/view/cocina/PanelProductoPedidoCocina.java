/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disruta.view.cocina;

import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.logistica.CocineroPlatos;
import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.gestion.logistica.GestionDetallePedido;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class PanelProductoPedidoCocina extends JPanel {

    public JLabel icono;
    public JLabel cantidad;
    public JLabel nombre;
    public JLabel mesa;
    public JLabel presentacion;
    public JLabel comentario;
    public JLabel yapreparado;//si es que el producto ha sido devuelto y esta siendo vendido nuevamente- le avizara al cocinero que este producto fue devuelto
    public JButton enespera;//icono del reloj
    public JButton aceptar;
    public double cant = 0;
    public String estadoEspera = "I"; //I=inactivo,A=activo
    public String estadoAceptado = "N";//N= no aceptado, S=si aceptado
    public int idProducto = 0;
    public JPanel panel;

    public PanelProductoPedidoCocina(final DetallePedido pedido, final ArrayList<ItemStaffSesion> staffCocina, final JPanel parent) {
        panel = this;
        this.idProducto = pedido.getPresentacion().getProudcto().getIdproductocarta();
        System.out.println("cantidad llnn: " + pedido.getCantidad());
        this.cant = this.cant + pedido.getCantidad();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(960, 50));
        this.setBackground(new Color(252, 252, 252));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
        Image fotoimg = getToolkit().getImage(getClass().getResource("/images/fotoPerfil.png"));
        fotoimg = fotoimg.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        icono = new JLabel();
        icono.setIcon(new ImageIcon(fotoimg));
        this.icono.setBounds(20, 5, 40, 40);
        this.mesa = new JLabel("Mesa: " + pedido.getPedido().getMesa());
        this.mesa.setForeground(new Color(149, 149, 149));
        this.mesa.setFont(new Font("Arial", Font.BOLD, 12));
        this.mesa.setBounds(80, 10, 80, 25);
        this.cantidad = new JLabel((int) this.cant + "");
        this.cantidad.setForeground(new Color(149, 149, 149));
        this.cantidad.setFont(new Font("Arial", Font.BOLD, 12));
        this.cantidad.setBounds(190, 10, 80, 25);
        this.nombre = new JLabel(pedido.getPresentacion().getProudcto().getNombre());
        this.nombre.setForeground(new Color(149, 149, 149));
        this.nombre.setFont(new Font("Arial", Font.BOLD, 12));
        this.nombre.setBounds(250, 10, 250, 25);
        this.presentacion = new JLabel(pedido.getPresentacion().getPresentacion().getDescripcion());
        this.presentacion.setForeground(new Color(149, 149, 149));
        this.presentacion.setFont(new Font("Arial", Font.BOLD, 12));
        this.presentacion.setBounds(450, 10, 150, 25);
        this.comentario = new JLabel(pedido.getComentario());
        this.comentario.setForeground(new Color(149, 149, 149));
        this.comentario.setFont(new Font("Arial", Font.BOLD, 12));
        this.comentario.setBounds(600, 10, 250, 25);

        if (pedido.getEstado().equals("YP")) {
            this.yapreparado = new JLabel("Ya Preparado");
            this.yapreparado.setForeground(new Color(229, 147, 35));
            this.yapreparado.setFont(new Font("Arial", Font.BOLD, 12));
            this.yapreparado.setBounds(810, 10, 80, 25);
            this.add(yapreparado);
        } else {
            this.enespera = new JButton("reloj");
            this.enespera.setBounds(860, 10, 30, 25);
            this.enespera.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DialogSelectedStaffCocina dialog = new DialogSelectedStaffCocina(null, true);
                    int count = 0;
                    for (int i = 0; i < staffCocina.size(); i++) {
                        if (staffCocina.get(i).status.equals("Activo")) {
                            ItemStaffSelected item = new ItemStaffSelected(staffCocina.get(i).user);
                            dialog.panelCtnStaffCocina.add(item);
                            count = count + 1;
                        }
                    }
                    if (count > 1) {// si hay 1 cocinero es el mismo que ha iniciado sesion, debe haber mas de uno para poder elegir
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                        UsuarioDesktop userco = DialogSelectedStaffCocina.cocinero;
                        ArrayList<CocineroPlatos> cocineros = PanelCocina.cocineros;
                        if (userco != null) {
                            //agrego el pedido a la lista de espera al cocinero correspondiente
                            for (int i = 0; i < cocineros.size(); i++) {
                                if (userco.getIdUser() == cocineros.get(i).getUsuario().getIdUser()) {
                                    cocineros.get(i).getPlatos().add(pedido);
                                    break;
                                }
                            }
                            panel.setBorder(BorderFactory.createMatteBorder(6, 0, 1, 0, Color.red));
                            GestionDetallePedido gestion = new GestionDetallePedido();
                            pedido.setTipoOperacion("ee");
                            gestion.actualizarEstadoPlato(pedido);
                            //mostrar pedido a la lista de espera

                            parent.remove(panel);
                        }
                    } else {
                        panel.setBorder(BorderFactory.createMatteBorder(0, 6, 1, 0, Color.red));
                        GestionDetallePedido gestion = new GestionDetallePedido();
                        pedido.setTipoOperacion("ee");
                        gestion.actualizarEstadoPlato(pedido);
                    }
                }
            });
            this.add(enespera);
        }
        this.aceptar = new JButton("Aceptar");
        this.aceptar.setBounds(900, 10, 30, 25);
        this.aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBorder(new LineBorder(new Color(254, 190, 119), 1, true));
                GestionDetallePedido gestion = new GestionDetallePedido();
                pedido.setTipoOperacion("ac");
                gestion.actualizarEstadoPlato(pedido);
                parent.remove(panel);
            }
        });

        this.add(icono);
        this.add(mesa);
        this.add(cantidad);
        this.add(nombre);
        this.add(presentacion);
        this.add(comentario);
        this.add(aceptar);
    }
}
