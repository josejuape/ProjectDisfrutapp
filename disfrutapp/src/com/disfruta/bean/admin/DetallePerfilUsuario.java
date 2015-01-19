/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.admin;

/**
 *
 * @author Juape
 */
public class DetallePerfilUsuario {
    protected PerfilUsuario perfil;
    protected UsuarioDesktop usuario;
    protected String estado;
    protected String tipoOperacion;

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public UsuarioDesktop getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDesktop usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
