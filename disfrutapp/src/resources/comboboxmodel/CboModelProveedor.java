/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.logistica.Proveedor;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelProveedor extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<Proveedor> data;
    
    public CboModelProveedor(){                  
    }

    public CboModelProveedor(ArrayList<Proveedor> datos) {
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
        return data.get(index).getNombres()+" "+data.get(index).getApellidos();
    }
    
    public Proveedor getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((Proveedor)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((Proveedor)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (Proveedor)item);
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
    
    public ArrayList<Proveedor> getData() {
        return data;
    }

    public void setData(ArrayList<Proveedor> data) {
        this.data = data;
    }
    
}
