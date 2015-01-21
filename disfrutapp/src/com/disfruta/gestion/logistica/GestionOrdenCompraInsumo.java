/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.OrdenCompraInsumo;
import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicOrdenCompraInsumo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionOrdenCompraInsumo {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(OrdenCompraInsumo beanOrdenCompraInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicOrdenCompraInsumo logicOrdenCompraInsumo = new LogicOrdenCompraInsumo(objCnx);
            
            
            if (beanOrdenCompraInsumo.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicOrdenCompraInsumo.mantenimiento(beanOrdenCompraInsumo);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(OrdenCompraInsumo beanOrdenCompraInsumo) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicOrdenCompraInsumo logicOrdenCompraInsumo = new LogicOrdenCompraInsumo(objCnx);
            
            
            if (beanOrdenCompraInsumo.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicOrdenCompraInsumo.mantenimiento(beanOrdenCompraInsumo);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
     public String eliminar(OrdenCompra beanOrdenCompra) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicOrdenCompraInsumo logicOrdenCompraInsumo = new LogicOrdenCompraInsumo(objCnx);
            
            
            if (beanOrdenCompra.getTipoOperacion().equalsIgnoreCase("e")) {
                OrdenCompraInsumo bean=new OrdenCompraInsumo();
                bean.setCantidad(0);
                bean.setPrecio(0);
                bean.setSubtotal(0);
                Insumo insumo=new Insumo();
                insumo.setIdinsumo(0);
                Moneda moneda=new Moneda();
                moneda.setN_idmon(0);
                UnidadMedida medida=new UnidadMedida();
                medida.setN_idum(0);
                bean.setInsumo(insumo);
                bean.setMoneda(moneda);
                bean.setUnidad(medida);
                bean.setOrden(beanOrdenCompra);
                bean.setTipoOperacion("e");
                mensaje = logicOrdenCompraInsumo.mantenimiento(bean);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
       
    public ArrayList<OrdenCompraInsumo> listar(OrdenCompra orden) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicOrdenCompraInsumo logicOrdenCompraInsumo = new LogicOrdenCompraInsumo(objCnx);
            array=logicOrdenCompraInsumo.listar(orden);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionOrdenCompraInsumo.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
