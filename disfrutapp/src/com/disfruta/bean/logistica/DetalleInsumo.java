/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author Juape
 * Bean DetalleInsumo que hace referencia a la Tabla logtbc_detalle_insumo
 */
public class DetalleInsumo {
    protected Insumo insumo;
    protected PresentacionPrecioVenta presentacion;
    protected double cantidad;
    protected String unidad;
    protected String tipoOperacion;
    protected boolean controlInsercion;
    

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public PresentacionPrecioVenta getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(PresentacionPrecioVenta presentacion) {
        this.presentacion = presentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public boolean isControlInsercion() {
        return controlInsercion;
    }

    public void setControlInsercion(boolean controlInsercion) {
        this.controlInsercion = controlInsercion;
    }
    
    
}
