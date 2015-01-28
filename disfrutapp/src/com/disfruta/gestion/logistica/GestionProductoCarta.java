/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicProductoCarta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionProductoCarta {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(ProductoCarta beanProductoCarta) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            
            
            if (beanProductoCarta.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicProductoCarta.mantenimiento(beanProductoCarta);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(ProductoCarta beanProductoCarta) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            
            
            if (beanProductoCarta.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicProductoCarta.mantenimiento(beanProductoCarta);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String eliminar(ProductoCarta beanProductoCarta) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            
            
            if (beanProductoCarta.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicProductoCarta.mantenimiento(beanProductoCarta);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public ArrayList<ProductoCarta> listar() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            array=logicProductoCarta.listar();            
            return array;             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
    public ArrayList<ProductoCarta> listarPorFamilia(FamiliaProducto familia) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            array=logicProductoCarta.listarPorFamilia(familia);            
            return array;             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
     public ArrayList<ProductoCarta> listarCarta() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            array=logicProductoCarta.listarCarta();            
            return array;             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
     
     public ArrayList<DetallePedido> listarProductosDevueltos() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            array=logicProductoCarta.listarProductosDevueltos();            
            return array;             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
    public ArrayList<ProductoCarta> listarPorBusqueda(String nombre) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicProductoCarta logicProductoCarta = new LogicProductoCarta(objCnx);
            array=logicProductoCarta.listarPorBusqueda(nombre);            
            return array;             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoCarta.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
}
