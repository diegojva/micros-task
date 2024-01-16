package com.nttdata.libreria.repository;

import com.nttdata.libreria.apimodel.entity.BookStoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends CrudRepository<BookStoreEntity, Integer>
{

}
