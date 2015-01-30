/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.jdesktop.swingx.HorizontalLayout;

/**
 *
 * @author Administrador
 */
public class BeanTreeRenderer extends DefaultTreeCellRenderer {

    private JCheckBox chk_nodo;
    private JLabel lbl_nodo;
    private JPanel pnl_nodo;
    private final Font orgFont;
    private final Font boldFont;
    private TreeEntryBean te;
    
    public BeanTreeRenderer() {
        lbl_nodo = new JLabel();
        lbl_nodo.setBackground(null);
        lbl_nodo.setFont(UIManager.getFont("Tree.font"));
        orgFont = lbl_nodo.getFont();
        boldFont = lbl_nodo.getFont().deriveFont(lbl_nodo.getFont().getStyle() ^ Font.BOLD);
        chk_nodo = new JCheckBox();
        //chk_nodo.setBackground(null);
        //orgFont = chk_nodo.getFont();
        //boldFont = chk_nodo.getFont().deriveFont(chk_nodo.getFont().getStyle() ^ Font.BOLD);
        chk_nodo.setBackground(UIManager.getColor("Tree.background"));
        //chk_nodo.setBackground(null);
        chk_nodo.setBorder(null);
        pnl_nodo = new JPanel(new HorizontalLayout());
        //pnl_nodo=new JPanel();
        pnl_nodo.setOpaque(false);
        pnl_nodo.add(chk_nodo);
        pnl_nodo.add(lbl_nodo);
    }
    

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        te = (TreeEntryBean) value;
        MenuDinamico beanMenu=(MenuDinamico)te.getBean();
        lbl_nodo.setText(te.getTitulo());
        lbl_nodo.setToolTipText(te.getTitulo());
        lbl_nodo.setIcon(UIManager.getIcon("Tree.closedIcon"));
        //System.out.println(beanMenu.getVisible());
        //chk_nodo.setText(te.getTitulo());
        chk_nodo.setSelected(beanMenu.getVisible().equals("S"));
        /*if (sel) {
            lbl_nodo.setFont(boldFont);
        } else {
            lbl_nodo.setFont(orgFont);
        }*/
        //label.setPreferredSize(new Dimension(200, 20));
        return pnl_nodo;
        //return chk_nodo;
    }

    public TreeEntryBean getTe() {
        return te;
    }

    public void setTe(TreeEntryBean te) {
        this.te = te;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }
}
