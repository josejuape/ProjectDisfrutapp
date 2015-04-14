/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.Insumo;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author user
 */
public class CboModelInsumo extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<Insumo> data;
    
    public CboModelInsumo(){                  
    }

    public CboModelInsumo(ArrayList<Insumo> datos) {
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
        return data.get(index).getNombre();
    }
    
    public Insumo getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((Insumo)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((Insumo)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (Insumo)item);
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
    
    public ArrayList<Insumo> getData() {
        return data;
    }

    public void setData(ArrayList<Insumo> data) {
        this.data = data;
    }
    
}
