/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.CategoriaProveedor;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelCategoriaProveedor extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<CategoriaProveedor> data;
    
    public CboModelCategoriaProveedor(){                  
    }

    public CboModelCategoriaProveedor(ArrayList<CategoriaProveedor> datos) {
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
    
    public CategoriaProveedor getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((CategoriaProveedor)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((CategoriaProveedor)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (CategoriaProveedor)item);
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
    
    public ArrayList<CategoriaProveedor> getData() {
        return data;
    }

    public void setData(ArrayList<CategoriaProveedor> data) {
        this.data = data;
    }
}
