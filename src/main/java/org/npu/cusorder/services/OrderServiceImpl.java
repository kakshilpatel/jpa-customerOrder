package org.npu.cusorder.services;

import org.npu.cusorder.dao.CusOrderDao;
import org.npu.cusorder.domain.CusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CusOrderDao orderDao;

	public CusOrder getById(int id) {
		return orderDao.findById(id);
	}
	
	public CusOrder save(CusOrder order) {
		CusOrder persistedOrder;
		
		persistedOrder = orderDao.store(order);
		return persistedOrder;
	}
	
	public void addAmtToOrder(int orderId, double additionalAmt) {
		CusOrder order;
		double curAmt;
		
		order = orderDao.findById(orderId);
		curAmt = order.getAmount();
		curAmt = curAmt + additionalAmt;
		order.setAmount(curAmt);
	}

}
