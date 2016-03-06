package utilities;

import hs.ejb.GardienManagerRemote;
import hs.entity.Gardien;

import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class GardienUtility {

	
	
	
	public static Gardien[] getAll(){
		GardienManagerRemote gardienManagerRemote = null;
		try {
			gardienManagerRemote = (GardienManagerRemote) LookupUtility.lookupRemote("GardienManager",false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Gardien> lm = gardienManagerRemote.allGardien(); 
		Gardien[] gardiens = new Gardien[lm.size()];
		int i = 0;
		for (Iterator<Gardien> iterator = lm.iterator(); iterator.hasNext();) {
			Gardien gardien = (Gardien) iterator.next();
			gardiens[i] = gardien;
			i++;
		}

		return gardiens;
		
	}
	
	public static ListModel<Gardien> getListModel(List<Gardien> e) {
		final List<Gardien> gardiens = e;
		return new ListModel<Gardien>() {
			
			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getSize() {
				return gardiens.size();
			}
			
			@Override
			public Gardien getElementAt(int index) {
				return gardiens.get(index);
			}
			
			@Override
			public void addListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
