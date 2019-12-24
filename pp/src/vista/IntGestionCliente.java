package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import model.Clientes;

import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JScrollPane;

public class IntGestionCliente extends JInternalFrame {
private JTextField txtBuscar;
private JTable tblClientes;
private JButton btnEliminar;

/**
 * Launch the application.
 */
public static void main(String[] args) {
 EventQueue.invokeLater(new Runnable() {
  public void run() {
   try {
    IntGestionCliente frame = new IntGestionCliente();
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
DefaultTableModel model = new DefaultTableModel();
private JScrollPane scrollPane;
public IntGestionCliente() {
 addInternalFrameListener(new InternalFrameAdapter() {
  @Override
  public void internalFrameActivated(InternalFrameEvent arg0) {
   listar();
  }
 });
 setTitle("Gestion clientes");
 setBounds(100, 100, 1264, 731);
 model.addColumn("Tipo persona");
 model.addColumn("Forma Pago");
 model.addColumn("Doc");
 model.addColumn("Nº. Documento");
 model.addColumn("Nombre / Razon social");
 model.addColumn("Nombre Comercial");
 model.addColumn("Dirección");
 model.addColumn("Departamento");
 model.addColumn("Distrito");
 model.addColumn("Nº telefono");
 
 getContentPane().setLayout(null);
 
 JButton btnAgregar = new JButton("+");
 btnAgregar.setBounds(1008, 31, 41, 23);
 getContentPane().add(btnAgregar);
 
 txtBuscar = new JTextField();
 txtBuscar.setBounds(1124, 31, 116, 22);
 getContentPane().add(txtBuscar);
 txtBuscar.setColumns(10);
 
 scrollPane = new JScrollPane();
 scrollPane.setBounds(10, 92, 1228, 598);
 getContentPane().add(scrollPane);
 
 tblClientes = new JTable();
 scrollPane.setViewportView(tblClientes);
 tblClientes.setCellSelectionEnabled(true);
 tblClientes.setModel(model);
 
 btnEliminar = new JButton("-");
 btnEliminar.setBounds(1059, 31, 41, 23);
 getContentPane().add(btnEliminar);

}
void listar() {

 GestionClientes gc = new GestionClientes();
 ArrayList<Clientes> lista = gc.listado();
 model.getDataVector().removeAllElements();
 
 for (Clientes cl : lista) {
  Object datos[] = {  cl.getTip_persona_cli(),cl.getFormaPago_cli(),cl.getTip_doc_cli(),cl.getNum_doc_cli_(),cl.getNomb_cli(),cl.getNom_comercial(),cl.getDirec_cli()};

  model.addRow(datos);

 }

}
}