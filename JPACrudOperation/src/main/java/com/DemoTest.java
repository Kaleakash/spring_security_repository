package com;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// like a connection 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager manager = emf.createEntityManager();
		Query qry=  manager.createQuery("select p from Product p");
//		List<Product> listOfProducts = qry.getResultList();
//		System.out.println(listOfProducts.size());
		Product p = new Product();
		p.setPid(101);
		p.setPname("TV");
		p.setPrice(18000);
		EntityTransaction tra = manager.getTransaction();
		tra.begin();
		manager.persist(p);
		tra.commit();
	
	}

}
