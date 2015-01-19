/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class Consultas {
    public ArrayList funcion(
            String cadenaProcFun,
            ArrayList<Parametro> param,
            Connection cnx
            ) throws SQLException, Exception{
        ArrayList objetos=new ArrayList();
        CallableStatement cst;
        cst=cnx.prepareCall(cadenaProcFun);
        if(numeroParametros(cadenaProcFun)==param.size()){
            for(int i=0;i<param.size();i++){                
                if(param.get(i).getInOrOut().equalsIgnoreCase("OUT")){
                    try{
                    int out=Integer.parseInt(String.valueOf(param.get(i).getValor()));
                    cst.registerOutParameter(i+1, out);
                    }catch(Exception ex){
                        throw new Exception("Error - Los parametros de salida son solo tipo Integer");
                    }                    
                }else if(param.get(i).getInOrOut().equalsIgnoreCase("IN")){
                    Object in=(Object)param.get(i).getValor();
                    cst.setObject(i+1, in);
                }else{
                    throw new Exception("Por favor define tus parametros de entrada(IN) o salida(OUT)");
                }
            }                            
            cst.execute();
            for(int i=0;i<param.size();i++){
                if(param.get(i).getInOrOut().equalsIgnoreCase("OUT")){
                    Object objeto=cst.getObject(i+1);
                    objetos.add(objeto);
                }
            }
            objetos.add(cst);
            return objetos;
        }else{
            throw new Exception("Error - Nùmero de signos ? diferente del nùmero de parametros");
        }
    }
    
    /*Solo para Gestores Mysql y SqlServer*/
    public ArrayList procedimiento(
            String cadenaProcFun,
            ArrayList<Parametro> param,
            Connection cnx
            ) throws SQLException, Exception{
        ArrayList objetos=new ArrayList();
        CallableStatement cst;
        cst=cnx.prepareCall(cadenaProcFun);
        ResultSet rs;
        if(numeroParametros(cadenaProcFun)==param.size()){
            for(int i=0;i<param.size();i++){                
                if(param.get(i).getInOrOut().equalsIgnoreCase("OUT")){
                    try{
                    int out=Integer.parseInt(String.valueOf(param.get(i).getValor()));
                    cst.registerOutParameter(i+1, out);
                    }catch(Exception ex){
                        throw new Exception("Error - Los parametros de salida son solo tipo Integer");
                    }                    
                }else if(param.get(i).getInOrOut().equalsIgnoreCase("IN")){
                    Object in=(Object)param.get(i).getValor();
                    cst.setObject(i+1, in);
                }else{
                    throw new Exception("Por favor define tus parametros de entrada(IN) o salida(OUT)");
                }
            }                            
            rs=cst.executeQuery();            
            for(int i=0;i<param.size();i++){
                if(param.get(i).getInOrOut().equalsIgnoreCase("OUT")){
                    Object objeto=cst.getObject(i+1);
                    objetos.add(objeto);
                }
            }
            objetos.add(rs);
            objetos.add(cst);
            return objetos;
        }else{
            throw new Exception("Error - Nùmero de signos ? diferente del nùmero de parametros");
        }
    }
    
    private int numeroParametros(String consulta){
        int contador=0;
        for(int i=0;i<consulta.length();i++){
            if(String.valueOf(consulta.charAt(i)).equalsIgnoreCase("?")){
                contador=contador+1;
            }
        }
        return contador;
    }
}
