/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.IngresoAlmacen;
import com.disfruta.bean.logistica.TipoIngresoAlmacen;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicIngresoAlmacen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionIngresoAlmacen {
    ObjConexion objCnx = new ObjConexion();
    
    
    public String registrar(IngresoAlmacen beanIngreso) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicIngresoAlmacen logicIngreso = new LogicIngresoAlmacen(objCnx);
            
            
            if (beanIngreso.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicIngreso.mantenimiento(beanIngreso);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public ArrayList<TipoIngresoAlmacen> listarTipoIngreso() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicIngresoAlmacen logicInsumo = new LogicIngresoAlmacen(objCnx);
            array=logicInsumo.listarTipoIngreso();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
