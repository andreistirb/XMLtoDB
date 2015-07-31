package com.andreistirb.xmltodb;

import java.util.ArrayList;

public class Track {
	private String title, difficulty, duration, mark, accesibility, max_alt, min_alt, description;
	private ArrayList<TrackPoint> points;
	
	public Track(){
		this.title = "";
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

	
}
