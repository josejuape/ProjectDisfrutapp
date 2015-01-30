/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import Tester.MenuDinamico;
import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.admin.PerfilUsuario;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoMenu;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicMenu {
    private ObjConexion objCnx;
    
    public LogicMenu(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
public String mantenimiento(Menu beanMenu) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoMenu oDaoMenu = new DaoMenu();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanMenu.getId());
        Parametro param3 = new Parametro("IN", beanMenu.getDescripcion());
        Parametro param4 = new Parametro("IN", beanMenu.getNodopadre());
        Parametro param5 = new Parametro("IN", beanMenu.getNodo());
        Parametro param6 = new Parametro("IN", beanMenu.getEstado());
        Parametro param7 = new Parametro("IN", beanMenu.getBarra());
        Parametro param8 = new Parametro("IN", beanMenu.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);

        ArrayList objetos = oDaoMenu.mantenimiento(param, objCnx);
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
        
        DaoMenu oDaoMenu = new DaoMenu();
        ArrayList<Menu> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Menu objMenu=new Menu();
            objMenu.setId(rs.getInt("n_idmenu"));
            objMenu.setDescripcion(rs.getString("v_descripcion_menu"));
            objMenu.setNodopadre(rs.getInt("n_menu_padre"));
            objMenu.setNodo(rs.getInt("n_menu_nodo"));
            objMenu.setEstado(rs.getString("c_estado"));
            objMenu.setBarra(rs.getString("c_barra"));
            lista.add(objMenu);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
    
    public ArrayList listarMenuDinamico() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoMenu oDaoMenu = new DaoMenu();
        ArrayList<MenuDinamico> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.listarMenuDinamico(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            MenuDinamico objMenu=new MenuDinamico();
            objMenu.setId_menu(rs.getInt("n_idmenu_dinamico"));
            objMenu.setDescripcion(rs.getString("descripcion"));
            objMenu.setNombre(rs.getString("nombre"));
            objMenu.setMenu_item(rs.getString("menu_item"));
            objMenu.setOrden(rs.getString("orden"));
            objMenu.setNivel(rs.getInt("nivel"));
            objMenu.setId_menu_padre(rs.getInt("id_menu_padre"));
            objMenu.setVisible(rs.getString("visible"));
            objMenu.setControl(rs.getString("control"));
            objMenu.setId_formulario(rs.getInt("id_formulario"));
            objMenu.setFlag_sistema(rs.getString("flag_sistema"));
            lista.add(objMenu);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
    
    public ArrayList listarPorPerfilUsuario(PerfilUsuario perfil) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoMenu oDaoMenu = new DaoMenu();
        ArrayList<Menu> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN",perfil.getIdprefil()));
        ArrayList objetos=oDaoMenu.listarPorPerfilUsuario(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            Menu objMenu=new Menu();
            objMenu.setId(rs.getInt("n_idmenu"));
            objMenu.setDescripcion(rs.getString("v_descripcion_menu"));
            objMenu.setNodopadre(rs.getInt("n_menu_padre"));
            objMenu.setNodo(rs.getInt("n_menu_nodo"));
            objMenu.setEstado(rs.getString("c_estado"));
            objMenu.setBarra(rs.getString("c_barra"));
            lista.add(objMenu);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }  
}
