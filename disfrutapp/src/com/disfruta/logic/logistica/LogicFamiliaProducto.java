/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoFamiliaProducto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicFamiliaProducto {
    private ObjConexion objCnx;
    
    public LogicFamiliaProducto(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoFamiliaProducto oDaoFamilia = new DaoFamiliaProducto();
        ArrayList<FamiliaProducto> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoFamilia.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            FamiliaProducto obj=new FamiliaProducto();
            obj.setN_idfamilia(rs.getInt("n_idfamilia"));
            obj.setV_familia(rs.getString("v_descripcion"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
