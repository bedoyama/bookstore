package bookstore.dao;

import java.util.List;

import bookstore.model.Book;

public interface BookDao extends AbstractDao<Long, Book> {

	List<Book> listAll(Integer page, Integer size);
}
