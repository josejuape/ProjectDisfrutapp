/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.CategoriaProveedor;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicCategoriaProveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionCategoriaProveedor {
    ObjConexion objCnx = new ObjConexion();
    
    public ArrayList<CategoriaProveedor> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicCategoriaProveedor logicCategoriaProveedor = new LogicCategoriaProveedor(objCnx);
            array=logicCategoriaProveedor.listar();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionCategoriaProveedor.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
