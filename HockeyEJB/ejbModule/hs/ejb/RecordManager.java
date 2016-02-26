package hs.ejb;

import hs.entity.MatchHockey;
import hs.entity.Record;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RecordManager
 */
@Stateless
@LocalBean
public class RecordManager implements RecordManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RecordManager() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Record add(Record record) {
		em.persist(record);
		return record;
	}

	@Override
	public Record findRecord(int id) {
		return em.find(Record.class, id);		
	}

	@Override
	public Record findRcordByMatch(int id) {
		return (Record) em.createQuery("SELECT r FROM record WHERE match_id = "+id).getSingleResult();
	}

	

}
