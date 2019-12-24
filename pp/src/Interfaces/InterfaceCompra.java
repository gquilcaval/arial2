package Interfaces;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

import model.Compra;
import model.DetalleCompra;
import model.OrdenCompra;


public interface InterfaceCompra {

	public int ObtenerNumero();
	public int ObtenerNumeroRegistroCompra();

	
	//REGISTRAR VENTA
	public int realizaCompra(Compra c,ArrayList<DetalleCompra>detalle);
	
	/*registrar orden de compra*/
	
	public int ordenCompra(OrdenCompra c,ArrayList<DetalleCompra> d);
	
	/*gestion orden de compra*/
	public ArrayList<OrdenCompra> listadoOrdenCompra();
	
	/*gestion registro de compra*/
	public ArrayList<OrdenCompra> listaOrdenCompra(int codigo);
}
