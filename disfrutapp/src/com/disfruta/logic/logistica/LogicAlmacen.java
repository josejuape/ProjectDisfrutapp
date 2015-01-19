/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.xtbc.Ubigeo;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoAlmacen;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class LogicAlmacen {
    private ObjConexion objCnx;
    
    public LogicAlmacen(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(Almacen beanAlmacen) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoAlmacen oDaoAlmacen = new DaoAlmacen();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanAlmacen.getId());
        Parametro param3 = new Parametro("IN", beanAlmacen.getDescripcion());
        Parametro param4 = new Parametro("IN", beanAlmacen.getUbicacion());
        Parametro param5 = new Parametro("IN", beanAlmacen.getTelefono());
        Parametro param6 = new Parametro("IN", beanAlmacen.getDireccion1());
        Parametro param7 = new Parametro("IN", beanAlmacen.getReferencia1());
        Parametro param8 = new Parametro("IN", beanAlmacen.getDireccion2());
        Parametro param9 = new Parametro("IN", beanAlmacen.getReferencia2());
        Parametro param10 = new Parametro("IN", beanAlmacen.getRecepcion());
        Parametro param11 = new Parametro("IN", beanAlmacen.getUbigeo().getId());
        Parametro param12 = new Parametro("IN", beanAlmacen.getTipoOperacion());

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

        ArrayList objetos = oDaoAlmacen.mantenimiento(param, objCnx);
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
        
        DaoAlmacen oDaoAlmacen = new DaoAlmacen();
        ArrayList<Almacen> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoAlmacen.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Almacen objAlmacen=new Almacen();
            objAlmacen.setId(rs.getInt("n_idalmacen"));
            objAlmacen.setDescripcion(rs.getString("v_nombre"));
            objAlmacen.setUbicacion(rs.getString("v_ubicacion"));
            objAlmacen.setTelefono(rs.getString("v_telefono"));
            objAlmacen.setDireccion1(rs.getString("v_direccion1"));
            objAlmacen.setReferencia1(rs.getString("v_referencia1"));
            objAlmacen.setDireccion2(rs.getString("v_direccion2"));
            objAlmacen.setReferencia2(rs.getString("v_referencia2"));
            objAlmacen.setRecepcion(rs.getString("c_recepcion_pedido"));
            Ubigeo ub=new Ubigeo();
            ub.setId(rs.getInt("n_idubigeo"));
            objAlmacen.setUbigeo(ub);
            lista.add(objAlmacen);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
    
}
