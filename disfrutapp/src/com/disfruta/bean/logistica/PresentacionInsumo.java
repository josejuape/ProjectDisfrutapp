/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author user
 */
public class PresentacionInsumo {
    private int idpresentacion_compra;
    private String nombre_presentacion;
    private int cantidad;
    private String unidad;
    private Insumo producto;
    private String tipoOperacion;

    public int getIdpresentacion_compra() {
        return idpresentacion_compra;
    }

    public void setIdpresentacion_compra(int idpresentacion_compra) {
        this.idpresentacion_compra = idpresentacion_compra;
    }

    public String getNombre_presentacion() {
        return nombre_presentacion;
    }

    public void setNombre_presentacion(String nombre_presentacion) {
        this.nombre_presentacion = nombre_presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Insumo getProducto() {
        return producto;
    }

    public void setProducto(Insumo producto) {
        this.producto = producto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
}
