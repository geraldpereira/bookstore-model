package fr.gpereira.bookstore.model;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

import java.util.Date;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

import fr.gpereira.bookstore.model.Book;

public class BookTest {

	private static final Integer FAKE_ID = 1;
	private static final String FAKE_STRING = "Str";
	private static final Date FAKE_DATE = new Date();

	@Test
	public void testEquals() {
	    EqualsVerifier.forClass(Book.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testConstructor() {
		final Book book = new Book(FAKE_ID);
		assertEquals(FAKE_ID,book.getId());
	}
	
	@Test
	public void testId() {
		final Book book = new Book();
		book.setId(FAKE_ID);
		assertEquals(FAKE_ID,book.getId());
	}
	
	@Test
	public void testTitle() {
		final Book book = new Book();
		book.setTitle(FAKE_STRING);
		assertEquals(FAKE_STRING,book.getTitle());
	}
	@Test
	public void testReleaseDate() {
		final Book book = new Book();
		book.setReleaseDate(FAKE_DATE);
		assertEquals(FAKE_DATE,book.getReleaseDate());
	}
	
	@Test
	public void testAuthor() {
		final Book book = new Book();
		book.setAuthor(FAKE_STRING);
		assertSame(FAKE_STRING,book.getAuthor());
	}
}