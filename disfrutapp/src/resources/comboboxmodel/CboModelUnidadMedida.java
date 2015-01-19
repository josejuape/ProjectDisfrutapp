/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.UnidadMedida;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelUnidadMedida extends AbstractListModel implements MutableComboBoxModel {
    private Object selectedItem;
    private ArrayList<UnidadMedida> data;
    
    public CboModelUnidadMedida(){                  
    }

    public CboModelUnidadMedida(ArrayList<UnidadMedida> datos) {
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
        return data.get(index).getV_unidad();
    }
    
    public UnidadMedida getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((UnidadMedida)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((UnidadMedida)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (UnidadMedida)item);
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
    
    public ArrayList<UnidadMedida> getData() {
        return data;
    }

    public void setData(ArrayList<UnidadMedida> data) {
        this.data = data;
    }
}
