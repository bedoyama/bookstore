package bookstore.dao;

import java.util.List;

import bookstore.model.Category;

public interface CategoryDao extends AbstractDao<Long, Category> {
	List<Category> listAll(Integer page, Integer size);
}
