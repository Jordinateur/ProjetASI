package hs.ejb;

import hs.entity.Equipe;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class HockeyManager
 */
@Stateless
@LocalBean
public class HockeyManager extends AbstractManager implements HockeyManagerRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public HockeyManager() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	public List<Equipe> findAll() {
		return em.createNamedQuery("findAllEquipe").getResultList();
	}

}
