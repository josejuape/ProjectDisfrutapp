/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.dao.login;

import com.disfruta.conexion.Consultas;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DaoLogin {
    public ArrayList validarLogin(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception{
        ArrayList result=new ArrayList();
        if(objCnx.conectarMysqlLocal()){            
            String proc="{call validarlogin(?,?,?)}";//llamada a un procedimiento
            Consultas query=new Consultas(); 
            result=query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }   
    
    public ArrayList listarMenuLogin(ArrayList<Parametro> param, ObjConexion objCnx) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, Exception{
        ArrayList result=new ArrayList();
        if(objCnx.conectarMysqlLocal()){            
            String proc="{call listar_menu_perfil_login(?)}";//llamada a un procedimiento
            Consultas query=new Consultas(); 
            result=query.procedimiento(proc, param, objCnx.getMysql().getCnx());
            result.add(objCnx);
        }
        return result;
    }
    
    
}
