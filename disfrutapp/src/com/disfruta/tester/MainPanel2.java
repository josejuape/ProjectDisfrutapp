/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.tester;

import com.disfruta.gestion.admin.GestionMenu;
import static com.disfruta.tester.MainPanel.createAndShowGUI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.tree.*;


/**
 *
 * @author Juape
 */
public class MainPanel2 extends JPanel implements TreeSelectionListener {
    JTree tree;
    public MainPanel2() throws ClassNotFoundException, Exception {
        super(new BorderLayout());

       tree = new JTree();




//        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
//        Enumeration e = root.breadthFirstEnumeration();
//        while(e.hasMoreElements()) {
//            DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.nextElement();
//            Object o = node.getUserObject();
//            if(o instanceof String) {
//                node.setUserObject(new CheckBoxNode((String)o, Status.DESELECTED));
//            }
//        }

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");

        GestionMenu gm = new GestionMenu();
        ArrayList<com.disfruta.bean.admin.Menu> lista = gm.listar();

        for (com.disfruta.bean.admin.Menu menu : lista) {
            if (menu.getNodo() == menu.getNodopadre()) {
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
                String des = menu.getDescripcion();
                nodo.setUserObject(new CheckBoxNode(des, Status.DESELECTED));
                for (com.disfruta.bean.admin.Menu item : lista) {
                    if (item.getNodopadre() == menu.getNodo() && item.getNodo() != item.getNodopadre()) {
                        DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode();
                        String des2 = item.getDescripcion();
                        nodo1.setUserObject(new CheckBoxNode(des2, Status.DESELECTED));
                        nodo.add(nodo1);
                    }
                }
                raiz.add(nodo);
            }
        }
        DefaultTreeModel model = new DefaultTreeModel(raiz);
//        model.addTreeModelListener(new CheckBoxStatusUpdateListener());
//        
        tree.setModel(model);
        tree.getSelectionModel().addTreeSelectionListener(this);

        CheckTreeManager checkTreeManager = new CheckTreeManager(tree);
//        tree.setEditable(true);
//        tree.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
//
//        tree.expandRow(0);
        //tree.setToggleClickCount(1);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(new JScrollPane(tree));
        setPreferredSize(new Dimension(320, 240));

    }
    
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode nodoSeleccionado;
        nodoSeleccionado=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        String nodo=nodoSeleccionado.getUserObject().toString();
        System.out.println("nodo: "+nodo);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShowGUI();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void createAndShowGUI() throws ClassNotFoundException, Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //for(UIManager.LookAndFeelInfo laf: UIManager.getInstalledLookAndFeels())
            //  if("Nimbus".equals(laf.getName())) { UIManager.setLookAndFeel(laf.getClassName()); }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        JFrame frame = new JFrame("CheckBoxNodeEditor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    
}



class CheckTreeSelectionModel extends DefaultTreeSelectionModel {

    private TreeModel model;

    public CheckTreeSelectionModel(TreeModel model) {
        this.model = model;
        setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    }

    // tests whether there is any unselected node in the subtree of given path 
    public boolean isPartiallySelected(TreePath path) {
        if (isPathSelected(path, true)) {
            return false;
        }
        TreePath[] selectionPaths = getSelectionPaths();
        if (selectionPaths == null) {
            return false;
        }
        for (int j = 0; j < selectionPaths.length; j++) {
            if (isDescendant(selectionPaths[j], path)) {
                return true;
            }
        }
        return false;
    }

    // tells whether given path is selected. 
    // if dig is true, then a path is assumed to be selected, if 
    // one of its ancestor is selected. 
    public boolean isPathSelected(TreePath path, boolean dig) {
        if (!dig) {
            return super.isPathSelected(path);
        }
        while (path != null && !super.isPathSelected(path)) {
            path = path.getParentPath();
        }
        return path != null;
    }

