package bookstore.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import bookstore.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDaoImpl<Long, Category>implements CategoryDao {

	@Override
	public List<Category> listAll() {
		List<Category> pubList = getEntityManager().createNamedQuery("Category.findAll").getResultList();
		// for (Category pub : pubList) {
		// Hibernate.initialize(pub.getBooks());
		// }
		return pubList;
	}

	@Override
	public List<Category> listAll(Integer page, Integer size) {
		Query query = getEntityManager().createQuery("From Category");
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
