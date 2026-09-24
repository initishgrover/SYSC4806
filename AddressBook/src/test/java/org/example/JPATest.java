package org.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class JPATest {

    public void performJPA() {

        // Creating buddy objects
        BuddyInfo buddy1 = new BuddyInfo("Nitish", "11223344");
        buddy1.setId(24);

        BuddyInfo buddy2 = new BuddyInfo("chang", "55667788");
        buddy2.setId(25);

        AddressBook addressBook = new AddressBook(1);

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AddressBookPU");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        //em.persist(buddy1);
        //em.persist(buddy2);
        em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of address books\n----------------");

        for (AddressBook a : results) {
            System.out.println("AddressBook id =" + a.getId());
            for(BuddyInfo b: a.getBuddies()) {
                System.out.println(" " + b.getName() + "id= "+ b.getId() + "phone= " +b.getPhoneNumber() + ")");
            }

        }

        // Closing connection
        em.close();

        emf.close();
    }

    public static void main(String[] args) {
        JPATest test = new JPATest();
        test.performJPA();
    }
}