    // is path1 descendant of path2 
    private boolean isDescendant(TreePath path1, TreePath path2) {
        Object obj1[] = path1.getPath();
        Object obj2[] = path2.getPath();
        for (int i = 0; i < obj2.length; i++) {
            if (obj1[i] != obj2[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setSelectionPaths(TreePath[] pPaths) {
        clearSelection(); 
        for(int i=0; i<pPaths.length; i++) 
            addSelectionPath(pPaths[i]); 
    }

    public void addSelectionPaths(TreePath[] paths) {
        // unselect all descendants of paths[] 
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            TreePath[] selectionPaths = getSelectionPaths();
            if (selectionPaths == null) {
                break;
            }
            ArrayList toBeRemoved = new ArrayList();
            for (int j = 0; j < selectionPaths.length; j++) {
                if (isDescendant(selectionPaths[j], path)) {
                    toBeRemoved.add(selectionPaths[j]);
                }
            }
            super.removeSelectionPaths((TreePath[]) toBeRemoved.toArray(new TreePath[0]));
        }

        // if all siblings are selected then unselect them and select parent recursively 
        // otherwize just select that path. 
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            TreePath temp = null;
            while (areSiblingsSelected(path)) {
                temp = path;
                if (path.getParentPath() == null) {
                    break;
                }
                path = path.getParentPath();
            }
            if (temp != null) {
                if (temp.getParentPath() != null) {
                    addSelectionPath(temp.getParentPath());
                } else {
                    if (!isSelectionEmpty()) {
                        removeSelectionPaths(getSelectionPaths());
                    }
                    super.addSelectionPaths(new TreePath[]{temp});
                }
            } else {
                super.addSelectionPaths(new TreePath[]{path});
            }
        }
    }

    // tells whether all siblings of given path are selected. 
    private boolean areSiblingsSelected(TreePath path) {
        TreePath parent = path.getParentPath();
        if (parent == null) {
            return true;
        }
        Object node = path.getLastPathComponent();
        Object parentNode = parent.getLastPathComponent();

        int childCount = model.getChildCount(parentNode);
        for (int i = 0; i < childCount; i++) {
            Object childNode = model.getChild(parentNode, i);
            if (childNode == node) {
                continue;
            }
            if (!isPathSelected(parent.pathByAddingChild(childNode))) {
                return false;
            }
        }
        return true;
    }

    public void removeSelectionPaths(TreePath[] paths) {
        for (int i = 0; i < paths.length; i++) {
            TreePath path = paths[i];
            if (path.getPathCount() == 1) {
                super.removeSelectionPaths(new TreePath[]{path});
            } else {
                toggleRemoveSelection(path);
            }
        }
    }

    // if any ancestor node of given path is selected then unselect it 
    //  and selection all its descendants except given path and descendants. 
    // otherwise just unselect the given path 
    private void toggleRemoveSelection(TreePath path) {
        Stack stack = new Stack();
        TreePath parent = path.getParentPath();
        while (parent != null && !isPathSelected(parent)) {
            stack.push(parent);
            parent = parent.getParentPath();
        }
        if (parent != null) {
            stack.push(parent);
        } else {
            super.removeSelectionPaths(new TreePath[]{path});
            return;
        }

        while (!stack.isEmpty()) {
            TreePath temp = (TreePath) stack.pop();
            TreePath peekPath = stack.isEmpty() ? path : (TreePath) stack.peek();
            Object node = temp.getLastPathComponent();
            Object peekNode = peekPath.getLastPathComponent();
            int childCount = model.getChildCount(node);
            for (int i = 0; i < childCount; i++) {
                Object childNode = model.getChild(node, i);
                if (childNode != peekNode) {
                    super.addSelectionPaths(new TreePath[]{temp.pathByAddingChild(childNode)});
                }
            }
        }
        super.removeSelectionPaths(new TreePath[]{parent});
    }
}

class CheckTreeCellRenderer extends JPanel implements TreeCellRenderer {

    private CheckTreeSelectionModel selectionModel;
    private TreeCellRenderer delegate;
    private TristateCheckBox checkBox = new TristateCheckBox();

    public CheckTreeCellRenderer(TreeCellRenderer delegate, CheckTreeSelectionModel selectionModel) {
        this.delegate = delegate;
        this.selectionModel = selectionModel;
        setLayout(new BorderLayout());
        setOpaque(false);
        checkBox.setOpaque(false);
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component renderer = delegate.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            if (selectionModel.isPathSelected(path, true)) {
                checkBox.setState(TristateCheckBox.SELECTED);
            } else {
                checkBox.setState(selectionModel.isPartiallySelected(path) ? null : TristateCheckBox.NOT_SELECTED);
            }
        }
        removeAll();
        add(checkBox, BorderLayout.WEST);
        add(renderer, BorderLayout.CENTER);
        return this;
    }
}

class CheckTreeManager extends MouseAdapter implements TreeSelectionListener {

