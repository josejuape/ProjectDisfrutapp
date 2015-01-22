/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.logistica.OrdenCompra;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableOrdenCompra extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<OrdenCompra> data = new ArrayList();

    public ModelTableOrdenCompra(){
        this.crearCabeceras();
    }
    
    public ModelTableOrdenCompra(ArrayList<OrdenCompra> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("CÓDIGO");
        this.CabeceraTabla.add("PROVEEDOR");
        this.CabeceraTabla.add("COMENTARIO");
        this.CabeceraTabla.add("FECHA DE EMISIÓN");
        this.CabeceraTabla.add("FECHA DE RECEPCIÓN");
    }
    
    public OrdenCompra getValue(int rowIndex){
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
                return data.get(rowIndex).getNumero();
            case 1:
                return data.get(rowIndex).getProveedor().getNombres()+" "+data.get(rowIndex).getProveedor().getApellidos();
            case 2:
                return data.get(rowIndex).getComentario();
            case 3:
                return data.get(rowIndex).getFechaRegistro();
            case 4:
                return data.get(rowIndex).getFechaRecepcion();
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

    public ArrayList<OrdenCompra> getData() {
        return data;
    }

    public void setData(ArrayList<OrdenCompra> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
    
}
