/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.CategoriaProveedor;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoCategoriaProveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicCategoriaProveedor {
    private ObjConexion objCnx;
    
    public LogicCategoriaProveedor(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoCategoriaProveedor oDaoCategoriaProveedor = new DaoCategoriaProveedor();
        ArrayList<CategoriaProveedor> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoCategoriaProveedor.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            CategoriaProveedor objCategoriaProveedor=new CategoriaProveedor();
            objCategoriaProveedor.setId(rs.getInt("n_idcategoria_proveedor"));
            objCategoriaProveedor.setDescripcion(rs.getString("v_descripcion_categoria"));
            lista.add(objCategoriaProveedor);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
    
    
}
