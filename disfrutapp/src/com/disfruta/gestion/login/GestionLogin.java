/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.login;

import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.xtbc.Usuario;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.gestion.admin.GestionMenu;
import com.disfruta.logic.login.LogicLogin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juape
 */
public class GestionLogin {
    
    ObjConexion objCnx = new ObjConexion(); 
    
    public UsuarioDesktop validarLogin(UsuarioDesktop user) throws ClassNotFoundException, Exception {
        
        try {
            LogicLogin logicUsuario = new LogicLogin(objCnx);
            UsuarioDesktop us=logicUsuario.validarLogin(user);
            
            return us;
             
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
    
    
    public ArrayList<MenuPerfil> listarMenuLogin(UsuarioDesktop user) throws ClassNotFoundException, Exception {
            
        try {
            LogicLogin logicUsuario = new LogicLogin(objCnx);
            ArrayList<MenuPerfil> lista=logicUsuario.listarMenuLogin(user);
            
            return lista;
             
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
