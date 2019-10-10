package io.github.ahenteti.java.controller;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import io.github.ahenteti.java.model.Customer;
import io.github.ahenteti.java.service.CustomerService;
import lombok.Data;

@Data
@Named
@ViewScoped
public class CustomerController implements Serializable {

    private static final long serialVersionUID = 6866663669266518821L;
    
    ////////////////////////
    //        state       //
    ////////////////////////
    private Collection<Customer> customers;
    private Customer newCustomer;

    ////////////////////////
    //    dependencies    //
    ////////////////////////
    @Inject private CustomerService customerService;
    @Inject private FacesContext facesContext;

    @PostConstruct
    public void init() {
        this.customers = customerService.read();
        this.newCustomer = new Customer();
    }

    public void create() {
        customerService.create(newCustomer);
        this.customers = customerService.read();
        this.newCustomer = new Customer();
    }

    public void update() {
        customerService.update(customers);
        facesContext.addMessage(null, new FacesMessage("Update successful"));
    }

    public void delete(Customer customer) {
        customerService.delete(customer);
        customers.remove(customer);
    }

}
