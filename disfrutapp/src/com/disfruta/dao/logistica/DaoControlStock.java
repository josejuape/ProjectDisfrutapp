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
 * @author user
 */
public class DaoControlStock {
    public ArrayList registrar(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call registro_control_stock(?,?,?,?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList actualizar(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call act_control_stock(?,?,?,?,?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList listar(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String proc = "{call listar_control_stock()}";
            Consultas query = new Consultas();
            result = query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
}
