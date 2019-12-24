package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import mantenimientos.GestionEmpledos;
import model.Clientes;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.Tabla;

import java.awt.Cursor;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class IntUsuarios extends JInternalFrame {
	private JTextField txtBusqUsu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntUsuarios frame = new IntUsuarios();
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
	
	public static DefaultTableModel model = new DefaultTableModel();
	public static JTable tblUsuarios;
	Tabla t=new Tabla();
	public IntUsuarios() {
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
		
		JLabel lblUsu = new JLabel("Usuarios");
		lblUsu.setForeground(Color.decode("#808793"));
		lblUsu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsu.setBounds(92, 33, 73, 14);
		panelHeader.add(lblUsu);
		
		JLabel lblPerfiles = new JLabel("Perfiles");
		lblPerfiles.setForeground(new Color(128, 135, 147));
		lblPerfiles.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPerfiles.setBounds(188, 35, 73, 14);
		panelHeader.add(lblPerfiles);
		
		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setForeground(new Color(128, 135, 147));
		lblPermisos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPermisos.setBounds(295, 35, 73, 14);
		panelHeader.add(lblPermisos);
		
		JPanel panel = new JPanel();
		panel.setBounds(90, 63, 60, 3);
		panelHeader.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(188, 63, 60, 3);
		panelHeader.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(295, 63, 60, 3);
		panelHeader.add(panel_2);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#ebf0f4"));
		desktopPane.setBounds(0, 68, 1642, 806);
		getContentPane().add(desktopPane);
		
	/*	model.addColumn("Nombre");
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		model.addColumn("Sexo");
		model.addColumn("Email");
		model.addColumn("Sueldo");
		model.addColumn("Estado");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Celular");
		model.addColumn("Dni");
		model.addColumn("Nick");
		model.addColumn("Contraseña");
		model.addColumn("Cargo");*/
		
		txtBusqUsu = new HintTextField("Search") {
			
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
		txtBusqUsu.setBounds(439, 90, 430, 26);
		desktopPane.add(txtBusqUsu);
		txtBusqUsu.setColumns(10);
		
		JPanel panel_3 = new JPanel() {
			
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
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistroUsuario registroUsuario=new RegistroUsuario();
				registroUsuario.setVisible(true);
				registroUsuario.setLocationRelativeTo(null);
			
			}
		});
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/*-----------------------------------------------------------*/
		
		panel_3.setBackground(Color.decode("#1493e1"));
		panel_3.setBounds(1374, 90, 132, 35);
		desktopPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNuevo.setBounds(70, 11, 69, 14);
		panel_3.add(lblNuevo);
		
		JLabel lblIconAgregar = new JLabel("");
		lblIconAgregar.setBounds(10, 3, 38, 28);
		
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lblIconAgregar.setIcon(iconoEscalado);
		panel_3.add(lblIconAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 1598, 566);
		desktopPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		t.ver_tabla(tblUsuarios);
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				 int column = tblUsuarios.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblUsuarios.getRowHeight();
			        
			        if(row < tblUsuarios.getRowCount() && row >= 0 && column < tblUsuarios.getColumnCount() && column >= 0){
			            Object value = tblUsuarios.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("m")){
			                	
			                
			                  
			                	 JdialogEditarUsu editarUsu=new JdialogEditarUsu();
			                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
			                  int fila1 = tblUsuarios.getSelectedRow();
			                  System.out.println("el codigo el modficar es :"+tblUsuarios.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtIdUsu.setText(tblUsuarios.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtNomUsu.setText(tblUsuarios.getValueAt(fila1, 1).toString());
			                  JdialogEditarUsu.txtApellidoPat.setText(tblUsuarios.getValueAt(fila1, 2).toString());
			                  JdialogEditarUsu.txtApeMat.setText(tblUsuarios.getValueAt(fila1, 3).toString());
			    				//sex_emp=tblUsuarios.getValueAt(fila1, 4).toString();
			                  JdialogEditarUsu.txtEmail.setText(tblUsuarios.getValueAt(fila1, 5).toString());
			                  JdialogEditarUsu.txtSueldo.setText( tblUsuarios.getValueAt(fila1,6).toString());
			    				//estado_emp=tblUsuarios.getValueAt(fila1, 7).toString();
			                  JdialogEditarUsu.txtDirecUsu.setText(tblUsuarios.getValueAt(fila1, 8).toString());
			                  JdialogEditarUsu.txtTelf.setText(tblUsuarios.getValueAt(fila1, 9).toString());
			                  JdialogEditarUsu.txtCell.setText(tblUsuarios.getValueAt(fila1, 10).toString());
			                  JdialogEditarUsu.txtDniUsu.setText(tblUsuarios.getValueAt(fila1, 11).toString());
			                  JdialogEditarUsu.txtLogeo.setText(tblUsuarios.getValueAt(fila1, 12).toString());
			                  JdialogEditarUsu.txtPswUsu.setText(tblUsuarios.getValueAt(fila1, 13).toString());
			    			//	id_tip_emp=tblUsuarios.getValueAt(fila1, 9).toString();
			                  
			                 /*----PRIVILEGIOS DEL USUARIO ----*/ 
			                  ArrayList<Empleados> list=new GestionEmpledos().privilegios(tblUsuarios.getValueAt(fila1, 0).toString());
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
			                	int fila1 = tblUsuarios.getSelectedRow();
			                	System.out.println("en eliminar es :"+tblUsuarios.getValueAt(fila1, 0).toString());
			    				String id=tblUsuarios.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
			    			
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
		
		scrollPane.setViewportView(tblUsuarios);
		
	

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
