package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.print.DocFlavor.URL;
import javax.print.attribute.IntegerSyntax;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.table.DefaultTableModel;

import model.Clientes;
import model.RoundedCornerBorder;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


import mantenimientos.GestionClientes;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;

public class IntCliente extends JInternalFrame {
	DefaultTableModel model = new DefaultTableModel();
	private JDesktopPane dk;
	private JPanel panel;
	private JLabel label;
	private JLabel lblNuevo;
	private JLabel lblExcel;
	private JTextField txtBusqueda;
	private JLabel lblIconSearch;
	private JScrollPane scrollPane;
	private JTable tblClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCliente frame = new IntCliente();
					frame.setVisible(true);
					
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntCliente() {
		
		
		addInternalFrameListener(new InternalFrameAdapter() {
			  @Override
			  public void internalFrameActivated(InternalFrameEvent arg0) {
			   listar();
			  }
			 });
		listar();
		setBorder(null);
		setBounds(100, 100, 1626, 832);
		getContentPane().setLayout(null);

		dk = new JDesktopPane();
		dk.setBackground(Color.decode("#EFF4F9"));
		;
		dk.setBounds(0, 0, 1626, 701);
		getContentPane().add(dk);
		dk.setLayout(null);

		/* TABLA */
		model.addColumn("Tipo Persona");
		model.addColumn("Forma Pago");
		model.addColumn("Doc");
		model.addColumn("N.Documento");
		model.addColumn("Nombre/RazonSocial");
		model.addColumn("Nombre Comercial");
		/* model.addColumn("Pendiente Pago"); */
		model.addColumn("Direccion");
		model.addColumn("Departamento");
		model.addColumn("Distrito");
		model.addColumn("N.Telefono");
		model.addColumn("Celular");
		model.addColumn("Estado");
		model.addColumn("Correo");

		/*-------*/
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(1446, 11, 142, 41);
		panel.setBackground(Color.decode("#1493e1"));

		dk.add(panel);
		panel.setLayout(null);

		label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setBounds(20, 7, 25, 25);
		panel.add(label);

		lblNuevo = new JLabel("Nuevo");
		lblNuevo.setVerticalAlignment(SwingConstants.TOP);
		lblNuevo.setForeground(Color.decode("#FDFEFE"));
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setBounds(50, 7, 83, 30);
		panel.add(lblNuevo);

		lblExcel = new JLabel("");
		lblExcel.setBounds(92, 11, 45, 45);
		ImageIcon iconExecel = new ImageIcon(getClass().getResource("/iconos/exel.png"));
		Image imgEsca = iconExecel.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		Icon iconoEscalados = new ImageIcon(imgEsca);
		lblExcel.setIcon(iconoEscalados);
		dk.add(lblExcel);

		/*
		 * -------------------- BUSCADOR CON BORDE REDONDEADO (CLASE
		 * ROUNDEDCORNERBORDER) ----------------------
		 */
		txtBusqueda = new JTextField(20) {
			@Override
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		txtBusqueda.setBounds(923, 11, 345, 38);
		/*
		 * -----------------------------------------------------------------------------
		 * -
		 */

		txtBusqueda.setBackground(Color.decode("#EFF4F9"));
		txtBusqueda.setToolTipText("");
		dk.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		lblIconSearch = new JLabel("");
		lblIconSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconSearch.setBounds(1278, 11, 38, 38);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		lblIconSearch.setIcon(ic);
		dk.add(lblIconSearch);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 84, 1496, 606);
		dk.add(scrollPane);
		tblClientes = new JTable();
	
		tblClientes.setRowHeight(25);
		tblClientes.setIntercellSpacing(new Dimension(1, 3));
		tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblClientes.setGridColor(Color.LIGHT_GRAY);
		tblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		tblClientes.getTableHeader().setOpaque(false);
		tblClientes.getTableHeader().setBackground(Color.decode("#005f80"));
		tblClientes.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblClientes.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblClientes.getTableHeader().setSize(WIDTH,100);
		tblClientes.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		
		scrollPane.setViewportView(tblClientes);
		 tblClientes.setModel(model);

	}

	void imagenScalada() {

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/informatica.gif"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
				Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
	}

	void listar() {
		GestionClientes gc = new GestionClientes();
		ArrayList<Clientes> lista = gc.listado();
		model.getDataVector().removeAllElements();
		
		for (Clientes cl : lista) {
			Object datos[] = {  cl.getTip_persona_cli(),cl.getFormaPago_cli(),  cl.getTip_doc_cli(),
					cl.getNum_doc_cli_(),cl.getNum_doc_cli_(),cl.getNomb_cli(),cl.getNom_comercial(),cl.getDirec_cli(),cl.getDepartamento_cli()
					,cl.getDistrito_cli(),cl.getTelf_cli(),cl.getCelular(),cl.getEstado(),cl.getCorreo() };

			model.addRow(datos);

		}
		
	}
}