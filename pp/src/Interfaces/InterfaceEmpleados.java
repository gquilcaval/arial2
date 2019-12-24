package Interfaces ;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import model.Empleados;
import model.Privilegios;
import model.TipoEmpleado;

public interface InterfaceEmpleados {
	public Empleados ValidaAcceso(String TIPO,String USU,String PSW);
	public Empleados ValidaAcceso2(String USU,String PSW);
	
	ArrayList<TipoEmpleado> tipo();
	
	public ArrayList<Empleados>listado(); 
	public ArrayList<Empleados>listado(String nombre);
	public ArrayList<Empleados>privilegios(String id);
	
	public int cambiarContraseña(int id,String psw);
	
	public int registrar(Empleados reg,ArrayList<Privilegios>priv);
	public int actualizar(Empleados c);
	public int actualizarEmp_Priv(Empleados c,ArrayList<Privilegios>priv);
	public int eliminar(String id);
	
	
}
