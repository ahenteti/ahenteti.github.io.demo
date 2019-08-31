package io.github.ahenteti.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.ahenteti.java.Book;

public class MainWithoutJpa {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    loadDatabaseDriver();
    createBookTable();
    persistBook(new Book(1L, "title"));
    Book book = findBook(1L);
    System.out.println(book);
  }

  private static void loadDatabaseDriver() throws ClassNotFoundException {
    Class.forName("org.h2.Driver");
  }

  private static void createBookTable() throws SQLException {
    String query = "CREATE TABLE BOOK (ID BIGINT NOT NULL, TITLE VARCHAR, PRIMARY KEY (ID))";
    try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
      stmt.executeUpdate();
    }
  }

  private static void persistBook(Book book) throws SQLException {
    String query = "INSERT INTO BOOK (ID, TITLE) VALUES (?, ?)";
    try (PreparedStatement stmt = getConnection().prepareStatement(query)) {

      stmt.setLong(1, book.getId());
      stmt.setString(2, book.getTitle());

      stmt.executeUpdate();
    }
  }

  private static Book findBook(Long id) throws SQLException {
    Book book = new Book();
    String query = "SELECT ID, TITLE FROM BOOK WHERE ID = ?";
    try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        book.setId(rs.getLong("ID"));
        book.setTitle(rs.getString("TITLE"));
      }
    }
    return book;
  }

  private static Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:h2:mem:demo");
  }
}