/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import com.disfruta.gestion.admin.GestionMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author juae
 */
public class Tree extends JDialog implements ListSelectionListener, ActionListener, FocusListener, KeyListener {
    private java.net.URL path;
//    private Usuario usuario;
    private JPanel pnlCabecera;
    private JPanel pnlTable;
    private JToolBar jtbOpciones;
    private JButton btnNuevo;
    private BeanTreeModel arbolContenido = new BeanTreeModel();
    private BeanTreeRenderer render;
    private JTree arbol = new JTree();
    private JScrollPane arbolScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JPanel pnlLeft;
    private JPanel pnlRigth;
    private JSplitPane contenido;
//    public CTable table;
//    public TipoTrabajadorPerfilTableModel modeltable;
    public TableRowSorter modeloOrdenado;
    private JScrollPane scrollLeft;
    private JTextField txt_descripcion;
//    private List<TipoTrabajador> xTipotrabajador;
    private JComboBox cbo_TipoTrabajador;
    private JButton btn_Perfil;
    private JButton btn_Guardar;
    private JButton btn_Formulario;
    private JButton btn_FormularioPerfil;
    private JLabel lbl_Perfil;
    private int idPerfil = -1;
    private Map<Integer, String> mapMenu;
    private TreeEntryBean nodoRoot;
//    private TipoTrabajadorPerfil beanPerfil;
    List<MenuDinamico> listado;
    
    public Tree(){
        initComponents();
    }
    
    private void initComponents(){
        pnlLeft = new JPanel();
        pnlLeft.setLayout(new BorderLayout());
        pnlRigth = new JPanel();
        pnlRigth.setLayout(new BorderLayout());
        lbl_Perfil = new JLabel("Perfil");
        lbl_Perfil.setBounds(60, 10, 300, 20);
        JPanel pnlCabRigth = new JPanel();
        pnlCabRigth.setLayout(new BorderLayout());
        pnlCabRigth.add(lbl_Perfil);
        pnlCabRigth.setPreferredSize(new Dimension(500, 40));
        pnlCabRigth.setBorder(new LineBorder(new Color(130, 135, 144)));
        pnlRigth.add(pnlCabRigth, BorderLayout.NORTH);
        pnlRigth.add(arbolScrollPane, BorderLayout.CENTER);
        JPanel pnlOptRigth = new JPanel();
        pnlOptRigth.setBorder(new LineBorder(new Color(130, 135, 144)));
        btn_Guardar = new JButton("Guardar");
        btn_Guardar.setBounds(60, 10, 150, 20);
        btn_Guardar.addActionListener(this);
        btn_Guardar.setEnabled(false);
        pnlOptRigth.add(btn_Guardar);
        btn_Formulario = new JButton("Permisos");
        btn_Formulario.setBounds(60, 10, 150, 20);
        btn_Formulario.addActionListener(this);
        btn_Formulario.setEnabled(false);
        pnlOptRigth.add(btn_Formulario);
        pnlOptRigth.setPreferredSize(new Dimension(500, 40));
        pnlRigth.add(pnlOptRigth, BorderLayout.SOUTH);
        contenido = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, pnlLeft, pnlRigth);
        pnlCabecera = new JPanel();
        pnlCabecera.setLayout(new BorderLayout(0, 1));
        pnlTable = new JPanel();
        pnlTable.setLayout(new BorderLayout());
        jtbOpciones = new JToolBar();
        jtbOpciones.setRollover(true);
        btnNuevo = new JButton("Nuevo");
        jtbOpciones.add(btnNuevo);
        pnlCabecera.add(jtbOpciones, BorderLayout.NORTH);

        getContentPane().add(pnlCabecera, BorderLayout.PAGE_START);

