package com.andreistirb.xmltodb;

public class TrackPoint {
	private String latitude, longitude, altitude;
	
	public TrackPoint(){
		this.latitude = "";
		this.longitude = "";
		this.altitude = "";
	}
	
	public TrackPoint(String lat, String lon, String alt){
		this.latitude = lat;
		this.longitude = lon;
		this.altitude = alt;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	
}
