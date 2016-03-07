package utilities;

import hs.ejb.EquipeManagerRemote;
import hs.entity.Equipe;
import hs.entity.Gardien;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class EquipeUtility {

	
	
	
	public static Equipe[] getAll(){
		EquipeManagerRemote equipeManagerRemote = null;
		try {
			equipeManagerRemote = (EquipeManagerRemote) LookupUtility.lookupRemote("EquipeManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Equipe> lm = equipeManagerRemote.findAll(); 
		Equipe[] equipes = new Equipe[lm.size()];
		int i = 0;
		for (Iterator<Equipe> iterator = lm.iterator(); iterator.hasNext();) {
			Equipe equipe = (Equipe) iterator.next();
			equipes[i] = equipe;
			i++;
		}

		return equipes;
		
	}
	
	public static ListModel<Equipe> getListModel(List<Equipe> e) {
		final List<Equipe> equipes = e;
		return new ListModel<Equipe>() {
			
			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getSize() {
				return equipes.size();
			}
			
			@Override
			public Equipe getElementAt(int index) {
				return equipes.get(index);
			}
			
			@Override
			public void addListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@SuppressWarnings("unused")
	public static Collection<? extends Gardien> getGardiens(Equipe selectedEquipe) {
		EquipeManagerRemote equipeManagerRemote = null;
		try {
			equipeManagerRemote = (EquipeManagerRemote) LookupUtility.lookupRemote("EquipeManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Equipe> lm = equipeManagerRemote.findAll(); 
		Equipe[] mo = new Equipe[lm.size()];
		int i = 0;
		for (Iterator<Equipe> iterator = lm.iterator(); iterator.hasNext();) {
			Equipe m = (Equipe) iterator.next();
			if(selectedEquipe.getId() == m.getId())
			 return selectedEquipe.getGardiens();
			i++;
		}
		return null;
	}
}
