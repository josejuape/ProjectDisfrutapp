/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTablePresentacionPrecioVenta extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<PresentacionPrecioVenta> data = new ArrayList();

    public ModelTablePresentacionPrecioVenta(){
        this.crearCabeceras();
    }
    
    public ModelTablePresentacionPrecioVenta(ArrayList<PresentacionPrecioVenta> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("Presentación Comercial");
        this.CabeceraTabla.add("Precio de venta");
        this.CabeceraTabla.add("Proporción");
    }
    
    public PresentacionPrecioVenta getValue(int rowIndex){
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
                return data.get(rowIndex).getPresentacion().getDescripcion();
            case 1:
                return data.get(rowIndex).getPrecioventa();
            case 2:
                return data.get(rowIndex).getProporcion();
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

    public ArrayList<PresentacionPrecioVenta> getData() {
        return data;
    }

    public void setData(ArrayList<PresentacionPrecioVenta> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
    
}
