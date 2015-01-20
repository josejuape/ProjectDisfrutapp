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
public class DaoOrdenCompra {
    public ArrayList mantenimiento(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String fun = "{? = call mant_orden_compra(?,?,?,?,?,?,?,?,?,?)}";
            Consultas query = new Consultas();
            result = query.funcion(fun, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList listar(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String proc = "{call listar_orden_compra()}";
            Consultas query = new Consultas();
            result = query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    public ArrayList getUltimoObject(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception {
        ArrayList result = new ArrayList();
        if (objCnx.conectarMysqlLocal()) {
            String proc = "{call ultimo_orden_compra()}";
            Consultas query = new Consultas();
            result = query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
}
