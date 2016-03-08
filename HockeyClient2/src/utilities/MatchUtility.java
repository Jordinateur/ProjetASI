package utilities;

import hs.ejb.MatchHockeyManagerRemote;
import hs.entity.Equipe;
import hs.entity.MatchHockey;

import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class MatchUtility {

	
	public static MatchHockeyManagerRemote remote(){
		MatchHockeyManagerRemote matchManagerRemote = null;
		try {
			matchManagerRemote = (MatchHockeyManagerRemote) LookupUtility.lookupRemote("MatchHockeyManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matchManagerRemote;
		
	}
	
	public static List<MatchHockey> getAll(){
		List<MatchHockey> lm = remote().findAll(); 
		return lm;
		
	}

	@SuppressWarnings("unused")
	public static Equipe getEquipeAFrom(MatchHockey match) {
		List<MatchHockey> lm = remote().findAll(); 
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
	public static ListModel<MatchHockey> getListModel(List<MatchHockey> e) {
		final List<MatchHockey> equipes = e;
		return new ListModel<MatchHockey>() {
			
			@Override
			public void removeListDataListener(ListDataListener l) {}
			
			@Override
			public int getSize() {
				return equipes.size();
			}
			
			@Override
			public MatchHockey getElementAt(int index) {
				return equipes.get(index);
			}
			
			@Override
			public void addListDataListener(ListDataListener l) {}
		};
	}
	@SuppressWarnings("unused")
	public static Equipe getEquipeBFrom(MatchHockey match) {
		List<MatchHockey> lm = remote().findAll(); 
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
