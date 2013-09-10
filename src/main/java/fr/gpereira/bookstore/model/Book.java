package fr.gpereira.bookstore.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.google.common.base.Objects;

import fr.gpereira.bookstore.model.validation.CreateChecks;
import fr.gpereira.bookstore.model.validation.UpdateChecks;

/**
 * A book
 * 
 * @author Gerald PEREIRA
 * 
 */
public final class Book {

	private static final int TITLE_LENGTH = 45;
	private static final int AUTHOR_NAME_LENGTH = 45;
	private static final int MIN_LENGTH = 3;

	private Integer id;
	private String title;
	private String author;
	private Date releaseDate;

	/**
	 * Constructor
	 */
	public Book() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public Book(final Integer id) {
		this.id = id;
	}

	/**
	 * Book identifier
	 * 
	 * @return Book identifier
	 */
	@NotNull(groups = UpdateChecks.class)
	@Null(groups = CreateChecks.class)
	public Integer getId() {
		return id;
	}

	/**
	 * Campaign identifier
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Book title
	 * 
	 * @return Book title
	 */
	@Length(min = MIN_LENGTH, max = TITLE_LENGTH)
	@NotNull
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the book title
	 * 
	 * @param title
	 *            the book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The book author
	 * 
	 * @return the book author
	 */
	@Length(min = MIN_LENGTH, max = AUTHOR_NAME_LENGTH)
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the book author
	 * 
	 * @param author
	 *            book author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * The book release date
	 * 
	 * @return the book release date
	 */
	@NotNull
	public Date getReleaseDate() {
		return (Date) releaseDate.clone();
	}

	/**
	 * 
	 * @param releaseDate
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = (Date) releaseDate.clone();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Book) {
			return this.hashCode() == obj.hashCode();
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("title", title)
				.add("author", author).add("release date", releaseDate)
				.toString();
	}
}
