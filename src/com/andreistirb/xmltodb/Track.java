package com.andreistirb.xmltodb;

import java.util.ArrayList;

public class Track {
	private String title;
	private ArrayList<TrackPoint> points;
	
	public Track(){
		this.title = "";
		this.points = new ArrayList<TrackPoint>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addPoint(TrackPoint tp){
		this.points.add(tp);
	}
}
