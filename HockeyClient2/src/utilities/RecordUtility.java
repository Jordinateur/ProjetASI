package utilities;

import hs.ejb.RecordManagerRemote;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;

import javax.naming.NamingException;

public class RecordUtility {

	private static RecordManagerRemote remote(){
		RecordManagerRemote recordManagerRemote = null;
		try {
			recordManagerRemote = (RecordManagerRemote) LookupUtility.lookupRemote("RecordManager",false);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return recordManagerRemote;
	}
	public static Record update(Record r){
		return remote().update(r);
	}
	public static Record getRecordByMatchGardien(MatchHockey m, Gardien g){
		Record record = null;
		try{
			record = remote().findRecordByMatchAndGardien(m, g); 				
		}catch (Exception e){
			e.printStackTrace();
		}		
		return record;		
	}
}
