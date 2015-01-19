/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import com.disfruta.bean.admin.DetallePerfilUsuario;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoDetallePerfilUsuario;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicDetallePerfilUsuario {
    private ObjConexion objCnx;
    
    public LogicDetallePerfilUsuario(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
public String mantenimiento(DetallePerfilUsuario bean) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoDetallePerfilUsuario oDaoDetallePerfilUsuario= new DaoDetallePerfilUsuario();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", bean.getPerfil().getIdprefil());
        Parametro param3 = new Parametro("IN", bean.getUsuario().getIdUser());
        Parametro param4 = new Parametro("IN", bean.getEstado());
        Parametro param5 = new Parametro("IN", bean.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);

        ArrayList objetos = oDaoDetallePerfilUsuario.mantenimiento(param, objCnx);
        if (objetos.isEmpty()) {
            msg = "Sin resultados";
        } else {
            msg=objetos.get(0).toString();
            CallableStatement cst=(CallableStatement)objetos.get(1);
            objCnx=(ObjConexion)objetos.get(2);
            //objCnx.getMysql().confirmar();
            cst.close();
            
            //ocnx.getMysql().desconectarBD();
        }
        return msg;
    }    
    
}
