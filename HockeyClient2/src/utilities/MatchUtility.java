package utilities;

import hs.ejb.MatchHockeyManagerRemote;
import hs.entity.Equipe;
import hs.entity.MatchHockey;

import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;

public class MatchUtility {

	
	
	
	public static MatchHockey[] getAll(){
		MatchHockeyManagerRemote matchManagerRemote = null;
		try {
			matchManagerRemote = (MatchHockeyManagerRemote) LookupUtility.lookupRemote("MatchHockeyManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MatchHockey> lm = matchManagerRemote.findAll(); 
		MatchHockey[] mo = new MatchHockey[lm.size()];
		int i = 0;
		for (Iterator<MatchHockey> iterator = lm.iterator(); iterator.hasNext();) {
			MatchHockey match = (MatchHockey) iterator.next();
			mo[i] = match;
			i++;
		}

		return mo;
		
	}

	@SuppressWarnings("unused")
	public static Equipe getEquipeAFrom(MatchHockey match) {
		MatchHockeyManagerRemote matchManagerRemote = null;
		try {
			matchManagerRemote = (MatchHockeyManagerRemote) LookupUtility.lookupRemote("MatchHockeyManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MatchHockey> lm = matchManagerRemote.findAll(); 
		MatchHockey[] mo = new MatchHockey[lm.size()];
		int i = 0;
		for (Iterator<MatchHockey> iterator = lm.iterator(); iterator.hasNext();) {
			MatchHockey m = (MatchHockey) iterator.next();
			if(match.getId() == m.getId())
			 return match.getEquipe1();
			i++;
		}
		return null;
	}
	@SuppressWarnings("unused")
	public static Equipe getEquipeBFrom(MatchHockey match) {
		MatchHockeyManagerRemote matchManagerRemote = null;
		try {
			matchManagerRemote = (MatchHockeyManagerRemote) LookupUtility.lookupRemote("MatchHockeyManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MatchHockey> lm = matchManagerRemote.findAll(); 
		MatchHockey[] mo = new MatchHockey[lm.size()];
		int i = 0;
		for (Iterator<MatchHockey> iterator = lm.iterator(); iterator.hasNext();) {
			MatchHockey m = (MatchHockey) iterator.next();
			if(match.getId() == m.getId())
			 return match.getEquipe2();
			i++;
		}
		return null;
	}
}
