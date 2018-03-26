package abhi.spring.boot.restApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private Long id;

	private String name;
	private String authour;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, name=%s, authour=%s]", id, name, authour);
	}

}
