package com.nttdata.escuela.autor.repository;

import com.nttdata.escuela.autor.apimodel.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer> {
    
}
