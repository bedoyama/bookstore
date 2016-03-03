package bookstore.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import bookstore.model.Author;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDaoImpl<Long, Author>implements AuthorDao {

	@Override
	public List<Author> listAll() {
		List<Author> pubList = getEntityManager().createNamedQuery("Author.findAll").getResultList();
		// for (Author pub : pubList) {
		// Hibernate.initialize(pub.getBooks());
		// }
		return pubList;
	}

	@Override
	public List<Author> listAll(Integer page, Integer size) {
		Query query = getEntityManager().createQuery("From Author");
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
