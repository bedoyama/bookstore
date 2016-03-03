package bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.CategoryDao;
import bookstore.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void saveCategory(Category Category) {
		categoryDao.persist(Category);
	}

	@Override
	public void updateCategory(Category Category) {
		categoryDao.update(Category);
	}

	@Override
	public void deleteCategory(Category Category) {
		categoryDao.delete(Category);
	}

	@Override
	public Category findCategoryById(Long id) {
		return categoryDao.findById(id);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryDao.deleteById(id);
	}

	@Override
	public List<Category> listAllCategorys() {
		return categoryDao.listAll();
	}

	@Override
	public List<Category> listAllCategorys(Integer page, Integer size) {
		return categoryDao.listAll(page, size);
	}

	@Override
	public void deleteAllCategorys() {
		categoryDao.deleteAll();
	}

}
