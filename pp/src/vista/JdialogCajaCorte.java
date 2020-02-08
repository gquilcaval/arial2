package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import model.RoundedCornerBorder;
import utils.clsArial;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;

public class JdialogCajaCorte extends JDialog {
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
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JPanel panel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCajaCorte dialog = new JdialogCajaCorte();
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
	public JdialogCajaCorte() {
		
		setTitle("Corte de Caja");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 727, 413);
		setLocationRelativeTo(null);
		setModal(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(new clsArial().colorHover));
		panel.setBounds(0, 0, 711, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCaja = new JLabel("Caja :");
		lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja.setForeground(new Color(240, 240, 240, 240));
		lblCaja.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblCaja.setBounds(294, 11, 74, 37);
		panel.add(lblCaja);
		
		JLabel lblCaja_2 = new JLabel("Caja 1");
		lblCaja_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja_2.setForeground(new Color(240, 240, 240, 240));
		lblCaja_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblCaja_2.setBounds(365, 11, 74, 37);
		panel.add(lblCaja_2);
		
		JLabel lblEfectivo = new JLabel("Efectivo");
		lblEfectivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectivo.setForeground(Color.BLACK);
		lblEfectivo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblEfectivo.setBounds(26, 134, 64, 14);
		getContentPane().add(lblEfectivo);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField.setBounds(112, 133, 102, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(224, 133, 102, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(336, 133, 102, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(540, 133, 102, 20);
		getContentPane().add(textField_3);
		
		JLabel lblContado = new JLabel("Contado");
		lblContado.setHorizontalAlignment(SwingConstants.CENTER);
		lblContado.setForeground(Color.BLACK);
		lblContado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblContado.setBounds(128, 108, 64, 14);
		getContentPane().add(lblContado);
		
		JLabel lblCalculado = new JLabel("Calculado");
		lblCalculado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculado.setForeground(Color.BLACK);
		lblCalculado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblCalculado.setBounds(242, 108, 64, 14);
		getContentPane().add(lblCalculado);
		
		JLabel lblDiferencia = new JLabel("Diferencia");
		lblDiferencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiferencia.setForeground(Color.BLACK);
		lblDiferencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDiferencia.setBounds(349, 108, 70, 14);
		getContentPane().add(lblDiferencia);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(336, 164, 102, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(224, 164, 102, 20);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(112, 164, 102, 20);
		getContentPane().add(textField_6);
		
		JLabel lblCheque = new JLabel("Cheque");
		lblCheque.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheque.setForeground(Color.BLACK);
		lblCheque.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblCheque.setBounds(26, 165, 64, 14);
		getContentPane().add(lblCheque);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(336, 195, 102, 20);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBounds(224, 195, 102, 20);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(112, 195, 102, 20);
		getContentPane().add(textField_9);
		
		JLabel lblTarjeta = new JLabel("Tarjeta");
		lblTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarjeta.setForeground(Color.BLACK);
		lblTarjeta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTarjeta.setBounds(26, 196, 64, 14);
		getContentPane().add(lblTarjeta);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(336, 258, 102, 20);
		getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBounds(224, 258, 102, 20);
		getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_12.setColumns(10);
		textField_12.setBounds(112, 258, 102, 20);
		getContentPane().add(textField_12);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTotal.setBounds(26, 259, 64, 14);
		getContentPane().add(lblTotal);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_13.setColumns(10);
		textField_13.setBounds(540, 164, 102, 20);
		getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_14.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_14.setColumns(10);
		textField_14.setBounds(540, 195, 102, 20);
		getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_15.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_15.setColumns(10);
		textField_15.setBounds(540, 258, 102, 20);
		getContentPane().add(textField_15);
		
		JLabel lblRetiroPorCorte = new JLabel("Retiro por Corte");
		lblRetiroPorCorte.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetiroPorCorte.setForeground(Color.BLACK);
		lblRetiroPorCorte.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblRetiroPorCorte.setBounds(535, 108, 113, 14);
		getContentPane().add(lblRetiroPorCorte);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(235, 240, 244));
		panel_1_2.setBounds(100, 236, 548, 1);
		getContentPane().add(panel_1_2);
		
		JPanel panel_3 = new JPanel() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(35, 43, 55));
		panel_3.setBounds(308, 330, 130, 34);
		getContentPane().add(panel_3);
		
		JLabel lblT = new JLabel("Aceptar");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setForeground(SystemColor.menu);
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblT.setBounds(16, 8, 96, 20);
		panel_3.add(lblT);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(235, 240, 244));
		panel_1_1.setBounds(500, 97, 1, 189);
		getContentPane().add(panel_1_1);
		

	}

}