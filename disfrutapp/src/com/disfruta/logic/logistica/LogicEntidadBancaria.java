/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.EntidadBancaria;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoEntidadBancaria;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicEntidadBancaria {
    private ObjConexion objCnx;
    
    public LogicEntidadBancaria(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoEntidadBancaria oDaoEntidadBancaria = new DaoEntidadBancaria();
        ArrayList<EntidadBancaria> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoEntidadBancaria.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            EntidadBancaria objEntidadBancaria=new EntidadBancaria();
            objEntidadBancaria.setId(rs.getInt("n_identidad_bancaria"));
            objEntidadBancaria.setNombre(rs.getString("v_nombre"));
            lista.add(objEntidadBancaria);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
}
