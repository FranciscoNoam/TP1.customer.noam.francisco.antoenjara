/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service; // Cette classe permet la gestion des méthodes de CustomerManager dans la base de donnée

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import mg.etu.tp1.customer.noam.francisco.antoenjara.entity.Customer;



/**
 * Façade pour gérer les Customers.
 * @author xxxx
 */
@RequestScoped
public class CustomerManager { 
    
@PersistenceContext(unitName = "customerPU")
private EntityManager em;

@Transactional
public void persist(Customer customer) {
  em.persist(customer);
}
    
    
 public List<Customer> getAllCustomers() {  // Cette méthode permet de récuperer tous la liste de Customer
      Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }  

    @Transactional
    public Customer update(Customer customer) { // Cette méthode permet de modifier un Customer
       return em.merge(customer);
    } 
    
     public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
      }
}
