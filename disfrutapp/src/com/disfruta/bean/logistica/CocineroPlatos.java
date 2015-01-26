/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

import com.disfruta.bean.admin.UsuarioDesktop;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class CocineroPlatos {

    protected UsuarioDesktop usuario;
    protected ArrayList<DetallePedido> platos;

    public CocineroPlatos(UsuarioDesktop usuario, ArrayList<DetallePedido> platos) {
        this.usuario = usuario;
        this.platos = platos;
    }

    public UsuarioDesktop getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDesktop usuario) {
        this.usuario = usuario;
    }

    public ArrayList<DetallePedido> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<DetallePedido> platos) {
        this.platos = platos;
    }
}
