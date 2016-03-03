package bookstore.service;

import java.util.List;

import bookstore.model.Category;

public interface CategoryService {

	void saveCategory(Category Category);

	void updateCategory(Category Category);

	void deleteCategory(Category Category);

	Category findCategoryById(Long id);

	void deleteCategoryById(Long id);

	public List<Category> listAllCategorys();

	public void deleteAllCategorys();

	List<Category> listAllCategorys(Integer page, Integer size);

}
