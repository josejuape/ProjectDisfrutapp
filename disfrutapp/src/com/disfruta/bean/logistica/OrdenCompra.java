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
public class OrdenCompra {
    protected int id;
    protected String numero;
    protected String fechaRegistro;
    protected String comentario;
    protected String fechaRecepcion;
    protected String lugarRecepcion;
    protected String observaciones;
    protected String estado;
    protected int idactualizado;
    protected Proveedor proveedor;
    protected Moneda moneda;
    protected Almacen almacen;
    protected FormaPago formaPago;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getLugarRecepcion() {
        return lugarRecepcion;
    }

    public void setLugarRecepcion(String lugarRecepcion) {
        this.lugarRecepcion = lugarRecepcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdactualizado() {
        return idactualizado;
    }

    public void setIdactualizado(int idactualizado) {
        this.idactualizado = idactualizado;
    }
    
    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
}
