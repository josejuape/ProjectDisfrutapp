/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.logistica.Pedido;
import com.disfruta.gestion.logistica.GestionPedido;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import resources.auxiliar.FechaActual;

/**
 *
 * @author user
 */
public class PanelHistorialPedido extends javax.swing.JPanel {
    public ArrayList<Pedido> pedidosHoy;
    /**
     * Creates new form PanelHistorialPedido
     */
    public PanelHistorialPedido() {        
        initComponents();
        init();
        this.setLayout(null);
        this.panelContainerPedidos.setLayout(new GridLayout(10,1, 0, 0));//gridLayout es una matriz (filas,columnas,margen de filas,margen de columnas)
        this.panelContainerPedidos.setBorder(null);
        this.scrollContainer.setBounds(0,65,960,450);
        this.lblTitulo.setBounds(40,10,300,25);
        this.panelBarra.setBounds(0,40, 960, 26);
        this.panelBarra.setLayout(null);
        this.panelBarra.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(230, 230, 230)));
        this.lblcodigo.setBounds(40, 3, 120, 18);
        this.lblfecha.setBounds(140, 3, 120, 18);
        this.lblmesa.setBounds(280, 3, 120, 18);
        this.lblnombre.setBounds(360, 3, 350, 18);
        this.lblcantidad.setBounds(580, 3, 120, 18);
        this.lbltotal.setBounds(700, 3, 120, 18);
    }
    
    private void init(){
        try {
            pedidosHoy=new ArrayList();
            System.out.println("fecha: "+FechaActual.formatoMysql());
            pedidosHoy=new GestionPedido().listarPedidosHoy(FechaActual.formatoMysql());
            System.out.println("size fecha: "+pedidosHoy.size());
            for (int i = 0; i < pedidosHoy.size(); i++) {
                Pedido pedido=pedidosHoy.get(i);
                ItemPedidoEnviado item=new ItemPedidoEnviado(pedido);
                panelContainerPedidos.add(item);
                if (i % 2 != 0) {
                    item.setBackground(new Color(252, 249, 245));
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelHistorialPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelHistorialPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        panelBarra = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        lblmesa = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblcantidad = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        scrollContainer = new javax.swing.JScrollPane();
        panelContainerPedidos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 102, 0));
        lblTitulo.setText("Historial de pedidos");

        panelBarra.setBackground(new java.awt.Color(254, 237, 220));

        lblcodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(153, 153, 153));
        lblcodigo.setText("Código");

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(153, 153, 153));
        lblfecha.setText("Fecha y Hora");

        lblmesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblmesa.setForeground(new java.awt.Color(153, 153, 153));
        lblmesa.setText("Mesa");

        lblnombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(153, 153, 153));
        lblnombre.setText("Nombre de usuario");

        lblcantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcantidad.setForeground(new java.awt.Color(153, 153, 153));
        lblcantidad.setText("Cantidad Prod.");

        lbltotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(153, 153, 153));
        lbltotal.setText("Total");

        javax.swing.GroupLayout panelBarraLayout = new javax.swing.GroupLayout(panelBarra);
        panelBarra.setLayout(panelBarraLayout);
        panelBarraLayout.setHorizontalGroup(
            panelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblcodigo)
                .addGap(58, 58, 58)
                .addComponent(lblfecha)
                .addGap(64, 64, 64)
                .addComponent(lblmesa)
                .addGap(69, 69, 69)
                .addComponent(lblnombre)
                .addGap(137, 137, 137)
                .addComponent(lblcantidad)
                .addGap(45, 45, 45)
                .addComponent(lbltotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBarraLayout.setVerticalGroup(
            panelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(lblfecha)
                    .addComponent(lblmesa)
                    .addComponent(lblnombre)
                    .addComponent(lblcantidad)
                    .addComponent(lbltotal))
                .addContainerGap())
        );

        scrollContainer.setBorder(null);
        scrollContainer.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelContainerPedidos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelContainerPedidosLayout = new javax.swing.GroupLayout(panelContainerPedidos);
        panelContainerPedidos.setLayout(panelContainerPedidosLayout);
        panelContainerPedidosLayout.setHorizontalGroup(
            panelContainerPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 849, Short.MAX_VALUE)
        );
        panelContainerPedidosLayout.setVerticalGroup(
            panelContainerPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        scrollContainer.setViewportView(panelContainerPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollContainer)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblcantidad;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblmesa;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JPanel panelBarra;
    public javax.swing.JPanel panelContainerPedidos;
    private javax.swing.JScrollPane scrollContainer;
    // End of variables declaration//GEN-END:variables
}
