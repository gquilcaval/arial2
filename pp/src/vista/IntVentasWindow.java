package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class IntVentasWindow extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private String colorFondo="#ebf0f4";
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
		setBackground(Color.RED);
		setBounds(100, 100, 1626, 832);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode(colorFondo));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.decode(colorFondo));
		panel.setBounds(42, 11, 1507, 666);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(37, 284, 551, 36);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Cantidad :");
		label.setBounds(10, 11, 56, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 8, 72, 20);
		panel_1.add(textField);
		
		JButton button = new JButton("New button");
		button.setBounds(379, 5, 45, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(430, 5, 47, 23);
		panel_1.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 331, 730, 143);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(36, 485, 151, 68);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Importe");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 11, 131, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Cambio");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(80, 11, 61, 14);
		panel_2.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 37, 53, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 36, 61, 20);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(197, 485, 404, 68);
		panel.add(panel_3);
		
		JLabel label_3 = new JLabel("Total a pagar");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(292, 11, 86, 14);
		panel_3.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(292, 37, 86, 20);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(
								new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
										TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), new Color(0, 0, 0)),
								"Venta", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 11, 742, 216);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(22, 46, 290, 125);
		panel_4.add(panel_5);
		
		JLabel label_4 = new JLabel("Nombre");
		label_4.setBounds(10, 64, 46, 14);
		panel_5.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(68, 63, 117, 20);
		panel_5.add(textField_4);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(221, 32, 38, 23);
		panel_5.add(button_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(68, 94, 117, 20);
		panel_5.add(textField_5);
		
		JLabel label_5 = new JLabel("Apellidos");
		label_5.setBounds(10, 97, 58, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("Codigo");
		label_6.setBounds(10, 36, 46, 14);
		panel_5.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(68, 33, 117, 20);
		panel_5.add(textField_6);
		
		JLabel label_7 = new JLabel("Documento :");
		label_7.setBounds(22, 182, 70, 14);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("Fecha :");
		label_8.setBounds(510, 185, 46, 14);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("2019/11/26");
		label_9.setBounds(548, 185, 64, 14);
		panel_4.add(label_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(343, 37, 389, 134);
		panel_4.add(panel_6);
		
		JLabel label_10 = new JLabel("Codigo");
		label_10.setBounds(10, 50, 46, 14);
		panel_6.add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(65, 47, 131, 20);
		panel_6.add(textField_7);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(342, 46, 35, 23);
		panel_6.add(button_3);
		
		JLabel label_11 = new JLabel("Nombre");
		label_11.setBounds(10, 96, 46, 14);
		panel_6.add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(65, 93, 131, 20);
		panel_6.add(textField_8);
		
		JLabel label_12 = new JLabel("Stock");
		label_12.setBounds(231, 50, 46, 14);
		panel_6.add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(276, 47, 46, 20);
		panel_6.add(textField_9);
		
		JLabel label_13 = new JLabel("Precio");
		label_13.setBounds(231, 96, 46, 14);
		panel_6.add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(276, 93, 46, 20);
		panel_6.add(textField_10);
		
		JLabel label_14 = new JLabel("Nro\u00BA de Venta :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(287, 185, 105, 20);
		panel_4.add(label_14);
		
		JLabel label_15 = new JLabel("1");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		label_15.setBounds(379, 182, 40, 20);
		panel_4.add(label_15);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 179, 121, 20);
		panel_4.add(comboBox);
		
		JButton button_4 = new JButton("Grabar");
		button_4.setBounds(645, 510, 89, 23);
		panel.add(button_4);

	}
}
