package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JdialogCajaConfNuevo extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCajaConfNuevo dialog = new JdialogCajaConfNuevo();
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
	public JdialogCajaConfNuevo() {
		setResizable(false);
		setTitle("Nueva Caja");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNombre.setBounds(21, 27, 64, 14);
		getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(95, 26, 226, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Agregar");
		btnGuardar.setBounds(352, 25, 89, 23);
		getContentPane().add(btnGuardar);
		setBounds(100, 100, 457, 95);
		setModal(true);
		setLocationRelativeTo(null);

	}

}
