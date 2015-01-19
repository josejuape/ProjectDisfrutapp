/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicProveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionProveedor {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(Proveedor beanProveedor) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicProveedor logicProveedor = new LogicProveedor(objCnx);
            
            
            if (beanProveedor.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicProveedor.mantenimiento(beanProveedor);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(Proveedor beanProveedor){
            String mensaje = "Operacion incorrecta";
        try {
            
            LogicProveedor logicProveedor= new LogicProveedor(objCnx);
           
            
            if (beanProveedor.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicProveedor.mantenimiento(beanProveedor);
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
    
    public String eliminar(Proveedor beanProveedor){
           String mensaje = "Operacion incorrecta";
        try {
            
            LogicProveedor logicAlmacen = new LogicProveedor(objCnx);
            
            
            if (beanProveedor.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicAlmacen.mantenimiento(beanProveedor);
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
    
    public ArrayList<Proveedor> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProveedor logicProveedor = new LogicProveedor(objCnx);
            array=logicProveedor.listar();
            
            return array;
             
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
    
    public Proveedor getUltimoObject() throws ClassNotFoundException, Exception {        
        try {
            LogicProveedor logicProveedor = new LogicProveedor(objCnx);
            Proveedor obj=logicProveedor.getUltimoObject();
            
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
