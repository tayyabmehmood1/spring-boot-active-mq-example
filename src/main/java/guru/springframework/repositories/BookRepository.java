package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Book;

/**
 * Created by jt on 1/10/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
