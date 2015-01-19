/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.comboboxmodel;

import com.disfruta.bean.admin.UsuarioDesktop;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author Juape
 */
public class CboModelUsuario extends AbstractListModel implements MutableComboBoxModel{
    private Object selectedItem;
    private ArrayList<UsuarioDesktop> data;
    
    public CboModelUsuario(){                  
    }

    public CboModelUsuario(ArrayList<UsuarioDesktop> datos) {
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
    
    public UsuarioDesktop getElement(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(Object item) {
        data.add((UsuarioDesktop)item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove((UsuarioDesktop)obj);
    }

    @Override
    public void insertElementAt(Object item, int index) {
        data.set(index, (UsuarioDesktop)item);
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
    
    public ArrayList<UsuarioDesktop> getData() {
        return data;
    }

    public void setData(ArrayList<UsuarioDesktop> data) {
        this.data = data;
    }
    
}
