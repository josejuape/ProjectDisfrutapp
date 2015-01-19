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
public class Insumo {
    protected int idinsumo;
    protected String nombre;
    protected double capacidad;
    protected String controlstock;
    protected UnidadMedida unidad;
    protected String ventadirecta;
    protected double preciocompra;
    protected double precioventa;
    protected Moneda monedacompra;
    protected Moneda monedaventa;
    protected FamiliaProducto categoria;
    protected Almacen almacen;
    protected String tipoOperacion;

    public int getIdinsumo() {
        return idinsumo;
    }

    public void setIdinsumo(int idinsumo) {
        this.idinsumo = idinsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public String getControlstock() {
        return controlstock;
    }

    public void setControlstock(String controlstock) {
        this.controlstock = controlstock;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public String getVentadirecta() {
        return ventadirecta;
    }

    public void setVentadirecta(String ventadirecta) {
        this.ventadirecta = ventadirecta;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public Moneda getMonedacompra() {
        return monedacompra;
    }

    public void setMonedacompra(Moneda monedacompra) {
        this.monedacompra = monedacompra;
    }

    public Moneda getMonedaventa() {
        return monedaventa;
    }

    public void setMonedaventa(Moneda monedaventa) {
        this.monedaventa = monedaventa;
    }

    public FamiliaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(FamiliaProducto categoria) {
        this.categoria = categoria;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
