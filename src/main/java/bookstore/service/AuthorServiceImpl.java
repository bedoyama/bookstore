package bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.AuthorDao;
import bookstore.model.Author;

@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public void saveAuthor(Author Author) {
		authorDao.persist(Author);
	}

	@Override
	public void updateAuthor(Author Author) {
		authorDao.update(Author);
	}

	@Override
	public void deleteAuthor(Author Author) {
		authorDao.delete(Author);
	}

	@Override
	public Author findAuthorById(Long id) {
		return authorDao.findById(id);
	}

	@Override
	public void deleteAuthorById(Long id) {
		authorDao.deleteById(id);
	}

	@Override
	public List<Author> listAllAuthors() {
		return authorDao.listAll();
	}

	@Override
	public List<Author> listAllAuthors(Integer page, Integer size) {
		return authorDao.listAll(page, size);
	}

	@Override
	public void deleteAllAuthors() {
		authorDao.deleteAll();
	}

}
