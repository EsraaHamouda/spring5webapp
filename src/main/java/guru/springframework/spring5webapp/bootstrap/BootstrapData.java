package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("title: Sort you life out","123", new HashSet<>());
        Author author1 = new Author("Robert", "John", new HashSet<>());
        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Book book2 = new Book("title: cinderella","456", new HashSet<>());
        Author author2 = new Author("William", "shakespeare", new HashSet<>());
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in bootstrap");
        System.out.printf("Number of books: %d", bookRepository.count());
        System.out.printf("Number of authors: %d", authorRepository.count());


    }
}
