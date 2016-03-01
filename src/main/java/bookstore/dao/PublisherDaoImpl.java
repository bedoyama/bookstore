package bookstore.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import bookstore.model.Publisher;

@Repository("publisherDao")
public class PublisherDaoImpl extends AbstractDaoImpl<Long, Publisher>implements PublisherDao {

	@Override
	public List<Publisher> listAll() {
		List<Publisher> pubList = getEntityManager().createNamedQuery("Publisher.findAll").getResultList();
		// for (Publisher pub : pubList) {
		// Hibernate.initialize(pub.getBooks());
		// }
		return pubList;
	}

	@Override
	public List<Publisher> listAll(Integer page, Integer size) {
		Query query = getEntityManager().createQuery("From Publisher");
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
