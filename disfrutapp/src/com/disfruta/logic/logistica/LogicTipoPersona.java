/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.TipoPersona;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoTipoPersona;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicTipoPersona {
    private ObjConexion objCnx;
    
    public LogicTipoPersona(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoTipoPersona oDaoTipoPersona = new DaoTipoPersona();
        ArrayList<TipoPersona> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoTipoPersona.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            TipoPersona objTipoPersona=new TipoPersona();
            objTipoPersona.setId(rs.getInt("n_idtipo_persona"));
            objTipoPersona.setDescripcion(rs.getString("v_descripcion_tipo"));
            lista.add(objTipoPersona);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
}
