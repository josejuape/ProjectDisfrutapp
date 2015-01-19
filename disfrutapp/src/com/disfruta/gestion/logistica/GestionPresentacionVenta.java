/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicInsumo;
import com.disfruta.logic.logistica.LogicPresentacionVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionPresentacionVenta {
    ObjConexion objCnx = new ObjConexion();
    
    
    public String registrar(PresentacionVenta beanPresentacion) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionVenta logicPresentacionVenta = new LogicPresentacionVenta(objCnx);
            
            
            if (beanPresentacion.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicPresentacionVenta.mantenimiento(beanPresentacion);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public ArrayList<PresentacionVenta> listarPorFamilia(ProductoCarta producto) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicPresentacionVenta logicPresentacionVenta = new LogicPresentacionVenta(objCnx);
            array=logicPresentacionVenta.listarPorFamilia(producto);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionPresentacionVenta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
    public PresentacionVenta getUltimoObject() throws ClassNotFoundException, Exception {        
        try {
            LogicPresentacionVenta logicPresentacion = new LogicPresentacionVenta(objCnx);
            PresentacionVenta obj=logicPresentacion.getUltimoObject();
            
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
