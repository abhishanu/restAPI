package abhi.spring.boot.restApp.data.repo;

import org.springframework.data.repository.CrudRepository;

import abhi.spring.boot.restApp.entities.Book;

public interface BookRepositry extends CrudRepository<Book, Long> {

}
