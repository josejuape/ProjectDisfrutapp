/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.xtbc;

import com.disfruta.bean.xtbc.Ubigeo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.xtbc.DaoUbigeo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicUbigeo {
    private ObjConexion objCnx;
    
    public LogicUbigeo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoUbigeo oDao = new DaoUbigeo();
        ArrayList<Ubigeo> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDao.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Ubigeo obj=new Ubigeo();
            obj.setId(rs.getInt("n_idubigeo"));
            obj.setCod_pais(rs.getString("c_id_pais"));
            obj.setCod_departamento(rs.getString("c_cod_departamento"));
            obj.setCod_provincia(rs.getString("c_cod_provincia"));
            obj.setCod_distrito(rs.getString("c_cod_distrito"));
            obj.setNom_pais(rs.getString("v_pais"));
            obj.setNom_departamento(rs.getString("v_nombre_departamento"));
            obj.setNom_provincia(rs.getString("v_nombre_provincia"));
            obj.setNom_distrito(rs.getString("v_nombre_distrito"));
            obj.setBuscar(rs.getString("v_buscar"));
            obj.setEstado(rs.getString("c_estado"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
