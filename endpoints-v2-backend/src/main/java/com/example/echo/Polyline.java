package com.example.echo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import endpoints.repackaged.google.type.LatLng;

public class Polyline implements Serializable{
	
	
	ArrayList<LatLngBry> polilinea;
	
	public Polyline() {}

	public Polyline(ArrayList<LatLngBry> polilinea) {
		super();
		this.polilinea = polilinea;
	}

	public ArrayList<LatLngBry> getPolilinea() {
		return polilinea;
	}

	public void setPolilinea(ArrayList<LatLngBry> polilinea) {
		this.polilinea = polilinea;
	}

	
	
}
