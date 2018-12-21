package guru.springframework.services;

import java.util.List;

import guru.springframework.domain.Book;
import guru.springframework.domain.Product;

/**
 * Created by jt on 1/10/17.
 */
public interface BookService {

    List<Book> listAll();

    Book getById(Long id);

    Book saveOrUpdate(Book book);

    void delete(Long id);
	
}
