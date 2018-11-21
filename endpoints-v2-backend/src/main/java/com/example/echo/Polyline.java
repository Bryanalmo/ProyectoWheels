package com.example.echo;

public class Polyline {
	
	private double xInicio;
	private double xFinal;
	private double yInicio;
	private double yFinal;
	
	public Polyline() {}

	public Polyline(double xInicio, double xFinal, double yInicio, double yFinal) {
		super();
		this.xInicio = xInicio;
		this.xFinal = xFinal;
		this.yInicio = yInicio;
		this.yFinal = yFinal;
	}

	public double getxInicio() {
		return xInicio;
	}

	public void setxInicio(double xInicio) {
		this.xInicio = xInicio;
	}

	public double getxFinal() {
		return xFinal;
	}

	public void setxFinal(double xFinal) {
		this.xFinal = xFinal;
	}

	public double getyInicio() {
		return yInicio;
	}

	public void setyInicio(double yInicio) {
		this.yInicio = yInicio;
	}

	public double getyFinal() {
		return yFinal;
	}

	public void setyFinal(double yFinal) {
		this.yFinal = yFinal;
	}

	
	
	
	
	
}
