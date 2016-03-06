package hs.ejb;

import hs.entity.Equipe;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EquipeManager
 */
@Stateless
@LocalBean
public class EquipeManager implements EquipeManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EquipeManager() {
        // TODO Auto-generated constructor stub
    }
    
    public Equipe add(Equipe equipe) {
		em.persist(equipe);
		return equipe;
	}

	public Equipe findEquipe(int id) {
		return em.find(Equipe.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> allEquipe() {
		return em.createNamedQuery("findAllEquipe").getResultList();
	}

}
