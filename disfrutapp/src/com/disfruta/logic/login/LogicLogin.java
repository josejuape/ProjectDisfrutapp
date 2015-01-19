/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.login;

import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.admin.MenuPerfil;
import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.login.DaoLogin;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class LogicLogin {
    private ObjConexion objCnx;
    
    public LogicLogin(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public UsuarioDesktop validarLogin(UsuarioDesktop user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoLogin oDaoLogin = new DaoLogin();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("IN", user.getEmail());
        Parametro param2 = new Parametro("IN", user.getPassword());
        param.add(param1);
        param.add(param2);
        
        ArrayList objetos=oDaoLogin.validarLogin(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        UsuarioDesktop objuser=new UsuarioDesktop();
        if(rs.next()){            
            objuser.setIdUser(rs.getInt("n_iduser_desktop"));
            objuser.setNombres(rs.getString("v_nombres"));
            objuser.setApellidos(rs.getString("v_apellidos"));
            objuser.setEmail(rs.getString("v_usuario"));
            objuser.setEmail(rs.getString("v_email"));
            objuser.setEstado(rs.getString("v_estado"));
        }else{
            objuser=null;
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return objuser;
    }  
    
    
    public ArrayList<MenuPerfil> listarMenuLogin(UsuarioDesktop user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoLogin oDaoLogin = new DaoLogin();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("IN", user.getIdUser());
        param.add(param1);
        ArrayList<MenuPerfil> lista=new ArrayList();
        ArrayList objetos=oDaoLogin.listarMenuLogin(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();        
        while(rs.next()){      
            MenuPerfil objmenu=new MenuPerfil();
            Menu menu=new Menu();
            PerfilUsuario perfil=new PerfilUsuario();
            perfil.setIdprefil(rs.getInt("n_idperfil_user"));
            perfil.setDescripcion(rs.getString("v_descripcion_perfil"));
            perfil.setEstado(rs.getString("xtbc_perfil_user.c_estado"));            
            menu.setId(rs.getInt("n_idmenu"));
            menu.setDescripcion(rs.getString("v_descripcion_menu"));
            menu.setNodo(rs.getInt("n_menu_nodo"));
            menu.setNodopadre(rs.getInt("n_menu_padre"));
            menu.setTipo(rs.getString("v_tipo"));
            
            objmenu.setMenu(menu);
            objmenu.setPerfil(perfil);
            lista.add(objmenu);            
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }  
}
