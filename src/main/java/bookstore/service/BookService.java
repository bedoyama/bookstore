package bookstore.service;

import java.util.List;

import bookstore.model.Book;

public interface BookService {

	void saveBook(Book Book);

	void updateBook(Book Book);

	void deleteBook(Book Book);

	Book findBookById(Long id);

	void deleteBookById(Long id);

	public List<Book> listAllBooks();

	public void deleteAllBooks();

	List<Book> listAllBooks(Integer page, Integer size);

}
