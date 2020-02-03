
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import hilos.Hilo_Tiempo;
import mantenimientos.GestionCompra;
import model.DetalleCompra;
import model.JDateChooserEditor;
import model.OrdenCompra;
import model.Proveedores;
import model.RegistroCompra;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import componentes.boton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class FrmRegistroCompra extends JDialog {
	private JTextField txtProveedor;
	private JTextField txtRuc;
	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JTextField txtOrdenCompra;
	public static DefaultTableModel model=new DefaultTableModel();
	private JTable tblRegistroCompra;
	private JTextField txtTotal;
	public static double importe;
	public static double subtotal;
	public static double igv;
	public static double total;
	private JComboBox cboComprovante;
	private JDateChooser dtmEmision;
	private JDateChooser dtmVencimiento;
	public String numeroCompra;
	public int numero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRegistroCompra dialog = new FrmRegistroCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegistroCompra() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				lblUsuario.setText(FrmLogin.e.getNom_emp());
			
				
			}
		});
		
		
		setModal(true);
		
		/*model para el registro de compra*/
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Cantidad");
		
		model.addColumn("Valor unitatio");
		/*el precio unitario es el valor unitario mas el impuesto */
		/*model.addColumn("Precion unitario");*/
		
		
		
	
		model.addColumn("Total");
	/*	model.addColumn("fecha Caducidad");*/
		
		
		setBounds(100, 100, 1370, 830);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(45, 54, 63));
		panel.setBounds(0, 0, 1354, 66);
		getContentPane().add(panel);
		
		JLabel lblRegistroDeCompra = new JLabel("REGISTRO DE COMPRA");
		lblRegistroDeCompra.setForeground(Color.WHITE);
		lblRegistroDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRegistroDeCompra.setBounds(34, 0, 194, 66);
		panel.add(lblRegistroDeCompra);
		
		GestionCompra g=new GestionCompra();
		 numero=g.ObtenerNumeroRegistroCompra();
		numeroCompra ="N°0000"+numero;
		
		lblNumeroOrden = new JLabel(numeroCompra);
		lblNumeroOrden.setForeground(Color.WHITE);
		lblNumeroOrden.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroOrden.setBounds(1216, 27, 78, 14);
		panel.add(lblNumeroOrden);
		
		JLabel label = new JLabel("Usuario :");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(34, 83, 64, 14);
		getContentPane().add(label);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(104, 77, 100, 20);
		getContentPane().add(lblUsuario);
		
		JLabel label_2 = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		label_2.setBounds(0, 96, 1367, 14);
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
		panel_1.setBounds(34, 130, 390, 245);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
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
		lblDireccion.setBounds(10, 179, 115, 14);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(45, 54, 63));
		panel_2.setBounds(0, 0, 389, 50);
		panel_1.add(panel_2);
		
		JLabel label_1 = new JLabel("Proveedor");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_1.setBounds(10, 0, 73, 50);
		panel_2.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(93, 17, 222, 20);
		panel_2.add(textField);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(314, 17, 20, 20);
		panel_2.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_5.setBounds(466, 0, 56, 50);
		panel_2.add(label_5);
		
		txtCodigo = new JLabel("");
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtCodigo.setBounds(340, 0, 49, 50);
		panel_2.add(txtCodigo);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(135, 177, 221, 20);
		txtDireccion.setOpaque(false);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto       :");
		lblContacto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContacto.setBounds(10, 220, 115, 14);
		panel_1.add(lblContacto);
		
		txtContacto = new JTextField();
		txtContacto.setOpaque(false);
		txtContacto.setColumns(10);
		txtContacto.setBounds(135, 218, 221, 20);
		panel_1.add(txtContacto);
		
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
		cboFormaPago= new JComboBox();
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"credito 30 ", "credito 90"}));
		cboFormaPago.setBounds(146, 110, 94, 20);
		panel_3.add(cboFormaPago);
		
		dtmEmision = new JDateChooser();
		dtmEmision.setBounds(145, 61, 95, 20);
		panel_3.add(dtmEmision);
		
		dtmVencimiento = new JDateChooser();
		dtmVencimiento.setBounds(145, 154, 95, 20);
		panel_3.add(dtmVencimiento);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(975, 130, 319, 245);
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
				int codigoOrdenCompra=Integer.parseInt(txtOrdenCompra.getText());
				
				ArrayList<OrdenCompra>datosProducto= g.listaOrdenCompra(codigoOrdenCompra);
				ArrayList<OrdenCompra>lista= g.obtenerDatosOrdenCompra(codigoOrdenCompra);
				if(lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "el numero de orden no existe");
				}
				else {
					
				int codigoProve=lista.get(0).getCodProveedor();
				
				lblUsuario.setText(lista.get(0).getNomUsuario());
				txtCodigo.setText(codigoProve+"");
				txtProveedor.setText(lista.get(0).getNomProveedor());
				txtRuc.setText(lista.get(0).getRuc());
				txtDireccion.setText(lista.get(0).getDirecProveedor());
				cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {lista.get(0).getCondicionPago()}));
				
				
				/*tblRegistroCompra.getColumnModel().getColumn(7).setCellEditor(new JDateChooserEditor(new JCheckBox()));
					DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
					tblRegistroCompra.getColumnModel().getColumn(7).setCellRenderer(renderer);*/
				
				int total=0;
				
				for (OrdenCompra cl : datosProducto) {
					double subtotal=cl.getCantidad()*cl.getPrecio();
					
					Object datos[] = { cl.getIdprodu(),cl.getNomProd(),cl.getCantidad(),cl.getPrecio(),subtotal};
					model.addRow(datos);
					total+=subtotal;

				}
				
				
				txtTotal.setText(""+total);
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
*/
				txtTotal.setText(total + "");
				
				
				}
			}
		});
		btnPoner.setBounds(10, 111, 89, 23);
		panel_7.add(btnPoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 466, 1260, 235);
		getContentPane().add(scrollPane);
		
		tblRegistroCompra = new JTable();
		tblRegistroCompra.setModel(model);
		scrollPane.setColumnHeaderView(tblRegistroCompra);
		
		JLabel label_19 = new JLabel("Total");
		label_19.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_19.setBounds(1158, 687, 46, 14);
		getContentPane().add(label_19);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(1194, 708, 86, 20);
		getContentPane().add(txtTotal);
		
		label_6 = new JLabel("Grabar");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			grabar();
			
			IntGestionDeCompra.model.setRowCount(0);
			IntGestionDeCompra.listadoRegistroCompra();
			dispose();
			
			}
		});
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_6.setBorder(new LineBorder(Color.decode("#28a745")));
		label_6.setBackground(new Color(40, 167, 69));
		label_6.setBounds(1194, 739, 100, 25);
		getContentPane().add(label_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarProductoRegistroCompra f=new FrmBuscarProductoRegistroCompra();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		
		panel_5.setBounds(34, 426, 166, 29);
		
		boton.mibotonAgregar(panel_5);
		getContentPane().add(panel_5);
		
		iniciaReloj();
	}
	
	ArrayList<DetalleCompra> carrito = new ArrayList<>();
	private JLabel lblUsuario;
	private JTextField textField;
	private JTextField txtDireccion;
	private JLabel label_6;
	private JTextField txtContacto;
	private JLabel lblNumeroOrden;
	private JLabel txtCodigo;
	private JComboBox cboFormaPago;
	
	
	
	void iniciaReloj() {
		Hilo_Tiempo h=new Hilo_Tiempo();
		h.start();
	}
	
