/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.antoenjara.tpcustomer.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.antoenjara.tpcustomer.entities.Customer;

/**
 * Façade pour gérer les Customers.
 *
 * @author francisco
 */
/**
 * Gère la persistance des Customers.
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Methode pour faire l'insertion d'une customer
     *
     * @param customer
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Methode pour faire une selection ou avoire de tous les customer
     *
     * @return
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    /**
     * Methode pour faire une selection ou avoire un seul customer
     *
     * @return
     */
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }

    /**
     * Methode pour faire la modification sur une customer specifié
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

}
