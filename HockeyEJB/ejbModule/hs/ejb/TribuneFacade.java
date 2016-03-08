package hs.ejb;

import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;
import hs.entity.ZonesBut;
import hs.entity.ZonesTerrain;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TribuneFacade
 */
@Stateful
@LocalBean
public class TribuneFacade implements TribuneFacadeRemote {
	@PersistenceContext
	public EntityManager em;
	public MatchHockey currentMatch;
	public Gardien currentGardien;
	public Record currentRecord;
	public ZonesTerrain currentTMr;
	public ZonesTerrain currentTMn;
	public ZonesBut currentBMr;
	public ZonesBut currentBMn;
	private RecordManager rm;
    
	
	public TribuneFacade(){
		
	}
    public TribuneFacade(MatchHockey cm, Gardien cg) {
        this.currentGardien = cg;
        this.currentMatch = cm;
        this.rm = new RecordManager();
        this.currentRecord = this.rm.findRecordByMatchAndGardien(this.currentMatch, this.currentGardien);
        this.currentBMn = this.currentRecord.getZoneButManque();
        this.currentBMr = this.currentRecord.getZoneButMarque();
        this.currentTMn = this.currentRecord.getZoneTerrainManque();
        this.currentTMr = this.currentRecord.getZoneTerrainMarque();
    }
    public void create(MatchHockey cm, Gardien cg){
    	 this.currentGardien = cg;
         this.currentMatch = cm;
         this.rm = new RecordManager();
         System.out.println(cg);
         System.out.println(cm);
         try{
        	 this.currentRecord = (Record) em.createNamedQuery("findRecordByMatchAndGardien")
 					.setParameter("gardien", this.currentGardien)
 					.setParameter("match", this.currentMatch)
 					.getSingleResult();			
 		}catch(NoResultException e){
 			Record r = new Record();
 			r.setGardien(this.currentGardien);
 			r.setMatch(this.currentMatch);
 			this.currentRecord = r;
 			
 		}
//         this.currentRecord = this.rm.findRecordByMatchAndGardien(this.currentMatch, this.currentGardien);
         this.currentBMn = this.currentRecord.getZoneButManque();
         this.currentBMr = this.currentRecord.getZoneButMarque();
         this.currentTMn = this.currentRecord.getZoneTerrainManque();
         this.currentTMr = this.currentRecord.getZoneTerrainMarque();
    }
    @Override
    public void update(){
    	em.persist(this.currentBMn);
    	em.persist(this.currentBMr);
    	em.persist(this.currentTMn);
    	em.persist(this.currentTMr);
    	em.persist(this.currentRecord);
    }
	@Override
	public ZonesTerrain getZTMr() {
		return this.currentTMr;
	}
	@Override
	public ZonesTerrain getZTMn() {
		return this.currentTMn;
	}
	@Override
	public ZonesBut getZBMr() {
		return this.currentBMr;
	}
	@Override
	public ZonesBut getZBMn() {
		return this.currentBMn;
	}
	@Override
	public void addScore(int zoneT,int zoneB){
		System.out.println(this.currentBMr);
		switch (zoneB) {
		case 1:
			this.currentBMr.setA(this.currentBMr.getA() + 1);
			break;
		case 2:
			this.currentBMr.setB(this.currentBMr.getB() + 1);
			break;
		case 3:
			this.currentBMr.setC(this.currentBMr.getC() + 1);
			break;
		case 4:
			this.currentBMr.setD(this.currentBMr.getD() + 1);
			break;
		case 5:
			this.currentBMr.setE(this.currentBMr.getE() + 1);
			break;
		case 6:
			this.currentBMr.setF(this.currentBMr.getF() + 1);
			break;
		case 7:
			this.currentBMr.setG(this.currentBMr.getG() + 1);
			break;
		case 8:
			this.currentBMr.setH(this.currentBMr.getH() + 1);
			break;
		case 9:
			this.currentBMr.setI(this.currentBMr.getI() + 1);
			break;

		default:
			break;
		}
		switch (zoneT) {
		case 1:
			this.currentTMr.setA(this.currentTMr.getA() + 1);
			break;
		case 2:
			this.currentTMr.setB(this.currentTMr.getB() + 1);
			break;
		case 3:
			this.currentTMr.setC(this.currentTMr.getC() + 1);
			break;
		case 4:
			this.currentTMr.setD(this.currentTMr.getD() + 1);
			break;
		case 5:
			this.currentTMr.setE(this.currentTMr.getE() + 1);
			break;
		case 6:
			this.currentTMr.setF(this.currentTMr.getF() + 1);
			break;
		case 7:
			this.currentTMr.setG(this.currentTMr.getG() + 1);
			break;
		case 8:
			this.currentTMr.setH(this.currentTMr.getH() + 1);
			break;
		case 9:
			this.currentTMr.setI(this.currentTMr.getI() + 1);
			break;

		default:
			break;
		}
		
	}

}
