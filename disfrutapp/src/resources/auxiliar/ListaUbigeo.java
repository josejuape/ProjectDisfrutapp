/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

import com.disfruta.bean.xtbc.Ubigeo;
import java.util.ArrayList;

/**
 *
 * @author Juape
 */
public class ListaUbigeo {
    protected static ArrayList<Ubigeo> getListUbigeo;

    public static ArrayList<Ubigeo> getGetListUbigeo() {
        return getListUbigeo;
    }

    public static void setGetListUbigeo(ArrayList<Ubigeo> getListUbigeo) {
        ListaUbigeo.getListUbigeo = getListUbigeo;
    }
    
    
}
