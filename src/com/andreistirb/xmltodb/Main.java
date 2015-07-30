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
		System.out.println(filename);
		File file = new File(filename);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		NodeList trkList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < trkList.getLength(); i++) {
			Node trk = trkList.item(i);
			if (trk.getNodeName().equals("trk")) {
				NodeList trksegList = trk.getChildNodes();
				for (int j = 0; j < trksegList.getLength(); j++) {
					Node trkseg = trksegList.item(j);
					if (trkseg.getNodeName().equals("trkseg")) {
						NodeList trkptList = trkseg.getChildNodes();
						for (int k = 0; k < trkptList.getLength(); k++) {
							Node trkpt = trkptList.item(k);
							if (trkpt instanceof Element) {
								System.out.println(
										trkpt.getNodeName() 
												+ "		"
												+ trkpt.getAttributes().getNamedItem("lat").getNodeValue()
												+ "     "
												+ trkpt.getAttributes().getNamedItem("lon").getNodeValue());
							}
						}
					}

				}
			}
		}

	}

}
