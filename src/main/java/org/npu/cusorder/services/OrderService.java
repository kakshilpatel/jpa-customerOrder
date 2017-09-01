package org.npu.cusorder.services;

import org.npu.cusorder.domain.CusOrder;

public interface OrderService {
	public void addAmtToOrder(int orderId, double additionalAmt);
	public CusOrder save(CusOrder order);
	public CusOrder getById(int id);
}
