package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("Harper Collins", "address1", null);
        Book ddd = new Book("Domain Driven Design", "1234", pub1);

        eric.getBooks().add(ddd);

        publisherRepository.save(pub1);
        bookRepository.save(ddd);
        authorRepository.save(eric);



        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Worx", "address2", null);
        Book noEJB = new Book("J2EE Development without EJB", "23444", pub2);
        rod.getBooks().add(noEJB);

        publisherRepository.save(pub2);
        bookRepository.save(noEJB);
        authorRepository.save(rod);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
