/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.PresentacionVenta;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelPresentacionVenta extends AbstractListModel implements MutableComboBoxModel {
    private Object selectedItem;
    private ArrayList<PresentacionVenta> data;
    
    public CboModelPresentacionVenta(){                  
    }

    public CboModelPresentacionVenta(ArrayList<PresentacionVenta> datos) {
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
        return data.get(index).getDescripcion();
    }
    
    public PresentacionVenta getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((PresentacionVenta)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((PresentacionVenta)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (PresentacionVenta)item);
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
    
    public ArrayList<PresentacionVenta> getData() {
        return data;
    }

    public void setData(ArrayList<PresentacionVenta> data) {
        this.data = data;
    }
    
    public ArrayList<PresentacionVenta> filterPresentacion(String cadena){
        ArrayList<PresentacionVenta> result=new <PresentacionVenta>ArrayList();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDescripcion().contains(cadena)) {
                result.add(data.get(i));
            }
        }
        return result;
    }
    
    
}
