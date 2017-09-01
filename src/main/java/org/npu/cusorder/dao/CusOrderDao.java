package org.npu.cusorder.dao;

import java.util.List;

import org.npu.cusorder.domain.*;

public interface CusOrderDao {
	public CusOrder store(CusOrder order);
	public void delete(CusOrder order);
	public CusOrder findById(int orderId);
	public List<CusOrder> findAll();
	public long numOrders();
}
