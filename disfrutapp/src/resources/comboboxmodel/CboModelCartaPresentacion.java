/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author user
 */
public class CboModelCartaPresentacion extends AbstractListModel implements MutableComboBoxModel {
    private Object selectedItem;
    private ArrayList<PresentacionPrecioVenta> data;
    
    public CboModelCartaPresentacion(){                  
    }

    public CboModelCartaPresentacion(ArrayList<PresentacionPrecioVenta> datos) {
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
        return data.get(index).getPresentacion().getDescripcion();
    }
    
    public PresentacionPrecioVenta getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((PresentacionPrecioVenta)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((PresentacionPrecioVenta)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (PresentacionPrecioVenta)item);
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
    
    public ArrayList<PresentacionPrecioVenta> getData() {
        return data;
    }

    public void setData(ArrayList<PresentacionPrecioVenta> data) {
        this.data = data;
    }
    
}
