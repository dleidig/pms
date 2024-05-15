package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Publisher;
import de.hdi.cc.dl.pms.repo.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

	@InjectMocks
	private PublisherService publisherService;

	@Mock
	private PublisherRepository publisherRepository;
	
	@Test
	public void testFindBooks() {
		var publisher1 = new Publisher(1L, "test");
		var publisher2 = new Publisher(2L, "test");

		List<Publisher> expectedPublishers = Arrays.asList(publisher1, publisher2);
		when(publisherRepository.getItems()).thenReturn(expectedPublishers);
		List<Publisher> actualPublishers = publisherService.findAllPublishers();
		assertEquals(expectedPublishers, actualPublishers);
	}
}
