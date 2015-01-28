/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ProductoCarta {
    protected int idproductocarta;
    protected String nombre;
    protected String descripcion;
    protected String despachadoen;
    protected FamiliaProducto familia;
    protected ArrayList<PresentacionPrecioVenta> presentaciones;
    protected String tipoOperacion;

    public int getIdproductocarta() {
        return idproductocarta;
    }

    public void setIdproductocarta(int idproductocarta) {
        this.idproductocarta = idproductocarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<PresentacionPrecioVenta> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(ArrayList<PresentacionPrecioVenta> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public String getDespachadoen() {
        return despachadoen;
    }

    public void setDespachadoen(String despachadoen) {
        this.despachadoen = despachadoen;
    }
    
    
    
}
