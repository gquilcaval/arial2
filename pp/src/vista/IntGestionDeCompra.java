package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCompra;
import mantenimientos.GestionProveedor;
import model.DetalleCompra;
import model.OrdenRegistroCompra;
import model.Proveedores;
import model.RoundedCornerBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IntGestionDeCompra extends JInternalFrame {
	private JTextField txtBusquedad;
	private String colorFondo = "#ebf0f4";
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	private JTable tblCompra;
	private JScrollPane scrollPane_1;
	private JTable tblProducto;
	private JComboBox cboFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionDeCompra frame = new IntGestionDeCompra();
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
	public IntGestionDeCompra() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				listadoRegistroCompra();
			}
		});

		getContentPane().setBounds(new Rectangle(0, 0, 1626, 832));
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Codigo Registro Compra");
		model.addColumn("Tipo");
		model.addColumn("Serie");
		model.addColumn("Numero");
		model.addColumn("Fecha Registro");
		model.addColumn("Proveedor");
		model.addColumn("Forma pago");
		model.addColumn("Vencimiento");
		model.addColumn("Estado");
		model.addColumn("Total");
		model.addColumn("Pagado");
		model.addColumn("Anulado");
		model.addColumn("Recibido");

		model1.setRowCount(0);
		model1.setColumnCount(0);
		model1.addColumn("Codigo");
		model1.addColumn("Producto");
		model1.addColumn("Cantidad");
		model1.addColumn("Precio");
		model1.addColumn("Bruto");
		model1.addColumn("Descuento");
		model1.addColumn("Impuesto");
		model1.addColumn("Importe");

		setBounds(223, 79, 1626, 811);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1610, 781);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmRegistroCompra r = new FrmRegistroCompra();

				r.setVisible(true);
				r.setLocationRelativeTo(null);
			}
		});
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(20, 147, 225));
		panel_1.setBounds(726, 18, 142, 41);
		panel.add(panel_1);

		JLabel lblNuevo = new JLabel("NUEVO");

		lblNuevo.setVerticalAlignment(SwingConstants.TOP);
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setForeground(new Color(253, 254, 254));
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNuevo.setBounds(50, 7, 83, 30);
		panel_1.add(lblNuevo);

		JLabel label_2 = new JLabel("");
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		label_2.setIcon(ico);
		label_2.setBounds(10, 7, 30, 27);
		panel_1.add(label_2);

		txtBusquedad = new JTextField(10) {
			protected void paintComponent(Graphics g) {

				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);

			}

			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		txtBusquedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				String nombre = txtBusquedad.getText();
				String filtro = (String)cboFiltro.getSelectedItem();
			
				ArrayList<OrdenRegistroCompra> lista = null;

			

					GestionCompra gc = new GestionCompra();
					model.getDataVector().removeAllElements();
					lista = gc.listadoXFiltro(filtro,nombre);
					for (OrdenRegistroCompra cl : lista) {
						Object o[] = { cl.getCodigo(), cl.getComprovante(), "", cl.getNroOrdenCompra(), cl.getFechaRegisCom(),
								cl.getNomProveedor(), cl.getFormaPago(), cl.getFechaVenCom(), "", cl.getTotal() };
						model.addRow(o);

					
					
					
				}

				
			}
		});
		txtBusquedad.setToolTipText("");
		txtBusquedad.setBackground(new Color(239, 244, 249));
		txtBusquedad.setBounds(1168, 21, 345, 38);
		panel.add(txtBusquedad);

		JLabel label_3 = new JLabel("");
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label_3.setIcon(ic);
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(1523, 21, 38, 38);
		panel.add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 94, 1517, 345);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPane);

		tblCompra = new JTable();
		tblCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				model1.setRowCount(0);

				int fila = tblCompra.getSelectedRow();

				int codigo = Integer.parseInt(tblCompra.getValueAt(fila, 0).toString());

				ArrayList<OrdenRegistroCompra> lista = new GestionCompra().listadoXcodigoRegisCompra(codigo);

				for (OrdenRegistroCompra cl : lista) {

					/* precio bruto cantidad*precio */
					int cantidad = lista.get(0).getCantidad();
					double precio = lista.get(0).getPrecio();
					double precioBruto = cantidad * precio;
					double impuesto = precioBruto * 0.18;
					double total = precioBruto + impuesto;
					Object o[] = { cl.getCodPro(), cl.getNomPro(), cl.getCantidad(), cl.getPrecio(), precioBruto, 0,
							impuesto, total };
					model1.addRow(o);
				}

			}
		});
		scrollPane.setViewportView(tblCompra);
		tblCompra.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tblCompra.getTableHeader().setOpaque(false);
		tblCompra.getTableHeader().setBackground(Color.decode("#005f80"));
		tblCompra.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		tblCompra.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblCompra.getTableHeader().setSize(WIDTH, 100);
		tblCompra.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tblCompra.setRowHeight(30);
		tblCompra.setDefaultRenderer(Object.class, new FormatoTabla());
		tblCompra.setForeground(Color.decode("#39393C"));
		tblCompra.setModel(model);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 484, 1517, 225);
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPane_1);

		tblProducto = new JTable();
		tblProducto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane_1.setViewportView(tblProducto);

		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProducto.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		tblProducto.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProducto.getTableHeader().setSize(WIDTH, 100);
		tblProducto.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tblProducto.setRowHeight(30);
		tblProducto.setDefaultRenderer(Object.class, new FormatoTabla());
		tblProducto.setForeground(Color.decode("#39393C"));
		tblProducto.setModel(model1);

		JLabel lblNewLabel = new JLabel("FILTRO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNewLabel.setBounds(945, 21, 65, 38);
		panel.add(lblNewLabel);

		cboFiltro = new JComboBox();
		cboFiltro.setOpaque(false);
		cboFiltro.setBackground(Color.WHITE);
		cboFiltro.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONA", "TIPO DOCUMENTO", "PERIODO" }));
		cboFiltro.setBounds(1020, 21, 138, 38);
		cboFiltro.setUI(CustomUI.createUI(this));
		panel.add(cboFiltro);

	}

	void listadoRegistroCompra() {

		ArrayList<OrdenRegistroCompra> lista = new GestionCompra().listadoRegistroCompra();

		for (OrdenRegistroCompra cl : lista) {

			Object o[] = { cl.getCodigo(), cl.getComprovante(), "", cl.getNroOrdenCompra(), cl.getFechaRegisCom(),
					cl.getNomProveedor(), cl.getFormaPago(), cl.getFechaVenCom(), "", cl.getTotal() };
			model.addRow(o);
		}

	}
}
