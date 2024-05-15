package de.hdi.cc.dl.pms.model;

import java.math.BigDecimal;

public record Book(long id, String title, BigDecimal price, String isbn, String publisherId) {
}
