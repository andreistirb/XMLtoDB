package com.andreistirb.xmltodb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i=0; i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(node.getNodeName());
		}
		
	}

}
