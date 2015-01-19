/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.CuentaBancaria;
import com.disfruta.bean.logistica.EntidadBancaria;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.xtbc.Moneda;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoCuentaBancaria;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicCuentaBancaria {
    private ObjConexion objCnx;
    
    public LogicCuentaBancaria(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(CuentaBancaria beanCuentaBancaria) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoCuentaBancaria oDaoCuentaBancaria = new DaoCuentaBancaria();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanCuentaBancaria.getId());
        Parametro param3 = new Parametro("IN", beanCuentaBancaria.getNumerocuenta());
        Parametro param4 = new Parametro("IN", beanCuentaBancaria.getCuentainterbancaria());
        Parametro param5 = new Parametro("IN", beanCuentaBancaria.getEntidad().getId());
        Parametro param6 = new Parametro("IN", beanCuentaBancaria.getMoneda().getN_idmon());
        Parametro param7 = new Parametro("IN", beanCuentaBancaria.getProveedor().getId());
        Parametro param8 = new Parametro("IN", beanCuentaBancaria.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);
        param.add(param8);

        ArrayList objetos = oDaoCuentaBancaria.mantenimiento(param, objCnx);
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
    
    
    public ArrayList listarCuentaUsuario(Proveedor prov) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoCuentaBancaria oDaoCuentaBancaria = new DaoCuentaBancaria();
        ArrayList<CuentaBancaria> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1=new Parametro("IN",prov.getId());
        param.add(param1);
        ArrayList objetos=oDaoCuentaBancaria.listarCuentaUsuario(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            CuentaBancaria objCuentaBancaria=new CuentaBancaria();
            objCuentaBancaria.setId(rs.getInt("n_idcuenta_bancaria"));
            objCuentaBancaria.setNumerocuenta(rs.getString("v_numero_cuenta"));
            objCuentaBancaria.setCuentainterbancaria(rs.getString("v_cuenta_interbancaria"));
            Proveedor proveedor=new Proveedor();
            proveedor.setId(rs.getInt("n_idproveedor"));
            proveedor.setNombres(rs.getString("v_nombres"));
            EntidadBancaria entidad=new EntidadBancaria();
            entidad.setId(rs.getInt("n_identidad_bancaria"));
            entidad.setNombre(rs.getString("v_nombre"));
            Moneda moneda=new Moneda();
            moneda.setN_idmon(rs.getInt("n_idmoneda"));
            moneda.setV_moneda(rs.getString("v_descripcion"));
            moneda.setV_simbolo(rs.getString("v_simbolo"));
            objCuentaBancaria.setProveedor(proveedor);
            objCuentaBancaria.setEntidad(entidad);
            objCuentaBancaria.setMoneda(moneda);
            lista.add(objCuentaBancaria);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
}
