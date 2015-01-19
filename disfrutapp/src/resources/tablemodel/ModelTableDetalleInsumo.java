/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.DetalleInsumo;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableDetalleInsumo extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<DetalleInsumo> data = new ArrayList();

    public ModelTableDetalleInsumo(){
        this.crearCabeceras();
    }
    
    public ModelTableDetalleInsumo(ArrayList<DetalleInsumo> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("NOMBRE INSUMO");
        this.CabeceraTabla.add("CONTENIDO/CAP.");
        this.CabeceraTabla.add("PRESENTACIÓN");
        this.CabeceraTabla.add("UNIDAD");
        this.CabeceraTabla.add("CANTIDAD");
    }
    
    public DetalleInsumo getValue(int rowIndex){
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
                return data.get(rowIndex).getInsumo().getNombre();
            case 1:
                return data.get(rowIndex).getInsumo().getCapacidad();
            case 2:
                return data.get(rowIndex).getInsumo().getCapacidad();
            case 3:
                return data.get(rowIndex).getUnidad();
            case 4:
                return data.get(rowIndex).getCantidad();
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

    public ArrayList<DetalleInsumo> getData() {
        return data;
    }

    public void setData(ArrayList<DetalleInsumo> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
    
}
