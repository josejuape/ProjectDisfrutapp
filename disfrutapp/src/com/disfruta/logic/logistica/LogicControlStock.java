/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.ControlStock;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoControlStock;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class LogicControlStock {
    private ObjConexion objCnx;
    
    public LogicControlStock(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String registrar(ControlStock beanControlStock) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoControlStock oDaoControlStock = new DaoControlStock();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param3 = new Parametro("IN", beanControlStock.getStock());
        Parametro param4 = new Parametro("IN", beanControlStock.getPrecioventa());
        Parametro param5 = new Parametro("IN", beanControlStock.getAlmacen().getId());
        Parametro param6 = new Parametro("IN", beanControlStock.getInsumo().getIdinsumo());
        Parametro param7 = new Parametro("IN", beanControlStock.getTipoOperacion());

        param.add(param1);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);

        ArrayList objetos = oDaoControlStock.registrar(param, objCnx);
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
    
    public String actualizar(ControlStock beanControlStock) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoControlStock oDaoControlStock = new DaoControlStock();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanControlStock.getIdcontrol());
        Parametro param3 = new Parametro("IN", beanControlStock.getStock());
        Parametro param4 = new Parametro("IN", beanControlStock.getPrecioventa());
        Parametro param5 = new Parametro("IN", beanControlStock.getAlmacen().getId());
        Parametro param6 = new Parametro("IN", beanControlStock.getInsumo().getIdinsumo());
        Parametro param7 = new Parametro("IN", beanControlStock.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);

        ArrayList objetos = oDaoControlStock.actualizar(param, objCnx);
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
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoControlStock oDaoControl = new DaoControlStock();
        ArrayList<ControlStock> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoControl.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            ControlStock objControlStock=new ControlStock();
            objControlStock.setIdcontrol(rs.getInt("n_idcontrol_stock"));
            objControlStock.setStock(rs.getDouble("n_stock_actual"));
            objControlStock.setPrecioventa(rs.getInt("n_precio_venta"));
            Insumo insumo=new Insumo();
            insumo.setIdinsumo(rs.getInt("n_idinsumo"));
            insumo.setNombre(rs.getString("v_nombre_insumo"));
            Almacen almacen=new Almacen();
            almacen.setId(rs.getInt("n_idalmacen"));
            almacen.setDescripcion(rs.getString("v_nombre"));
            objControlStock.setAlmacen(almacen);
            objControlStock.setInsumo(insumo);
            lista.add(objControlStock);
        }
        rs.close();
        cst.close();
        return lista;
    } 
}
