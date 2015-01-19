/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class PaddingLeft {
    public static void agregarpadding(JTextField caja){
        caja.setBorder(BorderFactory.createCompoundBorder(
        caja.getBorder(), 
        BorderFactory.createEmptyBorder(0,15,0,0)));
    
    }
}
