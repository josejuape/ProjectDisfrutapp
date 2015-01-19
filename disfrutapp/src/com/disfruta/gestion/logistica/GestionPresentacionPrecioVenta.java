/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicPresentacionPrecioVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionPresentacionPrecioVenta {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(PresentacionPrecioVenta beanPresentacion) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionPrecioVenta logicPresentacionVenta = new LogicPresentacionPrecioVenta(objCnx);
            
            
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
    
    public String eliminarPorProducto(ProductoCarta producto) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPresentacionPrecioVenta logicPresentacionVenta = new LogicPresentacionPrecioVenta(objCnx);
            
            
            if (producto.getTipoOperacion().equalsIgnoreCase("e1")) {
                mensaje = logicPresentacionVenta.eliminarPorProducto(producto);
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
    
    public ArrayList<PresentacionPrecioVenta> listarPorProducto(ProductoCarta producto) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicPresentacionPrecioVenta logicPresentacionVenta = new LogicPresentacionPrecioVenta(objCnx);
            array=logicPresentacionVenta.listarPorProducto(producto);
            
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
}
