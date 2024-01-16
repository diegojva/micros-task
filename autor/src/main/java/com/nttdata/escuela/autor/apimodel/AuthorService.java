package com.nttdata.escuela.autor.apimodel;

import com.nttdata.escuela.autor.apimodel.AuthorEntity;

import java.util.List;

public interface AuthorService {

    List<AuthorEntity> getAllAuthors();

    void saveOrUpdateAuthor(AuthorEntity author);

    AuthorEntity getById(Integer id);

    void deleteAuthor(Integer id);
    
    boolean existsById(Integer id);
}
