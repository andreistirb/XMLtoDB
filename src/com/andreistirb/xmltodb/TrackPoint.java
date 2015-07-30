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

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the altitude
	 */
	public String getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	
}
