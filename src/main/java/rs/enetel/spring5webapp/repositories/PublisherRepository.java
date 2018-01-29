package rs.enetel.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.enetel.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
		
}
