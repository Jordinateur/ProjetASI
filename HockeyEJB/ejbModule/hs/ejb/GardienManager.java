package hs.ejb;

import hs.entity.Gardien;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class GardienManager
 */
@Stateless
@LocalBean
public class GardienManager extends AbstractManager implements GardienManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GardienManager() {
        // TODO Auto-generated constructor stub
    }
    
	public List<Gardien> findAll() {
		return em.createNamedQuery("findAllGardien").getResultList();
	}

}
