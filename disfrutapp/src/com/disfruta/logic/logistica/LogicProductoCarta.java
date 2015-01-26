/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.logistica;

import com.disfruta.bean.logistica.FamiliaProducto;
import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.PresentacionVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.logistica.DaoProductoCarta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicProductoCarta {

    private ObjConexion objCnx;

    public LogicProductoCarta(ObjConexion paramCnx) {
        this.objCnx = paramCnx;
    }

    public String mantenimiento(ProductoCarta beanProductoCarta) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;

        DaoProductoCarta oDaoProductoCarta = new DaoProductoCarta();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", beanProductoCarta.getIdproductocarta());
        Parametro param3 = new Parametro("IN", beanProductoCarta.getNombre());
        Parametro param4 = new Parametro("IN", beanProductoCarta.getDescripcion());
        Parametro param5 = new Parametro("IN", beanProductoCarta.getFamilia().getN_idfamilia());
        Parametro param6 = new Parametro("IN", beanProductoCarta.getTipoOperacion());

        param.add(param1);
        param.add(param2);
        param.add(param3);
        param.add(param4);
        param.add(param5);
        param.add(param6);

        ArrayList objetos = oDaoProductoCarta.mantenimiento(param, objCnx);
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
        DaoProductoCarta oDaoProductoCarta = new DaoProductoCarta();
        ArrayList<ProductoCarta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos = oDaoProductoCarta.listar(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        rs.beforeFirst();
        while (rs.next()) {
            ProductoCarta objProductoCarta = new ProductoCarta();
            objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            objProductoCarta.setNombre(rs.getString("v_nombre"));
            objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
            FamiliaProducto familia = new FamiliaProducto();
            familia.setN_idfamilia(rs.getInt("n_idfamilia"));
            familia.setV_familia(rs.getString("familia"));
            objProductoCarta.setFamilia(familia);
            lista.add(objProductoCarta);
        }
        rs.close();
        cst.close();
        return lista;
    }
    
    public ArrayList listarCarta() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {
        DaoProductoCarta oDaoProductoCarta = new DaoProductoCarta();
        ArrayList<ProductoCarta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos = oDaoProductoCarta.listarCarta(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        int control = 0;
        int idpro = 0;
        rs.beforeFirst();

        if (rs.next()) {
            control = rs.getInt("n_idproducto_carta");
            ProductoCarta objProductoCarta = new ProductoCarta();
            objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            objProductoCarta.setNombre(rs.getString("v_nombre"));
            objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
            FamiliaProducto familia = new FamiliaProducto();
            familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
            objProductoCarta.setFamilia(familia);
            ArrayList<PresentacionPrecioVenta> presentaciones = new ArrayList();
            PresentacionVenta pres = new PresentacionVenta();
            PresentacionPrecioVenta pv = new PresentacionPrecioVenta();
            pres.setId(rs.getInt("n_idpresentacion_producto"));
            pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
            pv.setPresentacion(pres);
            pv.setPrecioventa(rs.getDouble("n_precioventa"));
            pv.setProporcion(rs.getDouble("n_proporcion"));
            presentaciones.add(pv);
            while (rs.next()) {
                idpro = rs.getInt("n_idproducto_carta");
                System.out.println("idpro: " + idpro+" - control: "+control);
                if (idpro == control) {                    
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                } else {
                    control = rs.getInt("n_idproducto_carta");
                    objProductoCarta.setPresentaciones(presentaciones);
                    lista.add(objProductoCarta);
                    presentaciones = new ArrayList();
                    objProductoCarta = new ProductoCarta();
                    objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
                    objProductoCarta.setNombre(rs.getString("v_nombre"));
                    objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
                    FamiliaProducto fa = new FamiliaProducto();
                    familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
                    objProductoCarta.setFamilia(fa);
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                }

            }
            objProductoCarta.setPresentaciones(presentaciones);
            lista.add(objProductoCarta);
            
        }
        rs.close();
        cst.close();
        return lista;
    }

    public ArrayList listarPorFamilia(FamiliaProducto fam) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {
        DaoProductoCarta oDaoProductoCarta = new DaoProductoCarta();
        ArrayList<ProductoCarta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN", fam.getN_idfamilia()));
        ArrayList objetos = oDaoProductoCarta.listarPorFamilia(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        int control = 0;
        int idpro = 0;
        rs.beforeFirst();

        if (rs.next()) {
            control = rs.getInt("n_idproducto_carta");
            ProductoCarta objProductoCarta = new ProductoCarta();
            objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            objProductoCarta.setNombre(rs.getString("v_nombre"));
            objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
            FamiliaProducto familia = new FamiliaProducto();
            familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
            objProductoCarta.setFamilia(familia);
            ArrayList<PresentacionPrecioVenta> presentaciones = new ArrayList();
            PresentacionVenta pres = new PresentacionVenta();
            PresentacionPrecioVenta pv = new PresentacionPrecioVenta();
            pres.setId(rs.getInt("n_idpresentacion_producto"));
            pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
            pv.setPresentacion(pres);
            pv.setPrecioventa(rs.getDouble("n_precioventa"));
            pv.setProporcion(rs.getDouble("n_proporcion"));
            presentaciones.add(pv);
            while (rs.next()) {
                idpro = rs.getInt("n_idproducto_carta");
                System.out.println("idpro: " + idpro+" - control: "+control);
                if (idpro == control) {                    
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                } else {
                    control = rs.getInt("n_idproducto_carta");
                    objProductoCarta.setPresentaciones(presentaciones);
                    lista.add(objProductoCarta);
                    presentaciones = new ArrayList();
                    objProductoCarta = new ProductoCarta();
                    objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
                    objProductoCarta.setNombre(rs.getString("v_nombre"));
                    objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
                    FamiliaProducto fa = new FamiliaProducto();
                    familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
                    objProductoCarta.setFamilia(fa);
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                }

            }
            objProductoCarta.setPresentaciones(presentaciones);
            lista.add(objProductoCarta);
            
        }
        rs.close();
        cst.close();
        return lista;
    }
    
    public ArrayList listarPorBusqueda(String producto) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception {
        DaoProductoCarta oDaoProductoCarta = new DaoProductoCarta();
        ArrayList<ProductoCarta> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        param.add(new Parametro("IN", producto));
        ArrayList objetos = oDaoProductoCarta.listarPorBusqueda(param, objCnx);
        ResultSet rs = (ResultSet) objetos.get(0);
        CallableStatement cst = (CallableStatement) objetos.get(1);
        objCnx = (ObjConexion) objetos.get(2);
        int control = 0;
        int idpro = 0;
        rs.beforeFirst();

        if (rs.next()) {
            control = rs.getInt("n_idproducto_carta");
            ProductoCarta objProductoCarta = new ProductoCarta();
            objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
            objProductoCarta.setNombre(rs.getString("v_nombre"));
            objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
            FamiliaProducto familia = new FamiliaProducto();
            familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
            objProductoCarta.setFamilia(familia);
            ArrayList<PresentacionPrecioVenta> presentaciones = new ArrayList();
            PresentacionVenta pres = new PresentacionVenta();
            PresentacionPrecioVenta pv = new PresentacionPrecioVenta();
            pres.setId(rs.getInt("n_idpresentacion_producto"));
            pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
            pv.setPresentacion(pres);
            pv.setPrecioventa(rs.getDouble("n_precioventa"));
            pv.setProporcion(rs.getDouble("n_proporcion"));
            presentaciones.add(pv);
            while (rs.next()) {
                idpro = rs.getInt("n_idproducto_carta");
                System.out.println("idpro: " + idpro+" - control: "+control);
                if (idpro == control) {                    
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                } else {
                    control = rs.getInt("n_idproducto_carta");
                    objProductoCarta.setPresentaciones(presentaciones);
                    lista.add(objProductoCarta);
                    presentaciones = new ArrayList();
                    objProductoCarta = new ProductoCarta();
                    objProductoCarta.setIdproductocarta(rs.getInt("n_idproducto_carta"));
                    objProductoCarta.setNombre(rs.getString("v_nombre"));
                    objProductoCarta.setDescripcion(rs.getString("logtbc_producto_carta.v_descripcion"));
                    FamiliaProducto fa = new FamiliaProducto();
                    familia.setN_idfamilia(rs.getInt("logtbc_producto_carta.n_idfamilia"));
                    objProductoCarta.setFamilia(fa);
                    pres = new PresentacionVenta();
                    pv = new PresentacionPrecioVenta();
                    pres.setId(rs.getInt("n_idpresentacion_producto"));
                    pres.setDescripcion(rs.getString("logtbc_presentacion_producto.v_descripcion"));
                    pv.setPresentacion(pres);
                    pv.setPrecioventa(rs.getDouble("n_precioventa"));
                    pv.setProporcion(rs.getDouble("n_proporcion"));
                    presentaciones.add(pv);
                }

            }
            objProductoCarta.setPresentaciones(presentaciones);
            lista.add(objProductoCarta);
            
        }
        rs.close();
        cst.close();
        return lista;
    }
}
