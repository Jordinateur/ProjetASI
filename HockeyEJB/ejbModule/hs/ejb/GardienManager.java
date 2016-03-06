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
public class GardienManager implements GardienManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GardienManager() {
        // TODO Auto-generated constructor stub
    }
    
    public Gardien add(Gardien gardien) {
		em.persist(gardien);
		return gardien;
	}

	public Gardien findGardien(int id) {
		return em.find(Gardien.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Gardien> allGardien() {
		return em.createNamedQuery("findAllGardien").getResultList();
	}

}
