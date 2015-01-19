/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.tester;

import com.disfruta.bean.admin.Menu;
import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.gestion.admin.GestionMenu;
import com.disfruta.gestion.logistica.GestionFamiliaProducto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, SQLException, Exception {
//        ObjConexion obj=new ObjConexion();
//        boolean rpta=obj.conectarMysql();
//        System.out.println("Conexion: "+rpta);
        
        GestionFamiliaProducto gm=new GestionFamiliaProducto();
        ArrayList<FamiliaProducto> lista=gm.listar();
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Ro: "+lista.get(i).getN_idfamilia());
        }
        
    }
}
