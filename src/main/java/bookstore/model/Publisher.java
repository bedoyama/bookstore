package bookstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
@Table(name="publisher")
@NamedQuery(name="Publisher.findAll", query="SELECT p FROM Publisher p")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long publisherId;
	private String pemail;
	private String pname;
	private List<Book> books;

	public Publisher() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="publisher_id", unique=true, nullable=false)
	public Long getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}


	@Column(length=45)
	public String getPemail() {
		return this.pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}


	@Column(nullable=false, length=45)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}


	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="publishers")
	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}