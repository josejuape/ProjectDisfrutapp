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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class ItemPlatoEnEspera extends JPanel {
    public JLabel icono;
    public JLabel cantidad;
    public JLabel nombre;
    public JLabel mesa;
    public JButton aceptar;
    public double cant = 0;
    public String estadoEspera = "I"; //I=inactivo,A=activo
    public String estadoAceptado = "N";//N= no aceptado, S=si aceptado
    public int idProducto = 0;
    public JPanel panel;

    public ItemPlatoEnEspera(final DetallePedido pedido,final JPanel parent){
        panel = this;
        this.idProducto = pedido.getPresentacion().getProudcto().getIdproductocarta();
        System.out.println("cantidad llnn: " + pedido.getCantidad());
        this.cant = this.cant + pedido.getCantidad();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(820, 45));
        this.setBackground(new Color(242, 242, 242));
        this.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        this.icono = new JLabel("ico");
        this.icono.setBounds(10, 10, 25, 25);
        this.cantidad = new JLabel(this.cant + "");
        this.cantidad.setFont(new Font("Arial", Font.BOLD, 12));
        this.cantidad.setBounds(50, 10, 80, 25);
        this.nombre = new JLabel(pedido.getPresentacion().getProudcto().getNombre());
        this.nombre.setBounds(150, 10, 250, 25);
        this.mesa = new JLabel("Mesa: " + pedido.getPedido().getMesa());
        this.mesa.setBounds(300, 10, 80, 25);        
        this.aceptar = new JButton("Aceptar");
        this.aceptar.setBounds(520, 10, 30, 25);
        this.aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionDetallePedido gestion = new GestionDetallePedido();
                pedido.setTipoOperacion("ac");
                gestion.actualizarEstadoPlato(pedido);
                parent.remove(panel);
            }
        });

        this.add(icono);
        this.add(cantidad);
        this.add(nombre);
        this.add(mesa);
        this.add(aceptar);
    }
}
