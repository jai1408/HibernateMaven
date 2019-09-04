package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
	public static int register(Employee e) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metaData = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metaData.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		/*
		 * Employee e1 = new Employee(); 
		 * e1.setId(101); 
		 * e1.setFirstName("Gaurav");
		 * e1.setLastName("Chawla");
		 */
		
		
		int i = (Integer) session.save(e);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
		
		return i;
	}
}