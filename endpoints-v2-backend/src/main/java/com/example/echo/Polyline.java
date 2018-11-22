package com.example.echo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import endpoints.repackaged.google.type.LatLng;

public class Polyline implements Serializable{
	
	
	String polilinea;
	
	public Polyline() {}

	public Polyline(String polilinea) {
		super();
		this.polilinea = polilinea;
	}

	public String getPolilinea() {
		return polilinea;
	}

	public void setPolilinea(String polilinea) {
		this.polilinea = polilinea;
	}

	
	
}
