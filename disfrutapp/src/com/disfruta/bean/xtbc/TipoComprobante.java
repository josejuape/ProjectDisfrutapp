/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.xtbc;

/**
 *
 * @author Juape
 */
public class TipoComprobante {
    protected int id;
    protected String descripcion;
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

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
}
