package test.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.entity.Author;
import test.entity.Book;
import test.repository.AuthorRepository;

import java.util.Optional;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        Optional<Author> opt = authorRepository.findById(book.getAuthorId());
        return opt.isPresent() ? opt.get() : null;
    }
}
