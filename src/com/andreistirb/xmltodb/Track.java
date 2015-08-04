package com.andreistirb.xmltodb;

import java.util.ArrayList;

public class Track {
	private String title, id, difficulty, duration, mark, accesibility, max_alt, min_alt, description;
	private ArrayList<TrackPoint> points;
	
	public Track(){
		this.title = "";
		this.id = "";
		this.setDifficulty("");
		this.setDuration("");
		this.setMark("");
		this.setAccesibility("");
		this.setMax_alt("");
		this.setMin_alt("");
		this.setDescription("");
		this.points = new ArrayList<TrackPoint>();
	}

	public void addPoint(TrackPoint tp){
		this.points.add(tp);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getAccesibility() {
		return accesibility;
	}

	public void setAccesibility(String accesibility) {
		this.accesibility = accesibility;
	}

	public String getMax_alt() {
		return max_alt;
	}

	public void setMax_alt(String max_alt) {
		this.max_alt = max_alt;
	}

	public String getMin_alt() {
		return min_alt;
	}

	public void setMin_alt(String min_alt) {
		this.min_alt = min_alt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void printTrackData(){
		System.out.println(this.title);
		System.out.println("ID: " + this.id);
		System.out.println("Dificultate: " + this.difficulty + "\n"
				+ "Durata: " + this.duration + "\n"
				+ "Marcaj: " + this.mark + "\n" 
				+ "Accesibilitate: " + this.accesibility + "\n"
				+ "Altitudine minima: " + this.min_alt + "\n"
				+ "Altitudine maxima: " + this.max_alt + "\n"
				+ "Descriere: " + this.description);
		System.out.println("Puncte traseu: ");
		for(int i=0;i<this.points.size();i++){
			System.out.println("lat: " + this.points.get(i).getLatitude() + "\t"
					+ "lon: " + this.points.get(i).getLongitude() + "\t"
					+ "alt: " + this.points.get(i).getAltitude());
		}
		
	}
	
	public void computeMinAlt(){
		Double min_alt = Double.valueOf(9999);
		for(int i=0;i<this.points.size();i++){
			Double alt = Double.valueOf(this.points.get(i).getAltitude());
			if (min_alt > alt)
				min_alt = alt;
		}
		this.setMin_alt(min_alt.toString() + "m");
	}
	
	public void computeMaxAlt(){
		Double max_alt = Double.valueOf(0);
		for(int i=0;i<this.points.size();i++){
			Double alt = Double.valueOf(this.points.get(i).getAltitude());
			if (max_alt < alt)
				max_alt = alt;
		}
		this.setMax_alt(max_alt.toString() + "m");
	}

	
}
