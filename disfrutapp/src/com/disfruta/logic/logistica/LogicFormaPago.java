/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.FormaPago;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoFormaPago;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicFormaPago {
    private ObjConexion objCnx;
    
    public LogicFormaPago(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{        
        DaoFormaPago oDaoFormaPago = new DaoFormaPago();
        ArrayList<FormaPago> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoFormaPago.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            FormaPago objFormaPago=new FormaPago();
            objFormaPago.setId(rs.getInt("n_idforma_pago"));
            objFormaPago.setDescripcion(rs.getString("v_descripcion_forma"));
            objFormaPago.setDias(rs.getInt("n_numero_dias"));
            lista.add(objFormaPago);
        }
        rs.close();
        cst.close();
        return lista;
    } 
}
