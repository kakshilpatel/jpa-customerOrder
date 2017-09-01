package org.npu.cusorder.client;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.npu.cusorder.domain.CusOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testbench {
	public static void main(String args[]) {
		CusOrder order = null;
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		/*  Obtain our Entity Manager Factory bean */
		EntityManagerFactory entManagerFactory =
			    container.getBean("cusorder_emf", EntityManagerFactory.class);
		EntityManager em;
		EntityTransaction tx;
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(9000);
	    double randomAmt = Math.random() * 10000 + 100;
	    String newOrderNum;
		
		
		em = entManagerFactory.createEntityManager();
		tx = null;
		
		try {
			tx = em.getTransaction();

			tx.begin(); /* Start of Transaction */

			order = new CusOrder();
			newOrderNum = "ZH6" + randomInt; /* randomly generate order number so we don't get duplicates  */
			order.setOrderNum(newOrderNum);
			order.setAmount(randomAmt);
			em.persist(order);

			tx.commit(); /* End of Transaction */
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("****An Exception occurred: " + ex.getMessage());
		} finally {
			em.close();
		}
		System.out.println(order);
	}

}
