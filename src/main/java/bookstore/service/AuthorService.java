package bookstore.service;

import java.util.List;

import bookstore.model.Author;

public interface AuthorService {

	void saveAuthor(Author Author);

	void updateAuthor(Author Author);

	void deleteAuthor(Author Author);

	Author findAuthorById(Long id);

	void deleteAuthorById(Long id);

	public List<Author> listAllAuthors();

	public void deleteAllAuthors();

	List<Author> listAllAuthors(Integer page, Integer size);

}
