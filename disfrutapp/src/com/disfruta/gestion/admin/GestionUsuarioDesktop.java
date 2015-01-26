/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicUsuarioDesktop;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class GestionUsuarioDesktop {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(UsuarioDesktop user) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicUsuarioDesktop logic = new LogicUsuarioDesktop(objCnx);
            
            
            if (user.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logic.mantenimiento(user);
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
    
    public String actualizar(UsuarioDesktop user) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicUsuarioDesktop logic = new LogicUsuarioDesktop(objCnx);
            
            
            if (user.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logic.mantenimiento(user);
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
    
    public String eliminar(UsuarioDesktop user) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicUsuarioDesktop logic = new LogicUsuarioDesktop(objCnx);
            
            
            if (user.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logic.mantenimiento(user);
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
    
    public ArrayList<UsuarioDesktop> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicUsuarioDesktop logicMenu = new LogicUsuarioDesktop(objCnx);
            array=logicMenu.listar();
            
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
    
    
    public ArrayList<UsuarioDesktop> listarStaffCocina() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicUsuarioDesktop logicMenu = new LogicUsuarioDesktop(objCnx);
            array=logicMenu.listarStaffCocina();
            
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
    
    public ArrayList<UsuarioDesktop> listarStaff() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicUsuarioDesktop logicMenu = new LogicUsuarioDesktop(objCnx);
            array=logicMenu.listarStaff();
            
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
    
    public UsuarioDesktop getUltimoObject() throws ClassNotFoundException, Exception {
        try {
            LogicUsuarioDesktop logicMenu = new LogicUsuarioDesktop(objCnx);
            UsuarioDesktop array=logicMenu.getUltimoObject();
            
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
