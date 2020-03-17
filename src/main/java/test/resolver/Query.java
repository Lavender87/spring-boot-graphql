package test.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.entity.Author;
import test.entity.Book;
import test.model.InAuthor;
import test.repository.AuthorRepository;
import test.repository.BookRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by genghz on 18/3/28.
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public Author findOneAuthor(Long id) {
        Optional<Author> opt = authorRepository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Long countBooks() {
        return bookRepository.count();
    }

    public List<Author> findAuthorsByFilter(List<InAuthor> filter, int first) {
        List<Author> list = authorRepository.findAll();
        return list;
    }

}
