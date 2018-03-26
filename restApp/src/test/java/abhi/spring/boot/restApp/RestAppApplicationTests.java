package abhi.spring.boot.restApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import abhi.spring.boot.restApp.data.repo.BookRepositry;
import abhi.spring.boot.restApp.entities.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAppApplicationTests {

	@Autowired
	ApplicationContext applicationContex;

	@Test
	public void saveRepo() {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);

		Book book = new Book();

		book.setId(14l);
		book.setName("Spring");
		book.setAuthour("Abhishek");
		bookRepositry.save(book);
	}

	/*
	 * @Test public void deleteRepo() { BookRepositry bookRepositry =
	 * applicationContex.getBean(BookRepositry.class); Book book = new Book();
	 * book.setId(12l);
	 * 
	 * bookRepositry.delete(book);
	 * 
	 * }
	 */

	@Test
	public void updateRepo() {
		BookRepositry bookRepositry = applicationContex.getBean(BookRepositry.class);
		Book book = bookRepositry.findOne(13l);

		book.setAuthour("AK");
		bookRepositry.save(book);

		System.out.println(book);

	}

}
