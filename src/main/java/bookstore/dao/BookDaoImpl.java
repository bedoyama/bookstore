package bookstore.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import bookstore.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDaoImpl<Long, Book>implements BookDao {

	@Override
	public List<Book> listAll() {
		List<Book> bookList = getEntityManager().createNamedQuery("Book.findAll").getResultList();
		for (Book aBook : bookList) {
			Hibernate.initialize(aBook.getAuthors());
			Hibernate.initialize(aBook.getPublishers());
			Hibernate.initialize(aBook.getCategory());
		}
		return bookList;
	}

	@Override
	public List<Book> listAll(Integer page, Integer size) {
		Query query = getEntityManager().createQuery("From Book");
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
