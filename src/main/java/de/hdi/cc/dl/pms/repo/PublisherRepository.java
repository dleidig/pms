package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublisherRepository implements PmsRepository<Publisher> {

	private List<Publisher> publishers;

	public PublisherRepository(){
		loadItems();
	}

	@Override
	public void loadItems() {
		publishers = List.of();
	}

	@Override
	public List<Publisher> getItems(){
		return publishers;
	}
}
