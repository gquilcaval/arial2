package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import model.Tabla;

public class IntFinanzas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFinanzas frame = new IntFinanzas();
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
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	public static DefaultTableModel model = new DefaultTableModel();
	Tabla t=new Tabla();
	private JDesktopPane dkFinanzas;
	private JPanel rsyaPerfil;
	private JPanel rayaUsu;
	private JLabel lblPagos;
	private JLabel lblCobranza;
	public IntFinanzas() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
		@Override
		public void internalFrameOpened(InternalFrameEvent arg0) {
			dkFinanzas.removeAll();
			dkFinanzas.repaint();
			IntCobranza cobranza=new IntCobranza();
			dkFinanzas.add(cobranza);
			try {
				cobranza.setMaximum(true);
				cobranza.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
				cobranza.show(); 
				
			
		
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	});
	setBounds(100, 100, 1642, 901);
	getContentPane().setLayout(null);
	setBorder(null);
	/*-----BORDE SUPERIOR DISABLE ----*/
	((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
	/*-----------------------------------------------------------------------------*/
	
	
	
	JPanel panelHeader = new JPanel();
	panelHeader.setBackground(Color.WHITE);
	panelHeader.setBounds(0, 0, 1642, 69);
	getContentPane().add(panelHeader);
	panelHeader.setLayout(null);
	
	lblCobranza = new JLabel("Cobranzas");
	lblCobranza.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			lblPagos.setForeground(Color.decode(colorPlomo));
			
			rsyaPerfil.setVisible(false);
			
			lblCobranza.setForeground(Color.decode(colorNegro));
			rayaUsu.setVisible(true);
			dkFinanzas.removeAll();
			dkFinanzas.repaint();
			IntCobranza cobranza=new IntCobranza();
			dkFinanzas.add(cobranza);
			try {
				cobranza.setMaximum(true);
				cobranza.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
				cobranza.show(); 
				
			
		
			
			
			} catch (Exception ex) {
				// TODO: handle exception
			}
			
		}
		
	});
	lblCobranza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblCobranza.setForeground(Color.decode("#808793"));
	lblCobranza.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblCobranza.setBounds(92, 33, 73, 25);
	panelHeader.add(lblCobranza);
	
	lblPagos = new JLabel("Pagos");
	lblPagos.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			lblPagos.setForeground(Color.decode(colorNegro));
		
			rsyaPerfil.setVisible(true);
			
			lblCobranza.setForeground(Color.decode(colorPlomo));
			rayaUsu.setVisible(false);
			dkFinanzas.removeAll();
			dkFinanzas.repaint();
			IntFinanza_pagos pagos=new IntFinanza_pagos();
			dkFinanzas.add(pagos);
			try {
				pagos.setMaximum(true);
				pagos.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
				pagos.show(); 
				
			
		
			
			
			} catch (Exception ex) {
				// TODO: handle exception
			}
			
		}
	});
	lblPagos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblPagos.setForeground(new Color(128, 135, 147));
	lblPagos.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblPagos.setBounds(188, 35, 73, 23);
	panelHeader.add(lblPagos);
	
	rayaUsu = new JPanel();
	rayaUsu.setBounds(90, 63, 60, 3);
	rayaUsu.setBackground(Color.decode("#1493e1"));
	panelHeader.add(rayaUsu);
	
	rsyaPerfil = new JPanel();
	rsyaPerfil.setVisible(false);
	rsyaPerfil.setBounds(188, 63, 60, 3);
	rsyaPerfil.setBackground(Color.decode("#1493e1"));
	panelHeader.add(rsyaPerfil);
	
	dkFinanzas = new JDesktopPane();
	dkFinanzas.setBackground(Color.decode("#ebf0f4"));
	dkFinanzas.setBounds(0, 67, 1642, 807);
	getContentPane().add(dkFinanzas);
	
	
	


}

}