package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.klu.hibernate.Product;
import com.klu.util.HibernateUtil;

public class ProductApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT DATA
        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Accessories", 800, 0));
        session.save(new Product("Chair", "Furniture", 4000, 5));

        tx.commit();

        // HQL SORT
        Query<Product> query = session.createQuery(
                "FROM Product p ORDER BY p.price DESC", Product.class);

        List<Product> list = query.list();

        for (Product p : list) {
            System.out.println(p.getProductName() + " " + p.getPrice());
        }

        session.close();
    }
}
