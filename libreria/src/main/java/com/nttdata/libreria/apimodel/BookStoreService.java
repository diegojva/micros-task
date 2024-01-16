package com.nttdata.libreria.apimodel;

import com.nttdata.libreria.apimodel.entity.BookStoreEntity;

import java.util.List;

public interface BookStoreService
{
    List<BookStoreEntity> findAll();

    void saveOrUpdate(BookStoreEntity bookStoreEntity);

    BookStoreEntity getById(Integer id);

    void deleteAuthor(Integer id);

}
