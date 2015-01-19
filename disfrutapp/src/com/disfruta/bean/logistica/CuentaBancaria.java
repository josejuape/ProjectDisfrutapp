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
public class CuentaBancaria {
    protected int id;
    protected String numerocuenta;
    protected String cuentainterbancaria;
    protected Proveedor proveedor;
    protected EntidadBancaria entidad;
    protected Moneda moneda;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getCuentainterbancaria() {
        return cuentainterbancaria;
    }

    public void setCuentainterbancaria(String cuentainterbancaria) {
        this.cuentainterbancaria = cuentainterbancaria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EntidadBancaria getEntidad() {
        return entidad;
    }

    public void setEntidad(EntidadBancaria entidad) {
        this.entidad = entidad;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
}
