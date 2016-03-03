package bookstore.dao;

import java.util.List;

import bookstore.model.Author;

public interface AuthorDao extends AbstractDao<Long, Author> {

	List<Author> listAll(Integer page, Integer size);
}
