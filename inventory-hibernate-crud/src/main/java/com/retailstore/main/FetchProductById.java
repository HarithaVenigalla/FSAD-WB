package com.retailstore.main;

import org.hibernate.Session;

import com.retailstore.entity.Product;
import com.retailstore.util.HibernateUtil;

public class FetchProductById {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Change ID based on your DB data
        Product product = session.get(Product.class, 1);

        if (product != null) {
            System.out.println("Product ID   : " + product.getId());
            System.out.println("Name         : " + product.getName());
            System.out.println("Description  : " + product.getDescription());
            System.out.println("Price        : " + product.getPrice());
            System.out.println("Quantity     : " + product.getQuantity());
        } else {
            System.out.println("Product not found!");
        }

        session.close();
    }
}
