package com.example.echo;

import java.util.ArrayList;

public class Ruta {
	private String identificador;
	private String idConductor;
	private int numPuestos;
	private String placa;
	private double xInicio;
	private double yInicio;
	private double xFin;
	private double yFin;
	private String hora;
	private Polilineas polilineas;
	
	public Ruta() {}
	
	

	public Ruta(String identificador, String idConductor, int numPuestos, String placa, double xInicio,
			double yInicio, double xFin, double yFin, String hora) {
		super();
		this.identificador = identificador;
		this.idConductor = idConductor;
		this.numPuestos = numPuestos;
		this.placa = placa;
		this.xInicio = xInicio;
		this.yInicio = yInicio;
		this.xFin = xFin;
		this.yFin = yFin;
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

	public double getxInicio() {
		return xInicio;
	}

	public void setxInicio(double xInicio) {
		this.xInicio = xInicio;
	}

	public double getyInicio() {
		return yInicio;
	}

	public void setyInicio(double yInicio) {
		this.yInicio = yInicio;
	}

	public double getxFin() {
		return xFin;
	}

	public void setxFin(double xFin) {
		this.xFin = xFin;
	}

	public double getyFin() {
		return yFin;
	}

	public void setyFin(double yFin) {
		this.yFin = yFin;
	}

	public Polilineas getPolilineas() {
		return polilineas;
	}

	public void setPolilineas(Polilineas polilineas) {
		this.polilineas = polilineas;
	}

	
	


	

	
	
	
	
	
}
