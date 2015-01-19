/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.conexion;

/**
 *
 * @author Juape
 */
public class Parametro {
    private String inOrOut;
    private Object valor;
    
    public Parametro(String paramInOrOut,Object paramObject){
        this.inOrOut=paramInOrOut;
        this.valor=paramObject;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
