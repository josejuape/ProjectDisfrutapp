/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionInsumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicPresentacionInsumo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionPresentacionInsumo {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(PresentacionInsumo beanInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionInsumo logicInsumo = new LogicPresentacionInsumo(objCnx);
            
            
            if (beanInsumo.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicInsumo.mantenimiento(beanInsumo);
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
    
    public String actualizar(PresentacionInsumo beanPresentacionInsumo){
            String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionInsumo logicPresentacionInsumo= new LogicPresentacionInsumo(objCnx);
           
            
            if (beanPresentacionInsumo.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicPresentacionInsumo.mantenimiento(beanPresentacionInsumo);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
    }
    
    public String eliminar(PresentacionInsumo beanPresentacionInsumo){
           String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionInsumo logicAlmacen = new LogicPresentacionInsumo(objCnx);
            
            
            if (beanPresentacionInsumo.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicAlmacen.mantenimiento(beanPresentacionInsumo);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionAlmacen.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
    }
    
    public ArrayList<PresentacionInsumo> listarPorInsumo(Insumo insumo) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicPresentacionInsumo logicPresentacionInsumo = new LogicPresentacionInsumo(objCnx);
            array=logicPresentacionInsumo.listarPorInsumo(insumo);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionPresentacionInsumo.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