    private CheckTreeSelectionModel selectionModel;
    private JTree tree = new JTree();
    int hotspot = new JCheckBox().getPreferredSize().width;

    public CheckTreeManager(JTree tree) {
        this.tree = tree;
        selectionModel = new CheckTreeSelectionModel(tree.getModel());
        tree.setCellRenderer(new CheckTreeCellRenderer(tree.getCellRenderer(), selectionModel));
        tree.addMouseListener(this);
        selectionModel.addTreeSelectionListener(this);
    }

    public void mouseClicked(MouseEvent me) {
        TreePath path = tree.getPathForLocation(me.getX(), me.getY());
        if (path == null) {
            return;
        }
        if (me.getX() > tree.getPathBounds(path).x + hotspot) {
            return;
        }

        boolean selected = selectionModel.isPathSelected(path, true);
        selectionModel.removeTreeSelectionListener(this);

        try {
            if (selected) {
                selectionModel.removeSelectionPath(path);
            } else {
                selectionModel.addSelectionPath(path);
            }
        } finally {
            selectionModel.addTreeSelectionListener(this);
            tree.treeDidChange();
        }
    }

    public CheckTreeSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void valueChanged(TreeSelectionEvent e) {
        tree.treeDidChange();
    }
}

class TristateCheckBox extends JCheckBox {

    /**
     * This is a type-safe enumerated type
     */
    public static class State {

        private State() {
        }
    }
    public static final State NOT_SELECTED = new State();
    public static final State SELECTED = new State();
    public static final State DONT_CARE = new State();
    private final TristateDecorator model;

