package bookstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity
@Table(name="author")
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long authorId;
	private String auFname;
	private String auLname;
	private List<Book> books;

	public Author() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="author_id", unique=true, nullable=false)
	public Long getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}


	@Column(name="au_fname", nullable=false, length=45)
	public String getAuFname() {
		return this.auFname;
	}

	public void setAuFname(String auFname) {
		this.auFname = auFname;
	}


	@Column(name="au_lname", nullable=false, length=45)
	public String getAuLname() {
		return this.auLname;
	}

	public void setAuLname(String auLname) {
		this.auLname = auLname;
	}


	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="authors")
	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}