package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Author;

import java.util.List;

/**
 * Created by genghz on 18/3/27.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    List<Author> findAll();
}
