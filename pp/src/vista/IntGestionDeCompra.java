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
import javax.swing.table.DefaultTableModel;

import model.RoundedCornerBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.Cursor;

public class IntGestionDeCompra extends JInternalFrame {
	private JTextField textField;
	private String colorFondo="#ebf0f4";
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1=new DefaultTableModel();
	private JTable tblCompra;
	private JScrollPane scrollPane_1;
	private JTable tblProducto;
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
		
		getContentPane().setBounds(new Rectangle(0, 0, 1626, 832));
		model.addColumn("Tipo");
		model.addColumn("Serie");
		model.addColumn("Numero");
		model.addColumn("Fecha");
		model.addColumn("Proveedor");
		model.addColumn("Forma pago");
		model.addColumn("Vencimiento");
		model.addColumn("Estado");
		model.addColumn("Total");
		model.addColumn("Pagado");
		model.addColumn("Anulado");
		model.addColumn("Recibido");
		
		model1.addColumn("Codigo");
		model1.addColumn("Producto");
		model1.addColumn("Cantidad");
		model1.addColumn("Precio");
		model1.addColumn("Bruto");
		model1.addColumn("Descuento");
		model1.addColumn("Impuesto");
		model1.addColumn("Importe");
		
		
		
		
		
		setBounds(223, 79, 1626, 753);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1620, 720);
		panel.setBackground(Color.decode(colorFondo));
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Tipo de Documento");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(10, 42, 142, 14);
		panel.add(label);
		
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
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(20, 147, 225));
		panel_1.setBounds(1005, 18, 142, 41);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Nuevo");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				FrmRegistroCompra r=new FrmRegistroCompra();
				
				r.setVisible(true);
				r.setLocationRelativeTo(null);
			}
		});
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(253, 254, 254));
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		label_1.setBounds(50, 7, 83, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		label_2.setIcon(ico);
		label_2.setBounds(10, 7, 30, 27);
		panel_1.add(label_2);
		
		textField = new JTextField(10) {
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
		textField.setToolTipText("");
		textField.setBackground(new Color(239, 244, 249));
		textField.setBounds(1189, 21, 345, 38);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("");
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label_3.setIcon(ic);
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(1544, 21, 38, 38);
		panel.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 94, 1602, 345);
		panel.add(scrollPane);
		
		tblCompra = new JTable();
		scrollPane.setViewportView(tblCompra);
		tblCompra.getTableHeader().setOpaque(false);
		tblCompra.getTableHeader().setBackground(Color.decode("#005f80"));
		tblCompra.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblCompra.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblCompra.getTableHeader().setSize(WIDTH,100);
		tblCompra.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tblCompra.setModel(model);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 450, 1604, 225);
		panel.add(scrollPane_1);
		
		tblProducto = new JTable();
		scrollPane_1.setViewportView(tblProducto);
		
		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProducto.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblProducto.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProducto.getTableHeader().setSize(WIDTH,100);
		tblProducto.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		
		tblProducto.setModel(model1);
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox.setBounds(154, 36, 134, 26);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBox_1.setBounds(403, 36, 134, 26);
		panel.add(comboBox_1);
		
		JLabel label_4 = new JLabel("Periodo");
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_4.setBounds(321, 42, 94, 14);
		panel.add(label_4);
		
		

	}
}
