/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.conexion;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Juape
 */
public class ObjConexion {
    private Conexion mysql;
    
    public boolean conectarMysql() throws ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException, IOException{
        Rutas ruta=new Rutas();
        ReadProperties pro=new ReadProperties(ruta.getFileDBMysql());
        mysql=new Conexion(
                pro.getIpHost(),
                pro.getPuerto(),
                pro.getBasedatos(),
                pro.getUsuario(),
                pro.getContrasena(),
                pro.getGestor()
                );
        return mysql.conectarBD();
    }

    public Conexion getMysql() {
        return mysql;
    }

    public void setMysql(Conexion mysql) {
        this.mysql = mysql;
    }
    
    
    public boolean conectarMysqlLocal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        mysql=new Conexion("localhost","3306","bddisfrutapprueba","root","","mysql");
        return mysql.conectarBD();
    }
    
}
