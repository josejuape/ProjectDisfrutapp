/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.conexion;

import java.net.URL;

/**
 *
 * @author Juape
 */
public class Rutas {
    private final String dbmysql="/com/disfruta/conexion/dbmysql.properties";
    
    public URL getFileDBMysql(){
        return getClass().getResource(dbmysql);
    }
}
