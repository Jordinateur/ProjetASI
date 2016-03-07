package utilities;

import hs.ejb.RecordManagerRemote;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;

import javax.naming.NamingException;

public class RecordUtility {

	public static Record getRecordByMatchGardien(MatchHockey m, Gardien g){
		RecordManagerRemote recordManagerRemote = null;
		Record record = null;
		try {
			recordManagerRemote = (RecordManagerRemote) LookupUtility.lookupRemote("RecordManager",false);
			if(recordManagerRemote == null){
				System.out.println("fuck");
			}
			record = recordManagerRemote.findRecordByMatchAndGardien(m.getId(), g.getId()); 
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return record;
		
	}
}
