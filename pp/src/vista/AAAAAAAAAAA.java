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
import model.Celda_CheckBox;
import model.Empleados;
import model.Producto;
import model.Render_CheckBox;
import model.Tabla_Reutilizable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AAAAAAAAAAA extends JDialog {
	private JTable tblPrueba;
	DefaultTableModel model=new DefaultTableModel();
	private JButton btnEnviar;
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
		setBounds(100, 100, 450, 335);
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
	
		model.setDataVector(new Object[][] {
		        { false, "Juan Perez", "12", "Hombre" },
		        { false, "Homero J. Simpsons", "40", "Hombre" },
		        { true, "Ned Flanders", "35", "Hombre" },
		        { true, "Asuka Langley", "15", "Si gracias" },
		        { false, "Rei Ayanami", "16", "Mujer" },
		        { true, "shinji ikari", "15", "No se sabe" } }, new Object[] {
		        "CheckBox", "Nombre", "Edad", "Sexo" });
		
		
		
		tblPrueba.setModel(model);
		tblPrueba.getColumnModel().getColumn( 0 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
		tblPrueba.getColumnModel().getColumn( 0 ).setCellRenderer(new Render_CheckBox());
 
		
		scrollPane.setViewportView(tblPrueba);
		
		btnEnviar = new JButton("enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(int i=0;i<tblPrueba.getRowCount();i++) {
					boolean valor=Boolean.parseBoolean(tblPrueba.getValueAt(i, 0).toString());
					System.out.println(	valor);
				}

				
			}
		});
		btnEnviar.setBounds(39, 261, 89, 23);
		getContentPane().add(btnEnviar);
		
		
		
	

		

	}
}
