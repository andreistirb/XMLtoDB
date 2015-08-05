package com.andreistirb.xmltodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	Connection connection;
	Statement stmt;
	
	public Database(String dbName){
	
		connection = null;
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		}
		catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
	}
	
	private void insertTrack(Track traseu){
		
		try {
			stmt = connection.createStatement();
			String sql = "INSERT INTO Tracks(track_id, mountain_id,"
					+ "track_name, track_difficulty, track_mark, "
					+ "track_length, track_description, track_availability) " + 
			"VALUES(" 
					+ Integer.parseInt(traseu.getId()) + ", "
					+ Integer.parseInt(traseu.getMountainId()) + ", "
					+ "'" + traseu.getTitle() + "'" + ", "
					+ "'" + traseu.getDifficulty() + "'" + ", "
					+ "'" + traseu.getMark() + "'" + ", "
					+ "'" + traseu.getDuration() + "'" + ", "
					+ "'" + traseu.getDescription() + "'" + ", "
					+ "'" + traseu.getAccesibility() + "'" + ")";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void insertTrackPoint(TrackPoint trackpoint, int order){
		try {
			stmt = connection.createStatement();
			String sql = "INSERT INTO Trackpoints(track_id, "
					+ "trackpoint_lat, trackpoint_lon, trackpoint_alt,"
					+ "trackpoint_order)" + 
					"VALUES("
					+ Integer.parseInt(trackpoint.getTrackId()) + ", "
					+ Double.parseDouble(trackpoint.getLatitude()) + ", "
					+ Double.parseDouble(trackpoint.getLongitude()) + ", "
					+ Double.parseDouble(trackpoint.getAltitude()) + ", "
					+ order + ")";
			stmt.execute(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void insertTrackIntoDatabase(Track traseu){
		insertTrack(traseu);
		for(int i=0;i<traseu.getPoints().size();i++){
			insertTrackPoint(traseu.getPoints().get(i),i);
		}
	}
	
}
