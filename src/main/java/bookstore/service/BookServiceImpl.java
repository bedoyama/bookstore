package bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.BookDao;
import bookstore.model.Book;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void saveBook(Book Book) {
		bookDao.persist(Book);
	}

	@Override
	public void updateBook(Book Book) {
		bookDao.update(Book);
	}

	@Override
	public void deleteBook(Book Book) {
		bookDao.delete(Book);
	}

	@Override
	public Book findBookById(Long id) {
		return bookDao.findById(id);
	}

	@Override
	public void deleteBookById(Long id) {
		bookDao.deleteById(id);
	}

	@Override
	public List<Book> listAllBooks() {
		return bookDao.listAll();
	}

	@Override
	public List<Book> listAllBooks(Integer page, Integer size) {
		return bookDao.listAll(page, size);
	}

	@Override
	public void deleteAllBooks() {
		bookDao.deleteAll();
	}

}
