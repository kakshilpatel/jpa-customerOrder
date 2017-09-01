package org.npu.cusorder.domain;

import java.text.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CusOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orderNum;
	private double amount;
	private static NumberFormat dlrFormatter = NumberFormat.getCurrencyInstance();

	public CusOrder() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		String orderStr, amountStr;
		
		amountStr = dlrFormatter.format(amount);
		orderStr = "CusOrder[id=" + id + "  orderNum=" + orderNum +
				"  amount=" + amountStr + "]";
		return orderStr;
	}
	
	public boolean equals(Object otherObj) {
		CusOrder otherOrder;
		
		if (!(otherObj instanceof CusOrder)) return false;
		otherOrder = (CusOrder) otherObj;
		
		if (id == otherOrder.id && orderNum.equals(otherOrder.orderNum)) {
			return true;
		}
		
		return false;
	}
	
	
}
