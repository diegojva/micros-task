package com.nttdata.escuela.autor.controller;

import com.nttdata.escuela.autor.apimodel.AuthorEntity;
import com.nttdata.escuela.autor.apimodel.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<AuthorEntity>> getAllAuthors() {
        return ResponseEntity.ok(this.authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Void> saveAuthor(@RequestBody final AuthorEntity author) throws Exception {
        if (author.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }
        this.authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(this.authorService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("id") final Integer id, @RequestBody final AuthorEntity authorEntity) {
        authorEntity.setId(id);
        this.authorService.saveOrUpdateAuthor(authorEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") final Integer id) {
        this.authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existAuthorById(@PathVariable("id") final Integer id) {
        if (id == 1) {
            throw new RuntimeException("Exceptión para probar el circuit breaker.");
        } else {
            return ResponseEntity.ok(this.authorService.existsById(id));
        }
    }

}
