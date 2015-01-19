/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.Insumo;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableInsumos extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<Insumo> data = new ArrayList();

    public ModelTableInsumos(){
        this.crearCabeceras();
    }
    
    public ModelTableInsumos(ArrayList<Insumo> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("NOMBRE");
        this.CabeceraTabla.add("CATEGORIA");
        this.CabeceraTabla.add("CAPACIDAD/CONTENIDO");
        this.CabeceraTabla.add("PRECIO DE COMPRA");
        this.CabeceraTabla.add("CUENTA CONTABLE");
    }
    
    public Insumo getValue(int rowIndex){
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
                return data.get(rowIndex).getNombre();
            case 1:
                return data.get(rowIndex).getCategoria().getV_familia();
            case 2:
                return data.get(rowIndex).getCapacidad();
            case 3:
                return data.get(rowIndex).getPreciocompra();
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

    public ArrayList<Insumo> getData() {
        return data;
    }

    public void setData(ArrayList<Insumo> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
