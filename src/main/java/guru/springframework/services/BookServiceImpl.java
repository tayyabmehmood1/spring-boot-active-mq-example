package guru.springframework.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import guru.springframework.SpringBootActiveMQApplication;
import guru.springframework.commands.ProductForm;
import guru.springframework.converters.ProductFormToProduct;
import guru.springframework.domain.Book;
import guru.springframework.domain.Product;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.ProductRepository;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    	

    @Override
    public List<Book> listAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add); //fun with Java 8
        return books;
    }

    @Override
    public Book	 getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveOrUpdate(Book product) {
        bookRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

 
}
