package io.github.ahenteti.java.service;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import io.github.ahenteti.java.model.Customer;

@Stateless
public class CustomerService {

    @PersistenceContext(unitName = "customers") private EntityManager entityManager;

    public void create(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setBirthday(customer.getBirthday());
        this.entityManager.persist(newCustomer);
    }

    public Collection<Customer> read() {
        return this.entityManager.createNamedQuery(Customer.FIND_ALL, Customer.class).getResultList();
    }

    public void update(Collection<Customer> customers) {
        customers.forEach(entityManager::merge);
    }

    public void delete(Customer customer) {
        if (entityManager.contains(customer)) {
            entityManager.remove(customer);
        } else {
            Customer managedCustomer = entityManager.find(Customer.class, customer.getId());
            if (managedCustomer != null) {
                entityManager.remove(managedCustomer);
            }
        }
    }
}
