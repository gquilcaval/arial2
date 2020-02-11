package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.axis.StandardTickUnitSource;
import org.jfree.layout.CenterLayout;
import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimientos.GestionEmpledos;

public class Tabla_Reutilizable {

	static JButton btn1;
	static JButton btn2;
	
	
	public static DefaultTableModel model;
	
public void ver_tabla(JTable tabla,ArrayList<DefaultTableModel>models,int longitud ){
	model=new DefaultTableModel();
	 model.setColumnCount(0);
	 model.setRowCount(0);
        tabla.setDefaultRenderer(Object.class, new Render());
        
  
         btn1 = new JButton("");
        ImageIcon edit = new ImageIcon(getClass().getResource("/img/editar.png"));
    	Image im = edit.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ico = new ImageIcon(im);
    	btn1.setIcon(ico);
        btn1.setName("m");
        
        
         btn2 = new JButton();
        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
    	Image ia = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ic = new ImageIcon(ia);
    	btn2.setIcon(ic);
        btn2.setName("e");
        
        
    
    
             model.isCellEditable(0,0);
       
        for(int i=0;i<longitud;i++) {
        	model.addColumn(models.get(0).getColumnName(i));
        	System.out.println(models.get(0).getColumnName(i));
        }

        tabla.setModel(model);
	
		
		
        tabla.setRowHeight(30);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
       

    }


public static  void listar(ArrayList<Producto> lista) {
   
	
	
	
	for (Producto cl : lista) {
		Object datos[] = {cl.getCodbarra(),cl.getDescripcion(),cl.getStock(),cl.getPrecioProCom() ,cl.getPrecioProVen(),cl.getCodregistrosani(),btn1,btn2 };

		model.addRow(datos);

	}
}

public static void listarFinanzas() {
	
}
	

public static  void listarCaja(ArrayList<Caja> listado) {
   
	
	
	
	for (Caja cl : listado) {
		Object datos[] = {cl.getCodCaja(),cl.getNomCaja(),btn1,btn2 };

		model.addRow(datos);

	}
}
public void setBox(JTable tabla ,TableColumn column) {
	column.setCellEditor(new JDateChooserEditor(new JCheckBox()));
	DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
	column.setCellRenderer(renderer);

	

	
}

}

