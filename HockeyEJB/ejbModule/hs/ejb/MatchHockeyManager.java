package hs.ejb;

import hs.entity.MatchHockey;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class MatchHockeyManager
 */
@Stateless
@LocalBean
public class MatchHockeyManager extends AbstractManager implements MatchHockeyManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public MatchHockeyManager() {
    }
    
	@SuppressWarnings("unchecked")
	public List<MatchHockey> findAll() {
		return em.createNamedQuery("findAllMatchHockey").getResultList();
	}

}
