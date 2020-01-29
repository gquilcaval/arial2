package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmBuscarLCiente extends JDialog {
	private JTable tblCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmBuscarLCiente dialog = new FrmBuscarLCiente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBuscarLCiente() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Cliente");
		lblNewLabel.setBounds(189, 24, 90, 14);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(39, 48, 411, 2);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/user.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setBounds(294, 24, 30, 20);
		getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 110, 288, 322);
		getContentPane().add(scrollPane);
		
		tblCliente = new JTable();
		scrollPane.setViewportView(tblCliente);
		setBounds(100, 100, 506, 497);
	}
}
