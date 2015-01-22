/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.FormaPago;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoOrdenCompra;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicOrdenCompra {
    private ObjConexion objCnx;
    
    public LogicOrdenCompra(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(OrdenCompra beanOrdenCompra) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoOrdenCompra oDaoOrdenCompra = new DaoOrdenCompra();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanOrdenCompra.getId());
        Parametro param3 = new Parametro("IN", beanOrdenCompra.getNumero());
        Parametro param4 = new Parametro("IN", beanOrdenCompra.getComentario());
        Parametro param5 = new Parametro("IN", beanOrdenCompra.getFechaRecepcion());
        Parametro param6 = new Parametro("IN", beanOrdenCompra.getLugarRecepcion());
        Parametro param7 = new Parametro("IN", beanOrdenCompra.getObservaciones());
        Parametro param8 = new Parametro("IN", beanOrdenCompra.getIdactualizado());
        Parametro param9 = new Parametro("IN", beanOrdenCompra.getProveedor().getId());
        Parametro param10 = new Parametro("IN", beanOrdenCompra.getMoneda().getN_idmon());
        Parametro param11 = new Parametro("IN", beanOrdenCompra.getAlmacen().getId());
        Parametro param12 = new Parametro("IN", beanOrdenCompra.getFormaPago().getId());
        Parametro param13 = new Parametro("IN", beanOrdenCompra.getTipoOperacion());

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

        ArrayList objetos = oDaoOrdenCompra.mantenimiento(param, objCnx);
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
        DaoOrdenCompra oDaoOrdenCompra = new DaoOrdenCompra();
        ArrayList<OrdenCompra> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoOrdenCompra.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            OrdenCompra objOrdenCompra=new OrdenCompra();
            Proveedor proveedor=new Proveedor();
            Almacen almacen=new Almacen();
            Moneda moneda=new Moneda();
            FormaPago forma=new FormaPago();
            objOrdenCompra.setId(rs.getInt("n_idorden_compra"));
            objOrdenCompra.setNumero(rs.getString("c_numero_oc"));
            objOrdenCompra.setFechaRegistro(rs.getString("v_fecha_registro"));
            objOrdenCompra.setComentario(rs.getString("v_comentario_referencia"));
            objOrdenCompra.setFechaRecepcion(rs.getString("v_fecha_recepcion"));
            objOrdenCompra.setLugarRecepcion(rs.getString("v_lugar_recepcion"));
            objOrdenCompra.setObservaciones(rs.getString("v_observaciones"));
            proveedor.setId(rs.getInt("n_idproveedor"));
            proveedor.setRuc(rs.getString("v_ruc"));
            proveedor.setNombres(rs.getString("v_nombres"));
            proveedor.setApellidos(rs.getString("v_apellidos"));
            almacen.setId(rs.getInt("n_idalmacen"));
            almacen.setDescripcion(rs.getString("v_nombre"));
            almacen.setUbicacion(rs.getString("v_ubicacion"));
            moneda.setN_idmon(rs.getInt("n_idmoneda"));
            moneda.setV_moneda(rs.getString("xtbc_moneda.v_descripcion"));
            forma.setId(rs.getInt("n_idforma_pago"));
            forma.setDescripcion(rs.getString("v_descripcion_forma"));
            forma.setDias(rs.getInt("n_numero_dias"));
            objOrdenCompra.setAlmacen(almacen);
            objOrdenCompra.setMoneda(moneda);
            objOrdenCompra.setProveedor(proveedor);
            objOrdenCompra.setFormaPago(forma);
            lista.add(objOrdenCompra);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public OrdenCompra getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoOrdenCompra oDaoOrdenCompra = new DaoOrdenCompra();
        ArrayList<Parametro> param = new ArrayList();
        OrdenCompra objOrdenCompra=new OrdenCompra();
        ArrayList objetos=oDaoOrdenCompra.getUltimoObject(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){            
            Proveedor proveedor=new Proveedor();
            Almacen almacen=new Almacen();
            Moneda moneda=new Moneda();
            FormaPago forma=new FormaPago();
            objOrdenCompra.setId(rs.getInt("n_idorden_compra"));
            objOrdenCompra.setFechaRegistro(rs.getString("v_fecha_registro"));
            objOrdenCompra.setComentario(rs.getString("v_comentario_referencia"));
            objOrdenCompra.setFechaRecepcion(rs.getString("v_fecha_recepcion"));
            objOrdenCompra.setLugarRecepcion(rs.getString("v_lugar_recepcion"));
            objOrdenCompra.setObservaciones(rs.getString("v_observaciones"));
            proveedor.setId(rs.getInt("n_idproveedor"));
            proveedor.setRuc(rs.getString("v_ruc"));
            proveedor.setNombres(rs.getString("v_nombres"));
            proveedor.setApellidos(rs.getString("v_apellidos"));
            almacen.setId(rs.getInt("n_idalmacen"));
            almacen.setDescripcion(rs.getString("v_nombre"));
            almacen.setUbicacion(rs.getString("v_ubicacion"));
            moneda.setN_idmon(rs.getInt("n_idmoneda"));
            moneda.setV_moneda(rs.getString("xtbc_moneda.v_descripcion"));
            forma.setId(rs.getInt("n_idforma_pago"));
            forma.setDescripcion(rs.getString("v_descripcion_forma"));
            forma.setDias(rs.getInt("n_numero_dias"));
            objOrdenCompra.setAlmacen(almacen);
            objOrdenCompra.setMoneda(moneda);
            objOrdenCompra.setProveedor(proveedor);
            objOrdenCompra.setFormaPago(forma);
        }
        rs.close();
        cst.close();
        return objOrdenCompra;
    } 
    
    public OrdenCompra buscarOC(OrdenCompra orden) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoOrdenCompra oDaoOrdenCompra = new DaoOrdenCompra();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN",orden.getNumero()));
        param.add(new Parametro("IN",orden.getEstado()));
        OrdenCompra objOrdenCompra=new OrdenCompra();
        ArrayList objetos=oDaoOrdenCompra.buscarOC(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        if(rs.next()){            
            Proveedor proveedor=new Proveedor();
            Almacen almacen=new Almacen();
            Moneda moneda=new Moneda();
            FormaPago forma=new FormaPago();
            objOrdenCompra.setId(rs.getInt("n_idorden_compra"));
            objOrdenCompra.setFechaRegistro(rs.getString("v_fecha_registro"));
            objOrdenCompra.setComentario(rs.getString("v_comentario_referencia"));
            objOrdenCompra.setFechaRecepcion(rs.getString("v_fecha_recepcion"));
            objOrdenCompra.setLugarRecepcion(rs.getString("v_lugar_recepcion"));
            objOrdenCompra.setObservaciones(rs.getString("v_observaciones"));
            proveedor.setId(rs.getInt("n_idproveedor"));
            proveedor.setRuc(rs.getString("v_ruc"));
            proveedor.setNombres(rs.getString("v_nombres"));
            proveedor.setApellidos(rs.getString("v_apellidos"));
            almacen.setId(rs.getInt("n_idalmacen"));
            almacen.setDescripcion(rs.getString("v_nombre"));
            almacen.setUbicacion(rs.getString("v_ubicacion"));
            moneda.setN_idmon(rs.getInt("n_idmoneda"));
            moneda.setV_moneda(rs.getString("xtbc_moneda.v_descripcion"));
            forma.setId(rs.getInt("n_idforma_pago"));
            forma.setDescripcion(rs.getString("v_descripcion_forma"));
            forma.setDias(rs.getInt("n_numero_dias"));
            objOrdenCompra.setAlmacen(almacen);
            objOrdenCompra.setMoneda(moneda);
            objOrdenCompra.setProveedor(proveedor);
            objOrdenCompra.setFormaPago(forma);
        }else{
            objOrdenCompra=null;
        }
        rs.close();
        cst.close();
        return objOrdenCompra;
    } 
}
