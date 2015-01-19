/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author Juape
 */
public class PresentacionVenta {
    protected int id;
    protected String descripcion;
    protected FamiliaProducto familia;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FamiliaProducto getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaProducto familia) {
        this.familia = familia;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
    
}
