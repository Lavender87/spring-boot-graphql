package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Book;

import java.util.List;

/**
 * Created by genghz on 18/3/29.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAll();

    List<Book> findByAuthorId(Long id);
}
