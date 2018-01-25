package rs.enetel.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.enetel.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
