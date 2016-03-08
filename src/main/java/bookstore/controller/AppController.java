package bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.model.Publisher;
import bookstore.service.PublisherService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PublisherService publisherService;

	@ModelAttribute("publishers")
	public List<Publisher> populatePublisherList(ModelMap model) {
		List<Publisher> publishers = publisherService.listAllPublishers();
		model.addAttribute("nofpublishers", publishers.size());

		return publishers;
	}

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/publist" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		return "publishers";
	}

	/*
	 * This method will list all existing publishers.
	 */
	@RequestMapping(value = { "/publist" }, params = { "page", "size" }, method = RequestMethod.GET)
	public String listSomePublishers(ModelMap model, @RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		model.addAttribute("page", page);
		model.addAttribute("size", size);

		model.addAttribute("publishers", publisherService.listAllPublishers(page, size));

		return "somepublishers";
	}

}
