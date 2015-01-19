/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.tablemodel;

import com.disfruta.bean.admin.UsuarioDesktop;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juape
 */
public class ModelTableEmpleados extends AbstractTableModel {
    private ArrayList<String> CabeceraTabla = new ArrayList();
    private ArrayList<UsuarioDesktop> data = new ArrayList();

    public ModelTableEmpleados(){
        this.crearCabeceras();
    }
    
    public ModelTableEmpleados(ArrayList<UsuarioDesktop> ListaDatos){
        this.crearCabeceras();
        this.data=ListaDatos;
    }
    
    private void crearCabeceras(){
        this.CabeceraTabla.add("DNI");
        this.CabeceraTabla.add("NOMBRES");
        this.CabeceraTabla.add("APELLIDOS");
        this.CabeceraTabla.add("CORREO ELECTRÓNICO");
        this.CabeceraTabla.add("N° CELULAR");
        this.CabeceraTabla.add("TIPO DE USUARIO");
        this.CabeceraTabla.add("ESTADO");
    }
    
    public UsuarioDesktop getValue(int rowIndex){
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
                return data.get(rowIndex).getDni();
            case 1:
                return data.get(rowIndex).getNombres();
            case 2:
                return data.get(rowIndex).getApellidos();
            case 3:
                return data.get(rowIndex).getEmail();
            case 4:
                return data.get(rowIndex).getCelular();
            case 5:
                return data.get(rowIndex).getTipoUser().getDescripcion();
            case 6:
                return data.get(rowIndex).getEstado();
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

    public ArrayList<UsuarioDesktop> getData() {
        return data;
    }

    public void setData(ArrayList<UsuarioDesktop> data) {
        this.data = data;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
    
}
