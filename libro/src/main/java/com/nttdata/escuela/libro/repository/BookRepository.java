package com.nttdata.escuela.libro.repository;

import com.nttdata.escuela.libro.apimodel.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

    List<BookEntity> findByAutorId(final Integer authorId);
}
