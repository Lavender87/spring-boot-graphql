package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import test.entity.Author;
import test.repository.AuthorRepository;

import java.util.Optional;

/**
 * Created by genghz on 18/3/29.
 */
public class TestController {
    @Autowired
    private AuthorRepository authorRepository;

    public Object test(long id) {
        Optional<Author> opt = authorRepository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }
}
