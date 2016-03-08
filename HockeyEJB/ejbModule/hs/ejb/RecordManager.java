package hs.ejb;

import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RecordManager
 */
@Stateless
@LocalBean
public class RecordManager extends AbstractManager implements RecordManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RecordManager() {
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> findAll() {
		return (List<Record>) em.createNamedQuery("findALlRecord").getResultList();
	}

	@Override
	public Record findRecordByMatchAndGardien(MatchHockey match, Gardien gardien) {
		try{
			return (Record) em.createNamedQuery("findRecordByMatchAndGardien")
					.setParameter("gardien", gardien)
					.setParameter("match", match)
					.getSingleResult();			
		}catch(NoResultException e){
			Record r = new Record();
			r.setGardien(gardien);
			r.setMatch(match);
			return r;
		}
	}

	@Override
	public Record update(Record r) {
		em.persist(r);
		em.flush();
		return r;
	}

	

}
