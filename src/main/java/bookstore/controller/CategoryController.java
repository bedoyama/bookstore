package bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import bookstore.model.Category;
import bookstore.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService; // will do data manipulation work

	// -------------------Retrieve All
	// Categorys--------------------------------------------------------

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> listAllCategorys() {
		// List<Category> categorys =
		// CategoryService.findAllCategorys();
		List<Category> categorys = categoryService.listAllCategorys();
		if (categorys.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
	}

	// -------------------Retrieve All
	// Categorys with pagination --------------------------------------

	@RequestMapping(value = "/category", params = { "page", "size" }, method = RequestMethod.GET)
	public ResponseEntity<List<Category>> listAllCategorysPaginated(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		List<Category> categorys = categoryService.listAllCategorys(page, size);
		if (categorys.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Category--------------------------------------------------------

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
		System.out.println("Fetching Category with id " + id);
		Category category = categoryService.findCategoryById(id);
		if (category == null) {
			System.out.println("Category with id " + id + " not found");
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	// -------------------Create a
	// Category--------------------------------------------------------

	@RequestMapping(value = "/category/", method = RequestMethod.POST)
	public ResponseEntity<Category> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Category " + category.getCatname());

		// if (categoryService.isCategoryExist(category)) {
		// System.out.println("A Category with name " + category.getName() +
		// " already exist");
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		categoryService.saveCategory(category);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getCategoryId()).toUri());
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}

	// ------------------- Update a Category
	// --------------------------------------------------------

	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
		System.out.println("Updating Category " + id);

		Category currentCategory = categoryService.findCategoryById(id);

		if (currentCategory == null) {
			System.out.println("Category with id " + id + " not found");
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}

		currentCategory.setCatname(category.getCatname());
		currentCategory.setCategory(category.getCategory());

		categoryService.updateCategory(currentCategory);
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}

	// ------------------- Delete a Category
	// --------------------------------------------------------

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id) {
		System.out.println("Fetching & Deleting Category with id " + id);

		Category category = categoryService.findCategoryById(id);
		if (category == null) {
			System.out.println("Unable to delete. Category with id " + id + " not found");
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}

		categoryService.deleteCategoryById(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
}
