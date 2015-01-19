/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.admin.TipoUserDesktop;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelTipoUserDesktop extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<TipoUserDesktop> data;
    
    public CboModelTipoUserDesktop(){                  
    }

    public CboModelTipoUserDesktop(ArrayList<TipoUserDesktop> datos) {
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
    
    public TipoUserDesktop getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((TipoUserDesktop)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((TipoUserDesktop)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (TipoUserDesktop)item);
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
    
    public ArrayList<TipoUserDesktop> getData() {
        return data;
    }

    public void setData(ArrayList<TipoUserDesktop> data) {
        this.data = data;
    }
    
}
