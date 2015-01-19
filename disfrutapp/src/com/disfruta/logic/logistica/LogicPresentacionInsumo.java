/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionInsumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoPresentacionInsumo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicPresentacionInsumo {
    private ObjConexion objCnx;
    
    public LogicPresentacionInsumo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(PresentacionInsumo beanInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoPresentacionInsumo oDaoInsumo = new DaoPresentacionInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanInsumo.getIdpresentacion_compra());
        Parametro param3 = new Parametro("IN", beanInsumo.getNombre_presentacion());
        Parametro param4 = new Parametro("IN", beanInsumo.getCantidad());
        Parametro param5 = new Parametro("IN", beanInsumo.getUnidad());
        Parametro param6 = new Parametro("IN", beanInsumo.getProducto().getIdinsumo());
        Parametro param7 = new Parametro("IN", beanInsumo.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);

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
    
    public ArrayList listarPorInsumo(Insumo insumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoPresentacionInsumo oDaoPresentacionInsumo = new DaoPresentacionInsumo();
        ArrayList<PresentacionInsumo> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        Parametro p1=new Parametro("IN",insumo.getIdinsumo());
        param.add(p1);
        ArrayList objetos = oDaoPresentacionInsumo.listarPorProducto(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            PresentacionInsumo objPresentacionInsumo = new PresentacionInsumo();
            objPresentacionInsumo.setIdpresentacion_compra(rs.getInt("n_idpresentacion_insumo"));
            objPresentacionInsumo.setNombre_presentacion(rs.getString("v_descripcion"));
            objPresentacionInsumo.setCantidad(rs.getInt("n_cantidad"));
            objPresentacionInsumo.setUnidad(rs.getString("v_unidad"));
            Insumo in = new Insumo();
            in.setIdinsumo(rs.getInt("n_idinsumo"));
            objPresentacionInsumo.setProducto(insumo);
            lista.add(objPresentacionInsumo);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
}
