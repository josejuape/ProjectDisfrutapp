/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoPerfilUsuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicPerfilUsuario {
    private ObjConexion objCnx;
    
    public LogicPerfilUsuario(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(PerfilUsuario perfil) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoPerfilUsuario oDaoPerfilUsuario = new DaoPerfilUsuario();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", perfil.getIdprefil());
        Parametro param3 = new Parametro("IN", perfil.getDescripcion());
        Parametro param4 = new Parametro("IN", perfil.getEstado());
        Parametro param5 = new Parametro("IN", perfil.getTipoOperacion());
        
        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);

        ArrayList objetos = oDaoPerfilUsuario.mantenimiento(param, objCnx);
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
        
        DaoPerfilUsuario oDaoPerfilusuario = new DaoPerfilUsuario();
        ArrayList<PerfilUsuario> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoPerfilusuario.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            PerfilUsuario user=new PerfilUsuario();
            user.setIdprefil(rs.getInt("n_idperfil_user"));
            user.setDescripcion(rs.getString("v_descripcion_perfil"));
            user.setEstado(rs.getString("c_estado"));
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
    
    public ArrayList listarPorUsuario(UsuarioDesktop usuario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoPerfilUsuario oDaoPerfilusuario = new DaoPerfilUsuario();
        ArrayList<PerfilUsuario> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN",usuario.getIdUser()));
        ArrayList objetos=oDaoPerfilusuario.listarPorUsuario(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            PerfilUsuario user=new PerfilUsuario();
            user.setIdprefil(rs.getInt("n_idperfil_user"));
            user.setDescripcion(rs.getString("v_descripcion_perfil"));
            user.setEstado(rs.getString("c_estado"));
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
    
    public PerfilUsuario getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoPerfilUsuario oDaoPerfilusuario = new DaoPerfilUsuario();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoPerfilusuario.getUltimoObject(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        PerfilUsuario user=new PerfilUsuario();
        while(rs.next()){            
            user.setIdprefil(rs.getInt("n_idperfil_user"));
            user.setDescripcion(rs.getString("v_descripcion_perfil"));
            user.setEstado(rs.getString("c_estado"));
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return user;
    }
}
