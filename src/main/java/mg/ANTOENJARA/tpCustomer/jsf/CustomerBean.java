/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.ANTOENJARA.tpCustomer.jsf; // Backing bean pour la page JSF customerList

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.ANTOENJARA.tpCustomer.entity.Customer;
import mg.ANTOENJARA.tpCustomer.service.CustomerManager;

/**
 *
 * @author francisco Backing bean de la page customerList.xhtml
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    @Inject
    private CustomerManager customerManager;

    private List<Customer> customers;
    private String name;
    // Autres propriétés

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    public List<Customer> getCustomers() { // Cette fonction retourne tous la liste de customers
        if (customers == null) {
            customers = customerManager.getAllCustomers();
        }
        return customers;
    }

}
