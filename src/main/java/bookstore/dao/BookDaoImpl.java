package bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bookstore.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Override
	public void persist(Book entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
