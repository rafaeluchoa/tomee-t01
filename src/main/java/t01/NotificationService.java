package t01;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class NotificationService {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Notification> list() {
		return em.createQuery("select d from Notification d")
				.getResultList();
	}

	public Notification read(String id) {
		try {
			return (Notification) 
					em.createQuery("select d from Notification d where d.id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Notification create(String name, String msg) {
		Notification e = new Notification(UUID.randomUUID().toString(), name, msg);
		em.persist(e);
		return e;
	}
	
	@Transactional
	public Notification update(String id, String name, String msg) {
		Notification e = read(id);
		if(e != null) {
			e.setName(name);
			e.setMsg(msg);
			em.merge(e);	
		}
		return e;
	}
	
	@Transactional
	public Notification delete(String id) {
		Notification e = read(id);
		if(e != null) {
			em.remove(e);
		}
		return e;
	}

}
