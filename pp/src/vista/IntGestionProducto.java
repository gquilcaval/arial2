package vista;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import mantenimientos.GestionClientes;
import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;
import model.Clientes;
import model.Producto;

import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.LineNumberInputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;

public class IntGestionProducto extends JInternalFrame {
	private JTextField txtBuscqueda;
	private String colorLetra="#000000";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionProducto frame = new IntGestionProducto();
					frame.setVisible(true);
					IntGestionProducto a=new IntGestionProducto();
					a.listar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox comboBox;
	private JTable tblProductos;
	
	
	
	public IntGestionProducto() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		/*---------------------------------- > QUITAR BORDES DEL JINTERNALFRAME <--------------------*/
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*---------------------------------------------------------------------------------------*/
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				listar();
			}
		});
		

		

		model.addColumn("linea");
		model.addColumn("Descripcion");
		model.addColumn("con lote");
		model.addColumn("stock");
		model.addColumn("U/M");
		model.addColumn("Moneda");
		model.addColumn("Precio Compra");
		model.addColumn("Precio Lista");
		model.addColumn("R.S.");
		model.addColumn("marca");
		model.addColumn("Codigo barra");
		model.addColumn("Codigo registro sanitario");
		
		
		
		
		setTitle("Gestion Productos");
		setBounds(100, 100, 1626, 731);
		getContentPane().setLayout(null);
		
		txtBuscqueda = new JTextField();
		txtBuscqueda.setName("");
		txtBuscqueda.setToolTipText("");
		txtBuscqueda.setBounds(1341, 35, 158, 20);
		getContentPane().add(txtBuscqueda);
		txtBuscqueda.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 93, 1496, 529);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setRowHeight(24);
		
		tblProductos.getTableHeader().setOpaque(false);
		tblProductos.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProductos.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblProductos.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProductos.getTableHeader().setSize(WIDTH,100);
		tblProductos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		
		tblProductos.setModel(model);
		scrollPane.setViewportView(tblProductos);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAo.setBounds(50, 34, 44, 20);
		getContentPane().add(lblAo);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox.setForeground(Color.decode(colorLetra));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015"}));
		

		comboBox.setUI(CustomUI.createUI(this));

		comboBox.setBounds(104, 30, 134, 26);
		getContentPane().add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTipo.setBounds(275, 34, 44, 20);
		getContentPane().add(lblTipo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bien", "Servicio"}));
		comboBox_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox_1.setForeground(Color.decode(colorLetra));
		comboBox_1.setUI(CustomUI.createUI(this));
		comboBox_1.setBounds(327, 29, 134, 26);
		getContentPane().add(comboBox_1);
		
		JLabel lblCategoria_1 = new JLabel("Categoria");
		lblCategoria_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCategoria_1.setBounds(533, 32, 81, 20);
		getContentPane().add(lblCategoria_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		comboBox_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox_2.setForeground(Color.decode(colorLetra));
		comboBox_2.setBounds(609, 29, 134, 26);
		comboBox_2.setUI(CustomUI.createUI(this));
		getContentPane().add(comboBox_2);
		
		JLabel lblLinea = new JLabel("Linea");
		lblLinea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLinea.setBounds(785, 35, 81, 20);
		getContentPane().add(lblLinea);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		comboBox_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox_3.setForeground(Color.decode(colorLetra));
		comboBox_3.setUI(CustomUI.createUI(this));
		comboBox_3.setBounds(839, 30, 134, 26);
		getContentPane().add(comboBox_3);
		
		JLabel label = new JLabel("Linea");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(1028, 33, 81, 20);
		getContentPane().add(label);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		comboBox_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox_4.setForeground(Color.decode(colorLetra));
		comboBox_4.setUI(CustomUI.createUI(this));
		comboBox_4.setBounds(1078, 30, 134, 26);
		getContentPane().add(comboBox_4);
		
	}
	
	 void listar() {
		
		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> lista = gc.listado();
		model.getDataVector().removeAllElements();
		
		for (Producto cl : lista) {
			Object datos[] = { cl.getCodigo(),cl.getIdproveedor(), cl.getDescripcion(), cl.getStock(),cl.getMarca(), cl.getPrecioProCompra(),cl.getPrecioProLista()
					,cl.getIdcategoria(),cl.getCodbarra(),cl.getCodregistrosani() };

			model.addRow(datos);

		}
		
	}
}
