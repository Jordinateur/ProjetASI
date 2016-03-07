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
public class EquipeManager extends AbstractManager implements EquipeManagerRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EquipeManager() {
    }
    
	public List<Equipe> findAll() {
		return em.createNamedQuery("findAllEquipe").getResultList();
	}

}
