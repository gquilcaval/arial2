package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import mantenimientos.GestionEmpledos;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class IntFinanza_pagos extends JInternalFrame {
	private JTable tblCobranza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFinanza_pagos frame = new IntFinanza_pagos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTextField txtBusqUsu;
	private JTable tblCobranzaHoy;
	/**
	 * Create the frame.
	 */
	public IntFinanza_pagos() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 806);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(){
			
			/* -------------REDONDEO BORDES JPANEL -----------*/
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
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RegistroUsuario registroUsuario=new RegistroUsuario();
				registroUsuario.setVisible(true);
				registroUsuario.setLocationRelativeTo(null);
			}
		});
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(1500, 11, 132, 35);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbliconoNuevo = new JLabel("");
		lbliconoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconoNuevo.setBounds(0, 0, 51, 35);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lbliconoNuevo.setIcon(iconoEscalado);
		panel.add(lbliconoNuevo);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setBounds(56, 0, 76, 35);
		panel.add(lblNuevo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 70, 1190, 709);
		getContentPane().add(scrollPane);
		
		tblCobranza = new JTable();
		t.ver_tabla(tblCobranza);
		tblCobranza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				 int column = tblCobranza.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblCobranza.getRowHeight();
			        
			        if(row < tblCobranza.getRowCount() && row >= 0 && column < tblCobranza.getColumnCount() && column >= 0){
			            Object value = tblCobranza.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("m")){
			                	
			                
			                  
			                	 JdialogEditarUsu editarUsu=new JdialogEditarUsu();
			                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
			                  int fila1 = tblCobranza.getSelectedRow();
			                  System.out.println("el codigo el modficar es :"+tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtIdUsu.setText(tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtNomUsu.setText(tblCobranza.getValueAt(fila1, 1).toString());
			                  JdialogEditarUsu.txtApellidoPat.setText(tblCobranza.getValueAt(fila1, 2).toString());
			                  JdialogEditarUsu.txtApeMat.setText(tblCobranza.getValueAt(fila1, 3).toString());
			    				//sex_emp=tblUsuarios.getValueAt(fila1, 4).toString();
			                  JdialogEditarUsu.txtEmail.setText(tblCobranza.getValueAt(fila1, 5).toString());
			                  JdialogEditarUsu.txtSueldo.setText( tblCobranza.getValueAt(fila1,6).toString());
			    				//estado_emp=tblUsuarios.getValueAt(fila1, 7).toString();
			                  JdialogEditarUsu.txtDirecUsu.setText(tblCobranza.getValueAt(fila1, 8).toString());
			                  JdialogEditarUsu.txtTelf.setText(tblCobranza.getValueAt(fila1, 9).toString());
			                  JdialogEditarUsu.txtCell.setText(tblCobranza.getValueAt(fila1, 10).toString());
			                  JdialogEditarUsu.txtDniUsu.setText(tblCobranza.getValueAt(fila1, 11).toString());
			                  JdialogEditarUsu.txtLogeo.setText(tblCobranza.getValueAt(fila1, 12).toString());
			                  JdialogEditarUsu.txtPswUsu.setText(tblCobranza.getValueAt(fila1, 13).toString());
			    			//	id_tip_emp=tblUsuarios.getValueAt(fila1, 9).toString();
			                  
			                 /*----PRIVILEGIOS DEL USUARIO ----*/ 
			                  ArrayList<Empleados> list=new GestionEmpledos().privilegios(tblCobranza.getValueAt(fila1, 0).toString());
			          		for (Empleados cl : list) {
			          		
			          			if ("ventas".equals(cl.getNom_privilegio())) {
			          				
			          				JdialogEditarUsu.chckbxVentas.setSelected(cl.isEstadoPrivilegio());
			          			}
			                      if ("compras".equals(cl.getNom_privilegio())) {
			          				
			                    	  JdialogEditarUsu.chckbxCompras.setSelected(cl.isEstadoPrivilegio());
			          			}
			                      if ("usuarios".equals(cl.getNom_privilegio())) {
			          				
			                    	  JdialogEditarUsu.chckbxUsuarios.setSelected(cl.isEstadoPrivilegio());
			          			}
			                     if ("almacen".equals(cl.getNom_privilegio())) {
			          				
			                    	 JdialogEditarUsu.chckbxAlmacn.setSelected(cl.isEstadoPrivilegio());
			          			}

			          		}
			          	 
		                  editarUsu.setVisible(true);
			                  
			                }
			                if(boton.getName().equals("e")){
			                	int fila1 = tblCobranza.getSelectedRow();
			                	System.out.println("en eliminar es :"+tblCobranza.getValueAt(fila1, 0).toString());
			    				String id=tblCobranza.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
			    			
			    				eliminar(id);
			    				
			                   
			                }
			            }
			          /*  if(value instanceof JCheckBox){
			                //((JCheckBox)value).doClick();
			                JCheckBox ch = (JCheckBox)value;
			                if(ch.isSelected()==true){
			                    ch.setSelected(false);
			                }
			                if(ch.isSelected()==false){
			                    ch.setSelected(true);
			                }
			                
			            }*/
			        }
			        
		
				
			}
		});
		scrollPane.setViewportView(tblCobranza);
		
		txtBusqUsu =new HintTextField("Buscar Proveedor") {
			
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
		txtBusqUsu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				System.out.println("entro al keyreelease");
				
				String nombre=txtBusqUsu.getText();
				
				GestionEmpledos gc = new GestionEmpledos();
				Tabla.model.getDataVector().removeAllElements();
				ArrayList<Empleados> lista = gc.listado(nombre);
				
				
				Tabla.listarNombre(lista);
			}
		});
		txtBusqUsu.setBounds(1027, 11, 396, 35);
		getContentPane().add(txtBusqUsu);
		txtBusqUsu.setColumns(10);
		
		JPanel panelConbranzaHoy = new JPanel();
		panelConbranzaHoy.setBackground(Color.decode("#1493e1"));
		panelConbranzaHoy.setBounds(0, 0, 408, 779);
		getContentPane().add(panelConbranzaHoy);
		panelConbranzaHoy.setLayout(null);
		
		JLabel lblHoy = new JLabel("HOY");
		lblHoy.setForeground(new Color(240,240,240,240));
		lblHoy.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblHoy.setBounds(172, 11, 52, 37);
		panelConbranzaHoy.add(lblHoy);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 70, 408, 644);
		panelConbranzaHoy.add(scrollPane_1);
		
		tblCobranzaHoy = new JTable();
		scrollPane_1.setViewportView(tblCobranzaHoy);
		
		JLabel lblTotalCobraHoy = new JLabel("1400");
		lblTotalCobraHoy.setForeground(new Color(240,240,240));
		lblTotalCobraHoy.setBounds(150, 725, 74, 45);
		panelConbranzaHoy.add(lblTotalCobraHoy);
		lblTotalCobraHoy.setFont(new Font("Segoe UI", Font.BOLD, 27));
		
		JLabel lblS = new JLabel("S/.");
		lblS.setForeground(new Color(240,240,240));
		lblS.setBounds(114, 726, 34, 45);
		panelConbranzaHoy.add(lblS);
		lblS.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		JLabel lblT = new JLabel("Total");
		lblT.setForeground(new Color(240,240,240));
		lblT.setBounds(27, 725, 75, 45);
		panelConbranzaHoy.add(lblT);
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JDateChooser dtpFecha = new JDateChooser();
		dtpFecha.setBounds(442, 11, 226, 35);
		getContentPane().add(dtpFecha);
		

			}

void eliminar(String id) {

	GestionEmpledos gc = new GestionEmpledos();

	int ok = gc.eliminar(id);

	if (ok == 0) {
		
	} else {
		JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
		Tabla.model.setRowCount(0);  // <--------- LIMPIA LA TABLA
		Tabla.listar();
	}

}
}
