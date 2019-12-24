package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Font;

public class IntAlmacen extends JInternalFrame {

	private String colorCeleste="#0f95ec";
	private String colorMenu="#2D363F";
	private String colorHover="#232b37";
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	private JLabel lblProductos;
	private JLabel lblLotes;
	private JLabel lblInventario;
	private JLabel lblEntrada;
	private JLabel lblSalidas;
	private JLabel lblRemision;
	private Panel panel_1;
	private Panel panel_2;
	private Panel panel_3;
	private Panel panel_4;
	private Panel panel_5;
	private Panel panel_6;
	private Panel panel_7;
	private Panel panel_8;
	private Panel panel_9;
	private Panel panel_11;
	private Panel panel_12;
	private Panel panel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntAlmacen frame = new IntAlmacen();
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
	public IntAlmacen() {
		setBounds(223, 122, 1626, 789);
		setBackground(Color.decode("#EFF4F9"));
		getContentPane().setLayout(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		setBorder(null);
		JDesktopPane dktIntGestionProd = new JDesktopPane();
		dktIntGestionProd.setBackground(Color.decode("#EFF4F9"));
		dktIntGestionProd.setBounds(0, 85, 1610, 674);
		getContentPane().add(dktIntGestionProd);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 1626, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new Panel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				lblProductos.setForeground(Color.decode(colorNegro));
				panel_7.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblProductos.setForeground(Color.decode(colorPlomo));
				panel_7.setVisible(false);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntGestionProducto p=new IntGestionProducto();
				dktIntGestionProd.add(p);
				try {
					p.setMaximum(true);
					p.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					p.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_1.setBounds(10, 29, 120, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setBounds(26, 5, 68, 20);
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProductos.setForeground(Color.decode(colorPlomo));
		panel_1.add(lblProductos);
		
		panel_7 = new Panel();
		panel_7.setBackground(Color.decode(colorCeleste));
		panel_7.setBounds(19, 42, 84, 3);
		panel_7.setVisible(false);
		panel_1.add(panel_7);
		
		panel_2 = new Panel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblLotes.setForeground(Color.decode(colorNegro));
				panel_8.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLotes.setForeground(Color.decode(colorPlomo));
				panel_8.setVisible(false);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
					dktIntGestionProd.removeAll();
					dktIntGestionProd.repaint();
					IntLotes l=new IntLotes();
					dktIntGestionProd.add(l);
					try {
						l.setMaximum(true);
						l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
						l.show(); 
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_2.setBounds(165, 29, 120, 45);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblLotes = new JLabel("Lotes");
		lblLotes.setBounds(42, 5, 35, 20);
		lblLotes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLotes.setForeground(Color.decode(colorPlomo));
		panel_2.add(lblLotes);
		
		panel_8 = new Panel();
		panel_8.setBackground(Color.decode(colorCeleste));
		panel_8.setBounds(21, 42, 84, 3);
		panel_8.setVisible(false);
		panel_2.add(panel_8);
		
		panel_3 = new Panel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblInventario.setForeground(Color.decode(colorNegro));
				panel_9.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblInventario.setForeground(Color.decode(colorPlomo));
				panel_9.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
					dktIntGestionProd.removeAll();
					dktIntGestionProd.repaint();
					IntInventario l=new IntInventario();
					dktIntGestionProd.add(l);
					try {
						l.setMaximum(true);
						l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
						l.show(); 
				}catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		panel_3.setBounds(338, 29, 120, 45);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblInventario = new JLabel("Inventario");
		lblInventario.setBounds(26, 5, 68, 20);
		lblInventario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblInventario.setForeground(Color.decode(colorPlomo));
		panel_3.add(lblInventario);
		
		panel_9 = new Panel();
		panel_9.setBackground(Color.decode(colorCeleste));
		panel_9.setBounds(20, 42, 84, 3);
		panel_9.setVisible(false);
		panel_3.add(panel_9);
		
		panel_4 = new Panel();
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblEntrada.setForeground(Color.decode(colorNegro));
				panel_10.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEntrada.setForeground(Color.decode(colorPlomo));
				panel_10.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntIngreso l=new IntIngreso();
				dktIntGestionProd.add(l);
				try {
					l.setMaximum(true);
					l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					l.show(); 
			}catch (Exception ex) {
				// TODO: handle exception
			}
			}
		});
		panel_4.setBounds(502, 29, 120, 45);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		lblEntrada = new JLabel("Ingreso");
		lblEntrada.setBounds(35, 5, 50, 20);
		lblEntrada.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEntrada.setForeground(Color.decode(colorPlomo));
		panel_4.add(lblEntrada);
		
		panel_10 = new Panel();
		panel_10.setBackground(Color.decode(colorCeleste));
		panel_10.setBounds(25, 42, 84, 3);
		panel_10.setVisible(false);
		panel_4.add(panel_10);
		
		panel_5 = new Panel();
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalidas.setForeground(Color.decode(colorNegro));
				panel_11.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSalidas.setForeground(Color.decode(colorPlomo));
				panel_11.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntSalida l=new IntSalida();
				dktIntGestionProd.add(l);
				try {
					l.setMaximum(true);
					l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					l.show(); 
			}catch (Exception ex) {
				// TODO: handle exception
			}
				
			}
		});
		panel_5.setBounds(678, 29, 120, 45);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		lblSalidas = new JLabel("Salida");
		lblSalidas.setBounds(39, 5, 41, 20);
		lblSalidas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalidas.setForeground(Color.decode(colorPlomo));
		panel_5.add(lblSalidas);
		
		panel_11 = new Panel();
		
		panel_11.setBackground(Color.decode(colorCeleste));
		panel_11.setBounds(24, 42, 84, 3);
		panel_11.setVisible(false);
		panel_5.add(panel_11);
		
		panel_6 = new Panel();
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRemision.setForeground(Color.decode(colorNegro));
				panel_12.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRemision.setForeground(Color.decode(colorPlomo));
				panel_12.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntGuiaRemision l=new IntGuiaRemision();
				dktIntGestionProd.add(l);
				try {
					l.setMaximum(true);
					l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					l.show(); 
			}catch (Exception ex) {
				// TODO: handle exception
			}
			}
		});
		panel_6.setBounds(840, 29, 120, 45);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		lblRemision = new JLabel("Remision");
		lblRemision.setBounds(29, 5, 61, 20);
		lblRemision.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRemision.setForeground(Color.decode(colorPlomo));
		panel_6.add(lblRemision);
		
		panel_12 = new Panel();
		panel_12.setBackground(Color.decode(colorCeleste));
		panel_12.setBounds(19, 42, 84, 3);
		panel_12.setVisible(false);
		panel_6.add(panel_12);
		
		
	
		
		
		

	}
}
