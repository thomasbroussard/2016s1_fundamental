package fr.tbr.iamcore.service.matching;

import fr.tbr.iamcore.datamodel.Identity;

public interface Match {
	
	
	public boolean match(Identity firstIdentity, Identity secondIdentity);

}
