package bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Publisher;
import bookstore.service.PublisherService;

@RestController
public class RESTFulController {

	@Autowired
	PublisherService publisherService; // will do data manipulation work

	// -------------------Retrieve All
	// Publishers--------------------------------------------------------

	@RequestMapping(value = "/publisher", method = RequestMethod.GET)
	public ResponseEntity<List<Publisher>> listAllPublishers() {
		// List<Publisher> publishers =
		// PublisherService.findAllPublishers();
		List<Publisher> publishers = publisherService.listAllPublishers();
		if (publishers.isEmpty()) {
			return new ResponseEntity<List<Publisher>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Publisher--------------------------------------------------------

	@RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Publisher> getPublisher(@PathVariable("id") Long id) {
		System.out.println("Fetching Publisher with id " + id);
		Publisher publisher = publisherService.findPublisherById(id);
		if (publisher == null) {
			System.out.println("Publisher with id " + id + " not found");
			return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
	}

}
