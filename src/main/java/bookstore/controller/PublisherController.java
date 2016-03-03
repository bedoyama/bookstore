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

import bookstore.model.Publisher;
import bookstore.service.PublisherService;

@RestController
public class PublisherController {

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

	// -------------------Retrieve All
	// Publishers with pagination --------------------------------------

	@RequestMapping(value = "/publisher", params = { "page", "size" }, method = RequestMethod.GET)
	public ResponseEntity<List<Publisher>> listAllPublishersPaginated(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		List<Publisher> publishers = publisherService.listAllPublishers(page, size);
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

	// -------------------Create a
	// Publisher--------------------------------------------------------

	@RequestMapping(value = "/publisher/", method = RequestMethod.POST)
	public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Publisher " + publisher.getPname());

		// if (publisherService.isPublisherExist(publisher)) {
		// System.out.println("A Publisher with name " + publisher.getName() +
		// " already exist");
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		publisherService.savePublisher(publisher);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/publisher/{id}").buildAndExpand(publisher.getPublisherId()).toUri());
		return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);
	}

	// ------------------- Update a Publisher
	// --------------------------------------------------------

	@RequestMapping(value = "/publisher/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Long id, @RequestBody Publisher publisher) {
		System.out.println("Updating Publisher " + id);

		Publisher currentPublisher = publisherService.findPublisherById(id);

		if (currentPublisher == null) {
			System.out.println("Publisher with id " + id + " not found");
			return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
		}

		currentPublisher.setPname(publisher.getPname());
		currentPublisher.setPemail(publisher.getPemail());

		publisherService.updatePublisher(currentPublisher);
		return new ResponseEntity<Publisher>(currentPublisher, HttpStatus.OK);
	}

	// ------------------- Delete a Publisher
	// --------------------------------------------------------

	@RequestMapping(value = "/publisher/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Publisher> deletePublisher(@PathVariable("id") Long id) {
		System.out.println("Fetching & Deleting Publisher with id " + id);

		Publisher publisher = publisherService.findPublisherById(id);
		if (publisher == null) {
			System.out.println("Unable to delete. Publisher with id " + id + " not found");
			return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
		}

		publisherService.deletePublisherById(id);
		return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
	}
}
