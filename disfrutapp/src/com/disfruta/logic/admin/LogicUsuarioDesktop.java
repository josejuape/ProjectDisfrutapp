/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.logic.admin;

import com.disfruta.bean.admin.UsuarioDesktop;
import com.disfruta.bean.admin.TipoUserDesktop;
import com.disfruta.conexion.ObjConexion;
import com.disfruta.conexion.Parametro;
import com.disfruta.dao.admin.DaoUsuarioDesktop;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class LogicUsuarioDesktop {
    private ObjConexion objCnx;
    
    public LogicUsuarioDesktop(ObjConexion paramCnx){
        this.objCnx=paramCnx;
    }
    
    public String mantenimiento(UsuarioDesktop usuario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        String msg;
        
        DaoUsuarioDesktop oDaoUsuario = new DaoUsuarioDesktop();
        ArrayList<Parametro> param = new ArrayList();
        Parametro param1 = new Parametro("OUT", Types.VARCHAR);
        Parametro param2 = new Parametro("IN", usuario.getIdUser());
        Parametro param3 = new Parametro("IN", usuario.getNombres());
        Parametro param4 = new Parametro("IN", usuario.getApellidos());
        Parametro param5 = new Parametro("IN", usuario.getDni());
        Parametro param6 = new Parametro("IN", usuario.getFechNacimiento());
        Parametro param7 = new Parametro("IN", usuario.getSexo());
        Parametro param8 = new Parametro("IN", usuario.getFoto());
        Parametro param9 = new Parametro("IN", usuario.getEmail());
        Parametro param10 = new Parametro("IN", usuario.getDireccion());
        Parametro param11 = new Parametro("IN", usuario.getCelular());
        Parametro param12 = new Parametro("IN", usuario.getUsuario());
        Parametro param13 = new Parametro("IN", usuario.getPassword());
        Parametro param14 = new Parametro("IN", usuario.getEstado());
        Parametro param15 = new Parametro("IN", usuario.getPedidosAtendidos());
        Parametro param16 = new Parametro("IN", usuario.getTipoUser().getIdtipouser());
        Parametro param17 = new Parametro("IN", usuario.getTipoOperacion());
        
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

        ArrayList objetos = oDaoUsuario.mantenimiento(param, objCnx);
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
        
        DaoUsuarioDesktop oDaoMenu = new DaoUsuarioDesktop();
        ArrayList<UsuarioDesktop> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.listar(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            UsuarioDesktop user=new UsuarioDesktop();
            user.setIdUser(rs.getInt("n_iduser_desktop"));
            user.setNombres(rs.getString("v_nombres"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setDni(rs.getString("v_dni"));
            user.setFechNacimiento(rs.getString("v_fecha_nacimiento"));
            user.setSexo(rs.getString("c_sexo"));
            user.setFoto(rs.getString("v_foto"));
            user.setEmail(rs.getString("v_email"));
            user.setDireccion(rs.getString("v_direccion"));
            user.setCelular(rs.getString("v_celular"));
            user.setUsuario(rs.getString("v_usuario"));
            user.setPassword(rs.getString("v_clave"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setEstado(rs.getString("v_estado"));
            user.setFechaRegistro(rs.getString("d_fecha_registro"));
            user.setPedidosAtendidos(rs.getInt("n_pedidos_atendidos"));
            TipoUserDesktop tipo=new TipoUserDesktop();
            tipo.setIdtipouser(rs.getInt("n_idtipo_user_desktop"));
            tipo.setDescripcion(rs.getString("v_descripcion"));
            user.setTipoUser(tipo);
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    }  
    
    public ArrayList listarStaff() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoUsuarioDesktop oDaoMenu = new DaoUsuarioDesktop();
        ArrayList<UsuarioDesktop> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.listarStaff(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            UsuarioDesktop user=new UsuarioDesktop();
            user.setIdUser(rs.getInt("n_iduser_desktop"));
            user.setNombres(rs.getString("v_nombres"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setDni(rs.getString("v_dni"));
            user.setFechNacimiento(rs.getString("v_fecha_nacimiento"));
            user.setSexo(rs.getString("c_sexo"));
            user.setFoto(rs.getString("v_foto"));
            user.setEmail(rs.getString("v_email"));
            user.setDireccion(rs.getString("v_direccion"));
            user.setCelular(rs.getString("v_celular"));
            user.setUsuario(rs.getString("v_usuario"));
            user.setPassword(rs.getString("v_clave"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setEstado(rs.getString("v_estado"));
            user.setFechaRegistro(rs.getString("d_fecha_registro"));
            user.setPedidosAtendidos(rs.getInt("n_pedidos_atendidos"));
//            TipoUserDesktop tipo=new TipoUserDesktop();
//            tipo.setIdtipouser(rs.getInt("n_idtipo_user_desktop"));
//            tipo.setDescripcion(rs.getString("v_descripcion"));
//            user.setTipoUser(tipo);
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
    
    public ArrayList listarStaffCocina() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoUsuarioDesktop oDaoMenu = new DaoUsuarioDesktop();
        ArrayList<UsuarioDesktop> lista = new ArrayList();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.listarStaffCocina(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        while(rs.next()){
            UsuarioDesktop user=new UsuarioDesktop();
            user.setIdUser(rs.getInt("n_iduser_desktop"));
            user.setNombres(rs.getString("v_nombres"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setDni(rs.getString("v_dni"));
            user.setFechNacimiento(rs.getString("v_fecha_nacimiento"));
            user.setSexo(rs.getString("c_sexo"));
            user.setFoto(rs.getString("v_foto"));
            user.setEmail(rs.getString("v_email"));
            user.setDireccion(rs.getString("v_direccion"));
            user.setCelular(rs.getString("v_celular"));
            user.setUsuario(rs.getString("v_usuario"));
            user.setPassword(rs.getString("v_clave"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setEstado(rs.getString("v_estado"));
            user.setFechaRegistro(rs.getString("d_fecha_registro"));
            user.setPedidosAtendidos(rs.getInt("n_pedidos_atendidos"));
            lista.add(user);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return lista;
    } 
    
    public UsuarioDesktop getUltimoObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException, Exception{
        
        DaoUsuarioDesktop oDaoMenu = new DaoUsuarioDesktop();
        ArrayList<Parametro> param = new ArrayList();
        ArrayList objetos=oDaoMenu.getUltimoObject(param, objCnx);
        ResultSet rs=(ResultSet)objetos.get(0);
        CallableStatement cst=(CallableStatement)objetos.get(1);
        objCnx=(ObjConexion)objetos.get(2);
        rs.beforeFirst();
        UsuarioDesktop user=new UsuarioDesktop();
        while(rs.next()){            
            user.setIdUser(rs.getInt("n_iduser_desktop"));
            user.setNombres(rs.getString("v_nombres"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setDni(rs.getString("v_dni"));
            user.setFechNacimiento(rs.getString("v_fecha_nacimiento"));
            user.setSexo(rs.getString("c_sexo"));
            user.setFoto(rs.getString("v_foto"));
            user.setEmail(rs.getString("v_email"));
            user.setDireccion(rs.getString("v_direccion"));
            user.setCelular(rs.getString("v_celular"));
            user.setUsuario(rs.getString("v_usuario"));
            user.setPassword(rs.getString("v_clave"));
            user.setApellidos(rs.getString("v_apellidos"));
            user.setEstado(rs.getString("v_estado"));
            user.setFechaRegistro(rs.getString("d_fecha_registro"));
            user.setPedidosAtendidos(rs.getInt("n_pedidos_atendidos"));
            TipoUserDesktop tipo=new TipoUserDesktop();
            tipo.setIdtipouser(rs.getInt("n_idtipo_user_desktop"));
            tipo.setDescripcion(rs.getString("v_descripcion"));
            user.setTipoUser(tipo);
        }
        rs.close();
        cst.close();
        //objCnx.getMysql().desconectarBD();
        return user;
    }  
}
