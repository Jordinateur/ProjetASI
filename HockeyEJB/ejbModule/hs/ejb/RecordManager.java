package hs.ejb;

import java.util.List;

import hs.entity.Record;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
		return (List<Record>) em.createNamedQuery("findAllRecord").getResultList();
	}

	@Override
	public Record findRecordByMatchAndGardien(int idMatch, int idGardien) {
		return (Record) em.createNamedQuery("findRecordByMatchAndGardien")
				.setParameter("gardien", idGardien)
				.setParameter("match", idMatch)
				.getSingleResult();
	}

	

}
