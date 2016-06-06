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
import fr.tbr.iamcore.exception.DAOExceptionsMessages;
import fr.tbr.iamcore.exception.DAOInitializationException;


/**
 * This class is performing the Data Access feature using an XML backend.
 * This class should be used as follow: 
 * <pre><code>//TODO place some usage example</code></pre>
 * 
 * @author tbrou
 *
 */
public class IdentityXmlDAO {

	private static final String UID = "uid";
	private static final String EMAIL_ATTRIBUTE = "email";
	private static final String DISPLAY_NAME_ATTRIBUTE = "displayName";
	private static final String IDENTITY_TAG_NAME = "identity";
	private Document doc;
	
	
	/**
	 * TODO Document!
	 * @throws DAOInitializationException
	 */
	public IdentityXmlDAO() throws DAOInitializationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			this.doc = db.parse(new File("identities.xml"));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new DAOInitializationException(DAOExceptionsMessages.UNABLE_TO_READ_XML_FILE);
		}

	}

	/**
	 * TODO Document!
	 * @param criteria
	 * @return
	 */
	public Collection<Identity> search(Identity criteria) {
		List<Identity> identities = new ArrayList<Identity>();
		NodeList list = this.doc.getElementsByTagName(IDENTITY_TAG_NAME);
		for (int i = 0; i < list.getLength(); i++) {
			Element identityTag = (Element) list.item(i);
			Identity identity = new Identity(identityTag.getAttribute(DISPLAY_NAME_ATTRIBUTE),
					identityTag.getAttribute(EMAIL_ATTRIBUTE),
					identityTag.getAttribute(UID));
			identities.add(identity);
		}
		return identities;
	}

}
