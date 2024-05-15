package de.hdi.cc.dl.pms.repo;

import java.util.List;

public interface PmsRepository<T> {
	void loadItems();
	List<T> getItems();
}
