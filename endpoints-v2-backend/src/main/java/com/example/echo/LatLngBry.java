package com.example.echo;

import java.io.Serializable;

public class LatLngBry implements Serializable{
	
	private double latitude;
	private double longitude;
	
	public LatLngBry() {}
	
	public LatLngBry(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
