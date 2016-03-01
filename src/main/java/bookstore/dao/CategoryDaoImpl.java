package bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bookstore.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void persist(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

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
