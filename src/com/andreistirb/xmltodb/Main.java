package com.andreistirb.xmltodb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String filename = s.next();
		s.close();
		
		File file = new File(filename);
		Track traseu = new Track();
		XMLParser parser = new XMLParser(file);
		Database db = new Database("MountainTracker.s3db");
		
		parser.parse(traseu);
		
		traseu.computeMaxAlt();
		traseu.computeMinAlt();
		traseu.printTrackData();
		
		db.insertTrackIntoDatabase(traseu);
	}

}
