/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.admin;

import com.disfruta.bean.admin.TipoUserDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.admin.LogicTipoUserDesktop;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionTipoUserDesktop {
    ObjConexion objCnx = new ObjConexion();
    
    public ArrayList<TipoUserDesktop> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicTipoUserDesktop logicTipoUserDesktop = new LogicTipoUserDesktop(objCnx);
            array=logicTipoUserDesktop.listar();
            
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
