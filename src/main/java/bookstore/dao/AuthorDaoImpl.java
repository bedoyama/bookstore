package bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bookstore.model.Author;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDaoImpl<Long, Author> implements AuthorDao {

	@Override
	public List<Author> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
