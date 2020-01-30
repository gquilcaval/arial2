package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.FrmRegistroCompra;


public class boton extends JButton{

	
JPanel panel;
public    JPanel  mibotonAgregar(int x,int y,JDialog j ) {
	 panel=new JPanel();
	JLabel texto=new JLabel("Agregar");
	texto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
	texto.setForeground(Color.decode("#d5e6f9"));
	texto.setVerticalTextPosition(CENTER);
	
	panel.setBorder(null);
	
	panel.setOpaque(true);
	panel.setBackground(Color.decode("#007bff"));
	
	panel.setSize(130,30);
	panel.add(texto);
	panel.setLocation(x, y);
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
		j.setVisible(true);
		j.setLocationRelativeTo(null);
		}
	});
	
	return panel;
}




}
