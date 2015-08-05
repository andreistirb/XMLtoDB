package com.andreistirb.xmltodb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		
		Scanner s = new Scanner(System.in);
		String trackFile = s.next();
		s.close();

		Scanner trackFileScanner = new Scanner(new FileReader(trackFile));

		while (trackFileScanner.hasNext()) {

			String filename = trackFileScanner.next();
			System.out.println(filename);
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

		trackFileScanner.close();
	}

}
