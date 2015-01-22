/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

/**
 *
 * @author Juape
 */
public class Proveedor {
    protected int id;
    protected String ruc;
    protected String nombres;
    protected String apellidos;
    protected String ubicacion;
    protected String direccion;
    protected String referencia;
    protected String contacto1;
    protected String telf_contacto1;
    protected String contacto2;
    protected String telf_contacto2;
    protected String contacto3;
    protected String telf_contacto3;
    protected CategoriaProveedor categoria;
    protected TipoPersona tipopersona;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getContacto1() {
        return contacto1;
    }

    public void setContacto1(String contacto1) {
        this.contacto1 = contacto1;
    }

    public String getTelf_contacto1() {
        return telf_contacto1;
    }

    public void setTelf_contacto1(String telf_contacto1) {
        this.telf_contacto1 = telf_contacto1;
    }

    public String getContacto2() {
        return contacto2;
    }

    public void setContacto2(String contacto2) {
        this.contacto2 = contacto2;
    }

    public String getTelf_contacto2() {
        return telf_contacto2;
    }

    public void setTelf_contacto2(String telf_contacto2) {
        this.telf_contacto2 = telf_contacto2;
    }

    public String getContacto3() {
        return contacto3;
    }

    public void setContacto3(String contacto3) {
        this.contacto3 = contacto3;
    }

    public String getTelf_contacto3() {
        return telf_contacto3;
    }

    public void setTelf_contacto3(String telf_contacto3) {
        this.telf_contacto3 = telf_contacto3;
    }

    public CategoriaProveedor getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProveedor categoria) {
        this.categoria = categoria;
    }

    public TipoPersona getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(TipoPersona tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    @Override
    public String toString(){
        return this.nombres+" "+this.apellidos;
    }
}
