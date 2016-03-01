package bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bookstore.service.PublisherService;

@RestController
public class RESTFulController {

	@Autowired
	PublisherService publisherService; //will do data manipulation work
	
}
