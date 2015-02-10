/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.util.jtree;

import com.disfruta.bean.admin.Menu;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Nodo {
    public Menu obj;
    public ArrayList<Nodo> hijos;
    public boolean selected;
    
    public Nodo(Menu obj,ArrayList hijos){
        this.obj=obj;
        this.hijos=hijos;
        this.selected=false;
    }

    public Menu getObj() {
        return obj;
    }

    public void setObj(Menu obj) {
        this.obj = obj;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}
