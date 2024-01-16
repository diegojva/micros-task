package com.nttdata.escuela.libro.service;

import com.nttdata.escuela.libro.apimodel.BookEntity;
import com.nttdata.escuela.libro.apimodel.BookService;
import com.nttdata.escuela.libro.apimodel.StrategyBean;
import com.nttdata.escuela.libro.client.AuthorFeignClient;
import com.nttdata.escuela.libro.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorFeignClient authorFeignClient;

    @Autowired
    private StrategyBean strategyBean;
    
    @Autowired
    private AuthorService authorService;

    @Override
    public List<BookEntity> getAllBooks() {
        final List<BookEntity> entities = new ArrayList<>();
        final Iterable<BookEntity> iterableEntities = this.bookRepository.findAll();
        iterableEntities.forEach(entities::add);
        return entities;
    }

    @Override
    public void saveOrUpdateBook(final BookEntity bookEntity) {
        final String strategyService = this.strategyBean.getStrategyService();
        final boolean exists;
        if (strategyService.equals("FEIGN_CLIENT")) {
            log.info("FEIGN_CLIENT");
            exists = this.authorFeignClient.existsAuthorById(bookEntity.getAutorId());
        } else if (strategyService.equals("REST_TEMPLATE")) {
            log.info("REST_TEMPLATE");
            exists = this.authorService.existsAuthorById(bookEntity.getAutorId());
        } else {
            throw new RuntimeException("No debería ocurrir, error de configuración");
        }

        if (exists) {
            this.bookRepository.save(bookEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor id no existe");
        }
    }

    @Override
    public BookEntity getById(final Integer id) {
        return this.bookRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteBookById(final Integer id) {
        this.bookRepository.delete(BookEntity.builder().id(id).build());
    }

    @Override
    public List<BookEntity> getAllBooksByAuthorId(final Integer idAuthor) {
        return this.bookRepository.findByAutorId(idAuthor);
    }

    @Override
    public boolean existsBookById(Integer id) {
        return this.bookRepository.existsById(id);
    }
}
