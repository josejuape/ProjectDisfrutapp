/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicInsumo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionInsumo {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(Insumo beanInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicInsumo logicInsumo = new LogicInsumo(objCnx);
            
            
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
    
    public String actualizar(Insumo beanInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicInsumo logicInsumo = new LogicInsumo(objCnx);
            
            
            if (beanInsumo.getTipoOperacion().equalsIgnoreCase("a")) {
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
    
     public String eliminar(Insumo beanInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicInsumo logicInsumo = new LogicInsumo(objCnx);
            
            
            if (beanInsumo.getTipoOperacion().equalsIgnoreCase("e")) {
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
       
    public ArrayList<Insumo> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicInsumo logicInsumo = new LogicInsumo(objCnx);
            array=logicInsumo.listar();
            
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
    
    public Insumo getUltimoObject() throws ClassNotFoundException, Exception {        
        try {
            LogicInsumo logicInsumo = new LogicInsumo(objCnx);
            Insumo obj=logicInsumo.getUltimoObject();
            
            return obj;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
}
