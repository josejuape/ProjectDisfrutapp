/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.MenuBar;

import com.disfruta.bean.admin.Menu;
import com.disfruta.gestion.logistica.GestionProveedor;
import com.disfruta.view.admin.PanelPerfilUsuario;
import com.disfruta.view.admin.PanelUsuarios;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import resources.auxiliar.FechaActual;
import resources.auxiliar.toExcel;
import resources.tablemodel.ModelTableProveedor;

/**
 *
 * @author Juape
 */
public class MenuAdmin extends JMenuBar implements ActionListener {
    JMenu menu = null;
    JMenuItem item = null;
    JPanel panelctn;
    ArrayList<Menu> lista;

    public MenuAdmin(JPanel ctn, ArrayList<Menu> items) {
        panelctn = ctn;
        lista = items;
        for (int i = 0; i < lista.size(); i++) {
            Menu m = lista.get(i);
            System.out.println("tipo: "+m.getTipo());
            if (m.getTipo().equals("MENU")) {
                this.menu = new JMenu(m.getDescripcion());
                this.menu.setFont(new Font("Arial", Font.BOLD, 13));
                this.menu.setForeground(new Color(77, 77, 77));
                this.add(this.menu);
                configurarMenu(m.getNodo());
            }
        }

        this.setPreferredSize(new Dimension(400, 25));
        this.setOpaque(true);
    }

    private void configurarMenu(int padre) {
        for (int i = 0; i < this.lista.size(); i++) {
            Menu m = lista.get(i);
            if (m.getNodopadre() == padre && m.getTipo().equals("MENUITEM")) {
                this.item = new JMenuItem(m.getDescripcion());
                this.item.setActionCommand(m.getDescripcion());
                this.item.addActionListener(this);
                changedBackgroundJMenuItem(this.item);
                this.menu.add(this.item);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Empleados")) {
		PanelUsuarios pu; 
            try {
                pu = new PanelUsuarios();
                pu.setBounds(0,0,960,590);
                panelctn.removeAll();
                panelctn.add(pu);
                panelctn.updateUI();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }                
	}else if(e.getActionCommand().equals("Perfiles")){
            try {
                PanelPerfilUsuario pu=new PanelPerfilUsuario();
                pu.setBounds(0,0,960,590);
                panelctn.removeAll();
                panelctn.add(pu);            
                panelctn.updateUI();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getActionCommand().equals("Ingresos de almacen")){
                File file = new File("C:\\Users\\user\\Documents\\GitHub\\ProjectDisfrutapp\\disfrutapp\\src\\Reportes\\IngresosAlmacen.xls");
                toExcel.fillData(null,file);
        }
        else if(e.getActionCommand().equals("Proveedores")){
            try {
                File file = new File("C:\\Users\\user\\Documents\\GitHub\\ProjectDisfrutapp\\disfrutapp\\src\\Reportes\\Proveedores"+FechaActual.formatoMysql()+".xls");
                GestionProveedor gestionprov = new GestionProveedor();
                ModelTableProveedor modelTableProveedor=new ModelTableProveedor(gestionprov.listar());
                toExcel.fillData(modelTableProveedor,file);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(242, 242, 242));
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
    
    private void changedBackgroundJMenuItem(JMenuItem item){
        item.setBackground(new Color(242,242,242));
        item.setFocusPainted(false);
        item.setContentAreaFilled(false);
        item.setOpaque(true);
    }
    
}
