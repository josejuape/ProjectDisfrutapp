/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.xtbc.Moneda;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelMoneda extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<Moneda> data;
    
    public CboModelMoneda(){                  
    }

    public CboModelMoneda(ArrayList<Moneda> datos) {
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
        return data.get(index).getV_moneda();
    }
    
    public Moneda getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((Moneda)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((Moneda)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (Moneda)item);
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
    
    public ArrayList<Moneda> getData() {
        return data;
    }

    public void setData(ArrayList<Moneda> data) {
        this.data = data;
    }
}
