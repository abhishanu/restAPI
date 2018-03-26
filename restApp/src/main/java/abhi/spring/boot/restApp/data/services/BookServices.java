package abhi.spring.boot.restApp.data.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import abhi.spring.boot.restApp.data.repo.BookRepositry;
import abhi.spring.boot.restApp.entities.Book;

@Service
@Scope("prototype")
public class BookServices {

	@Autowired
	ApplicationContext applicationContex;

	public Book saveBoks(Book book) {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);
		Book savedBook = bookRepositry.save(book);
		return savedBook;
	}
	
	public List<Book> getBooks() {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);
		List<Book> listOfBooks = new ArrayList();
		bookRepositry.findAll().forEach(b -> listOfBooks.add(b));

		return listOfBooks;
	}

	public Iterable<Book> getAllBooks() {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);
		Iterable<Book> findAllBooks = bookRepositry.findAll();

		return findAllBooks;
	}

	public Book getBookById(Long id) {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);
		Book findOne = bookRepositry.findOne(id);
		return findOne;
	}

}
