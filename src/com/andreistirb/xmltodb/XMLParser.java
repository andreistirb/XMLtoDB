package com.andreistirb.xmltodb;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document document;

	public XMLParser(File file) throws ParserConfigurationException, SAXException, IOException{
		
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(file);
		
	}
	
	public void parse(Track traseu){
		
		NodeList trkList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < trkList.getLength(); i++) {
			Node trk = trkList.item(i);
			if (trk.getNodeName().equals("trk")) {
				NodeList trksegList = trk.getChildNodes();
				for (int j = 0; j < trksegList.getLength(); j++) {
					Node trkchild = trksegList.item(j);
					switch (trkchild.getNodeName()){
					case "name" : {
						traseu.setTitle(trkchild.getTextContent());
						break;
					}
					case "id" : {
						traseu.setId(trkchild.getTextContent());
						break;
					}
					case "mid" : {
						traseu.setMountainId(trkchild.getTextContent());
						break;
					}
					case "diff" : {
						traseu.setDifficulty(trkchild.getTextContent());
						break;
					}
					case "duration" : {
						traseu.setDuration(trkchild.getTextContent());
						break;
					}
					case "mark" : {
						traseu.setMark(trkchild.getTextContent());
						break;
					}
					case "accessibility" : {
						traseu.setAccessibility(trkchild.getTextContent());
						break;
					}
					case "desc" : {
						traseu.setDescription(trkchild.getTextContent());
						break;
					}
 					case "trkseg": {
						NodeList trkptList = trkchild.getChildNodes();
						for (int k = 0; k < trkptList.getLength(); k++) {
							Node trkpt = trkptList.item(k);
							if (trkpt instanceof Element) {
								TrackPoint trackpoint = new TrackPoint();
								trackpoint.setTrackId(traseu.getId());
								trackpoint.setLatitude(trkpt.getAttributes().getNamedItem("lat").getNodeValue());
								trackpoint.setLongitude(trkpt.getAttributes().getNamedItem("lon").getNodeValue());
								NodeList altList = trkpt.getChildNodes();
								for(int l = 0; l < altList.getLength(); l++){
									Node alt = altList.item(l);
									if(alt instanceof Element){
										trackpoint.setAltitude(alt.getTextContent());
									}
								}
								traseu.addPoint(trackpoint);
							}
						}
						break;
					}
					}
				}
			}
		}
	}
	
}
