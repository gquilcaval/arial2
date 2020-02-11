package Interfaces;

import java.util.ArrayList;

import model.CorteCaja;
import model.DetalleCorteCaja;
import model.Movimiento;

public interface InterfaceCorteCaja {
	public int ObtenerNumero();
	
	public ArrayList<CorteCaja> calcularCalculado(int codCaja);
	
	public int registrarCorteDeCaja(CorteCaja c,ArrayList<DetalleCorteCaja> detalle);
	
	public ArrayList<DetalleCorteCaja> listadoParaElDetalle(int codigoCaja);
}
