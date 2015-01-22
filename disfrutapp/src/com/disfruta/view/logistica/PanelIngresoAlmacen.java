/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.view.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.IngresoAlmacenInsumo;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.OrdenCompraInsumo;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.bean.xtbc.TipoComprobante;
import com.disfruta.gestion.logistica.GestionAlmacen;
import com.disfruta.gestion.logistica.GestionFormaPago;
import com.disfruta.gestion.logistica.GestionInsumo;
import com.disfruta.gestion.logistica.GestionOrdenCompra;
import com.disfruta.gestion.logistica.GestionOrdenCompraInsumo;
import com.disfruta.gestion.logistica.GestionPresentacionInsumo;
import com.disfruta.gestion.logistica.GestionProveedor;
import com.disfruta.gestion.logistica.GestionUnidadMedida;
import com.disfruta.gestion.xtbc.GestionMoneda;
import com.disfruta.gestion.xtbc.GestionTipoComprobante;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.auxiliar.FechaActual;
import resources.auxiliar.PaddingLeft;

/**
 *
 * @author Juape
 */
public class PanelIngresoAlmacen extends javax.swing.JPanel {

    private resources.comboboxmodel.CboModelAlmacen modelCboAlmacen;
    private resources.comboboxmodel.CboModelAlmacen modelCboAlmacen2;
    private resources.comboboxmodel.CboModelAlmacen modelCboAlmacen3;
    private resources.comboboxmodel.CboModelAlmacen modelCboAlmacen4;
    private resources.comboboxmodel.CboModelTipoComprobante modelCboTipoDocumento;
    private resources.comboboxmodel.CboModelTipoComprobante modelCboTipoDocumento3;
    private resources.comboboxmodel.CboModelTipoComprobante modelCboTipoDocumento4;
    private resources.comboboxmodel.CboModelFormaPago modelCboFormaPago;
    private resources.comboboxmodel.CboModelMoneda modelCboMoneda;
    private resources.comboboxmodel.CboModelMoneda modelCboMonedaInsumo2;
    private resources.comboboxmodel.CboModelMoneda modelCboMonedaInsumo3;
    private resources.comboboxmodel.CboModelMoneda modelCboMonedaInsumo4;
    private resources.comboboxmodel.CboModelUnidadMedida modelCboUnidad2;
    private resources.comboboxmodel.CboModelUnidadMedida modelCboUnidad3;
    private resources.comboboxmodel.CboModelUnidadMedida modelCboUnidad4;
    private resources.tablemodel.ModelTableIngresoAlmacenOC modelProductosPedidos1;
    private resources.tablemodel.ModelTableIngresoAlmacenInsumo modelDetalle2;
    private resources.tablemodel.ModelTableIngresoAlmacenInsumo modelDetalle3;
    private resources.tablemodel.ModelTableIngresoAlmacenInsumo modelDetalle4;
    protected resources.comboboxmodel.CboModelPresentacionCompra cboModelPresentacionInsumo2;
    protected resources.comboboxmodel.CboModelPresentacionCompra cboModelPresentacionInsumo3;
    protected resources.comboboxmodel.CboModelPresentacionCompra cboModelPresentacionInsumo4;
    protected ArrayList listaInsumos;
    protected ArrayList listaProveedores;
    protected Proveedor proveedorselected3 = null;
    protected Insumo insumoselected2 = null;
    protected Insumo insumoselected3 = null;
    protected Insumo insumoselected4 = null;
    protected TextAutoCompleter autoCompleteProveedor;
    protected TextAutoCompleter autoCompleteInsumo2;
    protected TextAutoCompleter autoCompleteInsumo3;
    protected TextAutoCompleter autoCompleteInsumo4;
    protected ArrayList<IngresoAlmacenInsumo> listaDetalle1;
    protected ArrayList<IngresoAlmacenInsumo> listaDetalle2;
    protected ArrayList<IngresoAlmacenInsumo> listaDetalle3;
    protected ArrayList<IngresoAlmacenInsumo> listaDetalle4;

    /**
     * Creates new form PanelIngresoAlmacen
     */
    public PanelIngresoAlmacen() {
        init();
        initComponents();
        this.cboAlmacen1.setModel(modelCboAlmacen);
        this.cboAlmacen2.setModel(modelCboAlmacen2);
        this.cboAlmacen3.setModel(modelCboAlmacen3);
        this.cboAlmacen4.setModel(modelCboAlmacen4);
        this.cboTipoDocumento2.setModel(modelCboTipoDocumento);
        this.cboTipoDocumento3.setModel(modelCboTipoDocumento3);
        this.cboTipoDocumento4.setModel(modelCboTipoDocumento4);
        this.tblProductosPedidos1.setModel(modelProductosPedidos1);
        this.cboFormaPago.setModel(modelCboFormaPago);
        this.cboMoneda.setModel(modelCboMoneda);
        this.cboMonedaInsumo2.setModel(modelCboMonedaInsumo2);
        this.cboMonedaInsumo3.setModel(modelCboMonedaInsumo3);
        this.cboMonedaInsumo4.setModel(modelCboMonedaInsumo4);
        this.cboUnidad2.setModel(modelCboUnidad2);
        this.cboUnidad3.setModel(modelCboUnidad3);
        this.cboUnidad4.setModel(modelCboUnidad4);
        this.tblProductosPedidos2.setModel(modelDetalle2);
        this.tblProductosPedidos3.setModel(modelDetalle3);
        this.tblProductosPedidos4.setModel(modelDetalle4);
        setPadding();
        this.lblFechaActual.setText(FechaActual.fechactualNumerico());
        this.lblFecha2.setText(FechaActual.fechactualNumerico());
        this.lblFecha3.setText(FechaActual.fechactualNumerico());
        this.lblFecha4.setText(FechaActual.fechactualNumerico());
        cargarListaInsumo();
    }

