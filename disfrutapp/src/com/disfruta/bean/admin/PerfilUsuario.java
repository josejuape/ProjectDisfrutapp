/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.admin;

/**
 *
 * @author Juape
 */
public class PerfilUsuario {
    protected int idprefil;
    protected String descripcion;
    protected String estado;
    protected String tipoOperacion;

    public int getIdprefil() {
        return idprefil;
    }

    public void setIdprefil(int idprefil) {
        this.idprefil = idprefil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
}
