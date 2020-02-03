package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;

public class FormatoTablaMain {

	
	public static void formatoTabla(JTable tabla) {
		
		tabla.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabla.getTableHeader().setOpaque(false);
		tabla.getTableHeader().setBackground(Color.decode("#005f80"));
		tabla.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		tabla.getTableHeader().setFont(new Font("Arial", 1, 12));
		tabla.getTableHeader().setSize(100, 100);
		tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tabla.setRowHeight(30);
		tabla.setDefaultRenderer(Object.class, new FormatoTabla());
		tabla.setForeground(Color.decode("#39393C"));
	}
	
}
