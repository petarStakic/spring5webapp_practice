package rs.enetel.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import rs.enetel.spring5webapp.model.Author;
import rs.enetel.spring5webapp.model.Book;
import rs.enetel.spring5webapp.model.Publisher;
import rs.enetel.spring5webapp.repositories.AuthorRepository;
import rs.enetel.spring5webapp.repositories.BookRepository;
import rs.enetel.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
		
	}

	private void initData() {
		
		// Harper Collins
		Publisher hc = new Publisher("Harper Collins", "195 Broadway, New York City");
		publisherRepository.save(hc);
		
		
		//Worx
		Publisher worx = new Publisher("Worx", "111 River Street Hoboken");
		publisherRepository.save(worx);
		
		// Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", hc);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}
	
}
