/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.MenuBar;

import com.disfruta.bean.admin.Menu;
import com.disfruta.view.logistica.PanelAlmacen;
import com.disfruta.view.logistica.PanelProductoCarta;
import com.disfruta.view.logistica.PanelProductoInsumo;
import com.disfruta.view.logistica.PanelProveedor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Juape
 */
public class MenuLogistica extends JMenuBar implements ActionListener {

    JMenu menu = null;
    JMenuItem item = null;
    JPanel panelctn;
    ArrayList<Menu> lista;

    public MenuLogistica(JPanel ctn, ArrayList<Menu> items) {
        panelctn = ctn;
        lista = items;
        for (int i = 0; i < lista.size(); i++) {
            Menu m = lista.get(i);
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
        if (e.getActionCommand().equals("Almacen")) {
            PanelAlmacen pu = new PanelAlmacen();
            panelctn.removeAll();
            panelctn.add(pu);
            panelctn.updateUI();
        } else if (e.getActionCommand().equals("Insumo")) {
            PanelProductoInsumo pp = new PanelProductoInsumo();
            panelctn.removeAll();
            panelctn.add(pp);
            panelctn.updateUI();
        } else if (e.getActionCommand().equals("Proveedor")) {
            PanelProveedor prov = new PanelProveedor();
            panelctn.removeAll();
            panelctn.add(prov);
            panelctn.updateUI();
        }
        if (e.getActionCommand().equals("Producto carta")) {
            PanelProductoCarta form = new PanelProductoCarta();
            panelctn.removeAll();
            panelctn.add(form);
            panelctn.updateUI();
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
