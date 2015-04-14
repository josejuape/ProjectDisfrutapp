/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.auxiliar;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author user
 */
public class toExcel {

    public static void fillData(AbstractTableModel model, File file) {
        try {
            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
//            ModelTableProveedor model = (ModelTableProveedor) table.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                            model.getValueAt(i, j).toString());
                    sheet1.addCell(row);
                }
            }
            workbook1.write();
            workbook1.close();
            
            System.out.println("Escribiendo en disco....Listo");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error creando archivo Excel.");
        }
    }
}
