package abhi.spring.boot.restApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abhi.spring.boot.restApp.data.services.BookServices;
import abhi.spring.boot.restApp.entities.Book;

@RestController
public class ServiceController {

	@Autowired
	ApplicationContext applicationContex;

	@Autowired
	BookServices bookServices;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Boot";
	}

	@GetMapping("/books")
	public List<Book> showBooks() {
		
		List<Book> books = bookServices.getBooks();
		return books;
	}
	
	@GetMapping("/allBooks")
	public Iterable<Book> showAllBooks() {

		Iterable<Book> allBooks = bookServices.getAllBooks();
		return allBooks;
	}

	@PostMapping("/addBook")
	public boolean saveBook(@RequestBody Book book) {

		boolean isDataSaved = false;
		// ModelAndView modelAndView = new ModelAndView();

		Book savedBoks = bookServices.saveBoks(book);
		if(savedBoks!=null){
			isDataSaved = true;
		}
		
		// modelAndView.setViewName("/WEB-INF/jsp/success.jsp");

		return isDataSaved;

	}

	@PatchMapping("/updateBookDetails")
	public boolean updateRecord(@RequestBody Book book) {
		Book saveBoks = bookServices.saveBoks(book);
		boolean isUpdated = (saveBoks != null) ? true : false;
		return true;
	}

	@GetMapping("/getBook/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		return bookServices.getBookById(id);
	}

}
