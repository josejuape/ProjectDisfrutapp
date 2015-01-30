/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.OrdenCompraInsumo;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableIngresoAlmacenOC extends AbstractTableModel {

    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<OrdenCompraInsumo> data = new ArrayList();

    public ModelTableIngresoAlmacenOC() {
        this.crearCabeceras();

    }

    public ModelTableIngresoAlmacenOC(ArrayList<OrdenCompraInsumo> ListaDatos) {
        this.crearCabeceras();
        this.data = ListaDatos;
    }

    private void crearCabeceras() {
        this.CabeceraTabla.add("CÓDIGO");
        this.CabeceraTabla.add("NOMBRE");
        this.CabeceraTabla.add("PRESENTACIÓN");
        this.CabeceraTabla.add("CANTIDAD");
        this.CabeceraTabla.add("PRECIO");
        this.CabeceraTabla.add("MONEDA");
        this.CabeceraTabla.add("SUBTOTAL");
        this.CabeceraTabla.add("ATENDIDOS");
        this.CabeceraTabla.add("POR ATENDER");
    }

    public OrdenCompraInsumo getValue(int rowIndex) {
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
        if (columnIndex == 7 || columnIndex == 8) {
            return true;
        }
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getInsumo().getIdinsumo();
            case 1:
                return data.get(rowIndex).getInsumo().getNombre();
            case 2:
                return data.get(rowIndex).getInsumo().getNombre();
            case 3:
                return data.get(rowIndex).getCantidad();
            case 4:
                return data.get(rowIndex).getPrecio();
            case 5:
                return data.get(rowIndex).getMoneda().getV_moneda();
            case 6:
                return data.get(rowIndex).getSubtotal();
            case 7:
                return 0;
            case 8:
                return 0;
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

    public ArrayList<OrdenCompraInsumo> getData() {
        return data;
    }

    public void setData(ArrayList<OrdenCompraInsumo> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
