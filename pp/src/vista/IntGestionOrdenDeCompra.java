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
	DefaultTableModel model=new DefaultTableModel();
	private JTable table;
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
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				/*listar gestion orden de compra internal*/
				listaOrdeCompra();
				
			}
		});
		
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
		
		
		
		setBounds(100, 100, 1600, 626);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		JPanel panel = new JPanel();
		panel.setBounds(-1, 66, 318, 530);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 308, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Generada");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 17, 80, 28);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 77, 308, 57);
		panel.add(panel_2);
		
		JLabel lblAprovada = new JLabel("Aprovada");
		lblAprovada.setFont(new Font("Arial", Font.BOLD, 16));
		lblAprovada.setBounds(27, 17, 80, 28);
		panel_2.add(lblAprovada);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 145, 308, 57);
		panel.add(panel_3);
		
		JLabel lblEmitida = new JLabel("Emitida");
		lblEmitida.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmitida.setBounds(27, 17, 80, 28);
		panel_3.add(lblEmitida);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 226, 308, 57);
		panel.add(panel_4);
		
		JLabel lblCerrada = new JLabel("Cerrada");
		lblCerrada.setFont(new Font("Arial", Font.BOLD, 16));
		lblCerrada.setBounds(27, 17, 80, 28);
		panel_4.add(lblCerrada);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(10, 302, 308, 57);
		panel.add(panel_5);
		
		JLabel lblAnulada = new JLabel("Anulada");
		lblAnulada.setFont(new Font("Arial", Font.BOLD, 16));
		lblAnulada.setBounds(27, 17, 80, 28);
		panel_5.add(lblAnulada);
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
		scrollPane.setBounds(331, 66, 1243, 519);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(1, 3));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.decode("#005f80"));
		table.getTableHeader().setForeground(Color.decode("#f7edd7"));
		table.getTableHeader().setFont(new Font("Arial", 1, 12));
		table.getTableHeader().setSize(WIDTH,100);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		
		table.setModel(model);

	}
	
	void listaOrdeCompra() {
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