    private void init() {
        try {
            ArrayList<Almacen> listaAlamcenes = new GestionAlmacen().listar();
            this.modelCboAlmacen = new resources.comboboxmodel.CboModelAlmacen(listaAlamcenes);
            this.modelCboAlmacen2 = new resources.comboboxmodel.CboModelAlmacen(listaAlamcenes);
            this.modelCboAlmacen3 = new resources.comboboxmodel.CboModelAlmacen(listaAlamcenes);
            this.modelCboAlmacen4 = new resources.comboboxmodel.CboModelAlmacen(listaAlamcenes);
            this.modelProductosPedidos1 = new resources.tablemodel.ModelTableIngresoAlmacenOC();
            ArrayList<TipoComprobante> listaComprobantes = new GestionTipoComprobante().listar();
            this.modelCboTipoDocumento = new resources.comboboxmodel.CboModelTipoComprobante(listaComprobantes);
            this.modelCboTipoDocumento3 = new resources.comboboxmodel.CboModelTipoComprobante(listaComprobantes);
            this.modelCboTipoDocumento4 = new resources.comboboxmodel.CboModelTipoComprobante(listaComprobantes);
            this.modelCboFormaPago=new resources.comboboxmodel.CboModelFormaPago(new GestionFormaPago().listar());
            ArrayList<Moneda> listaMoneda = new GestionMoneda().listar();
            this.modelCboMoneda=new resources.comboboxmodel.CboModelMoneda(listaMoneda);
            this.modelCboMonedaInsumo2=new resources.comboboxmodel.CboModelMoneda(listaMoneda);
            this.modelCboMonedaInsumo3=new resources.comboboxmodel.CboModelMoneda(listaMoneda);
            this.modelCboMonedaInsumo4=new resources.comboboxmodel.CboModelMoneda(listaMoneda);
            ArrayList<UnidadMedida> listaUnidades = new GestionUnidadMedida().listar();
            this.modelCboUnidad2=new resources.comboboxmodel.CboModelUnidadMedida(listaUnidades);
            this.modelCboUnidad3=new resources.comboboxmodel.CboModelUnidadMedida(listaUnidades);
            this.modelCboUnidad4=new resources.comboboxmodel.CboModelUnidadMedida(listaUnidades);
            this.listaInsumos = new ArrayList();
            this.listaInsumos = new GestionInsumo().listar();
            this.listaDetalle1=new ArrayList();
            this.listaDetalle2=new ArrayList();
            modelDetalle2=new resources.tablemodel.ModelTableIngresoAlmacenInsumo(this.listaDetalle2);
            this.listaDetalle3=new ArrayList();
            modelDetalle3=new resources.tablemodel.ModelTableIngresoAlmacenInsumo(this.listaDetalle3);
            this.listaDetalle4=new ArrayList();
            modelDetalle4=new resources.tablemodel.ModelTableIngresoAlmacenInsumo(this.listaDetalle4);
            this.listaProveedores=new ArrayList();
            this.listaProveedores=new GestionProveedor().listar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelIngresoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelIngresoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setPadding() {
        this.cboAlmacen1.setBackground(Color.WHITE);
        this.cboAlmacen2.setBackground(Color.WHITE);
        this.cboAlmacen3.setBackground(Color.WHITE);
        this.cboAlmacen4.setBackground(Color.WHITE);
        this.cboFormaPago.setBackground(Color.WHITE);
        this.cboMoneda.setBackground(Color.WHITE);
        this.cboTipoDocumento2.setBackground(Color.WHITE);
        this.cboTipoDocumento3.setBackground(Color.WHITE);
        this.cboTipoDocumento4.setBackground(Color.WHITE);
        this.cboPresentacion2.setBackground(Color.WHITE);
        this.cboPresentacion3.setBackground(Color.WHITE);
        this.cboPresentacion4.setBackground(Color.WHITE);
        this.cboUnidad2.setBackground(Color.WHITE);
        this.cboUnidad3.setBackground(Color.WHITE);
        this.cboUnidad4.setBackground(Color.WHITE);
        this.cboMonedaInsumo2.setBackground(Color.WHITE);
        this.cboMonedaInsumo3.setBackground(Color.WHITE);
        this.cboMonedaInsumo4.setBackground(Color.WHITE);
        PaddingLeft.agregarpadding(this.txtCodigoOC);
        PaddingLeft.agregarpadding(this.txtNumeroDoc2);
        PaddingLeft.agregarpadding(this.txtNumeroDoc3);
        PaddingLeft.agregarpadding(this.txtNumeroDoc4);
        PaddingLeft.agregarpadding(this.txtCodigoInsumo2);
        PaddingLeft.agregarpadding(this.txtCodigoInsumo3);
        PaddingLeft.agregarpadding(this.txtCodigoInsumo4);
        PaddingLeft.agregarpadding(this.txtNombreInsumo2);
        PaddingLeft.agregarpadding(this.txtNombreInsumo3);
        PaddingLeft.agregarpadding(this.txtNombreInsumo4);
        PaddingLeft.agregarpadding(this.txtCantidadInsumo2);
        PaddingLeft.agregarpadding(this.txtCantidadInsumo3);
        PaddingLeft.agregarpadding(this.txtCantidadInsumo4);
        PaddingLeft.agregarpadding(this.txtPrecioInsumo2);
        PaddingLeft.agregarpadding(this.txtPrecioInsumo3);
        PaddingLeft.agregarpadding(this.txtPrecioInsumo4);
        PaddingLeft.agregarpadding(this.txtProveedor3);
    }

    
    
    private void cargarListaInsumo(){
        autoCompleteInsumo2 = new TextAutoCompleter(this.txtNombreInsumo2, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                String cad = selectedItem.toString();
                for (int i = 0; i < listaInsumos.size(); i++) {
                    if (cad.equals(((Insumo) listaInsumos.get(i)).getNombre())) {
                        try {
                            insumoselected2 = (Insumo) listaInsumos.get(i);
                            txtCodigoInsumo2.setText(insumoselected2.getIdinsumo() + "");
                            cboModelPresentacionInsumo2 = new resources.comboboxmodel.CboModelPresentacionCompra(new GestionPresentacionInsumo().listarPorInsumo(insumoselected2));
                            cboPresentacion2.setModel(cboModelPresentacionInsumo2);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        autoCompleteInsumo2.addItems(this.listaInsumos);
        autoCompleteInsumo3 = new TextAutoCompleter(this.txtNombreInsumo3, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                String cad = selectedItem.toString();
                for (int i = 0; i < listaInsumos.size(); i++) {
                    if (cad.equals(((Insumo) listaInsumos.get(i)).getNombre())) {
                        try {
                            insumoselected3 = (Insumo) listaInsumos.get(i);
                            txtCodigoInsumo3.setText(insumoselected3.getIdinsumo() + "");
                            cboModelPresentacionInsumo3 = new resources.comboboxmodel.CboModelPresentacionCompra(new GestionPresentacionInsumo().listarPorInsumo(insumoselected3));
                            cboPresentacion3.setModel(cboModelPresentacionInsumo3);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        autoCompleteInsumo3.addItems(this.listaInsumos);
        autoCompleteInsumo4 = new TextAutoCompleter(this.txtNombreInsumo4, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                String cad = selectedItem.toString();
                for (int i = 0; i < listaInsumos.size(); i++) {
                    if (cad.equals(((Insumo) listaInsumos.get(i)).getNombre())) {
                        try {
                            insumoselected4 = (Insumo) listaInsumos.get(i);
                            txtCodigoInsumo4.setText(insumoselected4.getIdinsumo() + "");
                            cboModelPresentacionInsumo4 = new resources.comboboxmodel.CboModelPresentacionCompra(new GestionPresentacionInsumo().listarPorInsumo(insumoselected4));
                            cboPresentacion4.setModel(cboModelPresentacionInsumo4);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        autoCompleteInsumo4.addItems(this.listaInsumos);  
        
        autoCompleteProveedor = new TextAutoCompleter(this.txtProveedor3, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                String cad = selectedItem.toString();
                for (int i = 0; i < listaProveedores.size(); i++) {
                    if (cad.equals(((Insumo) listaProveedores.get(i)).getNombre())) {
                        try {
                            proveedorselected3 = (Proveedor) listaProveedores.get(i);
                        } catch (Exception ex) {
                            Logger.getLogger(DialogPresComercialCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        autoCompleteProveedor.addItems(this.listaProveedores);  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneltitlealmacen = new javax.swing.JPanel();
        logoalmacen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevoAlmacen = new javax.swing.JButton();
        btnNuevoAlmacen1 = new javax.swing.JButton();
        btnNuevoAlmacen2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoParte1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboAlmacen1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoOC = new javax.swing.JTextField();
        btnCargarOC = new javax.swing.JButton();
        btnAdjuntarOrdenCompra = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        lblFechaOC = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosPedidos1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoParte2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblFecha2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboAlmacen2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboTipoDocumento2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroDoc2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario2 = new javax.swing.JTextArea();
        txtFechaEmisionDoc2 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        txtCodigoInsumo2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNombreInsumo2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cboPresentacion2 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        txtPrecioInsumo2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cboUnidad2 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        txtCantidadInsumo2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cboMonedaInsumo2 = new javax.swing.JComboBox();
        btnAddInsumo2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductosPedidos2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtCodigoParte3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblFecha3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cboAlmacen3 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cboTipoDocumento3 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        txtNumeroDoc3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComentario3 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        txtProveedor3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cboMoneda = new javax.swing.JComboBox();
        cboFormaPago = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        txtCodigoInsumo3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtNombreInsumo3 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        cboPresentacion3 = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        txtCantidadInsumo3 = new javax.swing.JTextField();
        cboUnidad3 = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtPrecioInsumo3 = new javax.swing.JTextField();
        cboMonedaInsumo3 = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        btnAddInsumo3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProductosPedidos3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtCodigoParte4 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lblFecha4 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cboTipoDocumento4 = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        txtNumeroDoc4 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtFechaEmisionDocInterno = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtComentario4 = new javax.swing.JTextArea();
        cboAlmacen4 = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        txtCodigoInsumo4 = new javax.swing.JTextField();
        txtNombreInsumo4 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        cboPresentacion4 = new javax.swing.JComboBox();
        txtCantidadInsumo4 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cboUnidad4 = new javax.swing.JComboBox();
        txtPrecioInsumo4 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        cboMonedaInsumo4 = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        btncAddInsumo4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProductosPedidos4 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(960, 590));

        paneltitlealmacen.setBackground(new java.awt.Color(238, 189, 122));
        paneltitlealmacen.setPreferredSize(new java.awt.Dimension(960, 60));

        logoalmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/almacen.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso de almacén");

        btnNuevoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoAlmacen.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoAlmacen.setForeground(new java.awt.Color(229, 147, 35));
        btnNuevoAlmacen.setText("Nuevo");
        btnNuevoAlmacen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoAlmacen.setBorderPainted(false);
        btnNuevoAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAlmacen.setFocusPainted(false);
        btnNuevoAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoAlmacen.setOpaque(false);
        btnNuevoAlmacen.setPreferredSize(new java.awt.Dimension(92, 30));

        btnNuevoAlmacen1.setBackground(new java.awt.Color(252, 242, 228));
        btnNuevoAlmacen1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoAlmacen1.setForeground(new java.awt.Color(83, 71, 65));
        btnNuevoAlmacen1.setText("Guardar");
        btnNuevoAlmacen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoAlmacen1.setBorderPainted(false);
        btnNuevoAlmacen1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAlmacen1.setFocusPainted(false);
        btnNuevoAlmacen1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoAlmacen1.setOpaque(false);
        btnNuevoAlmacen1.setPreferredSize(new java.awt.Dimension(92, 30));

        btnNuevoAlmacen2.setBackground(new java.awt.Color(229, 147, 35));
        btnNuevoAlmacen2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 11)); // NOI18N
        btnNuevoAlmacen2.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoAlmacen2.setText("Eliminar");
        btnNuevoAlmacen2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        btnNuevoAlmacen2.setBorderPainted(false);
        btnNuevoAlmacen2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAlmacen2.setFocusPainted(false);
        btnNuevoAlmacen2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoAlmacen2.setOpaque(false);
        btnNuevoAlmacen2.setPreferredSize(new java.awt.Dimension(92, 30));

        javax.swing.GroupLayout paneltitlealmacenLayout = new javax.swing.GroupLayout(paneltitlealmacen);
        paneltitlealmacen.setLayout(paneltitlealmacenLayout);
        paneltitlealmacenLayout.setHorizontalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltitlealmacenLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(logoalmacen)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(193, 193, 193)
                .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        paneltitlealmacenLayout.setVerticalGroup(
            paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltitlealmacenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoalmacen)
                .addGap(16, 16, 16))
            .addGroup(paneltitlealmacenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneltitlealmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevoAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevoAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Parte de entrada:");

        txtCodigoParte1.setText("12014-1245");

        jLabel4.setText("Fecha de parte de entrada:");

        lblFechaActual.setText("25/06/2014");

        jLabel6.setText("Nombre de almacén:");

        cboAlmacen1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Orden de compra (OC):");

        txtCodigoOC.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCodigoOC.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigoOC.setText("Ingresa código OC");
        txtCodigoOC.setToolTipText("");
        txtCodigoOC.setAlignmentX(0.0F);
        txtCodigoOC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCodigoOC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoOC.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCodigoOC.setName("txtusuario"); // NOI18N
        txtCodigoOC.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCodigoOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoOCActionPerformed(evt);
            }
        });

        btnCargarOC.setText("Cargar OC");
        btnCargarOC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarOCActionPerformed(evt);
            }
        });

        btnAdjuntarOrdenCompra.setText("Adjuntar Orden de compra");
        btnAdjuntarOrdenCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Datos de orden de compra ");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Proveedor:");

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Ruc:");

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Fecha de OC:");

        lblProveedor.setText("Empresa x EIRL");

        lblRuc.setText("10458525418");

        lblFechaOC.setText("12/10/2014");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechaOC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(lblRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblRuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblFechaOC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Productos de orden de compra");

        tblProductosPedidos1.setAutoCreateRowSorter(true);
        tblProductosPedidos1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblProductosPedidos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Contenido/ Cap", "Presentación comercial", "Cantidad", "Unidad", "Precio", "Moneda", "Atendidos", "Por atender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosPedidos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProductosPedidos1.setEditingColumn(0);
        tblProductosPedidos1.setEditingRow(0);
        tblProductosPedidos1.setSelectionBackground(new java.awt.Color(238, 189, 122));
        tblProductosPedidos1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProductosPedidos1);
        tblProductosPedidos1.getColumnModel().getColumn(0).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(1).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(2).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(3).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(4).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(5).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(6).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(7).setResizable(false);
        tblProductosPedidos1.getColumnModel().getColumn(8).setResizable(false);

        jCheckBox1.setText("Atender orden de compra completa");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCodigoParte1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFechaActual)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCodigoOC, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnCargarOC))
                                    .addComponent(btnAdjuntarOrdenCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(38, 38, 38))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCodigoParte1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblFechaActual)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAdjuntarOrdenCompra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarOC)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingreso con orden de compra", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Parte de entrada:");

        txtCodigoParte2.setText("12014-1245");

        jLabel14.setText("Fecha de parte de entrada:");

        lblFecha2.setText("25/06/2014");

        jLabel15.setText("Nombre de almacén:");

        cboAlmacen2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboAlmacen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAlmacen2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de documento:");

        cboTipoDocumento2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoDocumento2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setText("Número de documento:");

        txtNumeroDoc2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroDoc2.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroDoc2.setToolTipText("");
        txtNumeroDoc2.setAlignmentX(0.0F);
        txtNumeroDoc2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroDoc2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroDoc2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroDoc2.setName("txtusuario"); // NOI18N
        txtNumeroDoc2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroDoc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDoc2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha emisión de documento:");

        jLabel17.setText("Comentario:");

        txtComentario2.setColumns(20);
        txtComentario2.setRows(5);
        jScrollPane2.setViewportView(txtComentario2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoParte2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lblFecha2))
                    .addComponent(cboAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboTipoDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumeroDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFechaEmisionDoc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodigoParte2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16))))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblFecha2)
                        .addComponent(cboTipoDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechaEmisionDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumeroDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Código ");

        txtCodigoInsumo2.setEditable(false);
        txtCodigoInsumo2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCodigoInsumo2.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigoInsumo2.setToolTipText("");
        txtCodigoInsumo2.setAlignmentX(0.0F);
        txtCodigoInsumo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCodigoInsumo2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoInsumo2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCodigoInsumo2.setName("txtusuario"); // NOI18N
        txtCodigoInsumo2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCodigoInsumo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoInsumo2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Nombre de Producto");

        txtNombreInsumo2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombreInsumo2.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreInsumo2.setToolTipText("");
        txtNombreInsumo2.setAlignmentX(0.0F);
        txtNombreInsumo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombreInsumo2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreInsumo2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombreInsumo2.setName("txtusuario"); // NOI18N
        txtNombreInsumo2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombreInsumo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreInsumo2ActionPerformed(evt);
            }
        });

        jLabel20.setText("Presentación comercial");

        jLabel21.setText("Cantidad");

        txtPrecioInsumo2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPrecioInsumo2.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioInsumo2.setToolTipText("");
        txtPrecioInsumo2.setAlignmentX(0.0F);
        txtPrecioInsumo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPrecioInsumo2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioInsumo2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPrecioInsumo2.setName("txtusuario"); // NOI18N
        txtPrecioInsumo2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPrecioInsumo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioInsumo2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Unidad");

        cboUnidad2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("Precio de compra");

        txtCantidadInsumo2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCantidadInsumo2.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidadInsumo2.setToolTipText("");
        txtCantidadInsumo2.setAlignmentX(0.0F);
        txtCantidadInsumo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCantidadInsumo2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidadInsumo2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCantidadInsumo2.setName("txtusuario"); // NOI18N
        txtCantidadInsumo2.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCantidadInsumo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadInsumo2ActionPerformed(evt);
            }
        });

        jLabel24.setText("Moneda");

        cboMonedaInsumo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMonedaInsumo2.setPreferredSize(new java.awt.Dimension(80, 20));

        btnAddInsumo2.setText("+");
        btnAddInsumo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumo2ActionPerformed(evt);
            }
        });

        tblProductosPedidos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Contenido/ Cap", "Presentación comercial", "Cantidad", "Unidad", "Precio", "Moneda", "Subtotal", "Cantidad total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosPedidos2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblProductosPedidos2);
        tblProductosPedidos2.getColumnModel().getColumn(0).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(1).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(2).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(3).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(4).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(5).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(6).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(7).setResizable(false);
        tblProductosPedidos2.getColumnModel().getColumn(8).setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtCodigoInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtNombreInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cboPresentacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtCantidadInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboUnidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMonedaInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddInsumo2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPresentacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMonedaInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInsumo2)
                    .addComponent(txtCantidadInsumo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingreso por regularización de stock", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setText("Parte de entrada:");

        txtCodigoParte3.setText("12014-1245");

        jLabel26.setText("Fecha de parte de entrada:");

        lblFecha3.setText("25/06/2014");

        jLabel27.setText("Nombre de almacén:");

        cboAlmacen3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("Tipo de documento:");

        cboTipoDocumento3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Número de documento:");

        txtNumeroDoc3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroDoc3.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroDoc3.setToolTipText("");
        txtNumeroDoc3.setAlignmentX(0.0F);
        txtNumeroDoc3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroDoc3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroDoc3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroDoc3.setName("txtusuario"); // NOI18N
        txtNumeroDoc3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroDoc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDoc3ActionPerformed(evt);
            }
        });

        jLabel30.setText("Fecha emisión de documento:");

        jLabel31.setText("Comentario:");

        txtComentario3.setColumns(20);
        txtComentario3.setRows(5);
        jScrollPane4.setViewportView(txtComentario3);

        jLabel32.setText("Proveedor:");

        txtProveedor3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtProveedor3.setForeground(new java.awt.Color(153, 153, 153));
        txtProveedor3.setToolTipText("");
        txtProveedor3.setAlignmentX(0.0F);
        txtProveedor3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtProveedor3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtProveedor3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtProveedor3.setName("txtusuario"); // NOI18N
        txtProveedor3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtProveedor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedor3ActionPerformed(evt);
            }
        });

        jLabel33.setText("Moneda:");

        jLabel34.setText("Forma de pago:");

        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel35.setText("Fecha limite de cancelación:");

        jLabel36.setText("07/03/2014");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoParte3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(lblFecha3))
                    .addComponent(cboAlmacen3, 0, 240, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel32)
                    .addComponent(txtProveedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(txtNumeroDoc3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel30)
                    .addComponent(cboTipoDocumento3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(cboFormaPago, 0, 161, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel36)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtCodigoParte3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblFecha3)
                    .addComponent(cboTipoDocumento3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboAlmacen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProveedor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel37.setText("Código ");

        txtCodigoInsumo3.setEditable(false);
        txtCodigoInsumo3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCodigoInsumo3.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigoInsumo3.setToolTipText("");
        txtCodigoInsumo3.setAlignmentX(0.0F);
        txtCodigoInsumo3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCodigoInsumo3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoInsumo3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCodigoInsumo3.setName("txtusuario"); // NOI18N
        txtCodigoInsumo3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCodigoInsumo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoInsumo3ActionPerformed(evt);
            }
        });

        jLabel38.setText("Nombre de Producto");

        txtNombreInsumo3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombreInsumo3.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreInsumo3.setToolTipText("");
        txtNombreInsumo3.setAlignmentX(0.0F);
        txtNombreInsumo3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombreInsumo3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreInsumo3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombreInsumo3.setName("txtusuario"); // NOI18N
        txtNombreInsumo3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombreInsumo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreInsumo3ActionPerformed(evt);
            }
        });

        jLabel39.setText("Presentación comercial");

        jLabel40.setText("Cantidad");

        txtCantidadInsumo3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCantidadInsumo3.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidadInsumo3.setToolTipText("");
        txtCantidadInsumo3.setAlignmentX(0.0F);
        txtCantidadInsumo3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCantidadInsumo3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidadInsumo3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCantidadInsumo3.setName("txtusuario"); // NOI18N
        txtCantidadInsumo3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCantidadInsumo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadInsumo3ActionPerformed(evt);
            }
        });

        cboUnidad3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setText("Unidad");

        jLabel42.setText("Precio de compra");

        txtPrecioInsumo3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPrecioInsumo3.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioInsumo3.setToolTipText("");
        txtPrecioInsumo3.setAlignmentX(0.0F);
        txtPrecioInsumo3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPrecioInsumo3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioInsumo3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPrecioInsumo3.setName("txtusuario"); // NOI18N
        txtPrecioInsumo3.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPrecioInsumo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioInsumo3ActionPerformed(evt);
            }
        });

        cboMonedaInsumo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMonedaInsumo3.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel43.setText("Moneda");

        btnAddInsumo3.setText("+");
        btnAddInsumo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumo3ActionPerformed(evt);
            }
        });

        tblProductosPedidos3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Contenido/ Cap", "Presentación comercial", "Cantidad", "Unidad", "Precio", "Moneda", "Subtotal", "Cantidad total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosPedidos3.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblProductosPedidos3);
        tblProductosPedidos3.getColumnModel().getColumn(0).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(1).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(2).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(3).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(4).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(5).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(6).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(7).setResizable(false);
        tblProductosPedidos3.getColumnModel().getColumn(8).setResizable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(txtNombreInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cboPresentacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel39)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(txtCantidadInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cboUnidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMonedaInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddInsumo3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPresentacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMonedaInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInsumo3)
                    .addComponent(txtCantidadInsumo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingreso por documento externo de compra ", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setText("Parte de entrada:");

        txtCodigoParte4.setText("12014-1245");

        jLabel45.setText("Fecha de parte de entrada:");

        lblFecha4.setText("25/06/2014");

        jLabel46.setText("Nombre de almacén:");

        jLabel47.setText("Tipo de documento:");

        cboTipoDocumento4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel48.setText("Número de documento:");

        txtNumeroDoc4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNumeroDoc4.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroDoc4.setToolTipText("");
        txtNumeroDoc4.setAlignmentX(0.0F);
        txtNumeroDoc4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNumeroDoc4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumeroDoc4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNumeroDoc4.setName("txtusuario"); // NOI18N
        txtNumeroDoc4.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNumeroDoc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDoc4ActionPerformed(evt);
            }
        });

        jLabel49.setText("Fecha emisión de documento:");

        txtFechaEmisionDocInterno.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtFechaEmisionDocInterno.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaEmisionDocInterno.setText("  dd//mm/yy");
        txtFechaEmisionDocInterno.setToolTipText("");
        txtFechaEmisionDocInterno.setAlignmentX(0.0F);
        txtFechaEmisionDocInterno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtFechaEmisionDocInterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaEmisionDocInterno.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtFechaEmisionDocInterno.setName("txtusuario"); // NOI18N
        txtFechaEmisionDocInterno.setPreferredSize(new java.awt.Dimension(280, 24));
        txtFechaEmisionDocInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEmisionDocInternoActionPerformed(evt);
            }
        });

        jLabel50.setText("Comentario:");

        txtComentario4.setColumns(20);
        txtComentario4.setRows(5);
        jScrollPane6.setViewportView(txtComentario4);

        cboAlmacen4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoParte4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(lblFecha4))
                    .addComponent(jLabel46)
                    .addComponent(cboAlmacen4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(txtNumeroDoc4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(cboTipoDocumento4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaEmisionDocInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtCodigoParte4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel50))))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(lblFecha4)
                            .addComponent(cboTipoDocumento4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroDoc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboAlmacen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaEmisionDocInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel51.setText("Código ");

        txtCodigoInsumo4.setEditable(false);
        txtCodigoInsumo4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCodigoInsumo4.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigoInsumo4.setToolTipText("");
        txtCodigoInsumo4.setAlignmentX(0.0F);
        txtCodigoInsumo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCodigoInsumo4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoInsumo4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCodigoInsumo4.setName("txtusuario"); // NOI18N
        txtCodigoInsumo4.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCodigoInsumo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoInsumo4ActionPerformed(evt);
            }
        });

        txtNombreInsumo4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtNombreInsumo4.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreInsumo4.setToolTipText("");
        txtNombreInsumo4.setAlignmentX(0.0F);
        txtNombreInsumo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtNombreInsumo4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreInsumo4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNombreInsumo4.setName("txtusuario"); // NOI18N
        txtNombreInsumo4.setPreferredSize(new java.awt.Dimension(280, 24));
        txtNombreInsumo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreInsumo4ActionPerformed(evt);
            }
        });

        jLabel52.setText("Nombre de Producto");

        jLabel53.setText("Presentación comercial");

        txtCantidadInsumo4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtCantidadInsumo4.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidadInsumo4.setToolTipText("");
        txtCantidadInsumo4.setAlignmentX(0.0F);
        txtCantidadInsumo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtCantidadInsumo4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidadInsumo4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCantidadInsumo4.setName("txtusuario"); // NOI18N
        txtCantidadInsumo4.setPreferredSize(new java.awt.Dimension(280, 24));
        txtCantidadInsumo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadInsumo4ActionPerformed(evt);
            }
        });

        jLabel54.setText("Cantidad");

        jLabel55.setText("Unidad");

        cboUnidad4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPrecioInsumo4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        txtPrecioInsumo4.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioInsumo4.setToolTipText("");
        txtPrecioInsumo4.setAlignmentX(0.0F);
        txtPrecioInsumo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));
        txtPrecioInsumo4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioInsumo4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPrecioInsumo4.setName("txtusuario"); // NOI18N
        txtPrecioInsumo4.setPreferredSize(new java.awt.Dimension(280, 24));
        txtPrecioInsumo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioInsumo4ActionPerformed(evt);
            }
        });

        jLabel56.setText("Precio de compra");

        cboMonedaInsumo4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMonedaInsumo4.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel57.setText("Moneda");

        btncAddInsumo4.setText("+");
        btncAddInsumo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncAddInsumo4ActionPerformed(evt);
            }
        });

        tblProductosPedidos4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Contenido/ Cap", "Presentación comercial", "Cantidad", "Unidad", "Precio", "Moneda", "Subtotal", "Cantidad total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosPedidos4.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tblProductosPedidos4);
        tblProductosPedidos4.getColumnModel().getColumn(0).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(1).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(2).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(3).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(4).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(5).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(6).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(7).setResizable(false);
        tblProductosPedidos4.getColumnModel().getColumn(8).setResizable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(txtNombreInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cboPresentacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(txtCantidadInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel57))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cboUnidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMonedaInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btncAddInsumo4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPresentacion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMonedaInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncAddInsumo4)
                    .addComponent(txtCantidadInsumo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingreso por documento interno de compra", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneltitlealmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoOCActionPerformed

    private void txtNumeroDoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDoc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDoc2ActionPerformed

    private void txtCodigoInsumo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoInsumo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoInsumo2ActionPerformed

    private void txtNombreInsumo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInsumo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInsumo2ActionPerformed

    private void txtPrecioInsumo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioInsumo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioInsumo2ActionPerformed

    private void txtCantidadInsumo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadInsumo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInsumo2ActionPerformed

    private void txtNumeroDoc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDoc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDoc3ActionPerformed

    private void txtProveedor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveedor3ActionPerformed

    private void txtCodigoInsumo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoInsumo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoInsumo3ActionPerformed

    private void txtNombreInsumo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInsumo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInsumo3ActionPerformed

    private void txtCantidadInsumo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadInsumo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInsumo3ActionPerformed

    private void txtPrecioInsumo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioInsumo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioInsumo3ActionPerformed

    private void txtNumeroDoc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDoc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDoc4ActionPerformed

    private void txtFechaEmisionDocInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEmisionDocInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEmisionDocInternoActionPerformed

    private void txtCodigoInsumo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoInsumo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoInsumo4ActionPerformed

    private void txtNombreInsumo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreInsumo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreInsumo4ActionPerformed

    private void txtCantidadInsumo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadInsumo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInsumo4ActionPerformed

    private void txtPrecioInsumo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioInsumo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioInsumo4ActionPerformed

    private void btnCargarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarOCActionPerformed
        try {
            // TODO add your handling code here:
            GestionOrdenCompra gestionOC = new GestionOrdenCompra();
            OrdenCompra orden = new OrdenCompra();
            orden.setNumero(this.txtCodigoOC.getText());
            orden.setEstado("I");
            OrdenCompra obj = gestionOC.buscarOC(orden);
            if (obj != null) {
                GestionOrdenCompraInsumo gestionOCInsumo = new GestionOrdenCompraInsumo();
                ArrayList<OrdenCompraInsumo> listaDetalle = gestionOCInsumo.listar(obj);
                lblProveedor.setText(obj.getProveedor().getNombres() + " " + obj.getProveedor().getApellidos());
                lblRuc.setText(obj.getProveedor().getRuc());
                lblFechaOC.setText(obj.getFechaRegistro());
                this.modelProductosPedidos1.setData(listaDetalle);
                this.modelProductosPedidos1.fireTableDataChanged();
                System.out.println("encontrado: " + obj.getId());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelIngresoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelIngresoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCargarOCActionPerformed

    private void cboAlmacen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAlmacen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAlmacen2ActionPerformed

    private void btnAddInsumo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumo2ActionPerformed
        // TODO add your handling code here:
        IngresoAlmacenInsumo obj=new IngresoAlmacenInsumo();
        obj.setInsumo(insumoselected2);
        double cantidad=Double.parseDouble(this.txtCantidadInsumo2.getText());
        obj.setCantidad(cantidad);
        double precio=Double.parseDouble(this.txtPrecioInsumo2.getText());
        obj.setPrecio(precio);
        obj.setSubtotal((cantidad*precio));
        obj.setTipoOperacion("i");
        obj.setMoneda(this.modelCboMonedaInsumo2.getElement(this.cboMonedaInsumo2.getSelectedIndex()));
        obj.setUnidad(this.modelCboUnidad2.getElement(this.cboUnidad2.getSelectedIndex()));
        this.listaDetalle2.add(obj);
        this.modelDetalle2.setData(listaDetalle2);
        this.modelDetalle2.fireTableDataChanged();
    }//GEN-LAST:event_btnAddInsumo2ActionPerformed

    private void btnAddInsumo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumo3ActionPerformed
        // TODO add your handling code here:
        IngresoAlmacenInsumo obj=new IngresoAlmacenInsumo();
        obj.setInsumo(insumoselected3);
        double cantidad=Double.parseDouble(this.txtCantidadInsumo3.getText());
        obj.setCantidad(cantidad);
        double precio=Double.parseDouble(this.txtPrecioInsumo3.getText());
        obj.setPrecio(precio);
        obj.setSubtotal((cantidad*precio));
        obj.setTipoOperacion("i");
        obj.setMoneda(this.modelCboMonedaInsumo3.getElement(this.cboMonedaInsumo3.getSelectedIndex()));
        obj.setUnidad(this.modelCboUnidad3.getElement(this.cboUnidad3.getSelectedIndex()));
        this.listaDetalle3.add(obj);
        this.modelDetalle3.setData(listaDetalle3);
        this.modelDetalle3.fireTableDataChanged();
    }//GEN-LAST:event_btnAddInsumo3ActionPerformed

    private void btncAddInsumo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncAddInsumo4ActionPerformed
        // TODO add your handling code here:
        IngresoAlmacenInsumo obj=new IngresoAlmacenInsumo();
        obj.setInsumo(insumoselected4);
        double cantidad=Double.parseDouble(this.txtCantidadInsumo4.getText());
        obj.setCantidad(cantidad);
        double precio=Double.parseDouble(this.txtPrecioInsumo4.getText());
        obj.setPrecio(precio);
        obj.setSubtotal((cantidad*precio));
        obj.setTipoOperacion("i");
        obj.setMoneda(this.modelCboMonedaInsumo4.getElement(this.cboMonedaInsumo4.getSelectedIndex()));
        obj.setUnidad(this.modelCboUnidad4.getElement(this.cboUnidad4.getSelectedIndex()));
        this.listaDetalle4.add(obj);
        this.modelDetalle4.setData(listaDetalle4);
        this.modelDetalle4.fireTableDataChanged();
    }//GEN-LAST:event_btncAddInsumo4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInsumo2;
    private javax.swing.JButton btnAddInsumo3;
    private javax.swing.JButton btnAdjuntarOrdenCompra;
    private javax.swing.JButton btnCargarOC;
    private javax.swing.JButton btnNuevoAlmacen;
    private javax.swing.JButton btnNuevoAlmacen1;
    private javax.swing.JButton btnNuevoAlmacen2;
    private javax.swing.JButton btncAddInsumo4;
    private javax.swing.JComboBox cboAlmacen1;
    private javax.swing.JComboBox cboAlmacen2;
    private javax.swing.JComboBox cboAlmacen3;
    private javax.swing.JComboBox cboAlmacen4;
    private javax.swing.JComboBox cboFormaPago;
    private javax.swing.JComboBox cboMoneda;
    private javax.swing.JComboBox cboMonedaInsumo2;
    private javax.swing.JComboBox cboMonedaInsumo3;
    private javax.swing.JComboBox cboMonedaInsumo4;
    private javax.swing.JComboBox cboPresentacion2;
    private javax.swing.JComboBox cboPresentacion3;
    private javax.swing.JComboBox cboPresentacion4;
    private javax.swing.JComboBox cboTipoDocumento2;
    private javax.swing.JComboBox cboTipoDocumento3;
    private javax.swing.JComboBox cboTipoDocumento4;
    private javax.swing.JComboBox cboUnidad2;
    private javax.swing.JComboBox cboUnidad3;
    private javax.swing.JComboBox cboUnidad4;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblFecha3;
    private javax.swing.JLabel lblFecha4;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblFechaOC;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel logoalmacen;
    private javax.swing.JPanel paneltitlealmacen;
    private javax.swing.JTable tblProductosPedidos1;
    private javax.swing.JTable tblProductosPedidos2;
    private javax.swing.JTable tblProductosPedidos3;
    private javax.swing.JTable tblProductosPedidos4;
    private javax.swing.JTextField txtCantidadInsumo2;
    private javax.swing.JTextField txtCantidadInsumo3;
    private javax.swing.JTextField txtCantidadInsumo4;
    private javax.swing.JTextField txtCodigoInsumo2;
    private javax.swing.JTextField txtCodigoInsumo3;
    private javax.swing.JTextField txtCodigoInsumo4;
    private javax.swing.JTextField txtCodigoOC;
    private javax.swing.JLabel txtCodigoParte1;
    private javax.swing.JLabel txtCodigoParte2;
    private javax.swing.JLabel txtCodigoParte3;
    private javax.swing.JLabel txtCodigoParte4;
    private javax.swing.JTextArea txtComentario2;
    private javax.swing.JTextArea txtComentario3;
    private javax.swing.JTextArea txtComentario4;
    private com.toedter.calendar.JDateChooser txtFechaEmisionDoc2;
    private javax.swing.JTextField txtFechaEmisionDocInterno;
    private javax.swing.JTextField txtNombreInsumo2;
    private javax.swing.JTextField txtNombreInsumo3;
    private javax.swing.JTextField txtNombreInsumo4;
    private javax.swing.JTextField txtNumeroDoc2;
    private javax.swing.JTextField txtNumeroDoc3;
    private javax.swing.JTextField txtNumeroDoc4;
    private javax.swing.JTextField txtPrecioInsumo2;
    private javax.swing.JTextField txtPrecioInsumo3;
    private javax.swing.JTextField txtPrecioInsumo4;
    private javax.swing.JTextField txtProveedor3;
    // End of variables declaration//GEN-END:variables
}
