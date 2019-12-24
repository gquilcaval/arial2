package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.axis.StandardTickUnitSource;
import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimientos.GestionClientes;
import mantenimientos.GestionCompra;
import mantenimientos.GestionProductos;
import model.Clientes;
import model.DetalleCompra;
import model.Producto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmBuscarProducto extends JDialog {
	private JTextField textField;
	private JTable tblProducto;

	public static ArrayList<DetalleCompra> carrito=new ArrayList<DetalleCompra>();;

	public static double importe;
	public static double subtotal;
	public static double igv;
	public static double total;
	
	/* listado productos */
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			FrmBuscarProducto dialog = new FrmBuscarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBuscarProducto() {
		/*agregar al carrito*/
		
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});

		/* agregar columnas de productos */
		model.addColumn("Codigo");
		model.addColumn("Linea");
		model.addColumn("Descripcion");
		model.addColumn("Stock");
		model.addColumn("Costo");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblProductos.setBounds(76, 23, 97, 28);
		getContentPane().add(lblProductos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmBuscarProducto.class.getResource("/iconos/Producto.png")));
		lblNewLabel.setBounds(20, 11, 46, 56);
		getContentPane().add(lblNewLabel);

		Panel panel = new Panel();
		panel.setBounds(0, 92, 687, 68);
		panel.setBackground(Color.decode("#2D363F"));
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField(10);

		textField.setToolTipText("");
		textField.setBackground(new Color(239, 244, 249));
		textField.setBounds(58, 23, 207, 25);
		panel.add(textField);

		JLabel label = new JLabel("");
		label.setBounds(15, 21, 38, 29);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(32, 28, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label.setIcon(ic);
		panel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 667, 374);
		getContentPane().add(scrollPane);

		/*arraylist para agregar productos al carrito*/
		
	
		 
		tblProducto = new JTable();
	
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int fila = tblProducto.getSelectedRow();

				Object[] filas = new Object[6];

				// Secci�n 3
				filas[0] = tblProducto.getValueAt(fila, 0);
				filas[1] = tblProducto.getValueAt(fila, 2);
				filas[2] = tblProducto.getValueAt(fila, 3);
				filas[3] = tblProducto.getValueAt(fila, 4);
				/* calcular el importe */

				double precio = Double.parseDouble(tblProducto.getValueAt(fila, 4).toString());
				double cantidad = Double.parseDouble(tblProducto.getValueAt(fila, 3).toString());
				
				importe = precio * cantidad;
				filas[4]=importe;
				
				
				
				FrmOrdenDeCompra.model1.addRow(filas);
				

				/* calcular el subtotal */
				subtotal = subtotal + importe;
				filas[4] = importe;

				/* calcular el igv */
				igv = subtotal * 0.18;

				/* total */
				total = subtotal + igv;
				
			
				DetalleCompra dv = new DetalleCompra();
				GestionCompra g=new GestionCompra();
				dv.setNroCompra(g.ObtenerNumero());
				dv.setIdprodu(Integer.parseInt(filas[0].toString()));
				dv.setCantidad(Integer.parseInt(filas[2].toString()));
				dv.setPrecio(Double.parseDouble(filas[3].toString()));
				System.out.println("1"+filas[0].toString());
				System.out.println("2"+filas[2].toString());
				System.out.println("3"+filas[3].toString());
				
				carrito.add(dv);
				System.out.println("en el buscar es "+carrito);
				

				
				
				
				FrmOrdenDeCompra.txtSubtotal.setText(subtotal + "");

				FrmOrdenDeCompra.txtIGV.setText(igv + "");

				FrmOrdenDeCompra.txtTotal.setText(total + "");
				dispose();
			}
		});
		
		tblProducto.setModel(model);

		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProducto.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblProducto.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProducto.getTableHeader().setSize(WIDTH, 100);
		tblProducto.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));

		scrollPane.setViewportView(tblProducto);

		setBounds(100, 100, 703, 614);
	}

	void listar() {
		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> lista = gc.listado();
		model.getDataVector().removeAllElements();

		for (Producto cl : lista) {
			Object datos[] = { cl.getCodigo(), cl.getIdproveedor(), cl.getDescripcion(), cl.getStock(),
					cl.getPrecioProCompra() };

			model.addRow(datos);

		}

	}
}
