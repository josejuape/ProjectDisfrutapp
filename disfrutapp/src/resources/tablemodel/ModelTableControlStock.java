/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.ControlStock;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class ModelTableControlStock extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<ControlStock> data = new ArrayList();

    public ModelTableControlStock(){
        this.crearCabeceras();
    }
    
    public ModelTableControlStock(ArrayList<ControlStock> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("CÓDIGO");
        this.CabeceraTabla.add("NOMBRE INSUMO");
        this.CabeceraTabla.add("ALMACÉN");
        this.CabeceraTabla.add("STOCK ACTUAL");
        this.CabeceraTabla.add("PRECIO VENTA ACTUAL");
    }
    
    public ControlStock getValue(int rowIndex){
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
                return data.get(rowIndex).getIdcontrol();
            case 1:
                return data.get(rowIndex).getInsumo().getNombre();
            case 2:
                return data.get(rowIndex).getAlmacen().getDescripcion();
            case 3:
                return data.get(rowIndex).getStock();
            case 4:
                return data.get(rowIndex).getPrecioventa();
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

    public ArrayList<ControlStock> getData() {
        return data;
    }

    public void setData(ArrayList<ControlStock> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
