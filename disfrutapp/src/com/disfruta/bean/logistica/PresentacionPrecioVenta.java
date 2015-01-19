/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author Juape
 */
public class PresentacionPrecioVenta {
    protected ProductoCarta proudcto;
    protected PresentacionVenta presentacion;
    protected double precioventa;
    protected double proporcion;
    protected String tipoOperacion;

    public ProductoCarta getProudcto() {
        return proudcto;
    }

    public void setProudcto(ProductoCarta proudcto) {
        this.proudcto = proudcto;
    }

    public PresentacionVenta getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(PresentacionVenta presentacion) {
        this.presentacion = presentacion;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getProporcion() {
        return proporcion;
    }

    public void setProporcion(double proporcion) {
        this.proporcion = proporcion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
}
