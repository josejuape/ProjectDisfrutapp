/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.xtbc;

import com.disfruta.bean.xtbc.TipoComprobante;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.xtbc.DaoTipoComprobante;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicTipoComprobante {
    private ObjConexion objCnx;
    
    public LogicTipoComprobante(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoTipoComprobante oDao = new DaoTipoComprobante();
        ArrayList<TipoComprobante> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDao.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            TipoComprobante obj=new TipoComprobante();
            obj.setId(rs.getInt("n_idtipo_comprobante"));
            obj.setDescripcion(rs.getString("v_descripcion_comprobante"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