        arbolScrollPane.setViewportView(arbol);
        contenido.setContinuousLayout(true);
        contenido.setOneTouchExpandable(true);
        contenido.setDividerLocation(500);
        contenido.setPreferredSize(new Dimension(800, 500));
        construirArbol();
        pnlTable.add(contenido, java.awt.BorderLayout.CENTER);
        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);
        pack();
    }
    
    public void construirArbol() {
        try {
//            rn_Usuario logic_usuario = new rn_Usuario(path);
            listado = new ArrayList<MenuDinamico>();
            GestionMenu g=new GestionMenu();
            listado=g.listarMenuDinamico();
//            if (id_tipo_perfil == -1) {
//                listado = logic_usuario.cargaMenu("");
//            } else {
//                listado = logic_usuario.cargaMenuPerfil(id_tipo_perfil);
//            }
            //Seguridad
            MenuDinamico menuroot = new MenuDinamico();
            menuroot.setId_menu(-1);
            menuroot.setNombre("Seguridad");
            menuroot.setDescripcion("Seguridad");
            menuroot.setMenu_item("N");
            menuroot.setOrden("-1");
            menuroot.setNivel(0);
            menuroot.setId_menu_padre(-1);
            menuroot.setVisible("N");
            nodoRoot = new TreeEntryBean(menuroot.getDescripcion(), menuroot);
            //Escritorio
            MenuDinamico menuEscritorio = new MenuDinamico();
            menuEscritorio.setId_menu(-2);
            menuEscritorio.setNombre("Escritorio");
            menuEscritorio.setDescripcion("Escritorio");
            menuEscritorio.setMenu_item("N");
            menuEscritorio.setOrden("-2");
            menuEscritorio.setNivel(0);
            menuEscritorio.setId_menu_padre(-1);
            menuEscritorio.setVisible("N");
            menuEscritorio.setFlag_sistema("E");
            //menuEscritorio.setControl("M");
            TreeEntryBean nodoMenuEscritorio = new TreeEntryBean(menuEscritorio.getDescripcion(), menuEscritorio);
            nodoRoot.getHijos().add(nodoMenuEscritorio);
            //Web
            MenuDinamico menuWeb = new MenuDinamico();
            menuWeb.setId_menu(-3);
            menuWeb.setNombre("Web");
            menuWeb.setDescripcion("Web");
            menuWeb.setMenu_item("N");
            menuWeb.setOrden("-3");
            menuWeb.setNivel(0);
            menuWeb.setId_menu_padre(-1);
            menuWeb.setVisible("N");
            menuWeb.setFlag_sistema("W");
            //menuEscritorio.setControl("M");
            TreeEntryBean nodoMenuWeb = new TreeEntryBean(menuWeb.getDescripcion(), menuWeb);
            nodoRoot.getHijos().add(nodoMenuWeb);
            //Menu Escritorio
            MenuDinamico menuEscr = new MenuDinamico();
            menuEscr.setId_menu(-4);
            menuEscr.setNombre("Menu");
            menuEscr.setDescripcion("Menu");
            menuEscr.setMenu_item("N");
            menuEscr.setOrden("-4");
            menuEscr.setNivel(0);
            menuEscr.setId_menu_padre(-1);
            menuEscr.setVisible("N");
            menuEscr.setControl("M");
            menuEscr.setFlag_sistema("E");
            TreeEntryBean nodoMenuEscr = new TreeEntryBean(menuEscr.getDescripcion(), menuEscr);
            nodoRoot.getHijos().get(0).getHijos().add(nodoMenuEscr);
            //Barra de Herramientas Escritorio
            MenuDinamico menuBarraEscr = new MenuDinamico();
            menuBarraEscr.setId_menu(-5);
            menuBarraEscr.setNombre("Barra");
            menuBarraEscr.setDescripcion("Barra");
            menuBarraEscr.setMenu_item("N");
            menuBarraEscr.setOrden("-5");
            menuBarraEscr.setNivel(0);
            menuBarraEscr.setId_menu_padre(-1);
            menuBarraEscr.setVisible("N");
            menuBarraEscr.setControl("T");
            menuBarraEscr.setFlag_sistema("E");
            TreeEntryBean nodoBarraEscr = new TreeEntryBean(menuBarraEscr.getDescripcion(), menuBarraEscr);
            nodoRoot.getHijos().get(0).getHijos().add(nodoBarraEscr);

            //Menu Escritorio
            MenuDinamico menuW = new MenuDinamico();
            menuW.setId_menu(-6);
            menuW.setNombre("Menu");
            menuW.setDescripcion("Menu");
            menuW.setMenu_item("N");
            menuW.setOrden("-6");
            menuW.setNivel(0);
            menuW.setId_menu_padre(-1);
            menuW.setVisible("N");
            menuW.setControl("M");
            menuW.setFlag_sistema("W");
            TreeEntryBean nodoMenuW = new TreeEntryBean(menuW.getDescripcion(), menuW);
            nodoRoot.getHijos().get(1).getHijos().add(nodoMenuW);
            //
            mapMenu = new HashMap<Integer, String>();
            for (int i = 0; i < nodoRoot.getHijos().size(); i++) {
                TreeEntryBean b_nodo = (TreeEntryBean) nodoRoot.getHijos().get(i);
                for (int j = 0; j < b_nodo.getHijos().size(); j++) {
                    TreeEntryBean b_nodohijo = (TreeEntryBean) b_nodo.getHijos().get(j);
                    MenuDinamico b_menuhijo = (MenuDinamico) b_nodohijo.getBean();
                    System.out.println("entro aqui");
                    for (int k = 0; k < listado.size(); k++) {
                        MenuDinamico beanmenu = (MenuDinamico) listado.get(k);
                        if (beanmenu.getNivel() == 1) {
                            if (b_menuhijo.getFlag_sistema().equals(beanmenu.getFlag_sistema()) && b_menuhijo.getControl().equals(beanmenu.getControl())) {
                                TreeEntryBean hijoRoot = new TreeEntryBean(beanmenu.getDescripcion(), beanmenu);
                                mapMenu.put(beanmenu.getId_menu(), beanmenu.getVisible());
                                b_nodohijo.getHijos().add(hijoRoot);
                                llenarArbol(hijoRoot);
                            }
                        }
                    }
                }
            }
            
            arbolContenido.setRoot(nodoRoot);
            arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            arbol.setModel(arbolContenido);
            render = new BeanTreeRenderer();
            arbol.setCellRenderer(render);
            arbol.setEditable(true);
            arbol.setCellEditor(new EditorTree());
            arbol.setOpaque(false);
            arbol.setRootVisible(true);
            arbol.setExpandsSelectedPaths(true);
            arbol.setBackground(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void llenarArbol(TreeEntryBean nodo) {
        MenuDinamico beanmenuPadre = (MenuDinamico) nodo.getBean();
        for (int i = 0; i < listado.size(); i++) {
            MenuDinamico beanmenu = (MenuDinamico) listado.get(i);
            if (beanmenuPadre.getId_menu() == beanmenu.getId_menu_padre()) {
                TreeEntryBean hijoRoot = new TreeEntryBean(beanmenu.getDescripcion(), beanmenu);
                mapMenu.put(beanmenu.getId_menu(), beanmenu.getVisible());
                nodo.getHijos().add(hijoRoot);
                llenarArbol(hijoRoot);
            }
        }
    }

    private String posHijo(TreeEntryBean beanTree, int nivel, int id_padre) {
        if (nivel == 1) {
            for (int i = 0; i < beanTree.getHijos().size(); i++) {
                TreeEntryBean beanEntry = (TreeEntryBean) beanTree.getHijos().get(i);
                MenuDinamico menu = (MenuDinamico) beanEntry.getBean();
                if (menu.getId_menu() == id_padre) {
                    return String.valueOf(i);
                }
            }
        } else if (nivel == 2) {
            for (int i = 0; i < beanTree.getHijos().size(); i++) {
                TreeEntryBean beanEntry = (TreeEntryBean) beanTree.getHijos().get(i);
                for (int j = 0; j < beanEntry.getHijos().size(); j++) {
                    TreeEntryBean beanNodo = (TreeEntryBean) beanEntry.getHijos().get(j);
                    MenuDinamico menu = (MenuDinamico) beanNodo.getBean();
                    if (menu.getId_menu() == id_padre) {
                        return String.valueOf(i) + "," + String.valueOf(j);
                    }
                }
            }
        } else if (nivel == 3) {
            for (int i = 0; i < beanTree.getHijos().size(); i++) {
                TreeEntryBean beanEntry = (TreeEntryBean) beanTree.getHijos().get(i);
                for (int j = 0; j < beanEntry.getHijos().size(); j++) {
                    TreeEntryBean beanNodo = (TreeEntryBean) beanEntry.getHijos().get(j);
                    for (int k = 0; k < beanNodo.getHijos().size(); k++) {
                        TreeEntryBean beanHijo = (TreeEntryBean) beanNodo.getHijos().get(k);
                        MenuDinamico menu = (MenuDinamico) beanHijo.getBean();
                        if (menu.getId_menu() == id_padre) {
                            //return String.valueOf(i) + "," + String.valueOf(j);
                            return String.valueOf(j) + "," + String.valueOf(k);
                        }
                    }
                }
            }
        }
        return "";
    }

//    private void filtrar() {
//        modeloOrdenado.setRowFilter(getFilter());
//        table.setAllColumnPreferredWidth();
//
//        if (table.getRowCount() > 0) {
//            table.setRowSelectionInterval(0, 0);
//        }
//    }
//
//    private void mostrarMenuPerfil() {
//        if (table.getRowCount() == 0) {
//            return;
//        }
//        if (table.getSelectedRow() >= 0) {
//            int pos = table.convertRowIndexToModel(table.getSelectedRow());
//            beanPerfil = new TipoTrabajadorPerfil();
//            beanPerfil = modeltable.getTipoPerfil(pos);
//            idPerfil = modeltable.getTipoPerfil(pos).getId_tipo_perfil();
//            btn_Guardar.setEnabled(true);
//            btn_Formulario.setEnabled(true);
//            lbl_Perfil.setText(modeltable.getTipoPerfil(pos).getDescripcion());
//            arbol.setModel(null);
//            arbol.setCellRenderer(null);
//            construirArbol(idPerfil);
//        } else {
//            JOptionPane.showMessageDialog(this, "Seleccione Fila", "Perfiles", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
