/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.TipoPersona;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelTipoPersona extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<TipoPersona> data;
    
    public CboModelTipoPersona(){                  
    }

    public CboModelTipoPersona(ArrayList<TipoPersona> datos) {
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
    
    public TipoPersona getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((TipoPersona)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((TipoPersona)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (TipoPersona)item);
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
    
    public ArrayList<TipoPersona> getData() {
        return data;
    }

    public void setData(ArrayList<TipoPersona> data) {
        this.data = data;
    }
}
