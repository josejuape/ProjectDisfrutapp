/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

/**
 *
 * @author user
 */
public class Validate {
    public static boolean isNumero(String string){
        if(string==null || string.isEmpty()){
            return false;
        }
        int i=0;
        if(string.charAt(0)=='-'){
            if(string.length()>1){
                i++;
            }else{
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
