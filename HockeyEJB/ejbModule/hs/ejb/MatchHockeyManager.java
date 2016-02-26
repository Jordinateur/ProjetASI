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
public class MatchHockeyManager implements MatchHockeyManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public MatchHockeyManager() {
        // TODO Auto-generated constructor stub
    }
    
    public MatchHockey add(MatchHockey matchHockey) {
		em.persist(matchHockey);
		return matchHockey;
	}

	public MatchHockey findMatchHockey(int id) {
		return em.find(MatchHockey.class, id);
	}

	public List<MatchHockey> allMatchHockey() {
		return em.createNamedQuery("findAllMatchHockey").getResultList();
	}

}
