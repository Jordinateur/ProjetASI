package utilities;

import hs.ejb.RecordManagerRemote;
import hs.ejb.TribuneFacadeRemote;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;
import hs.entity.ZonesBut;
import hs.entity.ZonesTerrain;

import javax.naming.NamingException;

public class TribuneUtility {

	private static TribuneFacadeRemote remote(){
		TribuneFacadeRemote tribuneFacadeRemote = null;
		try {
			tribuneFacadeRemote = (TribuneFacadeRemote) LookupUtility.lookupRemote("TribuneFacade",false);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return tribuneFacadeRemote;
	}
	public static void update(){
		remote().update();
	}
	public static void create(MatchHockey m, Gardien g){
		try{
			remote().create(m, g); 				
		}catch (Exception e){
			e.printStackTrace();
		}			
	}
	public static ZonesTerrain getZtmn(){
		return remote().getZTMn();
	}
	public static ZonesTerrain getZtmr(){
		return remote().getZTMr();
	}
	public static ZonesBut getZbmn(){
		return remote().getZBMn();
	}
	public static ZonesBut getZbmr(){
		return remote().getZBMr();
	}
	public static void addScore(int zoneT,int zoneB){
		remote().addScore(zoneT,zoneB);
	}
	public static void addMiss(){
		
	}
}
