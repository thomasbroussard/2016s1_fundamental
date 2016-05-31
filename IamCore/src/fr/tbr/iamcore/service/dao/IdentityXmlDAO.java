package fr.tbr.iamcore.service.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;

public class IdentityXmlDAO {

	private Document doc;
	
	public IdentityXmlDAO() throws DAOInitializationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			this.doc = db.parse(new File("identities.xml"));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new DAOInitializationException("unable to read the identities.xml file");
		}

	}

	public Collection<Identity> search(Identity criteria) {
		List<Identity> identities = new ArrayList<Identity>();
		NodeList list = this.doc.getElementsByTagName("identity");
		for (int i = 0; i < list.getLength(); i++) {
			Element identityTag = (Element) list.item(i);
			Identity identity = new Identity(identityTag.getAttribute("displayName"),
					identityTag.getAttribute("email"),
					identityTag.getAttribute("uid"));
			identities.add(identity);
		}
	
		return identities;

	}

}
