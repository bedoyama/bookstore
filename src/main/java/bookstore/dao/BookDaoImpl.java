package bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bookstore.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDaoImpl<Long, Book> implements BookDao {

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
