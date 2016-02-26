package hs.ejb;

import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;
import hs.entity.ZonesBut;
import hs.entity.ZonesTerrain;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
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
    
	
	public TribuneFacade(){
		
	}
    public TribuneFacade(MatchHockey cm, Gardien cg) {
        this.currentMatch = cm;
        this.currentGardien = cg;
        currentRecord = (Record) em.createNamedQuery("findRecordByMatchGardien")
        .setParameter("gardien", cg)
        .setParameter("match", cm)
        .getSingleResult();
        if(currentRecord == null){
        	currentRecord = new Record();
        }
        
    }

}
