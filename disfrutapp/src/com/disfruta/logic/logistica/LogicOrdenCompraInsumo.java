/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.OrdenCompraInsumo;
import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoOrdenCompraInsumo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicOrdenCompraInsumo {
    private ObjConexion objCnx;
    
    public LogicOrdenCompraInsumo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(OrdenCompraInsumo beanOrdenCompraInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoOrdenCompraInsumo oDaoOrdenCompraInsumo = new DaoOrdenCompraInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanOrdenCompraInsumo.getOrden().getId());
        Parametro param3 = new Parametro("IN", beanOrdenCompraInsumo.getInsumo().getIdinsumo());
        Parametro param4 = new Parametro("IN", beanOrdenCompraInsumo.getCantidad());
        Parametro param5 = new Parametro("IN", beanOrdenCompraInsumo.getPrecio());
        Parametro param6 = new Parametro("IN", beanOrdenCompraInsumo.getSubtotal());
        Parametro param7 = new Parametro("IN", beanOrdenCompraInsumo.getMoneda().getN_idmon());
        Parametro param8 = new Parametro("IN", beanOrdenCompraInsumo.getUnidad().getN_idum());
        Parametro param9 = new Parametro("IN", beanOrdenCompraInsumo.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);
        param.add(param8);
        param.add(param9);

        ArrayList objetos = oDaoOrdenCompraInsumo.mantenimiento(param, objCnx);
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
    
    public ArrayList listar(OrdenCompra orden) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoOrdenCompraInsumo oDaoOrdenCompraInsumo = new DaoOrdenCompraInsumo();
        ArrayList<OrdenCompraInsumo> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN",orden.getId()));
        ArrayList objetos=oDaoOrdenCompraInsumo.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            OrdenCompraInsumo obj=new OrdenCompraInsumo();
            obj.setId(rs.getInt("n_idorden_compra_insumo"));
            Insumo insumo=new Insumo();
            obj.setCantidad(rs.getDouble("n_cantidad"));
            obj.setPrecio(rs.getDouble("n_precio_compra"));
            obj.setSubtotal(rs.getDouble("n_subtotal"));
            insumo.setIdinsumo(rs.getInt("n_idinsumo"));
            insumo.setNombre(rs.getString("v_nombre_insumo"));
            UnidadMedida unidad=new UnidadMedida();
            unidad.setN_idum(rs.getInt("n_idunidad_medida"));
            unidad.setV_unidad(rs.getString("xtbc_unidad_medida.v_descripcion"));
            Moneda moneda=new Moneda();
            moneda.setN_idmon(rs.getInt("n_idmoneda"));
            moneda.setV_moneda(rs.getString("xtbc_moneda.v_descripcion"));
            obj.setInsumo(insumo);
            obj.setUnidad(unidad);
            obj.setMoneda(moneda);
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    } 
}
