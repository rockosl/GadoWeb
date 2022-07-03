package rocko.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import rocko.jpautil.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(entidade);
		et.commit();
		em.close();

	}

	public E merge(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		E retorno = em.merge(entidade);
		et.commit();
		em.close();
		return retorno;
	}

	public void delete(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.remove(entidade);
		et.commit();
		em.close();

	}

	public void deletePorId(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Object id = JPAUtil.getPrimaryKey(entidade); 
		em.createQuery("delete from " + entidade.getClass().getName() + " where id = " + id).executeUpdate();

		et.commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<E> getListEntity(Class<E> entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		List<E> retorno = em.createQuery("from " + entidade.getName()).getResultList();
		
		et.commit();
		em.close();
		return retorno;
	}

}