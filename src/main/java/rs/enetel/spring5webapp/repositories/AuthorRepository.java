package rs.enetel.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.enetel.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	
}
