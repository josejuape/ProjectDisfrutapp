/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.FormaPago;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelFormaPago extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<FormaPago> data;
    
    public CboModelFormaPago(){                  
    }

    public CboModelFormaPago(ArrayList<FormaPago> datos) {
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
    
    public FormaPago getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((FormaPago)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((FormaPago)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (FormaPago)item);
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
    
    public ArrayList<FormaPago> getData() {
        return data;
    }

    public void setData(ArrayList<FormaPago> data) {
        this.data = data;
    }
    
}
