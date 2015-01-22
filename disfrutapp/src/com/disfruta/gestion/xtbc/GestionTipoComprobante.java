/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.xtbc;

import com.disfruta.bean.xtbc.TipoComprobante;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.xtbc.LogicTipoComprobante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionTipoComprobante {
    ObjConexion objCnx = new ObjConexion();
    
    public ArrayList<TipoComprobante> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicTipoComprobante logic = new LogicTipoComprobante(objCnx);
            array=logic.listar();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionMoneda.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
