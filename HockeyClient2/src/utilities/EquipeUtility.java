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
	private static EquipeManagerRemote remote(){
		
		EquipeManagerRemote equipeManagerRemote = null;
		
		try {
			equipeManagerRemote = (EquipeManagerRemote) LookupUtility.lookupRemote("EquipeManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipeManagerRemote;
		
	}
	public static List<Equipe> getAll(){
		List<Equipe> lm = remote().findAll(); 
		return lm;
		
	}
	public static ListModel<Equipe> getListModel(List<Equipe> e) {
		final List<Equipe> equipes = e;
		return new ListModel<Equipe>() {
			
			@Override
			public void removeListDataListener(ListDataListener l) {}
			
			@Override
			public int getSize() {
				return equipes.size();
			}
			
			@Override
			public Equipe getElementAt(int index) {
				return equipes.get(index);
			}
			
			@Override
			public void addListDataListener(ListDataListener l) {}
		};
	}

	@SuppressWarnings("unused")
	public static Collection<? extends Gardien> getGardiens(Equipe selectedEquipe) {
		List<Equipe> lm = remote().findAll(); 
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
