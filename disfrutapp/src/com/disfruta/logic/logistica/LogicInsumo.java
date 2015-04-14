/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.UnidadMedida;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoInsumo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicInsumo {
    private ObjConexion objCnx;
    
    public LogicInsumo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(Insumo beanInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoInsumo oDaoInsumo = new DaoInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanInsumo.getIdinsumo());
        Parametro param3 = new Parametro("IN", beanInsumo.getNombre());
        Parametro param4 = new Parametro("IN", beanInsumo.getCapacidad());
        Parametro param5 = new Parametro("IN", beanInsumo.getPreciocompra());
        Parametro param6 = new Parametro("IN", beanInsumo.getPrecioventa());
        Parametro param7 = new Parametro("IN", beanInsumo.getControlstock());
        Parametro param8 = new Parametro("IN", beanInsumo.getVentadirecta());
        Parametro param9 = new Parametro("IN", beanInsumo.getCategoria().getN_idfamilia());
        Parametro param10 = new Parametro("IN", beanInsumo.getUnidad().getN_idum());
        Parametro param11 = new Parametro("IN", beanInsumo.getMonedacompra().getN_idmon());
        Parametro param12 = new Parametro("IN", beanInsumo.getMonedaventa().getN_idmon());
        Parametro param13 = new Parametro("IN", beanInsumo.getTipoOperacion());

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
        param.add(param13);

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
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoInsumo oDaoInsumo = new DaoInsumo();
        ArrayList<Insumo> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoInsumo.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Insumo objInsumo=new Insumo();
            FamiliaProducto familia=new FamiliaProducto();
            UnidadMedida unidad=new UnidadMedida();
            Moneda monedaventa=new Moneda();
            Moneda monedacompra=new Moneda();
            objInsumo.setIdinsumo(rs.getInt("n_idinsumo"));
            objInsumo.setNombre(rs.getString("v_nombre_insumo"));
            objInsumo.setCapacidad(rs.getDouble("n_capacidad"));
            objInsumo.setControlstock(rs.getString("c_controla_stock"));
            objInsumo.setVentadirecta(rs.getString("c_venta_directa"));
            objInsumo.setPreciocompra(rs.getDouble("n_preciocosto"));
            objInsumo.setPrecioventa(rs.getDouble("n_precioventa"));
            familia.setN_idfamilia(rs.getInt("n_idfamilia"));
            familia.setV_familia(rs.getString("familia"));
            unidad.setN_idum(rs.getInt("n_idunidad_medida"));
            unidad.setV_unidad(rs.getString("unidad"));
            monedaventa.setN_idmon(rs.getInt("idmonedaventa"));
            monedaventa.setV_moneda(rs.getString("monedaventa"));
            monedacompra.setN_idmon(rs.getInt("idmonedacompra"));
            monedacompra.setV_moneda(rs.getString("monedacompra"));
            objInsumo.setMonedacompra(monedacompra);
            objInsumo.setMonedaventa(monedaventa);
            objInsumo.setUnidad(unidad);
            objInsumo.setCategoria(familia);
            lista.add(objInsumo);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public Insumo getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoInsumo oDaoInsumo = new DaoInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Insumo objInsumo=new Insumo();
        ArrayList objetos=oDaoInsumo.getUltimoObject(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){            
            FamiliaProducto familia=new FamiliaProducto();
            UnidadMedida unidad=new UnidadMedida();
            Moneda monedaventa=new Moneda();
            Moneda monedacompra=new Moneda();
            objInsumo.setIdinsumo(rs.getInt("n_idinsumo"));
            objInsumo.setNombre(rs.getString("v_nombre_insumo"));
            objInsumo.setCapacidad(rs.getDouble("n_capacidad"));
            objInsumo.setControlstock(rs.getString("c_controla_stock"));
            objInsumo.setVentadirecta(rs.getString("c_venta_directa"));
            objInsumo.setPreciocompra(rs.getDouble("n_preciocosto"));
            objInsumo.setPrecioventa(rs.getDouble("n_precioventa"));
            familia.setN_idfamilia(rs.getInt("n_idfamilia"));
            familia.setV_familia(rs.getString("familia"));
            unidad.setN_idum(rs.getInt("n_idunidad_medida"));
            unidad.setV_unidad(rs.getString("unidad"));
            monedaventa.setN_idmon(rs.getInt("idmonedaventa"));
            monedaventa.setV_moneda(rs.getString("monedaventa"));
            monedacompra.setN_idmon(rs.getInt("idmonedacompra"));
            monedacompra.setV_moneda(rs.getString("monedacompra"));
            objInsumo.setMonedacompra(monedacompra);
            objInsumo.setMonedaventa(monedaventa);
            objInsumo.setUnidad(unidad);
            objInsumo.setCategoria(familia);
        }
        rs.close();
        cst.close();
        return objInsumo;
    } 
    
}
