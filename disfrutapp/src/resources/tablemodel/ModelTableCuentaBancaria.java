/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.CuentaBancaria;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableCuentaBancaria  extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<CuentaBancaria> data = new ArrayList();

    public ModelTableCuentaBancaria(){
        this.crearCabeceras();
    }
    
    public ModelTableCuentaBancaria(ArrayList<CuentaBancaria> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("ENTIDAD BANCARIA");
        this.CabeceraTabla.add("TIPO MONEDA");
        this.CabeceraTabla.add("N° CUENTA");
        this.CabeceraTabla.add("N° CUENTA INTERBANCARIA");
    }
    
    public CuentaBancaria getValue(int rowIndex){
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
                return data.get(rowIndex).getEntidad().getNombre();
            case 1:
                return data.get(rowIndex).getMoneda().getV_moneda();
            case 2:
                return data.get(rowIndex).getNumerocuenta();
            case 3:
                return data.get(rowIndex).getCuentainterbancaria();
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

    public ArrayList<CuentaBancaria> getData() {
        return data;
    }

    public void setData(ArrayList<CuentaBancaria> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
