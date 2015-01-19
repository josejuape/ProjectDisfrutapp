/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.CuentaBancaria;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicCuentaBancaria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionCuentaBancaria {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(CuentaBancaria beanCuentaBancaria) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicCuentaBancaria logicCuentaBancaria = new LogicCuentaBancaria(objCnx);
            
            
            if (beanCuentaBancaria.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicCuentaBancaria.mantenimiento(beanCuentaBancaria);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(CuentaBancaria beanCuentaBancaria){
            String mensaje = "Operacion incorrecta";
        try {
            
            LogicCuentaBancaria logicProveedor= new LogicCuentaBancaria(objCnx);
           
            
            if (beanCuentaBancaria.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicProveedor.mantenimiento(beanCuentaBancaria);
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
    
    public String eliminar(CuentaBancaria beanCuentaBancaria){
           String mensaje = "Operacion incorrecta";
        try {
            
            LogicCuentaBancaria logicAlmacen = new LogicCuentaBancaria(objCnx);
            
            
            if (beanCuentaBancaria.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicAlmacen.mantenimiento(beanCuentaBancaria);
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
    
    public ArrayList<CuentaBancaria> listarCuentaUsuario(Proveedor proveedor) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicCuentaBancaria logicCuentaBancaria = new LogicCuentaBancaria(objCnx);
            array=logicCuentaBancaria.listarCuentaUsuario(proveedor);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionCuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
