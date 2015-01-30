/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.IngresoAlmacenInsumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicIngresoAlmacenInsumo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionIngresoAlmacenInsumo {
    ObjConexion objCnx = new ObjConexion();
    
     public String registrar(IngresoAlmacenInsumo beanIngreso) {
        String mensaje = "";
        try {
            
            LogicIngresoAlmacenInsumo logicIngreso = new LogicIngresoAlmacenInsumo(objCnx);
            String o=beanIngreso.getTipoOperacion();
            
            if (o.equals("ioc") || o.equals("irs") || o.equals("idec") || o.equals("idic")) {
                mensaje = logicIngreso.mantenimiento(beanIngreso);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionIngresoAlmacenInsumo.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
}
