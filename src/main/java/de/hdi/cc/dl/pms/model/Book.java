package de.hdi.cc.dl.pms.model;

import java.math.BigDecimal;

/**
 * model object for the book
 *
 * @param id not unique because book can have several author ids. will be changed after implementing a database solution
 * @param title book title
 * @param price price of the book
 * @param isbn isbn
 * @param publisherId
 */
public record Book(long id, String title, BigDecimal price, String isbn, String publisherId) {
}
