/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author user
 */
public class ControlStock {
    protected int idcontrol;
    protected double stock;
    protected double precioventa;
    protected IngresoAlmacen ingreso;
    protected Almacen almacen;
    protected Insumo insumo;
    protected String tipoOperacion;

    public int getIdcontrol() {
        return idcontrol;
    }

    public void setIdcontrol(int idcontrol) {
        this.idcontrol = idcontrol;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public IngresoAlmacen getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoAlmacen ingreso) {
        this.ingreso = ingreso;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperación) {
        this.tipoOperacion = tipoOperación;
    }
    
    
    
    
}
