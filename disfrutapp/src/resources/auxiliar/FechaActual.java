/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class FechaActual {
    
    public static String fechactualNumerico(){
        Calendar fecha=Calendar.getInstance();
        int dia=fecha.get(Calendar.DATE);
        int mes=fecha.get(Calendar.MONTH)+1;
        String mescadena=mes+"";
        String diacadena=dia+"";
        if(mes<10){
            mescadena="0"+mescadena;
        }
        if(dia<10){
            diacadena="0"+diacadena;
        }
        int anio=fecha.get(Calendar.YEAR);
        
        String fechaActual=diacadena+"/"+mescadena+"/"+anio;
        return fechaActual;
    }
    
    public static String formatoMysql(){
        Calendar fecha=Calendar.getInstance();
        int dia=fecha.get(Calendar.DATE);
        int mes=fecha.get(Calendar.MONTH)+1;
        String mescadena=mes+"";
        String diacadena=dia+"";
        if(mes<10){
            mescadena="0"+mescadena;
        }
        if(dia<10){
            diacadena="0"+diacadena;
        }
        int anio=fecha.get(Calendar.YEAR);
        
        String fechaActual=anio+"-"+mescadena+"-"+diacadena;
        return fechaActual;
    }
    
    public static String fechactual(){
        Calendar fecha=Calendar.getInstance();
        int dia=fecha.get(Calendar.DATE);
        int mes=fecha.get(Calendar.MONTH)+1;
        int anio=fecha.get(Calendar.YEAR);
        
        String fechaActual=dia+" de "+nombreMes(mes)+" del "+anio;
        return fechaActual;
    }
    
    private static String nombreMes(int mes){
        String nameMes="";
        switch(mes){
            case 1: nameMes="Enero";break;
            case 2: nameMes="Febrero";break;
            case 3: nameMes="Marzo";break;
            case 4: nameMes="Abril";break;
            case 5: nameMes="Mayo";break;
            case 6: nameMes="Junio";break;
            case 7: nameMes="Julio";break;
            case 8: nameMes="Agosto";break;
            case 9: nameMes="Septiembre";break;
            case 10: nameMes="Octubre";break;
            case 11: nameMes="Noviembre";break;
            case 12: nameMes="Diciembre";break;   
            default: nameMes="";break;
        }
        return nameMes;
    }
}
