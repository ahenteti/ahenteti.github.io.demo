package io.github.ahenteti.java.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import lombok.Data;

@Data
@Entity
@NamedQueries({
        // @formatter:off
        @NamedQuery(name = Customer.FIND_ALL, query = "select c from Customer c"),
        @NamedQuery(name= Customer.FIND_BY_EMAIL, query="select c from Customer c where c.email = :email")
        // @formatter:on
})
public class Customer implements Serializable {

    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_BY_EMAIL = "Employee.findByEmail";
    private static final long serialVersionUID = -8220762341837326032L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String firstName;

    @NotEmpty
    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;

    @Past
    private LocalDate birthday;

}
