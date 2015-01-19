/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.CategoriaProveedor;
import com.disfruta.bean.logistica.Proveedor;
import com.disfruta.bean.logistica.TipoPersona;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoProveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicProveedor {

    private ObjConexion objCnx;

    public LogicProveedor(ObjConexion paramCnx) {
        this.objCnx = paramCnx;
    }

    public String mantenimiento(Proveedor beanProveedor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoProveedor oDaoProveedor = new DaoProveedor();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanProveedor.getId());
        Parametro param3 = new Parametro("IN", beanProveedor.getRuc());
        Parametro param4 = new Parametro("IN", beanProveedor.getNombres());
        Parametro param5 = new Parametro("IN", beanProveedor.getApellidos());
        Parametro param6 = new Parametro("IN", beanProveedor.getUbicacion());
        Parametro param7 = new Parametro("IN", beanProveedor.getDireccion());
        Parametro param8 = new Parametro("IN", beanProveedor.getReferencia());
        Parametro param9 = new Parametro("IN", beanProveedor.getContacto1());
        Parametro param10 = new Parametro("IN", beanProveedor.getTelf_contacto1());
        Parametro param11 = new Parametro("IN", beanProveedor.getContacto2());
        Parametro param12 = new Parametro("IN", beanProveedor.getTelf_contacto2());
        Parametro param13 = new Parametro("IN", beanProveedor.getContacto3());
        Parametro param14 = new Parametro("IN", beanProveedor.getTelf_contacto3());
        Parametro param15 = new Parametro("IN", beanProveedor.getCategoria().getId());
        Parametro param16 = new Parametro("IN", beanProveedor.getTipopersona().getId());
        Parametro param17 = new Parametro("IN", beanProveedor.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);
        param.add(param7);
        param.add(param8);
        param.add(param9);
        param.add(param10);
        param.add(param11);                
        param.add(param12);
        param.add(param13);
        param.add(param14);
        param.add(param15);
        param.add(param16);
        param.add(param17);

        ArrayList objetos = oDaoProveedor.mantenimiento(param, objCnx);
        if (objetos.isEmpty()) {
            msg = "Sin resultados";
        } else {
            msg = objetos.get(0).toString();
            CallableStatement cst = (CallableStatement) objetos.get(1);
            objCnx = (ObjConexion) objetos.get(2);
            //objCnx.getMysql().confirmar();
            cst.close();

            //ocnx.getMysql().desconectarBD();
        }
        return msg;
    }

    public ArrayList listar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoProveedor oDaoProveedor = new DaoProveedor();
        ArrayList<Proveedor> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos = oDaoProveedor.listar(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            Proveedor objProveedor = new Proveedor();
            objProveedor.setId(rs.getInt("n_idproveedor"));
            objProveedor.setRuc(rs.getString("v_ruc"));
            objProveedor.setNombres(rs.getString("v_nombres"));
            objProveedor.setApellidos(rs.getString("v_apellidos"));
            objProveedor.setUbicacion(rs.getString("v_ubicacion"));
            objProveedor.setDireccion(rs.getString("v_direccion"));
            objProveedor.setReferencia(rs.getString("v_referencia"));
            objProveedor.setContacto1(rs.getString("v_contacto1"));
            objProveedor.setTelf_contacto1(rs.getString("v_telefono_contacto1"));
            objProveedor.setContacto2(rs.getString("v_contacto2"));
            objProveedor.setTelf_contacto2(rs.getString("v_telefono_contacto2"));
            objProveedor.setContacto3(rs.getString("v_contacto3"));
            objProveedor.setTelf_contacto3(rs.getString("v_telefono_contacto3"));
            TipoPersona tipo = new TipoPersona();
            tipo.setId(rs.getInt("n_idtipo_persona"));
            tipo.setDescripcion(rs.getString("v_descripcion_tipo"));
            CategoriaProveedor cat = new CategoriaProveedor();
            cat.setId(rs.getInt("n_idcategoria_proveedor"));
            cat.setDescripcion(rs.getString("v_descripcion_categoria"));
            objProveedor.setTipopersona(tipo);
            objProveedor.setCategoria(cat);
            lista.add(objProveedor);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }
    
    public Proveedor getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {

        DaoProveedor oDaoProveedor = new DaoProveedor();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos = oDaoProveedor.getUltimoObject(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        Proveedor objProveedor = new Proveedor();
        rs.beforeFirst();
        while (rs.next()) {            
            objProveedor.setId(rs.getInt("n_idproveedor"));
            objProveedor.setRuc(rs.getString("v_ruc"));
            objProveedor.setNombres(rs.getString("v_nombres"));
            objProveedor.setApellidos(rs.getString("v_apellidos"));
            objProveedor.setUbicacion(rs.getString("v_ubicacion"));
            objProveedor.setDireccion(rs.getString("v_direccion"));
            objProveedor.setReferencia(rs.getString("v_referencia"));
            objProveedor.setContacto1(rs.getString("v_contacto1"));
            objProveedor.setTelf_contacto1(rs.getString("v_telefono_contacto1"));
            objProveedor.setContacto2(rs.getString("v_contacto2"));
            objProveedor.setTelf_contacto2(rs.getString("v_telefono_contacto2"));
            objProveedor.setContacto3(rs.getString("v_contacto3"));
            objProveedor.setTelf_contacto3(rs.getString("v_telefono_contacto3"));
            TipoPersona tipo = new TipoPersona();
            tipo.setId(rs.getInt("n_idtipo_persona"));
            tipo.setDescripcion(rs.getString("v_descripcion_tipo"));
            CategoriaProveedor cat = new CategoriaProveedor();
            cat.setId(rs.getInt("n_idcategoria_proveedor"));
            cat.setDescripcion(rs.getString("v_descripcion_categoria"));
            objProveedor.setTipopersona(tipo);
            objProveedor.setCategoria(cat);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return objProveedor;
    }
}
