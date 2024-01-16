package com.nttdata.libreria.repository;

import com.nttdata.libreria.apimodel.entity.BookStoreBookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreBookRepository extends CrudRepository<BookStoreBookEntity, Integer>
{
    List<BookStoreBookEntity> findByLibreriaId(Integer id);
}
