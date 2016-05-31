package fr.tbr.iamcore.service.matching.impl;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.service.matching.Match;

public class ContainsMatch implements Match<Identity> {
	
	
	@Override
	public boolean match(Identity firstIdentity, Identity secondIdentity) {
		return firstIdentity.getDisplayName().contains(secondIdentity.getDisplayName());
	}

}
