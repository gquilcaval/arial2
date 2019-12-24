package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class IntpAlmacen extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntpAlmacen frame = new IntpAlmacen();
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
	public IntpAlmacen() {
		setBounds(100, 100, 450, 300);

	}

}
