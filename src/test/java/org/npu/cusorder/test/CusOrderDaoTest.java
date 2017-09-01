package org.npu.cusorder.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.npu.cusorder.dao.CusOrderDao;
import org.npu.cusorder.domain.CusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test.xml" })
@TransactionConfiguration   // So we get auto rollback of transactions on tests
@Transactional
public class CusOrderDaoTest {
	
	@Autowired
	private CusOrderDao cusOrderDao;
	
	@Test
	public void getCusOrderByIdTest() throws Exception {
		CusOrder order = cusOrderDao.findById(1);
		assertEquals(order.getId(), 1);
	}
	
	@Test
	public void getAllCusOrderTest() throws Exception {
		List<CusOrder> orderList = cusOrderDao.findAll();
		long count = cusOrderDao.numOrders();
		assertEquals(count, orderList.size());
	}
	
	/* This test should fail with an exception.   We are attempting to
	 * save two orders with the same order number.   The order number is
	 * unique so the failure occurs when adding the second order.
	 */
	@Test(expected =  PersistenceException.class)
	public void errorTest() throws Exception {
		CusOrder order;
		order = new CusOrder();
		order.setOrderNum("ZH67154");
		order.setAmount(100.50);
		cusOrderDao.store(order);
		order = new CusOrder();
		order.setOrderNum("ZH67154");
		order.setAmount(100.50);
		cusOrderDao.store(order);
	}
}
