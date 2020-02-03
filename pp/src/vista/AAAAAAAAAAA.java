package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionEmpledos;
import mantenimientos.GestionProductos;
import model.Empleados;
import model.Producto;
import model.Tabla_Reutilizable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AAAAAAAAAAA extends JDialog {
	private JTable tblPrueba;
	DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AAAAAAAAAAA dialog = new AAAAAAAAAAA();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AAAAAAAAAAA() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 393, 225);
		getContentPane().add(scrollPane);
		
		model.addColumn("a");
		model.addColumn("b");
		model.addColumn("c");
		model.addColumn("d");
		model.addColumn("e");
		model.addColumn("e");
		model.addColumn("e");
		model.addColumn("e");
		tblPrueba = new JTable();
		tblPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int column = tblPrueba.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblPrueba.getRowHeight();
			        
			        if(row < tblPrueba.getRowCount() && row >= 0 && column < tblPrueba.getColumnCount() && column >= 0){
			            Object value = tblPrueba.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("m")){
			                	
			                
			                	JOptionPane.showMessageDialog(null, "modifico");
			                  
			                }
			                if(boton.getName().equals("e")){
			                	JOptionPane.showMessageDialog(null, "elimino");
			    				
			                   
			                }
			            }
			          /*  if(value instanceof JCheckBox){
			                //((JCheckBox)value).doClick();
			                JCheckBox ch = (JCheckBox)value;
			                if(ch.isSelected()==true){
			                    ch.setSelected(false);
			                }
			                if(ch.isSelected()==false){
			                    ch.setSelected(true);
			                }
			                
			            }*/
			        }
			        
			}
		});
		scrollPane.setViewportView(tblPrueba);
		
		
		
	ArrayList<DefaultTableModel>lista=new ArrayList<>();
		lista.add(model);
		
		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> listado = gc.listado();
		
		Tabla_Reutilizable t=new Tabla_Reutilizable();
		t.ver_tabla(tblPrueba, lista, model.getColumnCount());
		t.listar(listado);
	}

}
