/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

import com.disfruta.bean.logistica.PresentacionPrecioVenta;
import com.disfruta.bean.logistica.ProductoCarta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Juape
 */
public class PanelProductoCartaItem extends JPanel {

    public JLabel nombre;
    public JLabel precio;
    public JComboBox presentacion;
    public JTextField cantidad;
    public JButton add;
    public JLabel total;
    public ArrayList<PresentacionPrecioVenta> listapresentaciones=null;
    public ProductoCarta productoSelected=null;
    public PresentacionPrecioVenta presentacionSelect=null;
    public double subtotal=0;
    public JPanel panel;
    public int idproducto=0;

    public PanelProductoCartaItem(final ProductoCarta producto) {
        this.panel=this;
        this.idproducto=producto.getIdproductocarta();
        this.listapresentaciones=producto.getPresentaciones();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(820, 45));
        this.setBackground(new Color(242, 242, 242));
        this.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        //label nombre
        this.nombre = new JLabel(producto.getNombre());
        this.nombre.setFont(new Font("Arial", Font.BOLD, 12));
        this.nombre.setBounds(10, 10, 350, 25);
        //label precio
        this.precio = new JLabel("0.00");
        this.precio.setForeground(new Color(149, 149, 149));
        this.precio.setFont(new Font("Arial", Font.BOLD, 12));
        this.precio.setBounds(390, 10, 80, 25);
        //combo presentacion
        this.presentacion = new JComboBox();
        this.presentacion.setModel(new resources.comboboxmodel.CboModelCartaPresentacion(this.listapresentaciones));
//        this.presentacion.setRenderer(new ListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                final JLabel renderer = new JLabel(value.toString());
//                if (isSelected) {
//                    renderer.setOpaque(true);
//                    renderer.setForeground(Color.white);
//                    renderer.setBackground(new Color(229, 147, 35));
//                    renderer.setFont(new Font("Arial", Font.BOLD, 12));
//                }
//                return renderer;
//            }
//        });
        this.presentacion.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int row=presentacion.getSelectedIndex();
                presentacionSelect=listapresentaciones.get(row);
                precio.setText(presentacionSelect.getPrecioventa()+"");
            }        
        });
        this.presentacion.setBounds(480, 10, 150, 25);
        this.presentacion.setBackground(new Color(255, 255, 255));
        this.presentacion.setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
        this.presentacion.setForeground(new Color(149, 149, 149));
        this.presentacion.setFont(new Font("Arial", Font.BOLD, 12));
        this.presentacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.presentacion.setFocusable(false);
        //cantidad 
        this.cantidad=new JTextField();
        this.cantidad.setBounds(640, 10,80,25);
        this.cantidad.setBorder(new LineBorder(new Color(230,230,230),1,true));
        this.cantidad.setForeground(new Color(149,149,149));
        this.cantidad.setFont(new Font("Arial",Font.BOLD, 12));
        this.cantidad.setHorizontalAlignment(JTextField.CENTER);
        //subtotal
        total=new JLabel("0.00");
        total.setForeground(new Color(149,149,149));
        total.setFont(new Font("Arial",Font.BOLD, 12));
        total.setBounds(790,10, 80,25);
        //boton agregar
        this.add=new JButton("+");
        this.add.setBounds(730, 10,45,25);
        this.add.setBackground(new Color(229,147,35));
        this.add.setForeground(new Color(255,255,255));
        this.add.setFont(new Font("Arial",Font.BOLD, 12));
        this.add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {  
                panel.setBorder(new LineBorder(new Color(254,190,119), 1, true));
                productoSelected=producto;
                if(!(cantidad.getText().equals(""))){
                    subtotal=Integer.parseInt(cantidad.getText())*Double.parseDouble(precio.getText());
                    total.setText(subtotal+"");
                }
            }            
        });
        
        //add components
        this.add(nombre);
        this.add(precio);
        this.add(presentacion);
        this.add(cantidad);
        this.add(add);
        this.add(total);
    }
}
