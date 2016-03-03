package bookstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long bookId;
	private String btitle;
	private Category category;
	private List<Author> authors;
	private List<Publisher> publishers;

	public Book() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id", unique=true, nullable=false)
	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	@Column(nullable=false, length=45)
	public String getBtitle() {
		return this.btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="bcategory")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-many association to Author
	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="book_id", nullable=false, insertable=false, updatable=false)
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(name = "book_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "author_id", nullable = false) })
	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	//bi-directional many-to-many association to Publisher
	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="book_id", nullable=false, insertable=false, updatable=false)
	@JoinTable(name = "book_publisher", joinColumns = {
			@JoinColumn(name = "book_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "publisher_id", nullable = false) })
	public List<Publisher> getPublishers() {
		return this.publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

}