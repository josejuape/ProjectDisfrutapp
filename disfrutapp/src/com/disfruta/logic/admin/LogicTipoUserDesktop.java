/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import com.disfruta.bean.admin.TipoUserDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoTipoUserDesktop;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicTipoUserDesktop {
    private ObjConexion objCnx;
    
    public LogicTipoUserDesktop(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoTipoUserDesktop oDaoTipoUserDesktop = new DaoTipoUserDesktop();
        ArrayList<TipoUserDesktop> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoTipoUserDesktop.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            TipoUserDesktop user=new TipoUserDesktop();
            user.setIdtipouser(rs.getInt("n_idtipo_user_desktop"));
            user.setDescripcion(rs.getString("v_descripcion"));
            user.setObs(rs.getString("v_observacion"));
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }  
}
