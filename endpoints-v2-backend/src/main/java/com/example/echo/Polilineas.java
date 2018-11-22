package com.example.echo;

import java.util.ArrayList;

public class Polilineas {
	
	private ArrayList<Polyline> polilineas = new ArrayList<>();
	
	public Polilineas() {}

	public Polilineas(ArrayList<Polyline> polilineas) {
		super();
		this.polilineas = polilineas;
	}
	
	public void addPoliline(String polilineaCod) {
		polilineas.add(new Polyline(polilineaCod));
	}

	public ArrayList<Polyline> getPolilineas() {
		return polilineas;
	}

	public void setPolilineas(ArrayList<Polyline> polilineas) {
		this.polilineas = polilineas;
	}
}
