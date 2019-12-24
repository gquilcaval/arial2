package model;

public class RegistroCompra {

	private int codRegisCompra,nroOrdenCompra;
	private String comprovante,fechaRegisCompra,fechaVenCompra;
	public int getCodRegisCompra() {
		return codRegisCompra;
	}
	public void setCodRegisCompra(int codRegisCompra) {
		this.codRegisCompra = codRegisCompra;
	}
	public int getNroOrdenCompra() {
		return nroOrdenCompra;
	}
	public void setNroOrdenCompra(int nroOrdenCompra) {
		this.nroOrdenCompra = nroOrdenCompra;
	}
	public String getComprovante() {
		return comprovante;
	}
	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}
	public String getFechaRegisCompra() {
		return fechaRegisCompra;
	}
	public void setFechaRegisCompra(String fechaRegisCompra) {
		this.fechaRegisCompra = fechaRegisCompra;
	}
	public String getFechaVenCompra() {
		return fechaVenCompra;
	}
	public void setFechaVenCompra(String fechaVenCompra) {
		this.fechaVenCompra = fechaVenCompra;
	}
	
	
}
