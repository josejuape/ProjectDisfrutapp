/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.TreeCellEditor;

/**
 *
 * @author Wilfo
 */
public class EditorTree extends AbstractCellEditor
        implements TreeCellEditor, ActionListener {

    private JCheckBox chk_nodo;
    private JLabel lbl_nodo;
    private JTextField txt_nodo;
    //Plantilla clsPlantilla;  
    private TreeEntryBean te;
    private MenuDinamico beanmenu;
    private JComponent editedComponent;
    private JPanel pnl_nodo;

    public EditorTree() {
        chk_nodo = new JCheckBox();
        chk_nodo.addActionListener(this);
        chk_nodo.setBackground(UIManager.getColor("Tree.background"));
        chk_nodo.setBorder(null);
        lbl_nodo = new JLabel();
        lbl_nodo.setFont(UIManager.getFont("Tree.font"));
        txt_nodo = new JTextField();
        txt_nodo.setEnabled(false);
        txt_nodo.addActionListener(this);
        txt_nodo.setBackground(UIManager.getColor("Tree.background"));
        txt_nodo.setBorder(null);
        pnl_nodo = new JPanel();
        pnl_nodo.setOpaque(false);
        pnl_nodo.add(chk_nodo);
        pnl_nodo.add(lbl_nodo);
        pnl_nodo.add(txt_nodo);
    }

    @Override
    public Object getCellEditorValue() {
        /*if (editedComponent == textField) {
            clsPlantilla.setNombre(textField.getText());
        } else {
            clsPlantilla.setValor(check.isSelected());
        }*/
        //return clsPlantilla;  
        if (editedComponent == chk_nodo) {
            beanmenu.setVisible(chk_nodo.isSelected()?"S":"N");
            te.setBean(beanmenu);
        }
        return te;
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        /*DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        clsPlantilla = (Plantilla) node.getUserObject();*/
        te = (TreeEntryBean) value;
        beanmenu=(MenuDinamico)te.getBean();
        chk_nodo.setSelected(beanmenu.getVisible().equals("S"));
        lbl_nodo.setIcon(UIManager.getIcon("Tree.openedIcon"));
        txt_nodo.setText(beanmenu.getDescripcion());
        //return panel;
        return pnl_nodo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editedComponent = (JComponent) e.getSource();
        super.stopCellEditing();
    }
}
