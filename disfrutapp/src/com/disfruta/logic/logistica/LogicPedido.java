/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.logistica.DetallePedido;
import com.disfruta.bean.logistica.Pedido;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoPedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicPedido {
    private ObjConexion objCnx;
    
    public LogicPedido(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(Pedido bean) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoPedido oDaoPedido = new DaoPedido();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", bean.getId());
        Parametro param3 = new Parametro("IN", bean.getEstado());
        Parametro param4 = new Parametro("IN", bean.getTipo());
        Parametro param5 = new Parametro("IN", bean.getMontototal());
        Parametro param6 = new Parametro("IN", bean.getEstado());
        Parametro param7 = new Parametro("IN", bean.getMesa());
        Parametro param8 = new Parametro("IN", bean.getUsuario().getIdUser());
        Parametro param9 = new Parametro("IN", bean.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);
        param.add(param8);
        param.add(param9);

        ArrayList objetos = oDaoPedido.mantenimiento(param, objCnx);
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
        DaoPedido oDaoPedido = new DaoPedido();
        ArrayList<Pedido> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoPedido.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Pedido objPedido=new Pedido();
            objPedido.setId(rs.getInt("n_idpedido"));
            objPedido.setEstadoPedido(rs.getString("c_estado_pedido"));
            objPedido.setTipo(rs.getString("c_tipo_pedido"));
            objPedido.setMontototal(rs.getDouble("n_valor_total"));
            objPedido.setEstado(rs.getString("c_estado"));
            objPedido.setMesa(rs.getString("v_numero_mesa"));
            UsuarioDesktop usuario=new UsuarioDesktop();
            usuario.setIdUser(rs.getInt("n_iduser_desktop"));
            usuario.setNombres(rs.getString("v_nombres"));
            usuario.setApellidos(rs.getString("v_apellidos"));
            objPedido.setUsuario(usuario);            
            lista.add(objPedido);
        }
        rs.close();
        cst.close();
        return lista;
    } 
    
    public Pedido getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoPedido oDaoInsumo = new DaoPedido();
        ArrayList<Parametro> param = new ArrayList();
        Pedido objPedido=new Pedido();
        ArrayList objetos=oDaoInsumo.getUltimoObject(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){     
            objPedido.setId(rs.getInt("n_idpedido"));
            objPedido.setEstadoPedido(rs.getString("c_estado_pedido"));
            objPedido.setTipo(rs.getString("c_tipo_pedido"));
            objPedido.setMontototal(rs.getDouble("n_valor_total"));
            objPedido.setEstado(rs.getString("c_estado"));
            objPedido.setMesa(rs.getString("v_numero_mesa"));
            UsuarioDesktop usuario=new UsuarioDesktop();
            usuario.setIdUser(rs.getInt("n_iduser_desktop"));
            usuario.setNombres(rs.getString("v_nombres"));
            usuario.setApellidos(rs.getString("v_apellidos"));
            objPedido.setUsuario(usuario);
        }
        rs.close();
        cst.close();
        return objPedido;
    } 
}
