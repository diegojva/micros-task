package com.nttdata.libreria.controller;

import com.nttdata.libreria.adapt.BookStoreBookAdapt;
import com.nttdata.libreria.apimodel.BookStoreBookService;
import com.nttdata.libreria.apimodel.BookClient;
import com.nttdata.libreria.apimodel.entity.BookStoreEntity;
import com.nttdata.libreria.apimodel.BookStoreService;
import com.nttdata.libreria.apimodel.entity.BookStoreBookEntity;
import com.nttdata.libreria.dto.BookStoreBookDTO;
import com.nttdata.libreria.dto.BookStoreDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.nttdata.libreria.adapt.BookStoreAdapt.convertToEntity;
import static com.nttdata.libreria.adapt.BookStoreBookAdapt.convertToDto;

@Slf4j
@RestController
@RequestMapping("/book-store")
public class BookStoreController
{
    @Autowired
    private BookStoreService service;

    @Autowired
    private BookStoreBookService bookStoreBookService;

    @Autowired
    private BookClient bookClient;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final BookStoreDTO dto) throws Exception
    {
        if (dto.getId() != null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }

        this.service.saveOrUpdate(convertToEntity(dto));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final Integer id, @RequestBody final BookStoreEntity libreriaEntity)
    {
        libreriaEntity.setId(id);
        this.service.saveOrUpdate(libreriaEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookStoreEntity> getById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookStoreEntity>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping("/{id}/book")
    public ResponseEntity<Void> saveBookInBookStore(@PathVariable("id") Integer id, @RequestBody final BookStoreBookDTO dto) throws Exception
    {
        this.existsBook(dto.getIdLibro());
        this.existsBookStore(id);
        this.bookStoreBookService.saveOrUpdate(BookStoreBookAdapt.convertToEntity(dto, id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/book")
    public ResponseEntity<List<BookStoreBookDTO>> findAllBooksFromBookStoreId(@PathVariable("id") final Integer id)
    {
        this.existsBookStore(id);
        List<BookStoreBookDTO> books = convertToDto(this.bookStoreBookService.findByLibreriaId(id));

        return ResponseEntity.ok(books);
    }

    private void existsBook(final Integer id)
    {
        final boolean existsBook = this.bookClient.existsById(id);
        if(!existsBook)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El libro no existe");
        }
    }

    private void existsBookStore(final Integer id)
    {
        final BookStoreEntity existsBookStore = this.service.getById(id);
        if(existsBookStore == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La librería no existe");
        }
    }

}
