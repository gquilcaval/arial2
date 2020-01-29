package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class boton extends JButton implements MouseListener{

public   JPanel  miboton(int x,int y) {
	JPanel panel=new JPanel();
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
	addMouseListener(this);
	return panel;
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("presiono aqui");
	JOptionPane.showMessageDialog(null, "hola mundo");
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}
