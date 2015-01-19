/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoMenuPerfil;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicMenuPerfil {
    private ObjConexion objCnx;
    
    public LogicMenuPerfil(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
public String mantenimiento(MenuPerfil beanMenu) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoMenuPerfil oDaoMenu = new DaoMenuPerfil();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanMenu.getPerfil().getIdprefil());
        Parametro param3 = new Parametro("IN", beanMenu.getMenu().getId());
        Parametro param4 = new Parametro("IN", beanMenu.getEstado());
        Parametro param5 = new Parametro("IN", beanMenu.getVisible());
        Parametro param6 = new Parametro("IN", beanMenu.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);

        ArrayList objetos = oDaoMenu.mantenimiento(param, objCnx);
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
