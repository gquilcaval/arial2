package vista;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Clientes;
import model.Compra;
import model.OrdenCompra;
import model.RoundedCornerBorder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.rollover.TableRolloverController;

import mantenimientos.GestionCompra;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntGestionOrdenDeCompra extends JInternalFrame {
	
	private JTextField textField;
	public static DefaultTableModel model=new DefaultTableModel();
	public static JTable table;
	private JLabel lblAprovada;
	private JLabel lblGenerada;
	private JLabel lblEmitida;
	private JLabel lblCerrada;
	private JLabel lblAnulada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionOrdenDeCompra frame = new IntGestionOrdenDeCompra();
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
	public IntGestionOrdenDeCompra() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				/*listar gestion orden de compra internal*/
				listaOrdeCompra();
			
				
			}
		});
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Nro");
		model.addColumn("Usuario");
		model.addColumn("Fecha de orden");
		model.addColumn("Proveedor");
		model.addColumn("Contacto");
		model.addColumn("Telefono");
		model.addColumn("Email");
		model.addColumn("Nro Cotizacion");
		model.addColumn("Fecha de cotizacion");
		model.addColumn("Fecha de entrega");
		model.addColumn("Total");
		
		
		
		setBounds(100, 100, 1600, 708);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
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
		textField.setBounds(1179, 11, 345, 38);
		getContentPane().add(textField);
		
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		
		JPanel panel_6 = new JPanel() {
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
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
				
				//los parametro son para bloquear al abrir el jdialog del FrmOdenDeCompra :v
				FrmOrdenDeCompra compra=new FrmOrdenDeCompra();
				compra.setVisible(true);
				compra.setLocationRelativeTo(null);
				
				
				
			}
		});
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(20, 147, 225));
		panel_6.setBounds(1001, 11, 142, 41);
		getContentPane().add(panel_6);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
		JLabel label_2 = new JLabel("Nuevo");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(253, 254, 254));
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		label_2.setBounds(50, 7, 83, 30);
		panel_6.add(label_2);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
FrmMenuPrincipal f=new FrmMenuPrincipal();
				
				FrmOrdenDeCompra compra=new FrmOrdenDeCompra();
				compra.setVisible(true);
				compra.setLocationRelativeTo(null);
				
			}
		});
		label.setBounds(10, 0, 38, 38);
		panel_6.add(label);
		label.setIcon(ic);
		
			label.setIcon(iconoEscalado);
			ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/search.png"));
			Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
			Icon ico = new ImageIcon(is);
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(ico);
		label_1.setBounds(1534, 11, 44, 38);
		getContentPane().add(label_1);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 66, 1186, 519);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(1, 3));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.decode("#005f80"));
		table.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		table.getTableHeader().setFont(new Font("Arial", 1, 12));
		table.getTableHeader().setSize(WIDTH,100);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		table.setRowHeight(30);
		table.setDefaultRenderer(Object.class, new FormatoTabla());
		table.setForeground(Color.decode("#39393C"));
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.decode("#2D363F"));
				lblGenerada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {

				panel_1.setBackground(Color.white);
				lblGenerada.setForeground(Color.black);
			}
		});
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(13, 183, 308, 57);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblGenerada = new JLabel("Generada");
		lblGenerada.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblGenerada.setBounds(27, 0, 80, 57);
		panel_1.add(lblGenerada);
		
		JPanel panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				panel_2.setBackground(Color.decode("#2D363F"));
				lblAprovada.setForeground(Color.WHITE);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(Color.white);
				lblAprovada.setForeground(Color.black);
			}
		});
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(13, 71, 308, 57);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblAprovada = new JLabel("Aprovada");
		lblAprovada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblAprovada.setBounds(27, 0, 80, 57);
		panel_2.add(lblAprovada);
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(Color.decode("#2D363F"));
				lblEmitida.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(Color.white);
				lblEmitida.setForeground(Color.black);
			}
		});
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(13, 299, 308, 57);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblEmitida = new JLabel("Emitida");
		lblEmitida.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEmitida.setBounds(27, 0, 80, 57);
		panel_3.add(lblEmitida);
		
		JPanel panel_4 = new JPanel();
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(Color.decode("#2D363F"));
				lblCerrada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(Color.white);
				lblCerrada.setForeground(Color.black);
			}
		});
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(13, 410, 308, 57);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		lblCerrada = new JLabel("Cerrada");
		lblCerrada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblCerrada.setBounds(27, 0, 80, 57);
		panel_4.add(lblCerrada);
		
		JPanel panel_5 = new JPanel();
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(Color.decode("#2D363F"));
				lblAnulada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(Color.white);
				lblAnulada.setForeground(Color.black);
			}
		});
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(13, 528, 308, 57);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		lblAnulada = new JLabel("Anulada");
		lblAnulada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblAnulada.setBounds(27, 0, 80, 57);
		panel_5.add(lblAnulada);

	}
	
	public static void listaOrdeCompra() {
		ArrayList<OrdenCompra> lista=new ArrayList<>();
		GestionCompra gui=new GestionCompra();
		lista=gui.listadoOrdenCompra();
	
model.getDataVector().removeAllElements();
		
		for (OrdenCompra cl : lista) {
			Object datos[] = {  cl.getNroOrdenCompra(),cl.getNomUsuario(),cl.getFechaOrdenCompra(),cl.getNomProveedor(),cl.getContacto(),cl.getTelefono(),cl.getEmail()
								,"","",cl.getFechaEntrega(),cl.getTotal()};

			model.addRow(datos);
			
		}
		
	}
}
