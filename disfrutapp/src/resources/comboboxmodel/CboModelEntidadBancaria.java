/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.EntidadBancaria;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelEntidadBancaria extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<EntidadBancaria> data;
    
    public CboModelEntidadBancaria(){                  
    }

    public CboModelEntidadBancaria(ArrayList<EntidadBancaria> datos) {
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
    
    public EntidadBancaria getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((EntidadBancaria)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((EntidadBancaria)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (EntidadBancaria)item);
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
    
    public ArrayList<EntidadBancaria> getData() {
        return data;
    }

    public void setData(ArrayList<EntidadBancaria> data) {
        this.data = data;
    }
}
