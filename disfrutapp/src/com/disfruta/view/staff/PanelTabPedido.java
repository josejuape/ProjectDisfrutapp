/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.staff;

import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.Pedido;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.gestion.admin.GestionUsuarioDesktop;
import com.disfruta.gestion.logistica.GestionDetallePedido;
import com.disfruta.gestion.logistica.GestionFamiliaProducto;
import com.disfruta.gestion.logistica.GestionPedido;
import com.disfruta.gestion.logistica.GestionProductoCarta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class PanelTabPedido extends javax.swing.JPanel {

    protected resources.comboboxmodel.CboModelFamiliaProducto cboModelFamilia;
    protected resources.comboboxmodel.CboModelUsuario cboModelUsuario;
    public ArrayList<PanelProductoCartaItem> listaProductosElegidos;
    public ArrayList<ItemProductoDevuelto> listaProductosElegidosDevueltos;
    public ArrayList<PanelProductoCartaItem> listadoProductos;
    public ArrayList<ItemProductoDevuelto> listaProductosDevueltos;
    public boolean control_devueltos = false;//para controlar si se esta en vista de productos devueltos
    public double montoTotal = 0;// para ir sumando el total cada ves q se agrega un producto
    public int cantidadProducto = 0;//para mostrar cantidad de productos marcados
    public boolean resumen = false;//variable para controlar la activacion del boton terminar pedido; se activa solo cuando le doy ver pedido

    /**
     * Creates new form PanelTabPedido
     */
    public PanelTabPedido() {
        init();
        initComponents();
        cargarProductos();
        this.setPreferredSize(new Dimension(960, 480));
        this.setLayout(null);
        this.lbltituloproddevueltos.setBounds(8, 10, 200, 24);
        this.lbltituloproddevueltos.setVisible(false);
        this.lbliconuser.setBounds(8, 10, 25, 25);
        this.cboUsuarioStaff.setBounds(35, 10, 280, 25);
        this.lblnummesa.setBounds(325, 10, 50, 25);
        this.txtNumeroMesa.setBounds(385, 10, 90, 25);
        this.btnMostrarProductosDvueltos.setBounds(910, 8, 40, 30);
        this.btnBuscarPorCarta.setBounds(8, 45, 470, 30);
        this.btnBuscarPorNombre.setBounds(482, 45, 470, 30);
        this.panelbusqueda.setBounds(8, 77, 944, 25);
        this.panelbusqueda.setLayout(null);
        this.cboBuscarPorCategoria.setBounds(0, 0, 944, 25);
        this.txtBuscarPorNombreProducto.setBounds(2, 0, 940, 25);
        this.panelTitulos.setBounds(0, 108, 960, 26);
        this.panelTitulos.setLayout(null);
        this.panelTitulos.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(230, 230, 230)));
        this.lblproducto.setBounds(10, 3, 120, 18);
        this.lblprecio.setBounds(370, 3, 120, 18);
        this.lblpresentacion.setBounds(510, 3, 120, 18);
        this.lblcantidad.setBounds(650, 3, 120, 18);
        this.lblsubtotal.setBounds(780, 3, 100, 18);
        this.scrollContainer.setBounds(0, 135, 960, 375);
        this.scrollContainer.setBorder(null);

        this.cboBuscarPorCategoria.setModel(cboModelFamilia);
        this.panelContainerProductos.setLayout(new GridLayout(10, 1, 1, 0));//gridLayout es una matriz (filas,columnas,margen de filas,margen de columnas)
        this.panelContainerProductos.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));// margenes internos para el panel

        this.txtBuscarPorNombreProducto.setVisible(false);
        this.cboUsuarioStaff.setModel(cboModelUsuario);
        PaddingLeft.agregarpadding(this.txtBuscarPorNombreProducto);
        PaddingLeft.agregarpadding(this.txtNumeroMesa);
        this.cboBuscarPorCategoria.setBackground(Color.white);
        this.cboUsuarioStaff.setBackground(Color.white);
    }

    private void init() {
        try {
            listaProductosElegidos = new ArrayList();
            listaProductosElegidosDevueltos = new ArrayList();
            this.cboModelUsuario = new resources.comboboxmodel.CboModelUsuario(new GestionUsuarioDesktop().listarStaff());
            listadoProductos = new ArrayList();
            this.cboModelFamilia = new resources.comboboxmodel.CboModelFamiliaProducto(new GestionFamiliaProducto().listar());
            this.listaProductosDevueltos = new ArrayList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarUltimaSeleccion() {
        System.out.println("llenar ultima seleccion: " + listadoProductos.size());
        for (int i = 0; i < listadoProductos.size(); i++) {
            PanelProductoCartaItem obj = (PanelProductoCartaItem) listadoProductos.get(i);
            if (obj.productoSelected != null) {
                boolean band = true;
                for (int j = 0; j < listaProductosElegidos.size(); j++) {
                    if (obj.idproducto == listaProductosElegidos.get(j).idproducto) {
                        this.listaProductosElegidos.set(j, obj);
                        band = false;
                        break;
                    }
                }
                if (band) {
                    this.listaProductosElegidos.add(obj);
                }
            }

        }
        this.listadoProductos = new ArrayList();
    }

    public void cargarProductos() {
        try {
            if (listadoProductos.size() > 0) {
                llenarUltimaSeleccion();
            }
            this.panelContainerProductos.removeAll();

            int rows = 10;
            ArrayList<ProductoCarta> lista = new GestionProductoCarta().listarCarta();
            if (lista.size() > 10) {
                rows = lista.size();
            }
            this.panelContainerProductos.setLayout(new GridLayout(rows, 1, 1, 0));
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("listado productos: " + listadoProductos.size());
                boolean band = false;
                PanelProductoCartaItem panelProducto = null;
                for (int j = 0; j < listaProductosElegidos.size(); j++) {
                    if (lista.get(i).getIdproductocarta() == listaProductosElegidos.get(j).idproducto) {
                        band = true;
                        panelProducto = listaProductosElegidos.get(j);
                        break;
                    }
                }
                if (band == false) {
                    panelProducto = new PanelProductoCartaItem(lista.get(i), this);
                }
                this.listadoProductos.add(panelProducto);
                this.panelContainerProductos.add(panelProducto);
                if (i % 2 != 0) {
                    panelProducto.setBackground(new Color(252, 249, 245));
                }
            }
            this.panelContainerProductos.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<PanelProductoCartaItem> getListaProductosElegidos() {
        return listaProductosElegidos;
    }

    public void setListaProductosElegidos(ArrayList<PanelProductoCartaItem> listaProductosElegidos) {
        this.listaProductosElegidos = listaProductosElegidos;
    }

    public JPanel getPanelContainerProductos() {
        return panelContainerProductos;
    }

    public void setPanelContainerProductos(JPanel panelContainerProductos) {
        this.panelContainerProductos = panelContainerProductos;
    }

    public ArrayList<ItemProductoDevuelto> getListaProductosElegidosDevueltos() {
        return listaProductosElegidosDevueltos;
    }

    public void setListaProductosElegidosDevueltos(ArrayList<ItemProductoDevuelto> listaProductosElegidosDevueltos) {
        this.listaProductosElegidosDevueltos = listaProductosElegidosDevueltos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbliconuser = new javax.swing.JLabel();
        cboUsuarioStaff = new javax.swing.JComboBox();
        txtNumeroMesa = new javax.swing.JTextField();
        btnBuscarPorCarta = new javax.swing.JButton();
        btnBuscarPorNombre = new javax.swing.JButton();
        panelbusqueda = new javax.swing.JPanel();
        cboBuscarPorCategoria = new javax.swing.JComboBox();
        txtBuscarPorNombreProducto = new javax.swing.JTextField();
        scrollContainer = new javax.swing.JScrollPane();
        panelContainerProductos = new javax.swing.JPanel();
        lblnummesa = new javax.swing.JLabel();
        btnMostrarProductosDvueltos = new javax.swing.JButton();
        panelTitulos = new javax.swing.JPanel();
        lblproducto = new javax.swing.JLabel();
        lblprecio = new javax.swing.JLabel();
        lblpresentacion = new javax.swing.JLabel();
        lblcantidad = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        lbltituloproddevueltos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbliconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cboStaff.png"))); // NOI18N

        cboUsuarioStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Seleccione Staff -", "Item 2", "Item 3", "Item 4" }));
        cboUsuarioStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsuarioStaffActionPerformed(evt);
            }
        });

        txtNumeroMesa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroMesa.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroMesa.setToolTipText("");
        txtNumeroMesa.setAlignmentX(0.0F);
        txtNumeroMesa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroMesa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroMesa.setName("txtusuario"); // NOI18N
        txtNumeroMesa.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroMesaActionPerformed(evt);
            }
        });
        txtNumeroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroMesaKeyReleased(evt);
            }
        });

        btnBuscarPorCarta.setBackground(new java.awt.Color(253, 148, 2));
        btnBuscarPorCarta.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnBuscarPorCarta.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPorCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_carta.png"))); // NOI18N
        btnBuscarPorCarta.setText("Carta");
        btnBuscarPorCarta.setBorder(null);
        btnBuscarPorCarta.setBorderPainted(false);
        btnBuscarPorCarta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPorCarta.setFocusable(false);
        btnBuscarPorCarta.setRolloverEnabled(false);
        btnBuscarPorCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorCartaActionPerformed(evt);
            }
        });

        btnBuscarPorNombre.setBackground(new java.awt.Color(254, 190, 119));
        btnBuscarPorNombre.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnBuscarPorNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_buscar.png"))); // NOI18N
        btnBuscarPorNombre.setText("Buscar");
        btnBuscarPorNombre.setBorder(null);
        btnBuscarPorNombre.setBorderPainted(false);
        btnBuscarPorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPorNombre.setFocusable(false);
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });

        panelbusqueda.setBackground(new java.awt.Color(255, 255, 255));

        cboBuscarPorCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Busqueda por familia de porducto -", "Item 2", "Item 3", "Item 4" }));
        cboBuscarPorCategoria.setBorder(null);
        cboBuscarPorCategoria.setFocusable(false);
        cboBuscarPorCategoria.setOpaque(false);
        cboBuscarPorCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBuscarPorCategoriaItemStateChanged(evt);
            }
        });
        cboBuscarPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBuscarPorCategoriaActionPerformed(evt);
            }
        });

        txtBuscarPorNombreProducto.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtBuscarPorNombreProducto.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarPorNombreProducto.setText("Buscar por nombre de producto");
        txtBuscarPorNombreProducto.setToolTipText("");
        txtBuscarPorNombreProducto.setAlignmentX(0.0F);
        txtBuscarPorNombreProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtBuscarPorNombreProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscarPorNombreProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtBuscarPorNombreProducto.setName("txtusuario"); // NOI18N
        txtBuscarPorNombreProducto.setOpaque(false);
        txtBuscarPorNombreProducto.setPreferredSize(new java.awt.Dimension(280, 24));
        txtBuscarPorNombreProducto.setSelectionColor(new java.awt.Color(229, 147, 35));
        txtBuscarPorNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPorNombreProductoActionPerformed(evt);
            }
        });
        txtBuscarPorNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorNombreProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelbusquedaLayout = new javax.swing.GroupLayout(panelbusqueda);
        panelbusqueda.setLayout(panelbusquedaLayout);
        panelbusquedaLayout.setHorizontalGroup(
            panelbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarPorNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(cboBuscarPorCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelbusquedaLayout.setVerticalGroup(
            panelbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbusquedaLayout.createSequentialGroup()
                .addComponent(cboBuscarPorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscarPorNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrollContainer.setBackground(new java.awt.Color(255, 255, 255));
        scrollContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 1, true));
        scrollContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelContainerProductos.setBackground(new java.awt.Color(255, 255, 255));
        panelContainerProductos.setForeground(new java.awt.Color(255, 255, 255));
        panelContainerProductos.setLayout(null);
        scrollContainer.setViewportView(panelContainerProductos);

        lblnummesa.setForeground(new java.awt.Color(102, 102, 102));
        lblnummesa.setText("N° Mesa:");

        btnMostrarProductosDvueltos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_productos_devueltos.png"))); // NOI18N
        btnMostrarProductosDvueltos.setBorderPainted(false);
        btnMostrarProductosDvueltos.setContentAreaFilled(false);
        btnMostrarProductosDvueltos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarProductosDvueltos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_productos_devueltos_active.png"))); // NOI18N
        btnMostrarProductosDvueltos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_productos_devueltos_active.png"))); // NOI18N
        btnMostrarProductosDvueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProductosDvueltosActionPerformed(evt);
            }
        });

        panelTitulos.setBackground(new java.awt.Color(254, 237, 220));

        lblproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblproducto.setForeground(new java.awt.Color(153, 153, 153));
        lblproducto.setText("Producto");

        lblprecio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(153, 153, 153));
        lblprecio.setText("Precio unit.");

        lblpresentacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblpresentacion.setForeground(new java.awt.Color(153, 153, 153));
        lblpresentacion.setText("Presentación");

        lblcantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcantidad.setForeground(new java.awt.Color(153, 153, 153));
        lblcantidad.setText("Cantidad");

        lblsubtotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblsubtotal.setForeground(new java.awt.Color(153, 153, 153));
        lblsubtotal.setText("SubTotal");

        javax.swing.GroupLayout panelTitulosLayout = new javax.swing.GroupLayout(panelTitulos);
        panelTitulos.setLayout(panelTitulosLayout);
        panelTitulosLayout.setHorizontalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblproducto)
                .addGap(310, 310, 310)
                .addComponent(lblprecio)
                .addGap(73, 73, 73)
                .addComponent(lblpresentacion)
                .addGap(62, 62, 62)
                .addComponent(lblcantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblsubtotal)
                .addGap(75, 75, 75))
        );
        panelTitulosLayout.setVerticalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio)
                    .addComponent(lblpresentacion)
                    .addComponent(lblcantidad)
                    .addComponent(lblsubtotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbltituloproddevueltos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbltituloproddevueltos.setForeground(new java.awt.Color(253, 148, 2));
        lbltituloproddevueltos.setText("Productos devueltos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTitulos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lbliconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboUsuarioStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(lblnummesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbltituloproddevueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)))
                        .addComponent(btnMostrarProductosDvueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBuscarPorCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbltituloproddevueltos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboUsuarioStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblnummesa))
                            .addComponent(lbliconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarProductosDvueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPorCarta)
                    .addComponent(btnBuscarPorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(scrollContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboUsuarioStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsuarioStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsuarioStaffActionPerformed

    private void txtNumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroMesaActionPerformed

    private void btnBuscarPorCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorCartaActionPerformed
        // TODO add your handling code here:
        this.btnBuscarPorCarta.setBackground(new Color(229, 147, 35));
        this.btnBuscarPorNombre.setBackground(new Color(254, 190, 119));
        this.cboBuscarPorCategoria.setVisible(true);
        this.txtBuscarPorNombreProducto.setVisible(false);

    }//GEN-LAST:event_btnBuscarPorCartaActionPerformed

    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        // TODO add your handling code here:
        this.btnBuscarPorNombre.setBackground(new Color(229, 147, 35));
        this.btnBuscarPorCarta.setBackground(new Color(254, 190, 119));
        this.txtBuscarPorNombreProducto.setVisible(true);
        this.cboBuscarPorCategoria.setVisible(false);

        //cpodigo de ejemplo

        //        JPanel panel=new JPanel();
        //        panel.setLayout(null);
        //        panel.setPreferredSize(new Dimension(820,45));
        //        panel.setBackground(new Color(242,242,242));
        //        panel.setBorder(new LineBorder(new Color(255,255,255),2,true));
        //
        //        JLabel nombre=new JLabel("nuevo rpdocuto");
        //        nombre.setFont(new Font("Arial",Font.BOLD, 12));
        //        nombre.setBounds(10,10,350, 25);
        //        panel.add(nombre);
        //        JLabel precio=new JLabel("S/ 1452.56");
        //        precio.setForeground(new Color(149,149,149));
        //        precio.setFont(new Font("Arial",Font.BOLD, 12));
        //        precio.setBounds(390,10,80, 25);
        //        panel.add(precio);
        //        JComboBox combo=new JComboBox();
        //        combo.setRenderer(new ListCellRenderer() {
        //    @Override
        //    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //        final JLabel renderer = new JLabel(value.toString());
        //        if (isSelected) {
        //            renderer.setOpaque(true);
        //            renderer.setForeground(Color.white);
        //            renderer.setBackground(new Color(229,147,35));
        //            renderer.setFont(new Font("Arial",Font.BOLD, 12));
        //        }
        //        return renderer;
        //    }
        //});
        //        combo.addItem("uno");
        //        combo.addItem("dos");
        //        combo.setBounds(480, 10,150,25);
        //        combo.setBackground(new Color(255,255,255));
        //        combo.setBorder(new LineBorder(new Color(230,230,230),1,true));
        //        combo.setForeground(new Color(149,149,149));
        //        combo.setFont(new Font("Arial",Font.BOLD, 12));
        //        combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //        combo.setFocusable(false);
        //
        //        panel.add(combo);
        //        JTextField cantidad=new JTextField();
        //        cantidad.setBounds(640, 10,80,25);
        //        cantidad.setBorder(new LineBorder(new Color(230,230,230),1,true));
        //        cantidad.setForeground(new Color(149,149,149));
        //        cantidad.setFont(new Font("Arial",Font.BOLD, 12));
        //        cantidad.setHorizontalAlignment(JTextField.CENTER);
        //        panel.add(cantidad);
        //        JButton add=new JButton("+");
        //        add.setBounds(730, 10,45,25);
        //        add.setBackground(new Color(229,147,35));
        //        add.setForeground(new Color(255,255,255));
        //        add.setFont(new Font("Arial",Font.BOLD, 12));
        //        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //        add.addActionListener(new ActionListener(){
        //            @Override
        //            public void actionPerformed(ActionEvent e) {
        //
        //            }
        //        });
        //        panel.add(add);
        //        JLabel pr=new JLabel("S/ 2452.56");
        //        pr.setForeground(new Color(149,149,149));
        //        pr.setFont(new Font("Arial",Font.BOLD, 12));
        //        pr.setBounds(790,10, 80,25);
        //        panel.add(pr);
        //        this.panelContainerProductos.setLayout(new GridLayout(0,1));

    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

    private void cboBuscarPorCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBuscarPorCategoriaItemStateChanged
        try {
            // TODO add your handling code here:  
            this.resumen = false;
            PanelStaff.btnTerminarPedido.setBackground(new Color(102, 102, 102));
            if (listadoProductos.size() > 0) {
                llenarUltimaSeleccion();
            }
            this.panelContainerProductos.removeAll();

            int fila = this.cboBuscarPorCategoria.getSelectedIndex();
            FamiliaProducto familia = this.cboModelFamilia.getElement(fila);
            int rows = 10;
            ArrayList<ProductoCarta> lista = new GestionProductoCarta().listarPorFamilia(familia);
            if (lista.size() > 10) {
                rows = lista.size();
            }
            this.panelContainerProductos.setLayout(new GridLayout(rows, 1, 0, 0));
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("listado productos: " + listadoProductos.size());
                boolean band = false;
                PanelProductoCartaItem panelProducto = null;
                for (int j = 0; j < listaProductosElegidos.size(); j++) {
                    if (lista.get(i).getIdproductocarta() == listaProductosElegidos.get(j).idproducto) {
                        band = true;
                        panelProducto = listaProductosElegidos.get(j);
                        break;
                    }
                }
                if (band == false) {
                    panelProducto = new PanelProductoCartaItem(lista.get(i), this);
                }
                this.listadoProductos.add(panelProducto);
                this.panelContainerProductos.add(panelProducto);
                if (i % 2 != 0) {
                    panelProducto.setBackground(new Color(252, 249, 245));
                }
            }
            this.panelContainerProductos.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboBuscarPorCategoriaItemStateChanged

    private void cboBuscarPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBuscarPorCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBuscarPorCategoriaActionPerformed

    private void txtBuscarPorNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPorNombreProductoActionPerformed

    private void txtBuscarPorNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreProductoKeyReleased
        try {
            // TODO add your handling code here:
            this.panelContainerProductos.removeAll();
            this.resumen = false;
            PanelStaff.btnTerminarPedido.setBackground(new Color(102, 102, 102));
            String cad = this.txtBuscarPorNombreProducto.getText();
            if (cad.length() > 1) {
                System.out.println("busco por: " + cad);
                int rows = 10;
                ArrayList<ProductoCarta> lista = new GestionProductoCarta().listarPorBusqueda(cad);
                System.out.println("size: " + lista.size());
                if (lista.size() > 10) {
                    rows = lista.size();
                }
                this.panelContainerProductos.setLayout(new GridLayout(rows, 1, 0, 0));
                for (int i = 0; i < lista.size(); i++) {
                    boolean band = false;
                    PanelProductoCartaItem panelProducto = null;
                    for (int j = 0; j < listaProductosElegidos.size(); j++) {
                        if (lista.get(i).getIdproductocarta() == listaProductosElegidos.get(j).idproducto) {
                            band = true;
                            panelProducto = listaProductosElegidos.get(j);
                            break;
                        }
                    }
                    if (band == false) {
                        panelProducto = new PanelProductoCartaItem(lista.get(i), this);
                    }
                    this.panelContainerProductos.add(panelProducto);
                    if (i % 2 != 0) {
                        panelProducto.setBackground(new Color(252, 249, 245));
                    }
                }
            }
            this.panelContainerProductos.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtBuscarPorNombreProductoKeyReleased

    private void txtNumeroMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroMesaKeyReleased
        // TODO add your handling code here:
        JTabbedPane tabbed = (JTabbedPane) this.txtNumeroMesa.getParent().getParent();
        PanelStaff panel = (PanelStaff) this.txtNumeroMesa.getParent().getParent().getParent();
        int select = tabbed.getSelectedIndex();
        String numero = this.txtNumeroMesa.getText();
        tabbed.setTitleAt(select, numero + " ");
        panel.lblnummesa.setText(numero);
    }//GEN-LAST:event_txtNumeroMesaKeyReleased

    private void btnMostrarProductosDvueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProductosDvueltosActionPerformed
        try {
            // TODO add your handling code here:
            this.control_devueltos = true;
            ImageIcon estado_ac = new ImageIcon(getClass().getResource("/images/btn_productos_devueltos_active.png"));
            this.btnMostrarProductosDvueltos.setIcon(estado_ac);
            this.btnBuscarPorCarta.setVisible(false);
            this.btnBuscarPorNombre.setVisible(false);
            this.panelbusqueda.setVisible(false);
            this.lbliconuser.setBounds(8, 40, 25, 25);
            this.cboUsuarioStaff.setBounds(35, 40, 280, 25);
            this.lblnummesa.setBounds(325, 40, 50, 25);
            this.txtNumeroMesa.setBounds(385, 40, 90, 25);
            this.panelTitulos.setBounds(0, 72, 960, 26);
            this.scrollContainer.setBounds(0, 98, 960, 425);
            this.lbltituloproddevueltos.setVisible(true);
            ArrayList<DetallePedido> listaproductos = new GestionProductoCarta().listarProductosDevueltos();
            int size = 10;
            if (listaproductos.size() > 10) {
                this.panelContainerProductos.setLayout(new GridLayout(listaProductosDevueltos.size(), 1, 0, 0));
            } else {
                this.panelContainerProductos.setLayout(new GridLayout(size, 1, 0, 0));
            }
            this.panelContainerProductos.removeAll();
            int sizelista = listaProductosDevueltos.size();
            for (int i = 0; i < listaproductos.size(); i++) {
                DetallePedido detalle = listaproductos.get(i);
                boolean band = true;//No esta en lista=true
                System.out.println("size devueltos: " + listaProductosDevueltos.size());
                for (int j = 0; j < sizelista; j++) {
                    ItemProductoDevuelto item = this.listaProductosDevueltos.get(j);
                    if (item.idproducto == detalle.getPresentacion().getProudcto().getIdproductocarta() && item.presentacionSelect.getPresentacion().getId() == detalle.getPresentacion().getPresentacion().getId()) {
                        band = false;//esta en lista=false
                    }
                }
                if (band) {//si no esta en lista lo agregamos
                    ItemProductoDevuelto itemDev = new ItemProductoDevuelto(detalle, this);
                    listaProductosDevueltos.add(itemDev);
                }
            }

            for (int i = 0; i < listaProductosDevueltos.size(); i++) {
                ItemProductoDevuelto item=listaProductosDevueltos.get(i);
                this.panelContainerProductos.add(item);
                if(i%2!=0){
                    item.setBackground(new Color(252,249,245));
                }
            }
            this.panelContainerProductos.updateUI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelTabPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelTabPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMostrarProductosDvueltosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarPorCarta;
    public javax.swing.JButton btnBuscarPorNombre;
    public javax.swing.JButton btnMostrarProductosDvueltos;
    protected javax.swing.JComboBox cboBuscarPorCategoria;
    protected javax.swing.JComboBox cboUsuarioStaff;
    private javax.swing.JLabel lblcantidad;
    public javax.swing.JLabel lbliconuser;
    public javax.swing.JLabel lblnummesa;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblpresentacion;
    private javax.swing.JLabel lblproducto;
    private javax.swing.JLabel lblsubtotal;
    public javax.swing.JLabel lbltituloproddevueltos;
    protected javax.swing.JPanel panelContainerProductos;
    public javax.swing.JPanel panelTitulos;
    public javax.swing.JPanel panelbusqueda;
    public javax.swing.JScrollPane scrollContainer;
    private javax.swing.JTextField txtBuscarPorNombreProducto;
    protected javax.swing.JTextField txtNumeroMesa;
    // End of variables declaration//GEN-END:variables
}
