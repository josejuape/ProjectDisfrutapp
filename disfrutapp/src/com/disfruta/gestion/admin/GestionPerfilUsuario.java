/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicPerfilUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionPerfilUsuario {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(PerfilUsuario perfil) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPerfilUsuario logic = new LogicPerfilUsuario(objCnx);
            
            
            if (perfil.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logic.mantenimiento(perfil);
            }else{
                return mensaje;
            }            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(PerfilUsuario perfil) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPerfilUsuario logic = new LogicPerfilUsuario(objCnx);
            
            
            if (perfil.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logic.mantenimiento(perfil);
            }else{
                return mensaje;
            }            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String eliminar(PerfilUsuario perfil) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicPerfilUsuario logic = new LogicPerfilUsuario(objCnx);
            
            
            if (perfil.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logic.mantenimiento(perfil);
            }else{
                return mensaje;
            }            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public ArrayList<PerfilUsuario> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicPerfilUsuario logicPerfilUsuario = new LogicPerfilUsuario(objCnx);
            array=logicPerfilUsuario.listar();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
     public ArrayList<PerfilUsuario> listarPorUsuario(UsuarioDesktop user) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicPerfilUsuario logicPerfilUsuario = new LogicPerfilUsuario(objCnx);
            array=logicPerfilUsuario.listarPorUsuario(user);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
     
     public PerfilUsuario getUltimoObject() throws ClassNotFoundException, Exception {
        try {
            LogicPerfilUsuario logicPerfilUsuario = new LogicPerfilUsuario(objCnx);
            PerfilUsuario array=logicPerfilUsuario.getUltimoObject();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarioDesktop.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
