/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.xtbc.TipoComprobante;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelTipoComprobante extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<TipoComprobante> data;
    
    public CboModelTipoComprobante(){                  
    }

    public CboModelTipoComprobante(ArrayList<TipoComprobante> datos) {
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
    
    public TipoComprobante getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((TipoComprobante)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((TipoComprobante)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (TipoComprobante)item);
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
    
    public ArrayList<TipoComprobante> getData() {
        return data;
    }

    public void setData(ArrayList<TipoComprobante> data) {
        this.data = data;
    }
    
}
