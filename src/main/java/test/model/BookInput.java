package test.model;

import lombok.Data;

/**
 * Created by genghz on 18/3/30.
 */
@Data
public class BookInput {
    private String title;

    private String isbn;

    private int pageCount;

    private long authorId;
}
