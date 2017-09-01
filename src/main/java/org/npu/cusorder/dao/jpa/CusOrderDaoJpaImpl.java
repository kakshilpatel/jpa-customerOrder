package org.npu.cusorder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.npu.cusorder.dao.CusOrderDao;
import org.npu.cusorder.domain.CusOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("CusOrderDaoJpa")
@Transactional(readOnly=true)
public class CusOrderDaoJpaImpl implements CusOrderDao {
	@PersistenceContext(unitName="cusorder_persistence")
	private EntityManager em;
	
	@Transactional(readOnly=false)
	public CusOrder store(CusOrder order) {
		CusOrder persistedOrder;
		persistedOrder = em.merge(order);
		return persistedOrder;
	}

	@Transactional(readOnly=false)
	public void delete(CusOrder order) {
		em.remove(order);
	}

	public CusOrder findById(int orderId) {
		CusOrder order = (CusOrder) em.find(CusOrder.class, orderId);
		return order;
	}

	public List<CusOrder> findAll() {
		Query query = em.createQuery("from CusOrder");
		return query.getResultList();
	}
	
	public long numOrders() {
		Query query = em.createQuery("SELECT COUNT(cusorder) FROM CusOrder cusorder");
		long count = (Long) query.getSingleResult();
		return count;
	}
	
	

}
