/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.IngresoAlmacenInsumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoIngresoAlmacenInsumo;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicIngresoAlmacenInsumo {
    private ObjConexion objCnx;
    
    public LogicIngresoAlmacenInsumo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(IngresoAlmacenInsumo beanInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoIngresoAlmacenInsumo oDaoInsumo = new DaoIngresoAlmacenInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanInsumo.getId());
        Parametro param3 = new Parametro("IN", beanInsumo.getInsumo().getIdinsumo());
        Parametro param4 = new Parametro("IN", beanInsumo.getIngresoAlmacen().getId());
        Parametro param5 = new Parametro("IN", beanInsumo.getCantidad());
        Parametro param6 = new Parametro("IN", beanInsumo.getPrecio());
        Parametro param7 = new Parametro("IN", beanInsumo.getSubtotal());
        Parametro param8 = new Parametro("IN", beanInsumo.getMoneda().getN_idmon());
        Parametro param9 = new Parametro("IN", beanInsumo.getUnidad().getN_idum());
        Parametro param10 = new Parametro("IN", beanInsumo.getAtendidos());
        Parametro param11 = new Parametro("IN", beanInsumo.getPorAtender());
        Parametro param12 = new Parametro("IN", beanInsumo.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);
        param.add(param8);
        param.add(param9);
        param.add(param10);
        param.add(param11);                
        param.add(param12);

        ArrayList objetos = oDaoInsumo.mantenimiento(param, objCnx);
        if (objetos.isEmpty()) {
            msg = "Sin resultados";
        } else {
            msg = objetos.get(0).toString();
            CallableStatement cst = (CallableStatement) objetos.get(1);
            objCnx = (ObjConexion) objetos.get(2);
            //objCnx.getMysql().confirmar();
            cst.close();

            //ocnx.getMysql().desconectarBD();
        }
        return msg;
    }
    
}
