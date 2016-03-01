package bookstore.service;

import java.util.List;

import bookstore.model.Publisher;

public interface PublisherService {

	void savePublisher(Publisher Publisher);

	void updatePublisher(Publisher Publisher);

	void deletePublisher(Publisher Publisher);

	Publisher findPublisherById(Long id);

	void deletePublisherById(Long id);

	public List<Publisher> listAllPublishers();

	public void deleteAllPublishers();

	List<Publisher> listAllPublishers(Integer page, Integer size);

}
