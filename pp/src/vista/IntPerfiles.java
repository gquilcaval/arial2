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
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Cursor;

public class IntPerfiles extends JInternalFrame {
	private JTable tblPerfiles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntPerfiles frame = new IntPerfiles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	TablaPerfiles tablaPerfiles=new TablaPerfiles();
	/**
	 * Create the frame.
	 */
	public IntPerfiles() {
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
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JdialogRegistroPerfil perfil=new JdialogRegistroPerfil();
				perfil.setVisible(true);
				perfil.setLocationRelativeTo(null);
			}
		});
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(1374, 90, 132, 35);
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
		scrollPane.setBounds(303, 235, 977, 217);
		getContentPane().add(scrollPane);
		
		tblPerfiles = new JTable();
		tablaPerfiles.ver_tabla(tblPerfiles);
		tblPerfiles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int column = tblPerfiles.getColumnModel().getColumnIndexAtX(e.getX());
		        int row = e.getY()/tblPerfiles.getRowHeight();
		        
		        if(row < tblPerfiles.getRowCount() && row >= 0 && column < tblPerfiles.getColumnCount() && column >= 0){
		            Object value = tblPerfiles.getValueAt(row, column);
		            if(value instanceof JButton){
		                ((JButton)value).doClick();
		                JButton boton = (JButton) value;

		                if(boton.getName().equals("m")){
		                	
		                
		                  
		                	 DialogEditPerfil editarPerfil=new DialogEditPerfil();
		                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
		                  int fila1 = tblPerfiles.getSelectedRow();
		                  System.out.println("el codigo el modficar es :"+tblPerfiles.getValueAt(fila1, 0).toString());
		                  editarPerfil.txtId.setText(tblPerfiles.getValueAt(fila1, 0).toString());
		                  editarPerfil.txtNombre.setText(tblPerfiles.getValueAt(fila1, 1).toString());
		               
		          	 
		          		editarPerfil.setVisible(true);
		                  
		                }
		                if(boton.getName().equals("e")){
		                	int fila1 = tblPerfiles.getSelectedRow();
		                	System.out.println("en eliminar es :"+tblPerfiles.getValueAt(fila1, 0).toString());
		    				String id=tblPerfiles.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
		    			
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
		scrollPane.setViewportView(tblPerfiles);
		

			}

void eliminar(String id) {

	GestionEmpledos gc = new GestionEmpledos();

	int ok = gc.eliminarPerfil(id);

	if (ok == 0) {
		
	} else {
		JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
		TablaPerfiles.model.setRowCount(0);  // <--------- LIMPIA LA TABLA
		TablaPerfiles.listar();
	}

}
}
