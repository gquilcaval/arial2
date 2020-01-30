package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import componentes.boton;
import mantenimientos.GestionClientes;
import mantenimientos.GestionVentas;
import model.Clientes;
import model.DetalleCompra;
import model.DetalleVentas;
import model.Ventas;
import utils.FormatoTablaMain;
import utils.clsArial;

import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class IntVentasWindow extends JInternalFrame {
	private String colorFondo="#ebf0f4";
	public String ColorMain ="#2D363F";
	public static JTextField txtCliente;
	private JLabel lblUser;
	public static  JTable tblProducto;
	public static DefaultTableModel model=new DefaultTableModel();
	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JLabel lblTotal;
	public static JLabel lblCodigo;
	private JComboBox cboTipoDeComprovante;
	private JLabel lblNumeroVenta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVentasWindow frame = new IntVentasWindow();
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
	public IntVentasWindow() {
		
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				lblUser.setText(FrmLogin.e.getNom_emp());
				
			}
		});
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("codigo");
		model.addColumn("descripcion");
		model.addColumn("cantidad");
		model.addColumn("precio");
		model.addColumn("importe");
		FrmBuscarProductoVenta f=new FrmBuscarProductoVenta();
		boton b=new boton();
		
		getContentPane().add(b.mibotonAgregar(328, 239, f));
		setBackground(Color.RED);
		setBounds(100, 100, 1626, 901);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(140, 11, 1317, 871);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(45, 54, 63));
		panel_1.setBounds(1, 0, 1316, 66);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Usuario");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 28, 78, 14);
		panel_1.add(label);
		
		lblUser = new JLabel("");
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(85, 28, 58, 14);
		panel_1.add(lblUser);
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(805, 19, 91, 29);
		panel_1.add(lblFecha);
		
		lblReloj = new JLabel("");
		lblReloj.setForeground(Color.WHITE);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(916, 19, 46, 29);
		panel_1.add(lblReloj);
		
		String numeroCompra;
		GestionVentas g=new GestionVentas();
		numeroCompra ="N°0000"+g.ObtenerNumero();
		
		lblNumeroVenta = new JLabel(numeroCompra);
		lblNumeroVenta.setForeground(Color.WHITE);
		lblNumeroVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroVenta.setBounds(1209, 28, 78, 14);
		panel_1.add(lblNumeroVenta);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(148, 121, 30, 20);
		clsArial clsArial=new clsArial();
		clsArial.modifiedIcon("/iconos/user.png", 30, 30, label_4);
		panel.add(label_4);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(188, 121, 199, 20);
		panel.add(txtCliente);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarLCiente c=new FrmBuscarLCiente();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(397, 121, 20, 20);
		clsArial.modifiedIcon("/iconos/search.png", 20, 20, label_5);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		clsArial.modifiedIcon("/iconos/product.png", 20, 20, label_6);
		label_6.setBounds(158, 227, 30, 30);
		panel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 277, 706, 285);
		panel.add(scrollPane);
		
		tblProducto = new JTable();
	
		tblProducto.setModel(model);
		scrollPane.setViewportView(tblProducto);
		
		FormatoTablaMain.formatoTabla(tblProducto);
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(1, 277, 60, 285);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 60, 54);
		panel_3.add(panel_4);
		
		JLabel label_7 = new JLabel("Cantidad");
		label_7.setBounds(10, 40, 50, 14);
		panel_4.add(label_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 54, 60, 54);
		panel_3.add(panel_5);
		
		JLabel label_8 = new JLabel("Precio");
		label_8.setBounds(10, 40, 41, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(3, 0, 48, 35);
		panel_5.add(label_9);
		
		JLabel lblTot = new JLabel("Total");
		lblTot.setBounds(638, 604, 54, 20);
		panel.add(lblTot);
		
		lblTotal = new JLabel("");
		lblTotal.setBounds(702, 604, 83, 20);
		panel.add(lblTotal);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				grabar();
				
			}
		});
		btnGrabar.setBounds(779, 674, 89, 23);
		panel.add(btnGrabar);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(453, 127, 46, 14);
		panel.add(lblCodigo);
		
		cboTipoDeComprovante = new JComboBox();
		cboTipoDeComprovante.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Factura", "Boleta"}));
		cboTipoDeComprovante.setBounds(691, 121, 140, 30);
		panel.add(cboTipoDeComprovante);
		
		JLabel lblFechaVencimiento = new JLabel("fecha vencimiento");
		lblFechaVencimiento.setBounds(588, 208, 113, 30);
		panel.add(lblFechaVencimiento);
		
		dtmFechaVencimineto = new JDateChooser();
		dtmFechaVencimineto.setDateFormatString("yyyy/MM/dd");
		dtmFechaVencimineto.setBounds(705, 218, 109, 20);
		panel.add(dtmFechaVencimineto);
		
	
	

	}
	ArrayList<DetalleVentas> carrito = new ArrayList<>();
	private JDateChooser dtmFechaVencimineto;
	void grabar() {
		String a=(String)tblProducto.getValueAt(0, 2);
		if(a==null) {
			JOptionPane.showMessageDialog(null, "ingrese la cantidad");
		}
		else {
			
		int id_cli,id_usu;
		String tipo_comprovante,numero_comprovante,dtmFechaVencimiento;
		
		Date fecha1=dtmFechaVencimineto.getDate();
		String formato = dtmFechaVencimineto.getDateFormatString();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		String fecha=String.valueOf(sdf.format(fecha1));
		
		dtmFechaVencimiento=fecha;
		id_cli=Integer.parseInt(lblCodigo.getText());
		id_usu=FrmLogin.e.getId_emp();
		tipo_comprovante=cboTipoDeComprovante.getSelectedItem().toString();
		numero_comprovante=lblNumeroVenta.getText();
		
		Ventas ve=new Ventas();
		ve.setId_cli(id_cli);
		ve.setId_emp(id_usu);
		ve.setDoc_ven(tipo_comprovante);
		ve.setNumeroComprovante(numero_comprovante);
		
		
		for(int i=0;i<tblProducto.getRowCount();i++) {
			DetalleVentas deta=new DetalleVentas();
			deta.setNro_ven(Integer.parseInt(lblCodigo.getText()));
			deta.setId_prod(Integer.parseInt(tblProducto.getValueAt(i, 0).toString()));
			deta.setPrecioUnidad(Double.parseDouble(tblProducto.getValueAt(i, 3).toString()));
			deta.setCantxUnidad(Integer.parseInt(tblProducto.getValueAt(i, 2).toString()));
			
			carrito.add(deta);
		}
		GestionVentas v=new GestionVentas();
		System.err.println(carrito);
		int ok=v.realizaVenta(ve, carrito);
		
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "se realizo la venta");
		}
		else {
			JOptionPane.showMessageDialog(null, "hubo errores");
		}
		

		}
	}
}
