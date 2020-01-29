package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import model.Clientes;

import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntVentasWindow extends JInternalFrame {
	private String colorFondo="#ebf0f4";
	public String ColorMain ="#2D363F";
	private JTextField textField;
	private JLabel lblUser;
	private JTable tblCliente;

	public static JLabel lblReloj;
	public static JLabel lblFecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVentasWindow frame = new IntVentasWindow();
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
	public IntVentasWindow() {
		
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				lblUser.setText(FrmLogin.e.getNom_emp());
				
			}
		});
		setBackground(Color.RED);
		setBounds(100, 100, 1626, 901);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(116, 0, 1317, 871);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(45, 54, 63));
		panel_1.setBounds(1, 0, 1316, 66);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Usuario");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 28, 78, 14);
		panel_1.add(label);
		
		lblUser = new JLabel("");
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(85, 28, 58, 14);
		panel_1.add(lblUser);
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(1122, 19, 91, 29);
		panel_1.add(lblFecha);
		
		lblReloj = new JLabel("");
		lblReloj.setForeground(Color.WHITE);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(1266, 19, 46, 29);
		panel_1.add(lblReloj);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(-78, 312, 38, -14);
		panel.add(panel_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(148, 121, 30, 20);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(188, 121, 199, 20);
		panel.add(textField);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarLCiente c=new FrmBuscarLCiente();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		label_5.setOpaque(true);
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(397, 121, 20, 20);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(162, 204, 30, 20);
		panel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 277, 706, 285);
		panel.add(scrollPane);
		
		tblCliente = new JTable();
		
		scrollPane.setViewportView(tblCliente);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(1, 277, 60, 285);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 60, 54);
		panel_3.add(panel_4);
		
		JLabel label_7 = new JLabel("Cantidad");
		label_7.setBounds(10, 40, 50, 14);
		panel_4.add(label_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 54, 60, 54);
		panel_3.add(panel_5);
		
		JLabel label_8 = new JLabel("Precio");
		label_8.setBounds(10, 40, 41, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(11, 1, 48, 35);
		panel_5.add(label_9);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/user.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		ImageIcon imgIcon1 = new ImageIcon(getClass().getResource("/iconos/product.png"));
		Image imgEscalada1 = imgIcon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon id = new ImageIcon(imgEscalada1);
		ImageIcon imgIcon2 = new ImageIcon(getClass().getResource("/iconos/money.png"));
		Image imgEscalada2 = imgIcon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon u = new ImageIcon(imgEscalada2);

	}
	
	
}
