/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.xtbc;

import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.xtbc.DaoMoneda;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicMoneda {
    private ObjConexion objCnx;
    
    public LogicMoneda(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoMoneda oDao = new DaoMoneda();
        ArrayList<Moneda> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDao.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Moneda obj=new Moneda();
            obj.setN_idmon(rs.getInt("n_idmoneda"));
            obj.setV_moneda(rs.getString("v_descripcion"));
            obj.setV_simbolo(rs.getString("v_simbolo"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
