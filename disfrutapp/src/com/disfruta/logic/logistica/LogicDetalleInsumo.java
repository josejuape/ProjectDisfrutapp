/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.DetalleInsumo;
import com.disfruta.bean.logistica.Insumo;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoDetalleInsumo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicDetalleInsumo {
    private ObjConexion objCnx;
    
    public LogicDetalleInsumo(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(DetalleInsumo beanInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoDetalleInsumo oDaoInsumo = new DaoDetalleInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanInsumo.getInsumo().getIdinsumo());
        Parametro param3 = new Parametro("IN", beanInsumo.getPresentacion().getPresentacion().getId());
        Parametro param4 = new Parametro("IN", beanInsumo.getPresentacion().getProudcto().getIdproductocarta());
        Parametro param5 = new Parametro("IN", beanInsumo.getCantidad());
        Parametro param6 = new Parametro("IN", beanInsumo.getUnidad());
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
    
    public String eliminarPorInsumo(Insumo beanInsumo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoDetalleInsumo oDaoInsumo = new DaoDetalleInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanInsumo.getIdinsumo());
        Parametro param3 = new Parametro("IN", 0);
        Parametro param4 = new Parametro("IN", 0);
        Parametro param5 = new Parametro("IN", 0);
        Parametro param6 = new Parametro("IN", "");
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
    
    public String eliminarPorProducto(ProductoCarta producto) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoDetalleInsumo oDaoInsumo = new DaoDetalleInsumo();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", 0);
        Parametro param3 = new Parametro("IN", 0);
        Parametro param4 = new Parametro("IN", producto.getIdproductocarta());
        Parametro param5 = new Parametro("IN", 0);
        Parametro param6 = new Parametro("IN", "");
        Parametro param7 = new Parametro("IN", producto.getTipoOperacion());

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
    
    public ArrayList listarPorPresentacion(PresentacionPrecioVenta presentacion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoDetalleInsumo oDaoDetalleInsumo = new DaoDetalleInsumo();
        ArrayList<DetalleInsumo> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        Parametro p1=new Parametro("IN",presentacion.getProudcto().getIdproductocarta());
        Parametro p2=new Parametro("IN",presentacion.getPresentacion().getId());
        param.add(p1);
        param.add(p2);
        ArrayList objetos = oDaoDetalleInsumo.listarPorPresentacion(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            DetalleInsumo objDetalleInsumo = new DetalleInsumo();
            Insumo in = new Insumo();
            in.setIdinsumo(rs.getInt("n_idinsumo"));
            in.setNombre(rs.getString("v_nombre_insumo"));
            in.setCapacidad(rs.getDouble("n_capacidad"));
            objDetalleInsumo.setInsumo(in);
//            PresentacionPrecioVenta pres=new PresentacionPrecioVenta();
            ProductoCarta prod=new ProductoCarta();
            PresentacionVenta presventa=new PresentacionVenta();
            prod.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            presventa.setId(rs.getInt("n_idpresentacion_producto"));
            presventa.setDescripcion(rs.getString("v_descripcion"));
//            pres.setPresentacion(presventa);
//            pres.setProudcto(prod);
            objDetalleInsumo.setPresentacion(presentacion);
            objDetalleInsumo.setCantidad(rs.getDouble("n_cantidad"));
            objDetalleInsumo.setUnidad(rs.getString("v_unidad"));
            objDetalleInsumo.setTipoOperacion("i");
            lista.add(objDetalleInsumo);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
}
