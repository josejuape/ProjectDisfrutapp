/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicMenu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionMenu {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrarMenu(Menu beanMenu) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicMenu logicMenu = new LogicMenu(objCnx);
            
            
            if (beanMenu.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicMenu.mantenimiento(beanMenu);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizarMenu(Menu beanMenu){
            String mensaje = "Operacion incorrecta";
        try {
            
            LogicMenu logicMenu = new LogicMenu(objCnx);
            
            
            if (beanMenu.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicMenu.mantenimiento(beanMenu);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
    }
    
    public String eliminarMenu(Menu beanMenu){
           String mensaje = "Operacion incorrecta";
        try {
            
            LogicMenu logicMenu = new LogicMenu(objCnx);
            
            
            if (beanMenu.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicMenu.mantenimiento(beanMenu);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
    }
    
    public ArrayList<Menu> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicMenu logicMenu = new LogicMenu(objCnx);
            array=logicMenu.listar();
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
//    public ArrayList<MenuDinamico> listarMenuDinamico() throws ClassNotFoundException, Exception {
//        ArrayList array = new ArrayList();
//        try {
//            LogicMenu logicMenu = new LogicMenu(objCnx);
//            array=logicMenu.listarMenuDinamico();
//            
//            return array;
//             
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (InstantiationException ex) {
//            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (SQLException ex) {
//            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (Exception ex) {
//            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        }finally{
//            try {
//                objCnx.getMysql().desconectarBD();
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
//               
//            }
//        }
//    }
    
    public ArrayList<Menu> listarPorPerfilUsuario(PerfilUsuario perfil) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicMenu logicMenu = new LogicMenu(objCnx);
            array=logicMenu.listarPorPerfilUsuario(perfil);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionMenu.class.getName()).log(Level.SEVERE, null, ex);
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
