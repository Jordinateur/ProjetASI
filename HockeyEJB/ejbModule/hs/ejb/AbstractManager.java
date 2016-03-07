package hs.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public abstract class AbstractManager {
	@PersistenceContext
	EntityManager em;
	
	public Object add(Object obj){
		em.persist(obj);
		return obj;
	}
	public Object findOne(Class<?> clazz, int id){
		return em.find(clazz, id);
	}
	
	public abstract List<?> findAll();

}
