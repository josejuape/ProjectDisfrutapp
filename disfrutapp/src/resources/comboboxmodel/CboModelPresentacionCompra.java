/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.PresentacionInsumo;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelPresentacionCompra extends AbstractListModel implements MutableComboBoxModel {
    private Object selectedItem;
    private ArrayList<PresentacionInsumo> data;
    
    public CboModelPresentacionCompra(){                  
    }

    public CboModelPresentacionCompra(ArrayList<PresentacionInsumo> datos) {
        data = datos;
    }
    
    @Override
    public int getSize() {
        try {
            return data.size();
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    @Override
    public Object getElementAt(int index) {
        return data.get(index).getNombre_presentacion();
    }
    
    public PresentacionInsumo getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((PresentacionInsumo)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((PresentacionInsumo)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (PresentacionInsumo)item);
    }

    @Override
    public void removeElementAt(int index) {
        data.remove(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
    public ArrayList<PresentacionInsumo> getData() {
        return data;
    }

    public void setData(ArrayList<PresentacionInsumo> data) {
        this.data = data;
    }
    
    
    public int getPosition(String unidad){
        int position=-1;
        for(int i=0;i<data.size();i++){
            if(unidad.equalsIgnoreCase(data.get(i).getNombre_presentacion())){
                position=i;
                break;
            }
        }
        return position;
    }
}
