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

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.Cursor;

public class IntVentasWindow extends JInternalFrame {
	private String colorFondo="#ebf0f4";
	private JLabel lblUser;
	public static JLabel lblFecha;
	private JTextField txtBusquedad;
	public String ColorMain ="#2D363F";
	public static JLabel lblReloj;
	private JTable tblProducto;
	private JLabel label_1;
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
		panel.setBounds(75, 0, 1359, 66);
		panel.setBackground(Color.decode(ColorMain));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 28, 78, 14);
		lblUsuario.setForeground(Color.white);
		panel.add(lblUsuario);
		
		lblUser = new JLabel("");
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(72, 28, 58, 14);
		panel.add(lblUser);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(1122, 19, 91, 29);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel.add(lblFecha);
		
		lblReloj = new JLabel("");
		lblReloj.setBounds(1266, 19, 46, 29);
		lblReloj.setForeground(Color.WHITE);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel.add(lblReloj);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-4, 312, 38, -14);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/user.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setBounds(222, 121, 30, 20);
		getContentPane().add(label);
		
		txtBusquedad = new JTextField();
		txtBusquedad.setBounds(262, 121, 199, 20);
		getContentPane().add(txtBusquedad);
		txtBusquedad.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label_1.setIcon(ic);
		label_1.setBounds(490, 121, 20, 20);
		getContentPane().add(label_1);
		
		JLabel lblProducto = new JLabel("");
		ImageIcon imgIcon1 = new ImageIcon(getClass().getResource("/iconos/product.png"));
		Image imgEscalada1 = imgIcon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon id = new ImageIcon(imgEscalada1);
		lblProducto.setIcon(id);
		lblProducto.setBounds(236, 204, 30, 20);
		getContentPane().add(lblProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 277, 706, 285);
		getContentPane().add(scrollPane);
		
		tblProducto = new JTable();
		scrollPane.setViewportView(tblProducto);
		
		JPanel panel_2 = new JPanel();
		panel.setBackground(Color.decode(ColorMain));
		panel_2.setBounds(75, 277, 60, 285);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 40, 50, 14);
		panel_2.add(lblCantidad);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 60, 54);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		ImageIcon imgIcon2 = new ImageIcon(getClass().getResource("/iconos/money.png"));
		Image imgEscalada2 = imgIcon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon u = new ImageIcon(imgEscalada2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 54, 60, 54);
		panel_2.add(panel_4);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 40, 41, 14);
		panel_4.add(lblPrecio);
		
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(11, 1, 48, 35);
		panel_4.add(label_3);
		label_3.setIcon(u);

	}
}
