package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Base64.Decoder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class JdialogEnvioEstadoCuenta extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogEnvioEstadoCuenta dialog = new JdialogEnvioEstadoCuenta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JdialogEnvioEstadoCuenta() {
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 504, 538);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(0, 0, 488, 47);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCobranzaMedios = new JLabel("ENVIO DE CORREO");
		lblCobranzaMedios.setForeground(new Color(240,240,240));
		lblCobranzaMedios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCobranzaMedios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCobranzaMedios.setBounds(125, 11, 248, 14);
		panel.add(lblCobranzaMedios);
		
		JButton btnAceptar = new JButton("Enviar");
		btnAceptar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(240,240,240));
		btnAceptar.setBounds(200, 465, 89, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblDe = new JLabel("De :");
		lblDe.setForeground(new Color(119, 119, 119));
		lblDe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDe.setBounds(22, 58, 52, 21);
		getContentPane().add(lblDe);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(SystemColor.menu);
		separator_5.setBackground(SystemColor.menu);
		separator_5.setBounds(84, 104, 389, 2);
		getContentPane().add(separator_5);
		
		JLabel lblArchivosAdjuntos = new JLabel("Archivos adjuntos");
		lblArchivosAdjuntos.setForeground(new Color(110, 203, 240));
		lblArchivosAdjuntos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblArchivosAdjuntos.setBounds(22, 391, 159, 21);
		getContentPane().add(lblArchivosAdjuntos);
		
		JLabel lblPara = new JLabel("Para :");
		lblPara.setForeground(new Color(119, 119, 119));
		lblPara.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPara.setBounds(22, 86, 52, 21);
		getContentPane().add(lblPara);
		
		JLabel lblCc = new JLabel("CC :");
		lblCc.setForeground(new Color(119, 119, 119));
		lblCc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCc.setBounds(22, 118, 52, 21);
		getContentPane().add(lblCc);
		
		JLabel lblAsunto = new JLabel("Asunto :");
		lblAsunto.setForeground(new Color(119, 119, 119));
		lblAsunto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAsunto.setBounds(22, 150, 52, 21);
		getContentPane().add(lblAsunto);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setBounds(22, 182, 451, 198);
		getContentPane().add(textArea);
		
		JButton btnAdjuntar = new JButton("Adjuntar");
		btnAdjuntar.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnAdjuntar.setBackground(SystemColor.menu);
		btnAdjuntar.setBounds(384, 391, 89, 23);
		getContentPane().add(btnAdjuntar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.menu);
		separator.setBackground(SystemColor.menu);
		separator.setBounds(84, 135, 389, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.menu);
		separator_1.setBackground(SystemColor.menu);
		separator_1.setBounds(84, 169, 389, 2);
		getContentPane().add(separator_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBounds(84, 85, 389, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(84, 116, 389, 20);
		getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setColumns(10);
		textField_3.setBounds(84, 150, 389, 20);
		getContentPane().add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 59, 350, 20);
		getContentPane().add(comboBox);

	}
}