    public TristateCheckBox(String text, Icon icon, State initial) {
        super(text, icon);
        // Add a listener for when the mouse is pressed
        super.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                grabFocus();
                model.nextState();
            }
        });
        // Reset the keyboard action map
        ActionMap map = new ActionMapUIResource();
        map.put("pressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                grabFocus();
                model.nextState();
            }
        });
        map.put("released", null);
        SwingUtilities.replaceUIActionMap(this, map);
        // set the model to the adapted model
        model = new TristateDecorator(getModel());
        setModel(model);
        setState(initial);
    }

    public TristateCheckBox(String text, State initial) {
        this(text, null, initial);
    }

    public TristateCheckBox(String text) {
        this(text, DONT_CARE);
    }

    public TristateCheckBox() {
        this(null);
    }

    /**
     * No one may add mouse listeners, not even Swing!
     */
    @Override
    public void addMouseListener(MouseListener l) {
    }

    /**
     * Set the new state to either SELECTED, NOT_SELECTED or DONT_CARE. If state
     * == null, it is treated as DONT_CARE.
     */
    public void setState(State state) {
        model.setState(state);
    }

    /**
     * Return the current state, which is determined by the selection status of
     * the model.
     */
    public State getState() {
        return model.getState();
    }

    @Override
    public void setSelected(boolean b) {
        if (b) {
            setState(SELECTED);
        } else {
            setState(NOT_SELECTED);
        }
    }

    /**
     * Exactly which Design Pattern is this? Is it an Adapter, a Proxy or a
     * Decorator? In this case, my vote lies with the Decorator, because we are
     * extending functionality and "decorating" the original model with a more
     * powerful model.
     */
    private class TristateDecorator implements ButtonModel {

        private final ButtonModel other;

        private TristateDecorator(ButtonModel other) {
            this.other = other;
        }

        private void setState(State state) {
            if (state == NOT_SELECTED) {
                other.setArmed(false);
                setPressed(false);
                setSelected(false);
            } else if (state == SELECTED) {
                other.setArmed(false);
                setPressed(false);
                setSelected(true);
            } else { // either "null" or DONT_CARE
                other.setArmed(true);
                setPressed(true);
                setSelected(true);
            }
        }

        /**
         * The current state is embedded in the selection / armed state of the
         * model.
         *
         * We return the SELECTED state when the checkbox is selected but not
         * armed, DONT_CARE state when the checkbox is selected and armed (grey)
         * and NOT_SELECTED when the checkbox is deselected.
         */
        private State getState() {
            if (isSelected() && !isArmed()) {
                // normal black tick
                return SELECTED;
            } else if (isSelected() && isArmed()) {
                // don't care grey tick
                return DONT_CARE;
            } else {
                // normal deselected
                return NOT_SELECTED;
            }
        }

        /**
         * We rotate between NOT_SELECTED, SELECTED and DONT_CARE.
         */
        private void nextState() {
            State current = getState();
            if (current == NOT_SELECTED) {
                setState(SELECTED);
            } else if (current == SELECTED) {
                setState(DONT_CARE);
            } else if (current == DONT_CARE) {
                setState(NOT_SELECTED);
            }
        }

        /**
         * Filter: No one may change the armed status except us.
         */
        @Override
        public void setArmed(boolean b) {
        }

        /**
         * We disable focusing on the component when it is not enabled.
         */
        @Override
        public void setEnabled(boolean b) {
            setFocusable(b);
            other.setEnabled(b);
        }

        /**
         * All these methods simply delegate to the "other" model that is being
         * decorated.
         */
        @Override
        public boolean isArmed() {
            return other.isArmed();
        }

        @Override
        public boolean isSelected() {
            return other.isSelected();
        }

        @Override
        public boolean isEnabled() {
            return other.isEnabled();
        }

        @Override
        public boolean isPressed() {
            return other.isPressed();
        }

        @Override
        public boolean isRollover() {
            return other.isRollover();
        }

        @Override
        public void setSelected(boolean b) {
            other.setSelected(b);
        }

        @Override
        public void setPressed(boolean b) {
            other.setPressed(b);
        }

        @Override
        public void setRollover(boolean b) {
            other.setRollover(b);
        }

        @Override
        public void setMnemonic(int key) {
            other.setMnemonic(key);
        }

        @Override
        public int getMnemonic() {
            return other.getMnemonic();
        }

        @Override
        public void setActionCommand(String s) {
            other.setActionCommand(s);
        }

        @Override
        public String getActionCommand() {
            return other.getActionCommand();
        }

        @Override
        public void setGroup(ButtonGroup group) {
            other.setGroup(group);
        }

        @Override
        public void addActionListener(ActionListener l) {
            other.addActionListener(l);
        }

        @Override
        public void removeActionListener(ActionListener l) {
            other.removeActionListener(l);
        }

        @Override
        public void addItemListener(ItemListener l) {
            other.addItemListener(l);
        }

        @Override
        public void removeItemListener(ItemListener l) {
            other.removeItemListener(l);
        }

        @Override
        public void addChangeListener(ChangeListener l) {
            other.addChangeListener(l);
        }

        @Override
        public void removeChangeListener(ChangeListener l) {
            other.removeChangeListener(l);
        }

        @Override
        public Object[] getSelectedObjects() {
            return other.getSelectedObjects();
        }
    }
}