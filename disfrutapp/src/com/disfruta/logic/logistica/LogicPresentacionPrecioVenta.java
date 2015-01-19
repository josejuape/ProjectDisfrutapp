/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoPresentacionPrecioVenta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicPresentacionPrecioVenta {
    private ObjConexion objCnx;
    
    public LogicPresentacionPrecioVenta(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
     public String mantenimiento(PresentacionPrecioVenta beanPresentacion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoPresentacionPrecioVenta oDaoPresentacion= new DaoPresentacionPrecioVenta();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanPresentacion.getProudcto().getIdproductocarta());
        Parametro param3 = new Parametro("IN", beanPresentacion.getPresentacion().getId());
        Parametro param4 = new Parametro("IN", beanPresentacion.getPrecioventa());
        Parametro param5 = new Parametro("IN", beanPresentacion.getProporcion());
        Parametro param6 = new Parametro("IN", beanPresentacion.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);

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
     
     public String eliminarPorProducto(ProductoCarta bean) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoPresentacionPrecioVenta oDaoPresentacion= new DaoPresentacionPrecioVenta();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", bean.getIdproductocarta());
        Parametro param3 = new Parametro("IN", 0);
        Parametro param4 = new Parametro("IN", 0);
        Parametro param5 = new Parametro("IN", 0);
        Parametro param6 = new Parametro("IN", bean.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);

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
    
    public ArrayList listarPorProducto(ProductoCarta producto) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoPresentacionPrecioVenta oDaoPresentacionPrecioVenta = new DaoPresentacionPrecioVenta();
        ArrayList<PresentacionPrecioVenta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        Parametro p1=new Parametro("IN",producto.getIdproductocarta());
        param.add(p1);
        ArrayList objetos = oDaoPresentacionPrecioVenta.listarPorProducto(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            PresentacionPrecioVenta objPresentacionVenta = new PresentacionPrecioVenta();
            ProductoCarta prod=new ProductoCarta();
            prod.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            PresentacionVenta present=new PresentacionVenta();
            present.setId(rs.getInt("n_idpresentacion_producto"));
            present.setDescripcion(rs.getString("v_descripcion"));
            objPresentacionVenta.setPrecioventa(rs.getDouble("n_precioventa"));
            objPresentacionVenta.setProporcion(rs.getDouble("n_proporcion"));
            objPresentacionVenta.setTipoOperacion("i");
            objPresentacionVenta.setProudcto(prod);
            objPresentacionVenta.setPresentacion(present);
            lista.add(objPresentacionVenta);
        }
        rs.close();
        cst.close();
        return lista;
    }
}
