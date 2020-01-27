package utils;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.RoundedCornerBorder;
import vista.IntCobranza;
import vista.IntFinanzas;
import vista.IntUsuario;

public  class clsArial    {

	
	public clsArial() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Icon modifiedIcon(String url,int with,int heigh) {
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(url));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(with, heigh, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		return iconoEscalado;
	}
	
	public void setInternalFrame(JDesktopPane Desktop,JInternalFrame Internalframe,JDesktopPane subDesktop,JInternalFrame subInternalFrame) {
		Desktop.removeAll();
		Desktop.repaint();
	
		Desktop.add(Internalframe);
		try {
			Internalframe.setMaximum(true);
			Internalframe.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
			Internalframe.show(); 
			
			if (subInternalFrame!=null) {
				

				IntFinanzas.lblPagos.setForeground(Color.decode(IntFinanzas.colorNegro));
			
				IntFinanzas.rayaPago.setVisible(true);
				
				IntFinanzas.lblCobranza.setForeground(Color.decode(IntFinanzas.colorPlomo));
				IntFinanzas.rayaUsu.setVisible(false);
				subDesktop.removeAll();
				subDesktop.repaint();
			
				subDesktop.add(subInternalFrame);
				try {
					subInternalFrame.setMaximum(true);
					subInternalFrame.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					subInternalFrame.show(); 
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}

	}
	

	
}
