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

import bookstore.model.Author;
import bookstore.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService; // will do data manipulation work

	// -------------------Retrieve All
	// Authors--------------------------------------------------------

	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> listAllAuthors() {
		// List<Author> authors =
		// AuthorService.findAllAuthors();
		List<Author> authors = authorService.listAllAuthors();
		if (authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}

	// -------------------Retrieve All
	// Authors with pagination --------------------------------------

	@RequestMapping(value = "/author", params = { "page", "size" }, method = RequestMethod.GET)
	public ResponseEntity<List<Author>> listAllAuthorsPaginated(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		List<Author> authors = authorService.listAllAuthors(page, size);
		if (authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Author--------------------------------------------------------

	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getAuthor(@PathVariable("id") Long id) {
		System.out.println("Fetching Author with id " + id);
		Author author = authorService.findAuthorById(id);
		if (author == null) {
			System.out.println("Author with id " + id + " not found");
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	// -------------------Create a
	// Author--------------------------------------------------------

	@RequestMapping(value = "/author/", method = RequestMethod.POST)
	public ResponseEntity<Author> createAuthor(@RequestBody Author author, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Author " + author.getAuFname());

		// if (authorService.isAuthorExist(author)) {
		// System.out.println("A Author with name " + author.getName() +
		// " already exist");
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		authorService.saveAuthor(author);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/author/{id}").buildAndExpand(author.getAuthorId()).toUri());
		return new ResponseEntity<Author>(author, HttpStatus.CREATED);
	}

	// ------------------- Update a Author
	// --------------------------------------------------------

	@RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
		System.out.println("Updating Author " + id);

		Author currentAuthor = authorService.findAuthorById(id);

		if (currentAuthor == null) {
			System.out.println("Author with id " + id + " not found");
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}

		currentAuthor.setAuFname(author.getAuFname());
		currentAuthor.setAuLname(author.getAuLname());

		authorService.updateAuthor(currentAuthor);
		return new ResponseEntity<Author>(currentAuthor, HttpStatus.OK);
	}

	// ------------------- Delete a Author
	// --------------------------------------------------------

	@RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Long id) {
		System.out.println("Fetching & Deleting Author with id " + id);

		Author author = authorService.findAuthorById(id);
		if (author == null) {
			System.out.println("Unable to delete. Author with id " + id + " not found");
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}

		authorService.deleteAuthorById(id);
		return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
	}
}
