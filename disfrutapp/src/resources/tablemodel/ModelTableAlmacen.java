/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.Almacen;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableAlmacen extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<Almacen> data = new ArrayList();

    public ModelTableAlmacen(){
        this.crearCabeceras();
    }
    
    public ModelTableAlmacen(ArrayList<Almacen> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("CODIGO");
        this.CabeceraTabla.add("NOMBRE");
        this.CabeceraTabla.add("UBICACIÓN");
        this.CabeceraTabla.add("TELÉFONO");
        this.CabeceraTabla.add("DIRECCIÓN");
    }
    
    public Almacen getValue(int rowIndex){
        return data.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
       return this.CabeceraTabla.size();
    }

    public String getColumnName(int column) {

        return CabeceraTabla.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getId();
            case 1:
                return data.get(rowIndex).getDescripcion();
            case 2:
                return data.get(rowIndex).getUbicacion();
            case 3:
                return data.get(rowIndex).getTelefono();
            case 4:
                return data.get(rowIndex).getDireccion1();
            default:
                return null;
        }
    }

    public ArrayList<String> getCabeceraTabla() {
        return CabeceraTabla;
    }

    public void setCabeceraTabla(ArrayList<String> CabeceraTabla) {
        this.CabeceraTabla = CabeceraTabla;
    }

    public ArrayList<Almacen> getData() {
        return data;
    }

    public void setData(ArrayList<Almacen> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
