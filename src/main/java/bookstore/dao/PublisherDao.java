package bookstore.dao;

import java.util.List;

import bookstore.model.Publisher;

public interface PublisherDao extends AbstractDao<Long, Publisher> {

	List<Publisher> listAll(Integer page, Integer size);

}
