/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicMenuPerfil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionMenuPerfil {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrarMenu(MenuPerfil beanMenu) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicMenuPerfil logicMenu = new LogicMenuPerfil(objCnx);
            
            
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
    
    public String eliminar(MenuPerfil beanMenu) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicMenuPerfil logicMenu = new LogicMenuPerfil(objCnx);
            
            
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
}
