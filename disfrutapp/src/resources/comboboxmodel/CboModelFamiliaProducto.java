/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.FamiliaProducto;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelFamiliaProducto extends AbstractListModel implements MutableComboBoxModel {

    private Object selectedItem;
    private ArrayList<FamiliaProducto> data;
    
    public CboModelFamiliaProducto(){                  
    }

    public CboModelFamiliaProducto(ArrayList<FamiliaProducto> datos) {
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
        return data.get(index).getV_familia();
    }
    
    public FamiliaProducto getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((FamiliaProducto)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((FamiliaProducto)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (FamiliaProducto)item);
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
    
    public ArrayList<FamiliaProducto> getData() {
        return data;
    }

    public void setData(ArrayList<FamiliaProducto> data) {
        this.data = data;
    }
    
}
