package fr.tbr.iamcore.tests.services;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.service.dao.IdentityXmlDAO;

public class TestXmlParsing {
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DAOInitializationException {
		
		//firstXmlParsing();
		
		//firstXmlParsingThenAppend();
		
		IdentityXmlDAO dao = new IdentityXmlDAO();
		System.out.println(dao.search(null));
		System.out.println("before insert");
		dao.save(new Identity("quentin","quentin@quentin.com", "789"));
		System.out.println("after insert:");
		System.out.println(dao.search(null));

		
	}

	private static void firstXmlParsing() throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument(); //create a document - an xml file in memory - from scratch
		
		Document parsedDocument = db.parse(new File("identities.xml"));
		
		NodeList list = parsedDocument.getElementsByTagName("identity");
		Element identityTag = (Element) list.item(0);
		
		System.out.println(identityTag.getAttribute("displayName"));
		System.out.println(identityTag.getAttribute("email"));
		System.out.println(identityTag.getAttribute("uid"));
	}

	
	private static void firstXmlParsingThenAppend() throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument(); //create a document - an xml file in memory - from scratch
		
		Document parsedDocument = db.parse(new File("identities.xml"));
		

		Element newIdentity = parsedDocument.createElement("identity");
		newIdentity.setAttribute("displayName", "clement");
		newIdentity.setAttribute("email", "clement@clement.com");
		newIdentity.setAttribute("uid", "4567");
		parsedDocument.getDocumentElement().appendChild(newIdentity);
		
		NodeList list = parsedDocument.getElementsByTagName("identity");
		
		for (int i = 0; i < list.getLength(); i++) {
			Element identityTag = (Element) list.item(i);
			
			System.out.println(identityTag.getAttribute("displayName"));
			System.out.println(identityTag.getAttribute("email"));
			System.out.println(identityTag.getAttribute("uid"));
		}
		


		
		
	}
	
}
