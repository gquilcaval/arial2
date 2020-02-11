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

import mantenimientos.GestionCorteCaja;
import mantenimientos.GestionEmpledos;
import model.CorteCaja;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;
import utils.clsArial;

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
import java.awt.SystemColor;

import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class IntCajaCortes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCajaCortes frame = new IntCajaCortes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTable tblCorteCaja;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public IntCajaCortes() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
		JPanel pnlRegistroMovCaja = new JPanel();
		pnlRegistroMovCaja.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlRegistroMovCaja.setLayout(null);
		pnlRegistroMovCaja.setBackground(new Color(45, 54, 63));
		pnlRegistroMovCaja.setBounds(10, 11, 378, 802);
		getContentPane().add(pnlRegistroMovCaja);
		
		JLabel lblHoy = new JLabel("Corte de Caja");
		lblHoy.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoy.setForeground(new Color(240, 240, 240, 240));
		lblHoy.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblHoy.setBounds(92, 22, 204, 37);
		pnlRegistroMovCaja.add(lblHoy);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 83, 378, 719);
		pnlRegistroMovCaja.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipo = new JLabel("Caja                    -");
		lblTipo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblTipo.setBounds(32, 176, 131, 20);
		panel_1.add(lblTipo);
		
		JLabel lblMonto = new JLabel("Usuario              -");
		lblMonto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblMonto.setBounds(32, 224, 131, 14);
		panel_1.add(lblMonto);
		
		JLabel lblNombre = new JLabel("Nombre            -");
		lblNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNombre.setBounds(32, 265, 131, 14);
		panel_1.add(lblNombre);
		
		JLabel lblFecha_1 = new JLabel("Fecha                 -");
		lblFecha_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFecha_1.setBounds(32, 307, 131, 14);
		panel_1.add(lblFecha_1);
		
		JLabel lblFecha_1_1 = new JLabel("Hora                  -");
		lblFecha_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFecha_1_1.setBounds(32, 351, 131, 14);
		panel_1.add(lblFecha_1_1);
		
		JLabel iconoCorte = new JLabel("");
		iconoCorte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconoCorte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int codigoCaja=Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText().toString());
				System.out.println("codigo caja "+codigoCaja);
			ArrayList<CorteCaja> listado=new GestionCorteCaja().calcularCalculado(1);
			System.out.println("el calculado es  "+listado.get(0).getCalculado());
			
			double calculado=listado.get(0).getCalculado();
				
				
				JdialogCajaCorte corte=new JdialogCajaCorte();
				JdialogCajaCorte.lblcalculado.setText(calculado+"");
				corte.setVisible(true);
			}
		});
		iconoCorte.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/corte_caja.png", 45, 45, iconoCorte);
		iconoCorte.setBounds(32, 22, 50, 50);
		panel_1.add(iconoCorte);
		
		JLabel lblCorteDe = new JLabel("Corte ");
		lblCorteDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorteDe.setForeground(Color.BLACK);
		lblCorteDe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblCorteDe.setBounds(32, 72, 46, 14);
		panel_1.add(lblCorteDe);
		
		JPanel pnlConsultMovCaja = new JPanel();
		pnlConsultMovCaja.setBackground(Color.WHITE);
		pnlConsultMovCaja.setBounds(417, 11, 1215, 802);
		getContentPane().add(pnlConsultMovCaja);
		pnlConsultMovCaja.setLayout(null);
		
		tblCorteCaja = new JTable();
		tblCorteCaja.setBounds(10, 159, 1195, 304);
		pnlConsultMovCaja.add(tblCorteCaja);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(45, 54, 63));
		panel_2.setBounds(0, 0, 1215, 81);
		pnlConsultMovCaja.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblExcel = new JLabel("Previa");
		lblExcel.setForeground(new Color(240, 240, 240, 240));
		lblExcel.setBounds(10, 61, 46, 14);
		panel_2.add(lblExcel);
		lblExcel.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel iconoVistaPrevia = new JLabel("");
		iconoVistaPrevia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconoVistaPrevia.setBounds(10, 11, 50, 50);
		panel_2.add(iconoVistaPrevia);
		iconoVistaPrevia.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/vista_previa.png", 45, 45, iconoVistaPrevia);
		
		JLabel lblFecha = new JLabel("Fecha Inicial :");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(10, 121, 94, 20);
		pnlConsultMovCaja.add(lblFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 121, 107, 20);
		pnlConsultMovCaja.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(339, 121, 107, 20);
		pnlConsultMovCaja.add(dateChooser_1);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final :");
		lblFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFinal.setForeground(Color.BLACK);
		lblFechaFinal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFechaFinal.setBounds(239, 121, 94, 20);
		pnlConsultMovCaja.add(lblFechaFinal);
		
		table = new JTable();
		table.setBounds(10, 502, 1195, 289);
		pnlConsultMovCaja.add(table);
		

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
