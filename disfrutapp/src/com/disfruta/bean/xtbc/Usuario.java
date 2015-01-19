/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.xtbc;

import com.disfruta.bean.admin.TipoUserDesktop;

/**
 *
 * @author juape
 */
public class Usuario {
    protected int id_usuario;
    protected String nombres;
    private String apellidos;
    private String sexo;
    private String fecha_nac;
    private String ubicacion;
    protected String email;
    protected String clave;
    private String estado;
    private String celular;
    private String foto;
    private String fotodni;
    private int num_pedidos;
    private int num_pedidos_ac;
    private String nom_local;
    private TipoUserDesktop tipouser;
    private Local local;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotodni() {
        return fotodni;
    }

    public void setFotodni(String fotodni) {
        this.fotodni = fotodni;
    }

    public int getNum_pedidos() {
        return num_pedidos;
    }

    public void setNum_pedidos(int num_pedidos) {
        this.num_pedidos = num_pedidos;
    }

    public int getNum_pedidos_ac() {
        return num_pedidos_ac;
    }

    public void setNum_pedidos_ac(int num_pedidos_ac) {
        this.num_pedidos_ac = num_pedidos_ac;
    }

    public String getNom_local() {
        return nom_local;
    }

    public void setNom_local(String nom_local) {
        this.nom_local = nom_local;
    }

    public TipoUserDesktop getTipouser() {
        return tipouser;
    }

    public void setTipouser(TipoUserDesktop tipouser) {
        this.tipouser = tipouser;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    
    
}
