/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.gestion.logistica;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.Pedido;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.logic.logistica.LogicDetallePedido;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juape
 */
public class GestionDetallePedido {
    ObjConexion objCnx = new ObjConexion();
    
    public String registrar(DetallePedido beanDetallePedido) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            
            
            if (beanDetallePedido.getTipoOperacion().equalsIgnoreCase("i")) {
                mensaje = logicDetallePedido.mantenimiento(beanDetallePedido);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
    public String actualizar(DetallePedido beanDetallePedido) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            
            
            if (beanDetallePedido.getTipoOperacion().equalsIgnoreCase("a")) {
                mensaje = logicDetallePedido.mantenimiento(beanDetallePedido);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
    
     public String eliminar(DetallePedido beanDetallePedido) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            
            
            if (beanDetallePedido.getTipoOperacion().equalsIgnoreCase("e")) {
                mensaje = logicDetallePedido.mantenimiento(beanDetallePedido);
            }else{
                return mensaje;
            }
            
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
       
    public ArrayList<DetallePedido> listar(Pedido pedido) throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            array=logicDetallePedido.listar(pedido);
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
    public ArrayList<DetallePedido> listarTodos() throws ClassNotFoundException, Exception {
        ArrayList array = new ArrayList();
        try {
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            array=logicDetallePedido.listarTodo();
            
            return array;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            try {
                objCnx.getMysql().desconectarBD();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
    }
    
    
    public String actualizarEstadoPlato(DetallePedido beanDetallePedido) {
        String mensaje = "Operacion incorrecta";
        try {
            
            LogicDetallePedido logicDetallePedido = new LogicDetallePedido(objCnx);
            
            String op=beanDetallePedido.getTipoOperacion();
            if(op.equals("ee") || op.equals("ac") || op.equals("de")){
                mensaje = logicDetallePedido.actualizarEstadoPlato(beanDetallePedido);
            }else{
                return mensaje;
            }
                        
            objCnx.getMysql().confirmar();
            
            return mensaje;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }finally{
            try {
                objCnx.getMysql().deshacer();
                objCnx.getMysql().desconectarBD();
                return mensaje;
            } catch (SQLException ex) {
                Logger.getLogger(GestionDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
               return mensaje;
            }
        }
        
    }
}
