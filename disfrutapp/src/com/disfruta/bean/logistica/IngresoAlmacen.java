/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.logistica;

import com.disfruta.bean.xtbc.Comprobante;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.bean.xtbc.TipoComprobante;

/**
 *
 * @author Juape
 */
public class IngresoAlmacen {
    protected int id;
    protected String parteEntrada;
    protected String atenderCompleto;
    protected String fechaRegistro;
    protected String numeroComprobante;
    protected String serieComprobante;
    protected String fechaEmisionComprobante;
    protected String fechaLimiteCancelacion;
    protected String comentario;
    protected String estado;
    protected int idactualizado;
    protected FormaPago formaPago;
    protected Moneda moneda;
    protected TipoComprobante tipoComprobante;
    protected OrdenCompra ordenCompra;
    protected TipoIngresoAlmacen tipoIngreso;
    protected Almacen almacen;
    protected Comprobante comprobante;
    protected Proveedor proveedor;
    protected String tipoOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParteEntrada() {
        return parteEntrada;
    }

    public void setParteEntrada(String parteEntrada) {
        this.parteEntrada = parteEntrada;
    }

    public String getAtenderCompleto() {
        return atenderCompleto;
    }

    public void setAtenderCompleto(String nombreAlmacen) {
        this.atenderCompleto = nombreAlmacen;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(String serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    public String getFechaEmisionComprobante() {
        return fechaEmisionComprobante;
    }

    public void setFechaEmisionComprobante(String fechaEmisionComprobante) {
        this.fechaEmisionComprobante = fechaEmisionComprobante;
    }

    public String getFechaLimiteCancelacion() {
        return fechaLimiteCancelacion;
    }

    public void setFechaLimiteCancelacion(String fechaLimiteCancelacion) {
        this.fechaLimiteCancelacion = fechaLimiteCancelacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdactualizado() {
        return idactualizado;
    }

    public void setIdactualizado(int idactualizado) {
        this.idactualizado = idactualizado;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public TipoIngresoAlmacen getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngresoAlmacen tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
    
}
