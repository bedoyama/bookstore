package bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bookstore.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDaoImpl<Long, Category> implements CategoryDao {

	@Override
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
