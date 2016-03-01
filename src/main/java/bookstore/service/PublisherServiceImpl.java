package bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.PublisherDao;
import bookstore.model.Publisher;

@Service("publisherService")
@Transactional
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherDao publisherDao;

	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@Override
	public void savePublisher(Publisher Publisher) {
		publisherDao.persist(Publisher);
	}

	@Override
	public void updatePublisher(Publisher Publisher) {
		publisherDao.update(Publisher);
	}

	@Override
	public void deletePublisher(Publisher Publisher) {
		publisherDao.delete(Publisher);
	}

	@Override
	public Publisher findPublisherById(Long id) {
		return publisherDao.findById(id);
	}

	@Override
	public void deletePublisherById(Long id) {
		publisherDao.deleteById(id);
	}

	@Override
	public List<Publisher> listAllPublishers() {
		return publisherDao.listAll();
	}

	@Override
	public List<Publisher> listAllPublishers(Integer page, Integer size) {
		return publisherDao.listAll(page, size);
	}

	@Override
	public void deleteAllPublishers() {
		publisherDao.deleteAll();
	}

}
