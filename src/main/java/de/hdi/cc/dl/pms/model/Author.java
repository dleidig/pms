package de.hdi.cc.dl.pms.model;

/**
 * model object for the author
 *
 * @param id not unique because author can have several book ids. will be changed after implementing a database solution
 * @param name name
 * @param lastName last name
 * @param bookId id of the
 */
public record Author(long id, String name, String lastName, long bookId) {
}
