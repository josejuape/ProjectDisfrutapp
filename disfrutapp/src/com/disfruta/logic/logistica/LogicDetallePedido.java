/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.Pedido;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoDetallePedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicDetallePedido {
    private ObjConexion objCnx;
    
    public LogicDetallePedido(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(DetallePedido bean) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoDetallePedido oDaoDetallePedido = new DaoDetallePedido();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", bean.getId());
        Parametro param3 = new Parametro("IN", bean.getCantidad());
        Parametro param4 = new Parametro("IN", bean.getSubtotal());
        Parametro param5 = new Parametro("IN", bean.getEstado());
        Parametro param6 = new Parametro("IN", bean.getComentario());
        Parametro param7 = new Parametro("IN", bean.getPedido().getId());
        Parametro param8 = new Parametro("IN", bean.getPresentacion().getProudcto().getIdproductocarta());
        Parametro param9 = new Parametro("IN", bean.getPresentacion().getPresentacion().getId());
        Parametro param10 = new Parametro("IN", bean.getTipoOperacion());

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

        ArrayList objetos = oDaoDetallePedido.mantenimiento(param, objCnx);
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
    
    public ArrayList listar(Pedido pedido) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoDetallePedido oDaoDetallePedido = new DaoDetallePedido();
        ArrayList<DetallePedido> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN",pedido.getId()));
        ArrayList objetos=oDaoDetallePedido.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            DetallePedido objPedido=new DetallePedido();
            objPedido.setId(rs.getInt("n_iddetalle_pedido"));
            objPedido.setCantidad(rs.getDouble("n_cantidad"));
            objPedido.setSubtotal(rs.getDouble("n_valor_venta"));
            objPedido.setEstado(rs.getString("c_estado"));
            objPedido.setComentario(rs.getString("v_comentario"));
            
            PresentacionPrecioVenta precioventa=new PresentacionPrecioVenta();
            ProductoCarta producto=new ProductoCarta();
            producto.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            producto.setNombre(rs.getString("v_nombre"));
            producto.setDescripcion(rs.getString("v_descripcion"));
            precioventa.setProudcto(producto);
            PresentacionVenta presventa=new PresentacionVenta();
            presventa.setId(rs.getInt("logtbc_presentacion_producto.n_idpresentacion_producto"));
            presventa.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
            precioventa.setPresentacion(presventa);
            precioventa.setPrecioventa(rs.getDouble("n_precioventa"));
            precioventa.setProporcion(rs.getDouble("n_proporcion"));
            objPedido.setPresentacion(precioventa);
            pedido.setMesa(rs.getString("v_numero_mesa"));
            objPedido.setPedido(pedido);
            lista.add(objPedido);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public ArrayList listarTodo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoDetallePedido oDaoDetallePedido = new DaoDetallePedido();
        ArrayList<DetallePedido> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoDetallePedido.listarTodo(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            DetallePedido objPedido=new DetallePedido();
            objPedido.setId(rs.getInt("n_iddetalle_pedido"));
            objPedido.setCantidad(rs.getDouble("n_cantidad"));
            objPedido.setSubtotal(rs.getDouble("n_valor_venta"));
            objPedido.setEstado(rs.getString("c_estado"));
            objPedido.setComentario(rs.getString("v_comentario"));
            
            PresentacionPrecioVenta precioventa=new PresentacionPrecioVenta();
            ProductoCarta producto=new ProductoCarta();
            producto.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            producto.setNombre(rs.getString("v_nombre"));
            producto.setDescripcion(rs.getString("v_descripcion"));
            precioventa.setProudcto(producto);
            PresentacionVenta presventa=new PresentacionVenta();
            presventa.setId(rs.getInt("logtbc_presentacion_producto.n_idpresentacion_producto"));
            presventa.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
            precioventa.setPresentacion(presventa);
            precioventa.setPrecioventa(rs.getDouble("n_precioventa"));
            precioventa.setProporcion(rs.getDouble("n_proporcion"));
            objPedido.setPresentacion(precioventa);
            Pedido pedido=new Pedido();
            pedido.setId(rs.getInt("n_idpedido") );
            pedido.setMesa(rs.getString("v_numero_mesa"));
            objPedido.setPedido(pedido);
            lista.add(objPedido);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public String actualizarEstadoPlato(DetallePedido bean) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoDetallePedido oDaoDetallePedido = new DaoDetallePedido();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", bean.getId());
        Parametro param3 = new Parametro("IN", bean.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);

        ArrayList objetos = oDaoDetallePedido.actualizarEstadoPlato(param, objCnx);
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
}
