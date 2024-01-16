package com.nttdata.escuela.libro.controller;

import com.nttdata.escuela.libro.adapter.BookAdapter;
import com.nttdata.escuela.libro.apimodel.BookDto;
import com.nttdata.escuela.libro.apimodel.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(BookAdapter.adaptToDto(this.bookService.getAllBooks()));
    }

    @PostMapping
    public ResponseEntity<Void> saveBook(@RequestBody BookDto bookDto) {
        if (bookDto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }
        this.bookService.saveOrUpdateBook(BookAdapter.adaptToEntity(bookDto));

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Integer idBook) {
        return ResponseEntity.ok(BookAdapter.adaptToDto(this.bookService.getById(idBook)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable("id") Integer idBook, @RequestBody BookDto bookDto) {
        bookDto.setId(idBook);
        this.bookService.saveOrUpdateBook(BookAdapter.adaptToEntity(bookDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer idBook) {
        this.bookService.deleteBookById(idBook);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-author/{idAuthor}")
    public ResponseEntity<List<BookDto>> getBooksByAuthorId(@PathVariable("idAuthor") Integer idAuthor) {
        return ResponseEntity.ok(BookAdapter.adaptToDto(this.bookService.getAllBooksByAuthorId(idAuthor)));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsBookById(@PathVariable("id") Integer idBook) {
        return ResponseEntity.ok(this.bookService.existsBookById(idBook));
    }

}
