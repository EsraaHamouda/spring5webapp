package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("title: Sort you life out", "123", new HashSet<>());
        Author author1 = new Author("Robert", "John", new HashSet<>());
        Publisher publisher = new Publisher("Cairo", "Street 1", "Gareden City", "1234", new HashSet<>());

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        Book book2 = new Book("title: cinderella", "456", new HashSet<>());
        Author author2 = new Author("William", "shakespeare", new HashSet<>());
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        publisher.getBooks().add(book1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book2);
        book2.setPublisher(publisher);

        publisherRepository.save(publisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Started in bootstrap");

        System.out.printf("Number of publisher: %d \n", publisherRepository.count());
        System.out.printf("Number of books: %d \n", publisher.getBooks().size());
        System.out.printf("Number of books: %d\n", bookRepository.count());
        System.out.printf("Number of authors: %d\n", authorRepository.count());


    }
}
