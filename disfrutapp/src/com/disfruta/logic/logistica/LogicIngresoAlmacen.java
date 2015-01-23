/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.Almacen;
import com.disfruta.bean.logistica.FormaPago;
import com.disfruta.bean.logistica.IngresoAlmacen;
import com.disfruta.bean.logistica.OrdenCompra;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.logistica.TipoIngresoAlmacen;
import com.disfruta.bean.xtbc.Comprobante;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.bean.xtbc.TipoComprobante;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoIngresoAlmacen;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicIngresoAlmacen {
    private ObjConexion objCnx;
    
    public LogicIngresoAlmacen(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(IngresoAlmacen beanIngreso) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoIngresoAlmacen oDaoIngreso = new DaoIngresoAlmacen();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanIngreso.getId());
        Parametro param3 = new Parametro("IN", beanIngreso.getParteEntrada());
        Parametro param4 = new Parametro("IN", beanIngreso.getAtenderCompleto());
        Parametro param5 = new Parametro("IN", beanIngreso.getFechaRegistro());
        Parametro param6 = new Parametro("IN", beanIngreso.getNumeroComprobante());
        Parametro param7 = new Parametro("IN", beanIngreso.getSerieComprobante());
        Parametro param8 = new Parametro("IN", beanIngreso.getFechaEmisionComprobante());
        Parametro param9 = new Parametro("IN", beanIngreso.getFechaLimiteCancelacion());
        Parametro param10 = new Parametro("IN", beanIngreso.getComentario());
        Parametro param11 = new Parametro("IN", beanIngreso.getEstado());
        Parametro param12 = new Parametro("IN", beanIngreso.getIdactualizado());
        Parametro param13 = new Parametro("IN", beanIngreso.getFormaPago().getId());
        Parametro param14 = new Parametro("IN", beanIngreso.getMoneda().getN_idmon());
        Parametro param15 = new Parametro("IN", beanIngreso.getTipoComprobante().getId());
        Parametro param16 = new Parametro("IN", beanIngreso.getOrdenCompra().getId());
        Parametro param17 = new Parametro("IN", beanIngreso.getTipoIngreso().getId());
        Parametro param18 = new Parametro("IN", beanIngreso.getAlmacen().getId());
        Parametro param19 = new Parametro("IN", beanIngreso.getComprobante().getId());
        Parametro param20 = new Parametro("IN", beanIngreso.getProveedor().getId());
        Parametro param21 = new Parametro("IN", beanIngreso.getTipoOperacion());

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
        param.add(param14);
        param.add(param15);
        param.add(param16);
        param.add(param17);
        param.add(param18);
        param.add(param19);
        param.add(param20);
        param.add(param21);

        ArrayList objetos = oDaoIngreso.mantenimiento(param, objCnx);
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
        DaoIngresoAlmacen oDaoIngresoAlmacen = new DaoIngresoAlmacen();
        ArrayList<IngresoAlmacen> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoIngresoAlmacen.listarTipoIngreso(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            IngresoAlmacen beanIngreso=new IngresoAlmacen();
            beanIngreso.setId(rs.getInt("n_idingreso_almacen"));
            beanIngreso.setParteEntrada(rs.getString("v_parte_entrada"));
            beanIngreso.setAtenderCompleto(rs.getString("c_atender_completo"));
            beanIngreso.setFechaRegistro(rs.getString("d_fecha_registro"));
            beanIngreso.setNumeroComprobante(rs.getString("v_numero_comprobante"));
            beanIngreso.setSerieComprobante(rs.getString("v_serie_comprobante"));
            beanIngreso.setFechaEmisionComprobante(rs.getString("v_fecha_emision_comprobante"));
            beanIngreso.setFechaLimiteCancelacion(rs.getString("v_fecha_limite_cancelacion"));
            beanIngreso.setComentario(rs.getString("v_comentario"));
            beanIngreso.setEstado(rs.getString("c_estado"));
            beanIngreso.setIdactualizado(rs.getInt("n_idingreso_almacen_actualizado"));
            FormaPago forma=new FormaPago();
            beanIngreso.setFormaPago(forma);
            Moneda moneda=new Moneda();
            beanIngreso.setMoneda(moneda);
            TipoComprobante tipocom=new TipoComprobante();
            beanIngreso.setTipoComprobante(tipocom);
            OrdenCompra orden=new OrdenCompra();
            beanIngreso.setOrdenCompra(orden);
            TipoIngresoAlmacen tipoing=new TipoIngresoAlmacen();
            beanIngreso.setTipoIngreso(tipoing);
            Almacen almacen=new Almacen();
            beanIngreso.setAlmacen(almacen);
            Comprobante comprobante=new Comprobante();
            beanIngreso.setComprobante(comprobante);
            Proveedor proveedor=new Proveedor();
            beanIngreso.setProveedor(proveedor);
            lista.add(beanIngreso);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public ArrayList listarTipoIngreso() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoIngresoAlmacen oDaoIngresoAlmacen = new DaoIngresoAlmacen();
        ArrayList<TipoIngresoAlmacen> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoIngresoAlmacen.listarTipoIngreso(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            TipoIngresoAlmacen obj=new TipoIngresoAlmacen();
            obj.setId(rs.getInt("n_idtipo_ingreso_almacen"));
            obj.setDescripcion(rs.getString("v_descripcion_tipo_ingreso"));
            obj.setIdentificador(rs.getString("c_identificador"));
            lista.add(obj);
        }
        rs.close();
        cst.close();
        return lista;
    } 
}
