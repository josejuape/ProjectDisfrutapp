/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.dao.logistica;

import com.disfruta.conexion.Consultas;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class DaoDetallePedido {
    public ArrayList mantenimiento(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call mant_detalle_pedido(?,?,?,?,?,?,?,?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList venderProductoDevuelto(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call vender_producto_devuelto(?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    //listar detalle pedido por codigo de pedido
    public ArrayList listar(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String proc = "{call listar_detalle_pedido(?)}";
            Consultas query = new Consultas();
            result = query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    //listar los productos pedidos que esten con estado EN=enviado por staff o YP=prod. devuelto q esta siendo vendido pero ya esta preparado
    public ArrayList listarTodo(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String proc = "{call listar_detalle_pedido_pordespachar()}";
            Consultas query = new Consultas();
            result = query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList actualizarEstadoPlato(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call actualizar_estado_plato(?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
}
