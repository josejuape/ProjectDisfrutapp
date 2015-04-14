/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

import com.disfruta.bean.xtbc.Moneda;

/**
 *
 * @author Juape
 */
public class IngresoAlmacenInsumo {
    protected int id;
    protected Insumo insumo;
    protected IngresoAlmacen ingresoAlmacen;
    protected int presentacion;
    protected double cantidad;
    protected double precio;
    protected double subtotal;
    protected Moneda moneda;
    protected UnidadMedida unidad;
    protected int atendidos;
    protected int porAtender;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public IngresoAlmacen getIngresoAlmacen() {
        return ingresoAlmacen;
    }

    public void setIngresoAlmacen(IngresoAlmacen ingresoAlmacen) {
        this.ingresoAlmacen = ingresoAlmacen;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public int getAtendidos() {
        return atendidos;
    }

    public void setAtendidos(int atendidos) {
        this.atendidos = atendidos;
    }

    public int getPorAtender() {
        return porAtender;
    }

    public void setPorAtender(int porAtender) {
        this.porAtender = porAtender;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(int presentacion) {
        this.presentacion = presentacion;
    }
    
    
}
