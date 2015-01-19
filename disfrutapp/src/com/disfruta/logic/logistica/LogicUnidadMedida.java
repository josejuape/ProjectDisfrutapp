/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoUnidadMedida;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicUnidadMedida {
    private ObjConexion objCnx;
    
    public LogicUnidadMedida(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoUnidadMedida oDao = new DaoUnidadMedida();
        ArrayList<UnidadMedida> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDao.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            UnidadMedida obj=new UnidadMedida();
            obj.setN_idum(rs.getInt("n_idunidad_medida"));
            obj.setV_unidad(rs.getString("v_descripcion"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
