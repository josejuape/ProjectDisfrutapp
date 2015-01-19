/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.xtbc;

/**
 *
 * @author Juape
 */
public class Ubigeo {
    protected int id;
    protected String cod_pais;
    protected String cod_departamento;
    protected String cod_provincia;
    protected String cod_distrito;
    protected String nom_pais;
    protected String nom_departamento;
    protected String nom_provincia;
    protected String nom_distrito;
    protected String buscar;
    protected String estado;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(String cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getCod_distrito() {
        return cod_distrito;
    }

    public void setCod_distrito(String cod_distrito) {
        this.cod_distrito = cod_distrito;
    }

    public String getNom_pais() {
        return nom_pais;
    }

    public void setNom_pais(String nom_pais) {
        this.nom_pais = nom_pais;
    }

    public String getNom_departamento() {
        return nom_departamento;
    }

    public void setNom_departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }

    public String getNom_distrito() {
        return nom_distrito;
    }

    public void setNom_distrito(String nom_distrito) {
        this.nom_distrito = nom_distrito;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
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
    
    @Override
    public String toString(){
        return this.buscar;
    }
    
}
