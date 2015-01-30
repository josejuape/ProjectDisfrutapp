/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

/**
 *
 * @author Ferronor1
 */
public class MenuDinamico {

    private int id_menu;
    private String nombre;
    private String descripcion;
    private String menu_item;
    private String orden;
    private int nivel;
    private int id_menu_padre;
    private String visible;
    private String control;
    private int id_formulario;
    private String flag_sistema;

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(String menu_item) {
        this.menu_item = menu_item;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public int getId_menu_padre() {
        return id_menu_padre;
    }

    public void setId_menu_padre(int id_menu_padre) {
        this.id_menu_padre = id_menu_padre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public int getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(int id_formulario) {
        this.id_formulario = id_formulario;
    }

    public String getFlag_sistema() {
        return flag_sistema;
    }

    public void setFlag_sistema(String flag_sistema) {
        this.flag_sistema = flag_sistema;
    }
}
