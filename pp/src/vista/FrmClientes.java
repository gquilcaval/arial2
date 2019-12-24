package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import model.Clientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

public class FrmClientes extends JDialog {
	private JTextField txtBusqueda;
	public static JTable tblClientes;
	private JTextField txtidCliente;
	private JTextField txtNombreCli;
	private JTextField txtApellidoCli;
	private JTextField txtTelfCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes dialog = new FrmClientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

					dialog.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTextField txtDni;
	private JLabel label;
	private JTextField txtDirecCli;
	private JLabel lblBusqueda;
	private JButton btnCancelar;
	private JTextField txtDniOculto;
	private JTabbedPane panelPrincipal;
	private JPanel panel_1;
	private JPanel panel;

	public FrmClientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});

		setTitle("Clientes");
		setBounds(100, 100, 697, 383);
		getContentPane().setLayout(null);

		panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setBounds(37, 32, 615, 284);
		getContentPane().add(panelPrincipal);

		model.addColumn("id Cliente");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Dni");
		model.addColumn("Telefono");
		model.addColumn("Direccion");
		
		

		panel = new JPanel();

		panelPrincipal.addTab("Buscar", null, panel, null);
		panel.setLayout(null);

		txtBusqueda = new JTextField();
		txtBusqueda.setName("");
		txtBusqueda.setToolTipText("");
		txtBusqueda.addKeyListener(new KeyAdapter() {

			/*-----------------------> EVENTO BUSCAR CLIENTE <----------------------------*/
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarCli();
			}
		});
		/*----------------------------------------------------------------------------------------*/
		txtBusqueda.setBounds(20, 33, 241, 20);
		panel.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setBounds(21, 11, 61, 14);
		panel.add(lblBusqueda);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(20, 64, 462, 181);

		panel.add(scrollPane);

		tblClientes = new JTable();

		tblClientes.addMouseListener(new MouseAdapter() {

			/*-----------------------> EVENTO SELECCIONAR CLIENTE <----------------------------*/
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int fila1 = tblClientes.getSelectedRow();
				txtidCliente.setText(tblClientes.getValueAt(fila1, 0).toString());
				txtDniOculto.setText(tblClientes.getValueAt(fila1, 3).toString());
				try {

					int fila = tblClientes.getSelectedRow();
					FrmVentas.txtCodigoCliente.setText(tblClientes.getValueAt(fila, 0).toString());
					FrmVentas.txtNombreCliente.setText(tblClientes.getValueAt(fila,1).toString());
					FrmVentas.txtApellidosCli.setText(tblClientes.getValueAt(fila, 2).toString());

					dispose();
				} catch (Exception e2) {

					
				}
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});

		/*-----------------------------------------------------------------------------------*/
		
		tblClientes.setCellSelectionEnabled(true);
		tblClientes.setModel(model);
		scrollPane.setViewportView(tblClientes);
		
		txtDniOculto = new JTextField();
		scrollPane.setColumnHeaderView(txtDniOculto);
		txtDniOculto.setColumns(10);

		btnNuevo = new JButton("Nuevo");

		btnNuevo.setBounds(408, 32, 73, 23);
		panel.add(btnNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(502, 96, 73, 23);
		panel.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(502, 130, 73, 23);
		panel.add(btnEliminar);

		btnSalir = new JButton("salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(502, 164, 73, 23);
		panel.add(btnSalir);

		panel_1 = new JPanel();
		panelPrincipal.addTab("Nuevo / Modificar", null, panel_1, null);
		panelPrincipal.setEnabledAt(1, false);
		panel_1.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("ID Cliente");
		lblNewLabel.setBounds(27, 35, 69, 14);
		panel_1.add(lblNewLabel);

		txtidCliente = new JTextField();
		txtidCliente.setEditable(false);
		txtidCliente.setBounds(172, 32, 99, 20);
		panel_1.add(txtidCliente);
		txtidCliente.setColumns(10);

		txtNombreCli = new JTextField();
		txtNombreCli.setBounds(172, 57, 99, 20);
		panel_1.add(txtNombreCli);
		txtNombreCli.setColumns(10);

		JLabel lblNombreORazon = new JLabel("Nombre");
		lblNombreORazon.setBounds(27, 57, 135, 14);
		panel_1.add(lblNombreORazon);

		JLabel lblRuc = new JLabel("Apellidos");
		lblRuc.setBounds(27, 82, 69, 14);
		panel_1.add(lblRuc);

		txtApellidoCli = new JTextField();
		txtApellidoCli.setBounds(172, 82, 99, 20);
		panel_1.add(txtApellidoCli);
		txtApellidoCli.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(172, 107, 99, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);

		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(27, 107, 69, 14);
		panel_1.add(lblDni);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(27, 132, 69, 14);
		panel_1.add(lblTelefono);

		txtTelfCli = new JTextField();
		txtTelfCli.setBounds(172, 132, 99, 20);
		panel_1.add(txtTelfCli);
		txtTelfCli.setColumns(10);

		txtDirecCli = new JTextField();
		txtDirecCli.setBounds(172, 165, 99, 20);
		panel_1.add(txtDirecCli);
		txtDirecCli.setColumns(10);

		label = new JLabel("Direcci\u00F3n");
		label.setBounds(27, 162, 69, 14);
		panel_1.add(label);

		JButton btnAceptar = new JButton("Aceptar");
		
		/*-----------------------> EVENTO AL ACEPTAR REGISTRA O ACTUALIZA DATOS DEL CLIENTE <----------------------------*/
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);
				

				if (txtidCliente.getText().isEmpty()) {
					registrar();
				}
				else {
					
					actualizar();
				}
			}
		});
		
		/*------------------------------------------------------------------------------------------------------*/
		btnAceptar.setBounds(369, 106, 94, 23);
		panel_1.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		
		/*-----------------------> EVENTO AL CANCELAR REGRESA A LA VENTANA CLIENTE BUSCAR <----------------------------*/
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);

				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});
		
		/*--------------------------------------------------------------------------------------------*/
		btnCancelar.setBounds(369, 140, 94, 23);
		panel_1.add(btnCancelar);

		/*-----------------------> EVENTO  ELIMANAR CLIENTE <-------------------------*/
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtidCliente.getText().isEmpty()) {
				
				}
				else{eliminar();
				}
				
			}
		});
		
		/*-----------------------------------------------------------------------*/
		
		
		/*--------> EVENTO  AL PRECIONAR EL BOTON MODIFICAR TE ABRE FORMULARIO PARA MODIFICAR <----------*/
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel_1);

				
				
			}
		});

		/*-----------------------------------------------------------------------------------------------*/
		
		/*-------> EVENTO  TE ABRE FORMULARIO PARA AGREGAR CLIENTE <----------*/
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Nuevo ", panel_1);

				
				
				txtidCliente.setText("");
				

			}
		});
     
		/*-------------------------------------------------------------------------*/
	}

	void listar() {

		GestionClientes gc = new GestionClientes();
		ArrayList<Clientes> lista = gc.listado();
		model.getDataVector().removeAllElements();
		
		for (Clientes cl : lista) {
			Object datos[] = {  cl.getId_cli(),cl.getNomb_cli(),  cl.getTelf_cli(),
					cl.getDirec_cli() };

			model.addRow(datos);

		}

	}

	void buscarCli() {

		String cliente = txtBusqueda.getText();

		GestionClientes gc = new GestionClientes();
		model.getDataVector().removeAllElements();

		ArrayList<Clientes> list = gc.listado(cliente);
		for (Clientes cl : list) {
			Object datos[] = { cl.getId_cli(), cl.getNomb_cli(), cl.getTelf_cli() };
			model.addRow(datos);

		}
	}

	void registrar() {

		String nom, ape, direc, telf, dni;
		nom = txtNombreCli.getText();
		direc = txtDirecCli.getText();
		telf = txtTelfCli.getText();
		ape = txtApellidoCli.getText();
		dni = txtDni.getText();
		if (nom.matches("[a-zA-Z]+")) {
			Clientes c = new Clientes();
			c.setNomb_cli(nom);
			
			c.setDirec_cli(direc);
			c.setTelf_cli(telf);

			GestionClientes gc = new GestionClientes();

			int ok = gc.registrar(c);
			
			if (ok == 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "registro correcto");
				model.setRowCount(0);
				limpiarCampos();
				listar();
			}
			
			panelPrincipal.removeAll();
			panelPrincipal.add("Buscar", panel);
			panelPrincipal.add("Nuevo / Modificar", panel_1);


		}
		else {
			JOptionPane.showMessageDialog(null,"campo nombre incorrecto");
			
		}
		

		
			}

	void actualizar() {

		String nom, ape, direc, telf, dni;
		int id;

		nom = txtNombreCli.getText();
		direc = txtDirecCli.getText();
		telf = txtTelfCli.getText();
		ape = txtApellidoCli.getText();
		dni = txtDni.getText();
         id=Integer.parseInt(txtidCliente.getText());
		Clientes c = new Clientes();
	
		c.setNomb_cli(nom);
	
		c.setDirec_cli(direc);
		c.setTelf_cli(telf);
        c.setId_cli(id);
		GestionClientes gc = new GestionClientes();

		int ok = gc.actualizar(c);

		if (ok == 0) {
		
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro actulizado");
			model.setRowCount(0);
			limpiarCampos();
			listar();
		}
	}

	void eliminar() {

		String dni;

		dni = txtidCliente.getText();

		GestionClientes gc = new GestionClientes();

		int ok = gc.eliminar(dni);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
			model.setRowCount(0);  // <--------- LIMPIA LA TABLA
			limpiarCampos();
			listar();
		}
	}
	
	void limpiarCampos(){
		
		txtNombreCli.setText("");
		txtApellidoCli.setText("");
		txtDirecCli.setText("");
		txtTelfCli.setText("");
		txtDni.setText("");
		
	}
}
