package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import hilos.Hilo_Tiempo;
import mantenimientos.GestionCompra;
import model.DetalleCompra;
import model.OrdenCompra;
import model.Proveedores;
import model.RegistroCompra;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistroCompra extends JDialog {
	private JTextField textField;
	private JTextField txtProveedor;
	private JTextField txtRuc;
	private JTextField textField_3;
	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField txtDireccion;
	private JTextField txtOrdenCompra;
	DefaultTableModel model=new DefaultTableModel();
	private JTable tblRegistroCompra;
	private JTextField txtSubtotal;
	private JTextField txtImpuesto;
	private JTextField txtTotal;
	public static double importe;
	public static double subtotal;
	public static double igv;
	public static double total;
	private JComboBox cboComprovante;
	private JDateChooser dtmEmision;
	private JDateChooser dtmVencimiento;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRegistroCompra dialog = new FrmRegistroCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegistroCompra() {
		
		/*model para el registro de compra*/
		
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Cantidad");
		
		model.addColumn("Valor unitatio");
		model.addColumn("Precion unitario");
		model.addColumn("Neto");
		model.addColumn("Impuesto");
		model.addColumn("Total");
		
		
		
		setBounds(100, 100, 1266, 979);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(45, 54, 63));
		panel.setBounds(0, 0, 1250, 66);
		getContentPane().add(panel);
		
		JLabel lblRegistroDeCompra = new JLabel("REGISTRO DE COMPRA");
		lblRegistroDeCompra.setForeground(Color.WHITE);
		lblRegistroDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRegistroDeCompra.setBounds(10, 0, 194, 66);
		panel.add(lblRegistroDeCompra);
		
		GestionCompra g=new GestionCompra();
		String numeroCompra;
		numeroCompra ="N°0000"+g.ObtenerNumeroRegistroCompra();
		
		JLabel lblNumeroOrden = new JLabel(numeroCompra);
		lblNumeroOrden.setForeground(Color.WHITE);
		lblNumeroOrden.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroOrden.setBounds(1140, 27, 84, 14);
		panel.add(lblNumeroOrden);
		
		JLabel label = new JLabel("Usuario :");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(12, 83, 64, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_1.setBounds(84, 82, 100, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		label_2.setBounds(0, 96, 1250, 14);
		getContentPane().add(label_2);
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(1057, 77, 91, 29);
		getContentPane().add(lblFecha);
		
		 lblReloj = new JLabel("");
		lblReloj.setForeground(Color.BLACK);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(1158, 77, 46, 29);
		getContentPane().add(lblReloj);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 130, 390, 245);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(45, 54, 63));
		panel_2.setBounds(0, 0, 445, 50);
		panel_1.add(panel_2);
		
		JLabel label_5 = new JLabel("Proveedor");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_5.setBounds(10, 0, 73, 50);
		panel_2.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 17, 222, 20);
		panel_2.add(textField);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(365, 17, 20, 20);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_7.setBounds(466, 0, 56, 50);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Razon Social  :");
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_8.setBounds(10, 88, 115, 14);
		panel_1.add(label_8);
		
		JLabel lblRuc = new JLabel("RUC              :     ");
		lblRuc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblRuc.setBounds(10, 132, 115, 14);
		panel_1.add(lblRuc);
		
		JLabel lblDireccion = new JLabel("Direccion       :");
		lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 180, 115, 14);
		panel_1.add(lblDireccion);
		
		txtProveedor = new JTextField();
		txtProveedor.setOpaque(false);
		txtProveedor.setColumns(10);
		txtProveedor.setBounds(135, 86, 221, 20);
		panel_1.add(txtProveedor);
		
		txtRuc = new JTextField();
		txtRuc.setOpaque(false);
		txtRuc.setColumns(10);
		txtRuc.setBounds(135, 130, 221, 20);
		panel_1.add(txtRuc);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 522, 305);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(45, 54, 63));
		panel_6.setBounds(0, 0, 522, 50);
		panel_5.add(panel_6);
		
		JLabel label_3 = new JLabel("Proveedor");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_3.setBounds(10, 0, 73, 50);
		panel_6.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 17, 222, 20);
		panel_6.add(textField_4);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(365, 17, 20, 20);
		panel_6.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_14.setBounds(466, 0, 56, 50);
		panel_6.add(label_14);
		
		JLabel label_15 = new JLabel("Razon Social  :");
		label_15.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_15.setBounds(10, 88, 115, 14);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("RUC              :     ");
		label_16.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_16.setBounds(10, 132, 115, 14);
		panel_5.add(label_16);
		
		JLabel label_17 = new JLabel("Direccion       :");
		label_17.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_17.setBounds(10, 180, 115, 14);
		panel_5.add(label_17);
		
		textField_8 = new JTextField();
		textField_8.setOpaque(false);
		textField_8.setColumns(10);
		textField_8.setBounds(135, 86, 221, 20);
		panel_5.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setOpaque(false);
		textField_9.setColumns(10);
		textField_9.setBounds(135, 130, 221, 20);
		panel_5.add(textField_9);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(135, 178, 221, 20);
		panel_5.add(txtDireccion);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 178, 221, 20);
		panel_5.add(textField_3);
		textField_3.setOpaque(false);
		textField_3.setColumns(10);
		
		JLabel lblComprobante = new JLabel("Comprobante");
		lblComprobante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblComprobante.setBounds(388, 74, 95, 33);
		getContentPane().add(lblComprobante);
		
		cboComprovante = new JComboBox();
		cboComprovante.setModel(new DefaultComboBoxModel(new String[] {"BOLETA", "FACTURA"}));
		cboComprovante.setBounds(493, 82, 128, 20);
		getContentPane().add(cboComprovante);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(483, 130, 358, 245);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(45, 54, 63));
		panel_4.setBounds(0, 0, 358, 50);
		panel_3.add(panel_4);
		
		JLabel lblCondicionesDePago = new JLabel("Condiciones de pago");
		lblCondicionesDePago.setForeground(Color.WHITE);
		lblCondicionesDePago.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCondicionesDePago.setBounds(10, 0, 141, 50);
		panel_4.add(lblCondicionesDePago);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(365, 17, 20, 20);
		panel_4.add(label_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_9.setBounds(466, 0, 56, 50);
		panel_4.add(label_9);
		
		JLabel lblFechaDeEmision = new JLabel("fecha de emision  :");
		lblFechaDeEmision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaDeEmision.setBounds(10, 61, 115, 14);
		panel_3.add(lblFechaDeEmision);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago     :");
		lblFormaDePago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFormaDePago.setBounds(10, 112, 115, 14);
		panel_3.add(lblFormaDePago);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento    :");
		lblFechaDeVencimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaDeVencimiento.setBounds(10, 160, 125, 14);
		panel_3.add(lblFechaDeVencimiento);
		
		JComboBox cboFormaPago; 
		cboFormaPago= new JComboBox();
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"credito 30 ", "credito 90"}));
		cboFormaPago.setBounds(146, 110, 115, 20);
		panel_3.add(cboFormaPago);
		
		dtmEmision = new JDateChooser();
		dtmEmision.setBounds(145, 61, 95, 20);
		panel_3.add(dtmEmision);
		
		dtmVencimiento = new JDateChooser();
		dtmVencimiento.setBounds(145, 154, 95, 20);
		panel_3.add(dtmVencimiento);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(921, 130, 319, 245);
		getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(45, 54, 63));
		panel_8.setBounds(0, 0, 319, 50);
		panel_7.add(panel_8);
		
		JLabel lblDatosAdicionales = new JLabel("Datos adicionales");
		lblDatosAdicionales.setForeground(Color.WHITE);
		lblDatosAdicionales.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDatosAdicionales.setBounds(10, 0, 141, 50);
		panel_8.add(lblDatosAdicionales);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(365, 17, 20, 20);
		panel_8.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_12.setBounds(466, 0, 56, 50);
		panel_8.add(label_12);
		
		JLabel lblOrdenDeCompra = new JLabel("Orden de compra");
		lblOrdenDeCompra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblOrdenDeCompra.setBounds(10, 72, 115, 14);
		panel_7.add(lblOrdenDeCompra);
		
		txtOrdenCompra = new JTextField();
		txtOrdenCompra.setBounds(134, 70, 95, 20);
		panel_7.add(txtOrdenCompra);
		txtOrdenCompra.setColumns(10);
		
		JButton btnPoner = new JButton("poner");
		btnPoner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model.setRowCount(0);
				int codigoRegisCompra=Integer.parseInt(txtOrdenCompra.getText());
				
				/*con esto llenamos la tabla tblProducto :v*/
				ArrayList<OrdenCompra>lista= g.listaOrdenCompra(codigoRegisCompra);
				
				
				
				System.out.println(codigoRegisCompra);
				txtProveedor.setText(lista.get(0).getNomProveedor());
				txtRuc.setText(lista.get(0).getRuc());
				txtDireccion.setText(lista.get(0).getDirecProveedor());
				cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {lista.get(0).getCondicionPago()}));
				
				
			
				
				for (OrdenCompra cl : lista) {
					Object datos[] = { cl.getIdprodu(),cl.getNomProd(),cl.getCantidad(),cl.getPrecio(),"","",cl.getTotal() };
					model.addRow(datos);
					System.out.println(cl.getIdprodu());

				}
				/* calcular el importe */
			/*
				double precio = Double.parseDouble(tblRegistroCompra.getValueAt(1, 4).toString());
				double cantidad = Double.parseDouble(tblRegistroCompra.getValueAt(1, 3).toString());
				importe = precio * cantidad;

				
				subtotal = subtotal + importe;
				

				
				igv = subtotal * 0.18;

				
				total = subtotal + igv;
				
				txtSubtotal.setText(subtotal + "");

				txtImpuesto.setText(igv + "");

				txtTotal.setText(total + "");
				
				*/
			}
		});
		btnPoner.setBounds(10, 111, 89, 23);
		panel_7.add(btnPoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 421, 1228, 235);
		getContentPane().add(scrollPane);
		
		tblRegistroCompra = new JTable();
		tblRegistroCompra.setModel(model);
		scrollPane.setViewportView(tblRegistroCompra);
		
		JLabel label_10 = new JLabel("Sub total");
		label_10.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_10.setBounds(616, 680, 91, 29);
		getContentPane().add(label_10);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setColumns(10);
		txtSubtotal.setBounds(691, 686, 86, 20);
		getContentPane().add(txtSubtotal);
		
		JLabel label_18 = new JLabel("Impuesto(18%)");
		label_18.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_18.setBounds(853, 684, 106, 21);
		getContentPane().add(label_18);
		
		txtImpuesto = new JTextField();
		txtImpuesto.setEditable(false);
		txtImpuesto.setColumns(10);
		txtImpuesto.setBounds(969, 686, 86, 20);
		getContentPane().add(txtImpuesto);
		
		JLabel label_19 = new JLabel("Total");
		label_19.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_19.setBounds(1098, 687, 46, 14);
		getContentPane().add(label_19);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(1154, 686, 86, 20);
		getContentPane().add(txtTotal);
		
		JButton btnGrabar = new JButton("Grabar");
		
		
		btnGrabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				grabar();
				
				
			}
		});
		btnGrabar.setBounds(1151, 747, 89, 23);
		getContentPane().add(btnGrabar);
		
		iniciaReloj();
	}
	
	ArrayList<DetalleCompra> carrito = new ArrayList<>();
	void iniciaReloj() {
		Hilo_Tiempo h=new Hilo_Tiempo();
		h.start();
	}
	
	
	
	
	void grabar() {
		
		int nroOrdenCompra;
		String comprovante,fechaRegis,fechaVenci;
		
		GestionCompra c=new GestionCompra();
		nroOrdenCompra=c.ObtenerNumeroRegistroCompra();
		comprovante=cboComprovante.getSelectedItem().toString();
		
		/*para la fecha*/
		Date fecha1=dtmEmision.getDate();
		Date fecha2=dtmVencimiento.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(sdf.format(fecha1).toString());
		fechaRegis=sdf.format(fecha1).toString();
		fechaVenci=sdf.format(fecha2).toString();
		
		
		RegistroCompra r=new RegistroCompra();
		r.setNroOrdenCompra(nroOrdenCompra);
		r.setComprovante(comprovante);
		r.setFechaRegisCompra(fechaRegis);
		r.setFechaVenCompra(fechaVenci);
		
		
		
		for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
			DetalleCompra deta=new DetalleCompra();
			
			deta.setIdprodu(Integer.parseInt(tblRegistroCompra.getValueAt(i, 0).toString()));
			deta.setCantidad(Integer.parseInt(tblRegistroCompra.getValueAt(i, 2).toString()));
			
			carrito.add(deta);
		}
		
		
		
		
		
		int ok=c.realizaCompra(r, carrito);
		
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error al Grabar la Compra");
		} else {
			JOptionPane.showMessageDialog(null, "registro Exitosa");
		}
	
	}
	
	
}
