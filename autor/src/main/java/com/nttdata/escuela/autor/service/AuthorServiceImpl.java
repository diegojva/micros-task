package com.nttdata.escuela.autor.service;

import com.nttdata.escuela.autor.apimodel.AuthorEntity;
import com.nttdata.escuela.autor.apimodel.AuthorService;
import com.nttdata.escuela.autor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthors() {
        final List<AuthorEntity> allAuthors = new ArrayList<>();
        final Iterable<AuthorEntity> authorEntities = this.authorRepository.findAll();
        authorEntities.forEach(allAuthors::add);
        return allAuthors;
    }

    public void saveOrUpdateAuthor(AuthorEntity author) {
        this.authorRepository.save(author);
    }

    public AuthorEntity getById(Integer id) {
        return this.authorRepository.findById(id)
                .orElse(null);
    }

    public void deleteAuthor(final Integer id) {
        this.authorRepository.delete(AuthorEntity.builder()
                .id(id)
                .build());
    }

    @Override
    public boolean existsById(Integer id) {
        return this.authorRepository.existsById(id);
    }
}
