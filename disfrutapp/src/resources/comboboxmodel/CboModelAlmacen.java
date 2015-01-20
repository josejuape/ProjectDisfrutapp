/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.Almacen;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelAlmacen extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<Almacen> data;
    
    public CboModelAlmacen(){                  
    }

    public CboModelAlmacen(ArrayList<Almacen> datos) {
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
    
    public Almacen getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((Almacen)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((Almacen)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (Almacen)item);
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
    
    public ArrayList<Almacen> getData() {
        return data;
    }

    public void setData(ArrayList<Almacen> data) {
        this.data = data;
    }
    
}
