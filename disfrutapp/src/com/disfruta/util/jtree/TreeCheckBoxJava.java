/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.util.jtree;

import com.disfruta.bean.admin.Menu;
import com.disfruta.gestion.admin.GestionMenu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author user
 */
public class TreeCheckBoxJava extends JTree {
//    public JTree tree;

    public CheckTreeManager checkTreeManager;
    public ArrayList<Menu> lista = new ArrayList();
    public ArrayList<Nodo> nodos = new ArrayList();
    public ArrayList<Menu> permisosUser = null;
    public DefaultTreeModel modelo = null;

    public TreeCheckBoxJava() {
        try {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }

//                tree = arbol;                
            GestionMenu gm = new GestionMenu();
            lista = gm.listar();
            cargarJTree();
            llenarArrayNodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TreeCheckBoxJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TreeCheckBoxJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarJTree() {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Opciones de Menu");
        for (com.disfruta.bean.admin.Menu menu : lista) {
            if (menu.getNodo() == menu.getNodopadre()) {
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
//                            String des = menu.getDescripcion();
                nodo.setUserObject(menu);
                for (com.disfruta.bean.admin.Menu item : lista) {
                    if (item.getNodopadre() == menu.getNodo() && item.getNodo() != item.getNodopadre()) {
                        DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode();
//                                    String des2 = item.getDescripcion();
                        nodo1.setUserObject(item);
                        for (com.disfruta.bean.admin.Menu item2 : lista) {
                            if (item2.getNodopadre() == item.getNodo() && item2.getNodo() != item2.getNodopadre()) {
                                DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode();
                                boolean control = true;
                                if (permisosUser != null && permisosUser.size() > 0) {
                                    for (int i = 0; i < permisosUser.size(); i++) {
                                        Menu itemmenu = permisosUser.get(i);
                                        if (itemmenu.getId() == item2.getId()) {
                                            control = false;
                                            break;
                                        }
                                    }
                                }
//                                            String des3 = item2.getDescripcion();
                                if (control) {
                                    nodo2.setUserObject(item2);
                                } else {
//                                    System.out.println("iditem Selected: " + item2.getId());
                                    nodo2.setUserObject(item2);
                                }
                                nodo1.add(nodo2);
                            }
                        }
                        nodo.add(nodo1);
                    }
                }
                raiz.add(nodo);
            }
        }

        modelo = new DefaultTreeModel(raiz);
        this.setModel(modelo);
        checkTreeManager = new CheckTreeManager(this);
    }

    public void llenarArrayNodos() {
        for (int i = 0; i < lista.size(); i++) {
            Menu menu = lista.get(i);
            if (menu.getNodo() == menu.getNodopadre() && menu.getTipo().equalsIgnoreCase("MODULO")) {
                Nodo parent = new Nodo(menu, new ArrayList());
                llenarHijos(parent);
                nodos.add(parent);
            }

        }

    }

    public void llenarHijos(Nodo padre) {
        Menu obj = (Menu) padre.getObj();
        for (int i = 0; i < lista.size(); i++) {
            Menu menu = lista.get(i);
            if (menu.getNodopadre() == obj.getNodo() && menu.getNodo() != menu.getNodopadre()) {
                Nodo hijo = new Nodo(menu, new ArrayList());
                padre.getHijos().add(hijo);
                llenarHijos(hijo);
            }
        }
    }

    //Metodos para retornar el arbol de nodos con su estado actual: seleccionado o no seleccionado cada nodo
    public ArrayList<Nodo> getNodosStatus() {
        TreePath checkedPaths[] = checkTreeManager.getSelectionModel().getSelectionPaths();
        if (checkedPaths.length > 0) {
            for (int i = 0; i < checkedPaths.length; i++) {
//                System.out.println("Rama N°: " + i);
                Object items[] = checkedPaths[i].getPath();
                String modulo = items[1].toString(); //la posicion 0 es la raiz
                Nodo nodo = identificarNodo(modulo);
                boolean control=true;
                System.out.println("nodo modulo: "+modulo);
                for (int j = 2; j < items.length; j++) {
                    control=false;
                    String menu = items[j].toString();
                    cambiarEstado(nodo, menu);//enviamos las ramas por ejmplo: LOGISTICA-Mantenimiento-Almacen
                }
                if(control && nodo.getHijos().size()==1){
                    nodo.getHijos().get(0).setSelected(true);
                }

            }
        }
        return this.nodos;
    }

    //metodo para identificar si el nodo ya fue elegido.. por un tema de no repetir las ramas seleccioandas
    public Nodo identificarNodo(String modulo) {
        Nodo nodo = null;
        for (int j = 0; j < nodos.size(); j++) {
            if (nodos.get(j).getObj().getDescripcion().equals(modulo)) {
                nodos.get(j).setSelected(true);
                nodo = nodos.get(j);
            }
        }
        return nodo;
    }

    public void cambiarEstado(Nodo nodo, String menu) {
        ArrayList<Nodo> hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            Nodo hi = hijos.get(i);
            if (hi.getObj().getDescripcion().equals(menu)) {
                hi.setSelected(true);
            }
            cambiarEstado(hi, menu);

        }
    }

    //listar los nodos
    public void mostrarArbolNodos() {
        for (int i = 0; i < nodos.size(); i++) {
            Nodo nodo = nodos.get(i);
            System.out.println("Nodo: " + ((Menu) nodo.getObj()).getDescripcion()+ "-- Estado: " + nodo.getSelected());
            mostrarHijos(nodo);
        }
    }

    public void mostrarHijos(Nodo nodo) {
        ArrayList<Nodo> hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            Nodo hi = hijos.get(i);
            System.out.println("----Nodo: " + ((Menu) hi.getObj()).getDescripcion() + "-- Estado: " + hi.getSelected());
            mostrarHijos(hi);

        }
    }
    
    
    //Seleccionar los checkbox-- se utiliza cuando se selcciona un perfil
    public void selectedCheckBox(){
        CheckTreeSelectionModel selectedModel=checkTreeManager.getSelectionModel();
        System.out.println("selectedd");
        TreePath path = new TreePath(new Object[] {"LOGISTICA", "Mantenimiento", "Proveedor"});
        selectedModel.addSelectionPath(path); //Metodo para seleccionar los checkbox
    
    }

    
}
