/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.ANTOENJARA.tpCustomer.service; // Cette classe permet la gestion des méthodes de DiscountManager dans la base de donnée

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import mg.ANTOENJARA.tpCustomer.entity.Discount;

/**
 * Façade pour gérer les Customers.
 *
 * @author xxxx
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }

    public List<Discount> getAllDiscounts() {  // Cette méthode permet de récuperer tous la liste de Discount
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    @Transactional
    public Discount update(Discount discount) { // Cette méthode permet de modifier un Discount
        return em.merge(discount);
    }

    public Discount findById(int idDiscount) {
        return em.find(Discount.class, idDiscount);
    }
}
