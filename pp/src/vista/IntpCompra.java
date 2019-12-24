package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.RoundedCornerBorder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntpCompra extends JInternalFrame {

	DefaultTableModel model1 = new DefaultTableModel();
	
	private String colorCeleste="#0f95ec";
	private String colorMenu="#2D363F";
	private String colorHover="#232b37";
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	private String colorFondo="#ebf0f4";
	private JLabel lblGestionDeCompra;
	private Panel panel_3;
	private Panel panel_5;
	private Panel panel_7;
	private JLabel lblOrdenDeCompra;
	private JLabel lblProveedores;
	private String colorLetra="#000000";
	private JDesktopPane dkpane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntpCompra frame = new IntpCompra();
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
	public IntpCompra() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionOrdenDeCompra venta=new IntGestionOrdenDeCompra();
				dkpane.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		setBounds(223, 79, 1627, 901);
		getContentPane().setLayout(null);
		getContentPane().setBounds(223,79,1626,832);
		setBorder(null);
		setBackground(Color.decode("#EFF4F9"));
		
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		/*TABLA*/
		
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		
		dkpane = new JDesktopPane();
		dkpane.setBackground(Color.decode("#ebf0f4"));
		dkpane.setBounds(0, 80, 1620, 794);
		getContentPane().add(dkpane);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1626, 77);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblGestionDeCompra.setForeground(Color.decode(colorNegro));
				panel_3.setVisible(true);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionDeCompra.setForeground(Color.decode(colorPlomo));
				
				panel_3.setVisible(false);
				
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionDeCompra g =new IntGestionDeCompra();
				dkpane.add(g);
				try {
					g.setMaximum(true);
					g.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					g.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_2.setBounds(242, 31, 165, 45);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblGestionDeCompra = new JLabel("Gestion de Compra");
		lblGestionDeCompra.setForeground(Color.decode(colorPlomo));
		lblGestionDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGestionDeCompra.setBounds(18, 0, 137, 29);
		panel_2.add(lblGestionDeCompra);
		
		panel_3 = new Panel();
		
		panel_3.setBackground(Color.decode(colorCeleste));
		panel_3.setBounds(18, 42, 131, 3);
		panel_3.setVisible(false);
		panel_2.add(panel_3);
		
		Panel panel_4 = new Panel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblOrdenDeCompra.setForeground(Color.decode(colorNegro));
				panel_5.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblOrdenDeCompra.setForeground(Color.decode(colorPlomo));
				panel_5.setVisible(false);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionOrdenDeCompra venta=new IntGestionOrdenDeCompra();
				dkpane.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		panel_4.setBounds(46, 31, 165, 45);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		lblOrdenDeCompra = new JLabel("Gestion Orden Compra");
		lblOrdenDeCompra.setForeground(Color.decode(colorPlomo));
		lblOrdenDeCompra.setBounds(5, 5, 154, 20);
		lblOrdenDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		panel_4.add(lblOrdenDeCompra);
		
		panel_5 = new Panel();
		panel_5.setBackground(Color.decode(colorCeleste));
		panel_5.setBounds(15, 42, 131, 3);
		panel_5.setVisible(false);
		panel_4.add(panel_5);
		
		Panel panel_6 = new Panel();
		panel_6.setForeground(Color.WHITE);
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblProveedores.setForeground(Color.decode(colorNegro));
				panel_7.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblProveedores.setForeground(Color.decode(colorPlomo));
				panel_7.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dkpane.removeAll();
				dkpane.repaint();
				IntProveedor venta=new IntProveedor();
				dkpane.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_6.setBounds(437, 32, 165, 45);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		lblProveedores = new JLabel("Proveedores");
		lblProveedores.setForeground(Color.decode(colorPlomo));
		lblProveedores.setBounds(39, 5, 86, 20);
		lblProveedores.setFont(new Font("Segoe UI", Font.BOLD, 14));
		panel_6.add(lblProveedores);
		
		panel_7 = new Panel();
		panel_7.setBackground(Color.decode(colorCeleste));
		panel_7.setBounds(44, 42, 84, 3);
		panel_7.setVisible(false);
		panel_6.add(panel_7);
		
		
		

	}
}