void grabar() {
		
		int nroOrdenCompra,idProve,idUsu,nroRegistroCompra;
		String comprovante,fechaRegis,fechaVenci,formaPago,contacto;
		
		GestionCompra c=new GestionCompra();
		
		System.out.println(numero);
		nroRegistroCompra=numero;
		
		String texto=txtOrdenCompra.getText();
		
		if(texto.isEmpty()) {
			nroOrdenCompra=0;
		}else {
			
		nroOrdenCompra=Integer.parseInt(txtOrdenCompra.getText());
		}
		
		
		comprovante=cboComprovante.getSelectedItem().toString();
		idProve=1;
		idUsu=FrmLogin.e.getId_emp();
		formaPago=cboFormaPago.getSelectedItem().toString();
		contacto=txtContacto.getText();
		/*para la fecha*/
		Date fecha1=dtmEmision.getDate();
		Date fecha2=dtmVencimiento.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(sdf.format(fecha1).toString());
		fechaRegis=sdf.format(fecha1).toString();
		fechaVenci=sdf.format(fecha2).toString();
		
		
		RegistroCompra r=new RegistroCompra();
		r.setCodRegisCompra(nroRegistroCompra);
		r.setNroOrdenCompra(nroOrdenCompra);
		r.setComprovante(comprovante);
		r.setFechaRegisCompra(fechaRegis);
		r.setFechaVenCompra(fechaVenci);
		
		r.setCondicionesPago(formaPago);
		r.setContacto(contacto);
		r.setIdProve(idProve);
		r.setIdUsu(idUsu);
		
		
		for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
			DetalleCompra deta=new DetalleCompra();
			
			deta.setIdprodu(Integer.parseInt(tblRegistroCompra.getValueAt(i, 0).toString()));
			deta.setCantidad(Integer.parseInt(tblRegistroCompra.getValueAt(i, 2).toString()));
			deta.setPrecio(Double.parseDouble(tblRegistroCompra.getValueAt(i, 3).toString()));
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

