/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.xtbc;

/**
 *
 * @author Juape
 */
public class Comprobante {
    protected int id;
    protected String numeroCom;
    protected String serieComp;
    protected String fechaRegistro;
    protected String fechaLimiteCancelacion;
    protected double subtotal;
    protected double igv;
    protected double montoTotal;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCom() {
        return numeroCom;
    }

    public void setNumeroCom(String numeroCom) {
        this.numeroCom = numeroCom;
    }

    public String getSerieComp() {
        return serieComp;
    }

    public void setSerieComp(String serieComp) {
        this.serieComp = serieComp;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaLimiteCancelacion() {
        return fechaLimiteCancelacion;
    }

    public void setFechaLimiteCancelacion(String fechaLimiteCancelacion) {
        this.fechaLimiteCancelacion = fechaLimiteCancelacion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
}
