package io.github.ahenteti.java;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.github.ahenteti.java.Book;

public class MainWithJpa {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("book-persistence-unit");
  private static EntityManager em = emf.createEntityManager();
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    persistBook(new Book(1L, "title"));
    Book book = findBook(1L);
    System.out.println(book);
  }

  private static void persistBook(Book book) {
    em.persist(book);
  }

  private static Book findBook(Long id) throws SQLException {
    return em.find(Book.class, id);
  }

}