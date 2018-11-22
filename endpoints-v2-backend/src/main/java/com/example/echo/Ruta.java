package com.example.echo;

import java.util.ArrayList;

public class Ruta {
	private String identificador;
	private String idConductor;
	private int numPuestos;
	private String placa;
	private String inicio;
	private String fin;
	private String hora;
	private Polilineas polilineas;

	public Ruta(String identificador, String idConductor, int numPuestos, String placa, String inicio, String fin,
			String hora) {
		super();
		this.identificador = identificador;
		this.idConductor = idConductor;
		this.numPuestos = numPuestos;
		this.placa = placa;
		this.inicio = inicio;
		this.fin = fin;
		this.hora = hora;
		this.polilineas = new Polilineas();
	}
	

	public String getIdentificador() {
		return identificador;
	}




	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}




	public String getIdConductor() {
		return idConductor;
	}



	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}



	public int getNumPuestos() {
		return numPuestos;
	}



	public void setNumPuestos(int numPuestos) {
		this.numPuestos = numPuestos;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getInicio() {
		return inicio;
	}



	public void setInicio(String inicio) {
		this.inicio = inicio;
	}



	public String getFin() {
		return fin;
	}



	public void setFin(String fin) {
		this.fin = fin;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}
	
	



	public Polilineas getPolilineas() {
		return polilineas;
	}



	public void setPolilineas(Polilineas polilineas) {
		this.polilineas = polilineas;
	}

	@Override
	public String toString() {
		return "Ruta [identificador=" + identificador + ", idConductor=" + idConductor + ", numPuestos=" + numPuestos
				+ ", placa=" + placa + ", inicio=" + inicio + ", fin=" + fin + ", hora=" + hora + ", polilineas="
				+ polilineas + "]";
	}

	

	
	
	
	
	
}
