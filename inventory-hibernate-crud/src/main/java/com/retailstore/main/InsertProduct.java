package com.retailstore.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.retailstore.entity.Product;
import com.retailstore.util.HibernateUtil;

public class InsertProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "Dell Laptop", 65000, 5);
        Product p2 = new Product("Keyboard", "Mechanical Keyboard", 2500, 20);
        Product p3 = new Product("Mouse", "Wireless Mouse", 900, 30);

        session.save(p1);
        session.save(p2);
        session.save(p3);

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully!");
    }
}

