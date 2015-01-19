/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoPresentacionVenta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicPresentacionVenta {
    private ObjConexion objCnx;
    
    public LogicPresentacionVenta(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(PresentacionVenta beanPresentacion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoPresentacionVenta oDaoPresentacion= new DaoPresentacionVenta();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanPresentacion.getId());
        Parametro param3 = new Parametro("IN", beanPresentacion.getDescripcion());
        Parametro param4 = new Parametro("IN", beanPresentacion.getFamilia().getN_idfamilia());
        Parametro param5 = new Parametro("IN", beanPresentacion.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);

        ArrayList objetos = oDaoPresentacion.mantenimiento(param, objCnx);
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
    
    public ArrayList listarPorFamilia(ProductoCarta producto) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoPresentacionVenta oDaoPresentacionVenta = new DaoPresentacionVenta();
        ArrayList<PresentacionVenta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        Parametro p1=new Parametro("IN",producto.getFamilia().getN_idfamilia());
        param.add(p1);
        ArrayList objetos = oDaoPresentacionVenta.listarPorFamilia(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            PresentacionVenta objPresentacionVenta = new PresentacionVenta();
            objPresentacionVenta.setId(rs.getInt("n_idpresentacion_producto"));
            objPresentacionVenta.setDescripcion(rs.getString("v_descripcion"));
            FamiliaProducto in = new FamiliaProducto();
            in.setN_idfamilia(rs.getInt("n_idfamilia"));
            objPresentacionVenta.setFamilia(in);
            lista.add(objPresentacionVenta);
        }
        rs.close();
        cst.close();
        return lista;
    }
    
    public PresentacionVenta getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoPresentacionVenta oDaoPresentacionVenta = new DaoPresentacionVenta();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos = oDaoPresentacionVenta.getUltimoObject(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        PresentacionVenta objPresentacionVenta = new PresentacionVenta();
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {            
            objPresentacionVenta.setId(rs.getInt("n_idpresentacion_producto"));
            objPresentacionVenta.setDescripcion(rs.getString("v_descripcion"));
            FamiliaProducto in = new FamiliaProducto();
            in.setN_idfamilia(rs.getInt("n_idfamilia"));
            objPresentacionVenta.setFamilia(in);
        }
        rs.close();
        cst.close();
        return objPresentacionVenta;
    }
    
    
}
