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
import mg.antoenjara.tpcustomer.entities.Discount;

/**
 * Façade pour gérer les Customers.
 * @author francisco
 */
@RequestScoped
public class DiscountManager {
     @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Methode pour faire l'insertion d'un Discount
     *
     * @param discount
     */
    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }

    /**
     * Methode pour faire une selection ou avoire de tous les discount
     *
     * @return
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    /**
     * Methode pour faire une selection ou avoire un seul discount
     *
     * @param idDiscount
     * @return
     */
    public Discount findById(int idDiscount) {
        return em.find(Discount.class, idDiscount);
    }

    /**
     * Methode pour faire la modification sur une discount specifié
     * @param discount
     * @return 
     */
    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

}
