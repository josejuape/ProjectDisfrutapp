/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.DetallePerfilUsuario;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicDetallePerfilUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionDetallePerfilUsuario {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(DetallePerfilUsuario bean) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePerfilUsuario logicDetallePerfilUsuario = new LogicDetallePerfilUsuario(objCnx);
            
            
            if (bean.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicDetallePerfilUsuario.mantenimiento(bean);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public String eliminar(DetallePerfilUsuario bean) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePerfilUsuario logicDetallePerfilUsuario = new LogicDetallePerfilUsuario(objCnx);
            
            
            if (bean.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicDetallePerfilUsuario.mantenimiento(bean);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePerfilUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
