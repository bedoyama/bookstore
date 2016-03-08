package bookstore.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bookstore.model.Publisher;
import bookstore.service.PublisherService;

public class PublisherControllerTest {
	@Mock
	PublisherService service;

	@InjectMocks
	PublisherController pubController;

	@Spy
	UriComponentsBuilder ucBuilder = UriComponentsBuilder.newInstance();

	@Spy
	List<Publisher> publishers = new ArrayList<Publisher>();

	@Spy
	ResponseEntity<List<Publisher>> publishersEntity = new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);

	@Spy
	Publisher publisher = new Publisher();

	@Spy
	ResponseEntity<Publisher> publisherEntity = new ResponseEntity<Publisher>(publisher, HttpStatus.OK);

	@Spy
	ModelMap model;

	@Mock
	BindingResult result;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		publishers = getPublisherList();
		publishersEntity = new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);

		Publisher publisher = new Publisher();
		publisher.setPublisherId((long) 1);
		publisher.setPname("Bantham");
		publisher.setPemail("bantham@bant.com");
		publisherEntity = new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);

	}

	@Test
	public void listPublishers() {
		when(service.listAllPublishers()).thenReturn(publishers);
		Assert.assertEquals(pubController.listAllPublishers(model), publishersEntity);
		Assert.assertEquals(model.get("publishers"), publishers);
		verify(service, atLeastOnce()).listAllPublishers();
	}

	@Test
	public void newPublisher() {
		Assert.assertEquals(pubController.createPublisher(publisher, ucBuilder, model), publisherEntity);
		Assert.assertNotNull(model.get("publisher"));
//		Assert.assertEquals(((Publisher) model.get("publisher")).getPublisherId(), (long) 1);
	}

	private List<Publisher> getPublisherList() {
		List<Publisher> publishers = new ArrayList<>();

		Publisher p1 = new Publisher();
		p1.setPublisherId((long) 1);
		p1.setPname("Bantham");
		p1.setPemail("bantham@bant.com");

		Publisher p2 = new Publisher();
		p2.setPublisherId((long) 2);
		p2.setPname("Hercules");
		p2.setPemail("hercules@bant.com");

		publishers.add(p1);
		publishers.add(p2);

		return publishers;
	}

}
